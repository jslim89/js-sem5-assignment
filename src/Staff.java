public class Staff extends Person
{
    private String position;
    private String address;
    private String postcode;
    private String town;
    private String state;
    private String country;
    private double salary;

	public Staff()
	{
		super();
                position = "";
                address = "";
                postcode ="";
                town = "";
                state = "";
                country = "";
                salary = 0.0;
	}
	
	public Staff(String ID,String PW,String FN,String LN,String IC,String G,String P,String position,String address,String postcode,String town,String state,String country,double salary)
	{
		super(ID,PW,FN,LN,IC,G,P);
                this.position = position;
                this.address = address;
                this.postcode = postcode;
                this.town = town;
                this.state = state;
                this.country = country;
                this.salary = salary;
	}

        public void setPosition(String P)
        {this.position = P;}

        public void setAddress(String A)
        {this.address = A;}

        public void setPostcode(String P) throws PostcodeException
        {
            if(P.length()!=5)
                throw new PostcodeException("Invalid Postcode length: "+P.length());
            else
                this.postcode = P;
        }

        public void setTown(String T)
        {this.town = T;}

        public void setState(String S)
        {this.state = S;}

        public void setCountry(String C)
        {this.country = C;}

        public void setSalary(double S)
        {this.salary = S;}

        public String getPosition()
        {return position;}

        public String getAddress()
        {return address;}

        public String getPostcode()
        {return postcode;}

        public String getTown()
        {return town;}

        public String getState()
        {return state;}

        public String getCountry()
        {return country;}

        public double getSalary()
        {return salary;}
}