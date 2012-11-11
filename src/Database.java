import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class Database
{
	private Connection con;
	private Statement stmt;
	private PreparedStatement ps;
	
	private String sql;
	private double currentBookRentPrice;
	
	private final java.net.URL url;
	private final String path;
	private final String dbConnection;

        private LogFile file;
	
	public Database()
	{
		con = null;
		stmt = null;
		ps = null;
                file = new LogFile();
		
		sql = "";
		currentBookRentPrice = -99.99;
		
        url = this.getClass().getResource("Database/LibrarySystem.accdb");
	    path = String.valueOf(url).substring(6).replaceAll("%20"," ").replace('/','\\');
		
		dbConnection = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+
						path+";DriverID=22;READONLY=false}";
		
	}
	
	/***************************************Getting Connection******************************************************/
	public Connection getConnection()
	{
		try
		{
			Class.forName
			("sun.jdbc.odbc.JdbcOdbcDriver");

		}
		catch (java.lang.ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null,"ClassNotFoundException: "+e.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		try
		{
			con = DriverManager.getConnection(dbConnection/*"jdbc:odbc:LibrarySystem"*/);
			System.out.println("The connection is established!");

		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null,"SQLException: " + e.getMessage(),"Database not found",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}

		return con;
	}
	/****************************************** Member Register ******************************************************/
	public Member memberRegister(Member m)
	{
		sql = "SELECT IC, PhoneNo FROM MEMBER";
		boolean isValid = true;
		try{
			getConnection();
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);

                        while(rs.next())
                        {
                            if(m.getIC().equals(rs.getString("IC")))
                            {
                                JOptionPane.showMessageDialog(null,"This IC already exist! Please re-check...","Warning",JOptionPane.WARNING_MESSAGE);
                                isValid = false;
                                finalize();
                                break;
                            }
                            if(m.getPhone().equals(rs.getString("PhoneNo")))
                            {
                                if(!m.getPhone().equals(""))
                                {
                                    JOptionPane.showMessageDialog(null,"This Phone No. already exist! Please re-check...","Warning",JOptionPane.WARNING_MESSAGE);
                                    isValid = false;
                                    finalize();
                                    break;
                                }
                            }
                        }
			
			}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"SQL Exception: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		
		if(isValid)
		{
			sql = "SELECT MemberID FROM MEMBER ORDER BY MemberID DESC";
			String id = "";
			try{
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				id = rs.getString("MemberID");
				int temp = Integer.parseInt(id.substring(3,10));
				temp = temp + 1;
				id = "SMD"+temp;
			}
			catch(SQLException e){
				JOptionPane.showMessageDialog(null,"Congratulation! You are the first member in SMD Library","SMD Library",JOptionPane.PLAIN_MESSAGE);
				id = "SMD1000000";
                                file.exceptionRecord(e.getStackTrace());
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Congratulation! You are the first member in SMD Library","SMD Library",JOptionPane.PLAIN_MESSAGE);
				id = "SMD1000000";
                                file.exceptionRecord(e.getStackTrace());
			}
			sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,?) ";
			try{
				ps = con.prepareStatement(sql);
				ps.setString(1,id);
				ps.setString(2,m.getPassword());
				ps.setString(3,m.getFirstName());
				ps.setString(4,m.getLastName());
				ps.setString(5,m.getIC());
				ps.setString(6,m.getGender());
				ps.setString(7,m.getPhone());
				ps.setDouble(8,m.getBalance());
				ps.setString(9,m.getQuestion());
				ps.setString(10,m.getAnswer());
				
				ps.executeUpdate();
				ps.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                                file.exceptionRecord(e.getStackTrace());
			}
			finally
			{
				m.setID(id);
				finalize();
			}
		
			return m;
		}
		else
			return null;
	}
	/******************************************** Member Login *******************************************************/
	public Member memberLogin(String id,String password)throws NameFormatException,ICFormatException
	{
		Member member = new Member();
		getConnection();
		sql = "SELECT * FROM MEMBER WHERE MemberID = '"+id+"'";
		try{
			stmt = con.createStatement();
		
			ResultSet rs = stmt.executeQuery(sql);
		
			if(rs.next())
			{
				if(rs.getString("Password").equals(password))
				{
					member.setID(rs.getString("MemberID"));
					member.setPassword(password);
					member.setFirstName(rs.getString("FirstName"));
					member.setLastName(rs.getString("LastName"));
					member.setIC(rs.getString("IC"));
					member.setGender(rs.getString("Gender"));
					member.setPhone(rs.getString("PhoneNo"));
					member.setBalance(rs.getDouble("Balance"));
					member.setQuestion(rs.getString("Question"));
					member.setAnswer(rs.getString("Answer"));
				}
				else
					member = null;
			}
			else
				member = null;
		
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return member;
	}
	
	/****************************************** Edit Member Profile *********************************************/
	public Member editProfile(Member mem)throws NameFormatException,ICFormatException
	{
		getConnection();
		sql = "UPDATE MEMBER SET Password=?, FirstName=?, LastName=?, PhoneNo=?, Question=?, Answer=? WHERE MemberID='"+mem.getID()+"'";
		
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1,mem.getPassword());
			ps.setString(2,mem.getFirstName());
			ps.setString(3,mem.getLastName());
			ps.setString(4,mem.getPhone());
			ps.setString(5,mem.getQuestion());
			ps.setString(6,mem.getAnswer());
			ps.executeUpdate();
			
			sql = "SELECT * FROM MEMBER WHERE MemberID = '"+mem.getID()+"'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			mem.setFirstName(rs.getString("FirstName"));
			mem.setLastName(rs.getString("LastName"));
			mem.setPassword(rs.getString("Password"));
			mem.setIC(rs.getString("IC"));
			mem.setPhone(rs.getString("PhoneNo"));
			mem.setGender(rs.getString("Gender"));
			mem.setBalance(rs.getDouble("Balance"));
			mem.setQuestion(rs.getString("Question"));
			mem.setAnswer(rs.getString("Answer"));
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
			mem = null;
		}
		finally{
			finalize();
		}
		return mem;
	}
	
	/****************************************** Reload Balance **************************************************/
	public double reloadBalance(String id,double amount)
	{
		getConnection();
		sql = "UPDATE MEMBER SET Balance = ("+amount+"+Balance) WHERE MemberID = '"+id+"'";
		double newBalance = 0.0;
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			sql = "SELECT Balance FROM MEMBER WHERE MemberID = '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				newBalance = rs.getDouble("Balance");
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return convertCurrency(newBalance);
	}

        /****************************************** Staff Register *************************************************/
        public void staffRegister(Staff stf)
        {
            getConnection();
            String id = "";
            boolean isValid = true;
            try{
                sql = "SELECT IC,PhoneNo FROM STAFF";
		stmt = con.createStatement();
                

		ResultSet rs = stmt.executeQuery(sql);

		while(rs.next())
                        {
                            if(stf.getIC().equals(rs.getString("IC")))
                            {
                                JOptionPane.showMessageDialog(null,"This IC already exist! Please re-check...","Warning",JOptionPane.WARNING_MESSAGE);
                                isValid = false;
                                break;
                            }
                            if(stf.getPhone().equals(rs.getString("PhoneNo")))
                            {
                                if(!stf.getPhone().equals(""))
                                {
                                    JOptionPane.showMessageDialog(null,"This Phone No. already exist! Please re-check...","Warning",JOptionPane.WARNING_MESSAGE);
                                    isValid = false;
                                    break;
                                }
                            }
                        }
                if(isValid)
                {
                        sql = "SELECT StaffID FROM STAFF ORDER BY StaffID DESC";
			
			rs = stmt.executeQuery(sql);
			rs.next();
			id = rs.getString("StaffID");
			int temp = Integer.parseInt(id.substring(3));
			temp = temp + 1;
			id = "STF"+temp;

                        sql = "INSERT INTO STAFF VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,stf.getPassword());
			ps.setString(3,stf.getFirstName());
			ps.setString(4,stf.getLastName());
			ps.setString(5,stf.getIC());
			ps.setString(6,stf.getGender());
			ps.setString(7,stf.getPhone());
			ps.setString(8,stf.getPosition());
			ps.setString(9,stf.getAddress());
			ps.setString(10,stf.getPostcode());
                        ps.setString(11,stf.getTown());
                        ps.setString(12,stf.getState());
                        ps.setString(13,stf.getCountry());
                        ps.setDouble(14,stf.getSalary());

			ps.executeUpdate();

                        stf.setID(id);
                        JOptionPane.showMessageDialog(null,"Register successful!\nStaff ID: "+stf.getID());
                    }
		
            }
            catch(SQLException e)
            {
		JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                file.exceptionRecord(e.getStackTrace());
            }
            finally{
                finalize();
            }
        }
	
	/****************************************** Staff Login *****************************************************/
	
	public Staff staffLogin(String id,String pw)throws NameFormatException,ICFormatException
	{
		Staff stf = new Staff();
		getConnection();
		sql = "SELECT * FROM STAFF WHERE StaffID = '"+id+"'";
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		
			if(rs.next())
			{
				if(rs.getString("Password").equals(pw))
				{
					stf.setID(rs.getString("StaffID"));
                                        stf.setFirstName(rs.getString("StaffFirstName"));
                                        stf.setLastName(rs.getString("StaffLastName"));
                                        stf.setIC(rs.getString("IC"));
                                        stf.setPassword(pw);
                                        stf.setGender(rs.getString("Gender"));
                                        stf.setPhone(rs.getString("PhoneNo"));
                                        stf.setPosition(rs.getString("Position"));
                                        stf.setAddress(rs.getString("Address"));
                                        stf.setPostcode(rs.getString("Postcode"));
                                        stf.setTown((rs.getString("Town")));
                                        stf.setState(rs.getString("State"));
                                        stf.setCountry(rs.getString("Country"));
                                        stf.setSalary(rs.getDouble("Salary"));
				}
				else
					stf = null;
			}
			else
				stf = null;
		
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"SQLException occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return stf;
	}
	
	/****************************************** Search Book *****************************************************/
	public ArrayList<Book> searchBook(Book b)
	{
		ArrayList<Book> bookSearch = new ArrayList<Book>();
		getConnection();
		sql = "SELECT * FROM BOOK WHERE ISBN LIKE '%"+b.getISBN()+"%' AND Title LIKE '%"+b.getTitle()+"%'"+
			" AND Publisher LIKE '%"+b.getPublisher()+"%' "+"AND Author LIKE '%"+b.getAuthor()+"%'"+
				" AND Type LIKE '%"+b.getType()+"%' AND Description LIKE '%"+b.getDescription()+"%' AND Quantity > 0"+
				" ORDER BY Title";
		try{
			stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				bookSearch.add(new Book(
					rs.getString("ISBN"),
					rs.getString("Title"),
					rs.getString("Publisher"),
					rs.getString("Author"),
					rs.getString("Type"),
					rs.getString("Description"),
					rs.getDouble("RentPrice"),
					rs.getInt("Quantity")));
					
				while(rs.next())
				{
					bookSearch.add(new Book(
						rs.getString("ISBN"),
						rs.getString("Title"),
						rs.getString("Publisher"),
						rs.getString("Author"),
						rs.getString("Type"),
						rs.getString("Description"),
						rs.getDouble("RentPrice"),
						rs.getInt("Quantity")));
				}
			}
			else
				bookSearch = null;
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return bookSearch;
	}

        /****************************************** Search Book for Admin ******************************************/
        public ArrayList<Book> adminBookSearch(Book b)
	{
		ArrayList<Book> bookSearch = new ArrayList<Book>();
		getConnection();
		sql = "SELECT * FROM BOOK WHERE ISBN LIKE '%"+b.getISBN()+"%' AND Title LIKE '%"+b.getTitle()+"%'"+
			" AND Publisher LIKE '%"+b.getPublisher()+"%' "+"AND Author LIKE '%"+b.getAuthor()+"%'"+
				" AND Type LIKE '%"+b.getType()+"%' AND Description LIKE '%"+b.getDescription()+"%'"+
				" ORDER BY Title";
		try{
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				bookSearch.add(new Book(
					rs.getString("ISBN"),
					rs.getString("Title"),
					rs.getString("Publisher"),
					rs.getString("Author"),
					rs.getString("Type"),
					rs.getString("Description"),
					rs.getDouble("RentPrice"),
					rs.getInt("Quantity")));

				while(rs.next())
				{
					bookSearch.add(new Book(
						rs.getString("ISBN"),
						rs.getString("Title"),
						rs.getString("Publisher"),
						rs.getString("Author"),
						rs.getString("Type"),
						rs.getString("Description"),
						rs.getDouble("RentPrice"),
						rs.getInt("Quantity")));
				}
			}
			else
				bookSearch = null;
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return bookSearch;
	}
	
	/****************************************** Borrow Book *****************************************************/
	public String borrowBook(String id,String isbn)
	{
		getConnection();
		String receiptNo="";
		try{
			sql = "SELECT ReceiptNo FROM TRANSACTION ORDER BY ReceiptNo DESC";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				receiptNo = String.valueOf((Long.parseLong(rs.getString("ReceiptNo")) + 1));
			else
				receiptNo = "10000001";
                        sql = "SELECT RentPrice FROM BOOK WHERE ISBN = '"+isbn+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next())
				currentBookRentPrice = rs.getDouble("RentPrice");
                        
			sql = "UPDATE BOOK SET Quantity = (Quantity-1) WHERE ISBN = '"+isbn+"'";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO TRANSACTION (ReceiptNo,MemberID,ISBN,DateBorrow,TotalRent) VALUES(?,?,?,Date(),?)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1,receiptNo);
			ps.setString(2,id);
			ps.setString(3,isbn);
                        ps.setDouble(4, currentBookRentPrice);
			
			ps.executeUpdate();
			
			
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}		
		return receiptNo;
	}
	
	public double getCurrentBookRentPrice() // Must call after the borrowBook()
	{ return convertCurrency(currentBookRentPrice); }
	
	/**************************************** Deduct Balance ****************************************************/
	public double deductBalance(String id,double amount)
	{
		getConnection();
		double newBalance = 0.0;
		sql = "UPDATE MEMBER SET Balance = (Balance-"+amount+") WHERE MemberID = '"+id+"'";
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			sql = "SELECT Balance FROM MEMBER WHERE MemberID = '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				newBalance = rs.getDouble("Balance");
			else
				newBalance = -999.99;
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return convertCurrency(newBalance);
	}
	
	
	/**************************************** Return Book *******************************************************/
	public int returnBook(String receiptNo)
	{
		int day = 0;
		double fineRate = 0.0;
		getConnection();
		String id = "";
		String isbn = "";
		
		try{
			sql = "SELECT ISBN, MemberID FROM TRANSACTION WHERE ReceiptNo = '"+receiptNo+"' AND DateReturn IS NULL";
			stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			if(resultSet.next())
			{
				id = resultSet.getString("MemberID");
				isbn = resultSet.getString("ISBN");
				sql = "UPDATE BOOK SET Quantity = (Quantity+1) WHERE ISBN = '"+isbn+"'";
				stmt.executeUpdate(sql);
				sql = "UPDATE TRANSACTION SET DateReturn = Date() WHERE ReceiptNo='"+receiptNo+"'";
			
				stmt.executeUpdate(sql);
				sql = "SELECT (DateReturn - DateBorrow) AS BorrowDay FROM TRANSACTION WHERE receiptNo='"+receiptNo+"'";
				
				ResultSet rs = stmt.executeQuery(sql);
				if(rs.next())
					day = rs.getInt("BorrowDay");
				if(day>7)
				{
					fineRate = (day-7)*0.5;
				}
				
				sql = "UPDATE MEMBER SET Balance = (Balance-"+fineRate+") WHERE MemberID = '"+id+"'";
				stmt.executeUpdate(sql);
                                sql = "UPDATE TRANSACTION SET TotalRent = (TotalRent+"+fineRate+") WHERE ReceiptNo='"+receiptNo+"'";
                                stmt.executeUpdate(sql);
			}
			else{
				JOptionPane.showMessageDialog(null,"Invalid ReceiptNo! Please re-check","Invalid",JOptionPane.ERROR_MESSAGE);
				day = -1;
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return day-7;
	}
	
	/************************************** Retrieve Balance ****************************************************/
	public double retrieveBalance(String receiptNo)
	{
		getConnection();
		double balance = 0.0;
		try{
			sql = "SELECT MemberID FROM TRANSACTION WHERE ReceiptNo = '"+receiptNo+"'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String id = "";
			if(rs.next())
			{
				id = rs.getString("MemberID");
				sql = "SELECT Balance FROM MEMBER WHERE MemberID = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1,id);
				rs = ps.executeQuery();
				rs.next();
				balance = rs.getDouble("Balance");
			}
			else
				balance = -999.99;
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return convertCurrency(balance);
	}
	
	/************************************** Search for ReceiptNo ************************************************/
	public ArrayList<String> searchReceiptNo(String id,String isbn)
	{
		sql = "SELECT ReceiptNo,ISBN FROM TRANSACTION WHERE "+
			  "MemberID = '"+id+"' AND ISBN LIKE '%"+isbn+
			  "%' AND DateReturn IS NULL";
		ArrayList<String> receiptNo = new ArrayList<String>();
		getConnection();
		try{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				receiptNo.add("Receipt no.: "+rs.getString("ReceiptNo")+"    \tISBN: "+rs.getString("ISBN"));
				while(rs.next())
				{
					receiptNo.add("Receipt no.: "+rs.getString("ReceiptNo")+"    \tISBN: "+rs.getString("ISBN"));
				}
			}
			else
				receiptNo = null;
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return receiptNo;
	}
	
	/****************************************** Add new book ****************************************************/
	public void addBook(Book book)
	{
		getConnection();
		
		try{
			sql = "SELECT ISBN FROM BOOK WHERE ISBN = '"+book.getISBN()+"'";
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				JOptionPane.showMessageDialog(null,"This ISBN already exist! Please re-check...","ERROR",JOptionPane.ERROR_MESSAGE);
			else{
				sql = "INSERT INTO BOOK VALUES (?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,book.getISBN());
				ps.setString(2,book.getTitle());
				ps.setString(3,book.getPublisher());
				ps.setString(4,book.getAuthor());
				ps.setString(5,book.getType());
				ps.setString(6,book.getDescription());
				ps.setDouble(7,book.getRentPrice());
				ps.setInt(8,book.getQuantity());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"This book have been inserted!");
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
	}
	
	/****************************************** Delete Book *****************************************************/
	public void deleteBook(String isbn)
	{
		getConnection();
		sql = "DELETE FROM BOOK WHERE ISBN = '"+isbn+"'";
		try{
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
	}
	
	/***************************************** Update Book *****************************************************/
	public void updateBook(Book b)
	{
		getConnection();
		try{
			sql = "UPDATE BOOK SET RentPrice = "+b.getRentPrice()+" , Quantity = "+b.getQuantity()+
				  " WHERE ISBN = '"+b.getISBN()+"'";
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Update Successful!");
			
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
	}

        /***************************************** Edit Staff Profile **********************************************/
        public Staff editStaffProfile(Staff stf)throws NameFormatException,ICFormatException
        {
            getConnection();
            try{
                sql = "UPDATE STAFF SET Password = '"+stf.getPassword()+"',Address='"+stf.getAddress()+
                        "', Postcode='"+stf.getPostcode()+"', Town='"+stf.getTown()+"', State ='"+
                        stf.getState()+"',Country='"+stf.getCountry()+"', PhoneNo='"+stf.getPhone()+
                        "' WHERE StaffID='"+stf.getID()+"'";
                stmt = con.createStatement();
                stmt.executeUpdate(sql);

                sql = "SELECT * FROM STAFF WHERE StaffID='"+stf.getID()+"'";
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next())
                {
                    stf.setID(rs.getString("StaffID"));
                    stf.setFirstName(rs.getString("StaffFirstName"));
                    stf.setLastName(rs.getString("StaffLastName"));
                    stf.setIC(rs.getString("IC"));
                    stf.setPassword(rs.getString("Password"));
                    stf.setGender(rs.getString("Gender"));
                    stf.setPhone(rs.getString("PhoneNo"));
                    stf.setPosition(rs.getString("Position"));
                    stf.setAddress(rs.getString("Address"));
                    stf.setPostcode(rs.getString("Postcode"));
                    stf.setTown((rs.getString("Town")));
                    stf.setState(rs.getString("State"));
                    stf.setCountry(rs.getString("Country"));
                    stf.setSalary(rs.getDouble("Salary"));
                }
                
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                file.exceptionRecord(e.getStackTrace());
            }
            finally{
                finalize();
            }
            return stf;
        }
	
	/****************************************** Retrieve Password ***********************************************/
	public String retrievePassword(String id,String question,String answer)
	{
		getConnection();
		String pw = "";
		sql = "SELECT Password FROM MEMBER WHERE MemberID=? AND Question=? AND Answer=?";
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,question);
			ps.setString(3,answer);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				pw = rs.getString("Password");
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return pw;
	}

        /***************************************************** Retrieve Staff Password **********************************************/
        public String retrieveStaffPassword(String id)
        {
            getConnection();
            String pw = "";
            try{
                sql = "SELECT Password FROM STAFF WHERE StaffID = '"+id+"'";
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next())
                    pw = rs.getString("Password");
                else
                    pw = "";
            }
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
		finally{
			finalize();
		}
		return pw;
        }

        /************************************************** For admin edit staff status ***********************************************/
        public void changeStaffStatus(String id,String position,double salary)
        {
            getConnection();

            try{
                sql = "UPDATE STAFF SET Position = '"+position+"' , Salary = "+salary+" WHERE StaffID = '"+id+"'";
                stmt = con.createStatement();
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Update Successful!");
            }
            catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
            }
            finally{
                finalize();
            }
        }

        /************************************************** Get Total Rent ************************************************************/
        public double[] getTotalRent(int year)
        {
            double []total = new double[12];
            int day = 31;
            getConnection();
            ResultSet rs;
            try{
                stmt = con.createStatement();
                for(int i=1;i<=12;i++)
                {
                    if(i==1||i==3||i==5||i==7||i==8||i==10||i==12)
                        day = 31;
                    else if(i==4||i==6||i==9||i==11)
                        day = 30;
                    else
                    {
                        if(year%4==0)
                            day = 29;
                        else
                            day = 28;
                    }
                    sql = "SELECT SUM(TotalRent) AS GrandTotal FROM TRANSACTION WHERE DateBorrow BETWEEN #"+i+"/1/"+year+"# AND #"+i+"/"+day+"/"+year+"#";
                    
                    rs = stmt.executeQuery(sql);
                    if(rs.next())
                        total[i-1] = convertCurrency(rs.getDouble("GrandTotal"));
                    else
                        total[i-1] = 0.00;
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                file.exceptionRecord(e.getStackTrace());
                e.printStackTrace();
            }
            finally{
                finalize();
            }

            return total;
        }

        /************************************************** Get Total Count ************************************************************/
        public int[] getTotalCount(int year)
        {
            int count[] = new int[12];
            int day = 31;
            getConnection();
            ResultSet rs;
            try{
                stmt = con.createStatement();
                for(int i=1;i<=12;i++)
                {
                    if(i==1||i==3||i==5||i==7||i==8||i==10||i==12)
                        day = 31;
                    else if(i==4||i==6||i==9||i==11)
                        day = 30;
                    else
                    {
                        if(year%4==0)
                            day = 29;
                        else
                            day = 28;
                    }
                    sql = "SELECT COUNT(ReceiptNo) AS TotalReceipt FROM TRANSACTION WHERE DateBorrow BETWEEN #"+i+"/1/"+year+"# AND #"+i+"/"+day+"/"+year+"#";
                    rs = stmt.executeQuery(sql);
                    if(rs.next())
                        count[i-1] = rs.getInt("TotalReceipt");
                    else
                        count[i-1] = 0;
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                file.exceptionRecord(e.getStackTrace());
                e.printStackTrace();
            }
            finally{
                finalize();
            }

            return count;
        }
	
	/****************************************** Finalize ********************************************************/
	public void finalize()
	{
		try{
			if(stmt != null)
				stmt.close();
			if(con != null)
			{
				con.close();		
				System.out.println("The connection is closed!");
			}
		}
		catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Exception occur: " + e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                        file.exceptionRecord(e.getStackTrace());
		}
	}
	
	/************************************* Convert to 2 decimal places ******************************************/
	private double convertCurrency(double money)
	{
		return Double.parseDouble(String.format("%.2f",money));
	}
}