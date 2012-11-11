public class Member extends Person
{
	private double balance;
	private String question;
	private String answer;
	
	public Member()
	{
		super();
		balance = 10.0;
		question = "";
		answer = "";
	}
	
	public Member(String ID,String PW,String FN,String LN,String IC,String G,String P,double B,String Q, String A)
	{
		super(ID,PW,FN,LN,IC,G,P);
		setBalance(B);
		setQuestion(Q);
		setAnswer(A);
	}
	
	public void setBalance(double B)
	{ balance = B; }
	
	public void setQuestion(String Q)
	{ question = Q; }
	
	public void setAnswer(String A)
	{ answer = A; }
	
	public double getBalance()
	{ return balance; }
	
	public String getQuestion()
	{ return question; }
	
	public String getAnswer()
	{ return answer; }
}