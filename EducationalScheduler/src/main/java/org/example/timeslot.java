package org.example;


public class timeslot {
	private long ID;
	private String[][] timeboard=null;
	public timeslot()
	{
		ID=0;
		timeboard=new String[][] 
				{
			{"8:  ","null"},
			{"9:  ","null"},
			{"10: ","null"},
			{"11: ","null"},
			{"12: ","null"},
			{"13: ","null"},
			{"14: ","null"},
			{"15: ","null"},
			{"16: ","null"},
			{"17: ","null"},
			{"18: ","null"},
			{"19: ","null"},
			};
	}
	public void addcourse(int a,String b)//a is the time and b is the course
	{
		timeboard[a-8][1]=b;
	}
	public long getID()
	{
		return ID;
	}
	public void setID(long id) 
	{
		ID=id;
	}
	public void print()
	{
		System.out.println(ID+"'s course:");
		for(int i=0;i<timeboard.length;i++)
		{
			System.out.println(timeboard[i][0]+timeboard[i][1]);
			
		}
	}
	public void deletecourse(int a)
	{
		timeboard[a-8][1]="null";
	}
	
}
