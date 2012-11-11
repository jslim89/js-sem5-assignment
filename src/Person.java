public class Person
{
	protected String id;
	protected  String password;
	protected String firstName;
	protected String lastName;
	private String ic;
	private String gender;
	private String phone;
	
	public Person()
	{
		id = "";
		password = "";
		firstName = "";
		lastName = "";
                ic = "";
                gender = "";
		phone = "";
	}
	
	public Person(String id,String password,String firstName,String lastName,String IC,String G,String P)
	{
		this.id = id;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
                this.ic = IC;
                this.gender = G;
                this.phone = P;
	}
	
	public void setID(String id)
	{ this.id = id; }
	
	public void setPassword(String password)
	{ this.password = password; }
	
	public void setFirstName(String firstName)throws NameFormatException
	{
		boolean isValid = true;
		String msg = "";
		char num[] = {'1','2','3','4','5','6','7','8','9','0'
                                ,'~','!','#','$','%','^','&','*','(',')','_'
                                ,'+','=','\\',']','[','}','{',';',':','\"','?','>'
                                ,'<',',','|'};

		if(firstName.length()<2 || firstName.length()>20)
		{
			msg = "Name must in range of 2 - 20 characters!\n";
			isValid =false;
		}

		if(firstName.charAt(0)==' ')
		{
			msg = "First character of name cannot be <space>!\n";
			isValid = false;
		}

		for(int i=0;i<firstName.length();i++)
		{
			for(int j=0;j<num.length;j++)
			{
				if(firstName.charAt(i)==num[j])
				{
					msg += "Invalid character for Name: "+num[j];
					isValid = false;
					break;
				}
			}
			if(!isValid)
				break;
		}
		if(!isValid)
		{
			throw new NameFormatException(msg);
		}
                else
                    this.firstName = firstName;
	}
	
	public void setLastName(String lastName)throws NameFormatException
	{
		boolean isValid = true;
		String msg = "";
		char num[] = {'1','2','3','4','5','6','7','8','9','0'
                                ,'~','!','#','$','%','^','&','*','(',')','_'
                                ,'+','=','\\',']','[','}','{',';',':','\"','?','>'
                                ,'<',',','|'};

		if(lastName.length()<2 || lastName.length()>20)
		{
			msg = "Name must in range of 2 - 20 characters!\n";
			isValid =false;
		}

		if(lastName.charAt(0)==' ')
		{
			msg = "First character of name cannot be <space>!\n";
			isValid = false;
		}

		for(int i=0;i<lastName.length();i++)
		{
			for(int j=0;j<num.length;j++)
			{
				if(lastName.charAt(i)==num[j])
				{
					msg += "Invalid character for Name: "+num[j];
					isValid = false;
					break;
				}
			}
			if(!isValid)
				break;
		}
		if(!isValid)
		{
			throw new NameFormatException(msg);
		}
                else
                    this.lastName = lastName;
	}

	public void setIC(String IC)throws ICFormatException
	{
		int month=0;
		int year=0;
		int day=0;

                if(IC.length()==12)
                {
        		month = Integer.parseInt(IC.charAt(2)+""+IC.charAt(3));
                	year = Integer.parseInt(IC.charAt(0)+""+IC.charAt(1));
                        day = Integer.parseInt(IC.charAt(4)+""+IC.charAt(5));
                }

		boolean isTrue = false;
		String msg = "";

		if (IC.length() != 12)
		{
			msg = "IC must be 12 digits!\n";
			isTrue = true;
		}

                else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
		{
                    if(day<=0 || day>31){
                        msg = "Invalid <Day>! Month "+month+" do no have "+day+" days";
                        isTrue = true;
                    }
		}
		else if (month == 4 || month == 6 || month == 9 || month == 11)
		{
					if(day<=0 || day>30){
                        msg = "Invalid <Day>! Month "+month+" do no have "+day+" days";
                        isTrue = true;
                    }
		}
		else if (month == 2)
		{
			if (year % 4 == 0)
			{
				if(day<=0 || day>29){
                        msg = "Invalid <Day>! Month "+month+" do no have "+day+" days";
                        isTrue = true;
                    }
			}
			else
			{
				if(day<=0 || day>28){
                        msg = "Invalid <Day>! Month "+month+" do no have "+day+" days";
                        isTrue = true;
                    }
			}
		}
		else
		{
                     msg = "Invalid <Month>! One year do not have "+month+" Months";
                     isTrue = true;
		}

		if (isTrue)
			throw new ICFormatException(msg);
                else
                    this.ic = IC;
	}

	public void setGender(String G)
	{ gender = G; }

	public void setPhone(String P)
	{ phone = P; }

	public String getID()
	{ return id; }
	
	public String getPassword()
	{ return password; }
	
	public String getFirstName()
	{ return firstName; }
	
	public String getLastName()
	{ return lastName; }

        public String getIC()
	{ return ic; }

	public String getGender()
	{ return gender; }

	public String getPhone()
	{ return phone; }
	
}