package gui.view;

import gui.controller.GUIRegister;
import gui.controller.Repository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import connections.SourceDAO;
import connections.SourceDatabaseJDBC_Oracle;
import controls.Register;


public class DatabaseManagerFrame extends JFrame implements ActionListener
{
	private JLabel sourceDbLabel = new JLabel("Source database:");
	private JLabel targetDbLabel = new JLabel("Target database:");
	private JLabel sourceUserLabel = new JLabel("Username:");
	private JLabel sourcePassLabel = new JLabel("Password:");
	private JLabel targetUserLabel = new JLabel("Username:");
	private JLabel targetPassLabel = new JLabel("Password:");
	private JLabel sourceURLLabel = new JLabel("URL:");
	private JLabel targetURLLabel = new JLabel("URL:");
	private JTextField sourceDbUserField = new JTextField();
	private JTextField sourceDbPassField = new JTextField();
	private JTextField targetDbUserField = new JTextField();
	private JTextField targetDbPassField = new JTextField();
	private JTextField sourceURLField = new JTextField();
	private JTextField targetURLField = new JTextField();
	private JButton saveAndContinue = new JButton("Save and continue");
	private JButton test = new JButton("Test connection");
	private JButton logout = new JButton("Log out");
	private JButton pass = new JButton("Change password");
	private JButton exit = new JButton("Exit");
	
	String[] choices = {"Yes", "No", "Cancel"};
	
	boolean changed = false;
	boolean target = false;
	boolean source = false; 
	
	public DatabaseManagerFrame()
	{
		initUI();
	}
	
	private void initUI()
	{
		initialize();
		setLayout(null);
		setResizable(false);
		
		sourceDbLabel.setBounds( 10,10,100,20);
		targetDbLabel.setBounds(200,10,100,20);
		
		sourceUserLabel.setBounds( 10,40,100,20);
		targetUserLabel.setBounds(200,40,100,20);
		
		sourceDbUserField.setBounds( 10,60,100,20);
		sourceDbUserField.getDocument().addDocumentListener(myListener);
		
		targetDbUserField.setBounds(200,60,100,20);
		targetDbUserField.getDocument().addDocumentListener(myListener);
		
		sourcePassLabel.setBounds( 10,90,100,20);
		targetPassLabel.setBounds(200,90,100,20);
		
		sourceDbPassField.setBounds( 10,110,100,20);
		sourceDbPassField.getDocument().addDocumentListener(myListener);
		
		targetDbPassField.setBounds(200,110,100,20);
		targetDbPassField.getDocument().addDocumentListener(myListener);
		
		sourceURLLabel.setBounds( 10, 140,100,20);
		targetURLLabel.setBounds(200, 140,100,20);
		
		sourceURLField.setBounds( 10, 160,100,20);
		sourceURLField.getDocument().addDocumentListener(myListener);
		
		targetURLField.setBounds(200, 160,100,20);
		targetURLField.getDocument().addDocumentListener(myListener);
		
		saveAndContinue.addActionListener(this);
		saveAndContinue.setBounds(400, 40,150,20);
		saveAndContinue.setHorizontalAlignment(SwingConstants.LEFT);
		
		test.addActionListener(this);
		test.setBounds(400,70,150,20);
		test.setHorizontalAlignment(SwingConstants.LEFT);
		
		logout.addActionListener(this);
		logout.setBounds(400,100,150,20);
		logout.setHorizontalAlignment(SwingConstants.LEFT);
		
		pass.addActionListener(this);
		pass.setBounds(400,130,150,20);
		pass.setHorizontalAlignment(SwingConstants.LEFT);
		
		exit.addActionListener(this);
		exit.setBounds(400,160,150,20);
		exit.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		add(sourceDbLabel);
		add(targetDbLabel);
		add(sourceUserLabel);
		add(targetUserLabel);
		add(sourcePassLabel);
		add(targetPassLabel);
		add(sourceURLLabel);
		add(targetURLLabel);
		add(sourceDbUserField);
		add(targetDbUserField);
		add(sourceDbPassField);
		add(targetDbPassField);
		add(sourceURLField);
		add(targetURLField);
		add(saveAndContinue);
		add(test);
		add(logout);
		add(pass);
		add(exit);
				
		setTitle("Set connections");
        setSize(580, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}
	
	DocumentListener myListener = new DocumentListener()
	{

		@Override
		public void changedUpdate(DocumentEvent arg0) 
		{
			changed = true;			
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) 
		{
			changed = true;		
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) 
		{
			changed = true;
		}
	};
	
	private void initialize()
	{
		sourceDbUserField.setText(GUIRegister.activeUser.getSourceDatabaseUsername());
		sourceDbPassField.setText(GUIRegister.activeUser.getSourceDatabasePassword());
		sourceURLField.setText(GUIRegister.activeUser.getSourceDatabaseURL());
	
		targetDbUserField.setText(GUIRegister.activeUser.getTargetDatabaseUsername());
		targetDbPassField.setText(GUIRegister.activeUser.getTargetDatabasePassword());
		targetURLField.setText(GUIRegister.activeUser.getTargetDatabaseURL());
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (saveAndContinue==e.getSource())
		{
			saveContinue();
		}
		if (test==e.getSource())
		{
			testConnection();
		}
		if (logout==e.getSource())
		{
			System.out.println("User: "+GUIRegister.activeUser.getUsername()+" had logged out.");
			GUIRegister.setActiveUser(null);
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			dispose();
		}
		if (pass==e.getSource())
		{
			ChangePasswordFrame cpf = new ChangePasswordFrame();
			cpf.setVisible(true);
		}
		if (exit==e.getSource())
		{
			exit();
		}
	}
	
	private void exit()
	{
		if (changed)
		{
			int response = JOptionPane.showOptionDialog
			(
	                null                       // Center in window.
	              , "Save changes?"            // Message
	              , "Quit without saving?"     // Title in titlebar
	              , JOptionPane.YES_NO_OPTION  // Option type
	              , JOptionPane.PLAIN_MESSAGE  // messageType
	              , null                       // Icon (none)
	              , choices                    // Button text as above.
	              , ""						   // Default button's label
	            );
			
			 switch (response) 
			 {
			 	case -1:  System.exit(0); //... Both the quit button (3) and the close box(-1) handled here.
			 							  // It would be better to exit loop, but...
		        case 0: saveAndExit(); break;
		        case 1: System.exit(0); break;
		        case 2: ; break;
		         
		         default:
		             //... If we get here, something is wrong.  Defensive programming.
		             JOptionPane.showMessageDialog(null, "Unexpected response " + response);
		     }
		}
		else
		{
			System.exit(0);
		}
	
	}
	
	private void saveContinue()
	{
		save();

		new BusinessRuleFrame();
		dispose();
	}
	
	private void saveAndExit()
	{
		JOptionPane.showMessageDialog(null,"All data has been saved", "Saving data", JOptionPane.INFORMATION_MESSAGE);
		save();
		System.exit(0);
	}
	
	private void save()
	{
		changed = false;
		
		GUIRegister.activeUser.setSourceDatabaseUsername(sourceDbUserField.getText());
		GUIRegister.activeUser.setSourceDatabasePassword(sourceDbPassField.getText());
		GUIRegister.activeUser.setSourceDatabaseURL(sourceURLField.getText());
		
		GUIRegister.activeUser.setTargetDatabaseUsername(targetDbUserField.getText());
		GUIRegister.activeUser.setTargetDatabasePassword(targetDbPassField.getText());
		GUIRegister.activeUser.setTargetDatabaseURL(targetURLField.getText());
		
		Repository.updateUser(GUIRegister.activeUser);
		Repository.initialize();
	}
	
	private void testConnection()
	{
		String _targetMessage = Register.getTargetConnection().testConnection(sourceDbUserField.getText(),sourceDbPassField.getText(), sourceURLField.getText());
		String _sourceMessage = Register.getSourceConnection().testConnection(targetDbUserField.getText(),targetDbPassField.getText(), targetURLField.getText());
		
		JOptionPane.showMessageDialog(null,"Source database:\n" + _targetMessage+"\n\nTarget database:\n"+_sourceMessage, "Database connections", JOptionPane.INFORMATION_MESSAGE);
	}
}
