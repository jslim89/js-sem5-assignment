import java.io.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class LogFile
{
	private FileOutputStream memberLog;
        private FileOutputStream adminLog;
	private FileOutputStream exception;
        private FileOutputStream staffLog;
        private PrintStream psExp;
	private PrintStream memberLogExp;
	private PrintStream staffLogExp;
	private PrintStream adminLogExp;

	private java.net.URL url;
	
	public LogFile()
	{
            try{
            	url = this.getClass().getResource("text");
	            String path = String.valueOf(url).substring(6).replaceAll("%20"," ").replace('/','\\');
				memberLog = new FileOutputStream(path+"\\Member_log.txt",true);
				staffLog = new FileOutputStream(path+"\\Staff_log.txt",true);
				adminLog = new FileOutputStream(path+"\\Adminlog.txt",true);
				exception = new FileOutputStream(path+"\\exception occur.txt",true);
                psExp = new PrintStream(exception);
                memberLogExp = new PrintStream(memberLog);
                staffLogExp = new PrintStream(staffLog);
                adminLogExp = new PrintStream(adminLog);
            }
            catch(FileNotFoundException e)
            {
                JOptionPane.showMessageDialog(null,"FileNotFoundException: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                this.exceptionRecord(e.getStackTrace());
            }
	}
	
	public void memberLogRecord(Member mem)
	{
		try{
			memberLogExp.println ("ID: "+mem.getID()+" logon at "+getDate());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                        this.exceptionRecord(e.getStackTrace());

		}
		finally{
			closeFile();
		}
	}
	public void staffLogRecord(Staff stf)
	{
		try{
			staffLogExp.println ("ID: "+stf.getID()+" logon at "+getDate());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                        this.exceptionRecord(e.getStackTrace());
		}
		finally{
			closeFile();
		}
	}
	public void adminLogRecord(Staff stf)
	{
		try{
			adminLogExp.println ("ID: "+stf.getID()+" logon at "+getDate());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                        this.exceptionRecord(e.getStackTrace());
		}
		finally{
			closeFile();
		}
	}
	
	public void exceptionRecord(StackTraceElement[] exp )
	{
		try{
                        psExp.println("Exception happened at "+getDate());
			for(StackTraceElement element : exp)
			{
				psExp.println(element.getClassName());
				psExp.println(element.getFileName());
				psExp.println(element.getLineNumber());
				psExp.println(element.getMethodName()+"\n");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Exception: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		finally{
			closeFile();
		}
	}

        public void printReceipt(String receipt)
        {
            try{
                FileWriter printing = new FileWriter("lpt1");
                
                printing.write(getDate()+"\n"+receipt);

                printing.close();
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null,"IOException: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                this.exceptionRecord(e.getStackTrace());
            }
        }

        public void printReport(String report)
        {
            try{
                FileWriter printing = new FileWriter("lpt1");

                printing.write("Printed at \t"+getDate()+"\n"+report);

                printing.close();
            }
            catch(IOException e)
            {
                JOptionPane.showMessageDialog(null,"IOException: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
                this.exceptionRecord(e.getStackTrace());
            }
        }
	
	private void closeFile()
	{
		try{
			if(memberLog!=null)
				memberLog.close();
			if(staffLog!=null)
				memberLog.close();
			if(adminLog!=null)
				memberLog.close();
			if(exception!=null)
				exception.close();
		}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null,"IOException: "+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	private String getDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("'Time: ' HH:mm:ss 'Date: ' dd/MM/yyyy");
		return dateFormat.format(new Date());
	}
}