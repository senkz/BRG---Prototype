package logger;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class GLogger {

	private GLogger() {}
	
	public static void log(Level lv, String msg) {
		Logger logger = Logger.getLogger("Generator");
		logger.setUseParentHandlers(false);

		FileHandler fh;
		
		try {
			fh = new FileHandler("Generator.log", true);
			logger.addHandler(fh);
			logger.setLevel(Level.ALL);
			fh.setFormatter(new Formatter() {
				@Override
				public String format(LogRecord rec) {
				
				StringBuffer buf = new StringBuffer(1000);
				
				Date d = new java.util.Date(rec.getMillis());
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		        buf.append('[');
		        buf.append(dateFormat.format(d));
		        buf.append(']');
		        
		        buf.append(' ');
		        
		        buf.append('[');
				buf.append(rec.getLevel());
		        buf.append(']');
		        
		        buf.append(' ');
		        buf.append(formatMessage(rec));
		        buf.append('\n');
		        return buf.toString();
				}
			});
			
			logger.log(lv, msg);
			fh.close();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
