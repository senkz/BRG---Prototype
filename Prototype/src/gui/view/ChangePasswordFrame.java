package gui.view;

import gui.controller.GUIRegister;
import gui.controller.Repository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ChangePasswordFrame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 2391029819307227283L;
	JButton ca = new JButton("Change Password");
	JButton cl = new JButton("Close");
    JTextField namef = new JTextField(12);
    JPasswordField passf1 = new JPasswordField(12);
    JPasswordField passf2 = new JPasswordField(12);
        
    public ChangePasswordFrame() 
    {
    	initUI();
    }

    public void setUser(){
    	namef.setText("");
    }
    public final void initUI() 
    {
    	initialize();
        setLayout(null);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(10,10,150,20);
        
        
        namef.setEditable(false);
        namef.setBounds(10,35,150,20);
        passf1.setFocusable(isCursorSet());
        
        JLabel pass1 = new JLabel(" New Password:");
        pass1.setBounds(10,60,150,20);
        
        passf1.setBounds(10,85,150,20);
        
        JLabel pass2 = new JLabel("Confirm new passport");
        pass2.setBounds(10,110,150,30);
        
        passf2.setBounds(10,135,150,20);
                   
        ca.setBounds(250, 60, 150, 20);
        ca.setHorizontalAlignment(SwingConstants.LEFT);
        ca.addActionListener(this);
        
        cl.setBounds(250, 85, 150, 20);
        cl.setHorizontalAlignment(SwingConstants.LEFT);
        cl.addActionListener(this);

            
        add(cl);
        add(ca);
        add(name);
        add(pass1);
        add(pass2);
        add(namef);
        add(passf1);
        add(passf2);

       
        
        setTitle("Change password");
        setSize(430, 205);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
  
    public void initialize()
    {
    	namef.setText(GUIRegister.activeUser.getUsername());
    	passf1.setText(GUIRegister.activeUser.getPassword());
    	passf2.setText(GUIRegister.activeUser.getPassword());
    }
    
    public boolean passCheck(String password)
    {  
   	 return true;
//   	 String  expression= "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9_-]{6,24}$";  
//   	 CharSequence inputStr = password;  
//   	 Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
//   	 Matcher matcher = pattern.matcher(inputStr);  
//   	 return matcher.matches();
    }
    
	public void actionPerformed(ActionEvent e)
    { 
        if(ca==e.getSource())
        {
        	if (!new String(passf1.getPassword()).equals(new String(passf2.getPassword())))
        	{
        		
        		JOptionPane.showMessageDialog(null, "The passwords do not match");
        	}
        	else
        	{
        		if (new String(passf1.getPassword()).length()<4)
        		{
        			JOptionPane.showMessageDialog(null, "The password must be at least 4 characters long");
        		}
        		else
        		{
        			if(!passCheck(new String(passf1.getPassword())))
        			{
        				JOptionPane.showMessageDialog(null, new String(passf1.getPassword()));
        			}
        			else
        			{
        				GUIRegister.activeUser.setPassword(new String (passf1.getPassword()));
        				Repository.updateUser(GUIRegister.activeUser);
        				Repository.initialize();
        				JOptionPane.showMessageDialog(null,"Your password has been changed", "", JOptionPane.INFORMATION_MESSAGE);
        				Repository.setCredentials(namef.getText(),passf1.getPassword());
        			}
        		}
        	}
        }
        	
        if(cl==e.getSource())
        {
        	dispose();
        }
    }
}