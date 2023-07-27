package org.example;


public class timeslot {
	private long ID;
	private String[] time= {"8: ","9: ","10: ","11: ","12: ","13: ","14: ","15: ","16: ","17: ","18: ","19: "};//TODO: Make this for all seven days a week
	private String[] course=null;
	public timeslot(long id)
	{
		ID=id;
		time=null;
		course=null;
		
	}
	public timeslot()
	{
	}
	public boolean addcourse(int a,classes b)//a is the time and b is the course
	{
		if (b.getCO()>=b.getMO())
		{
			return false;
		}
		course[a-8]=b.getCN();
		return true;
	}
	public long getID()
	{
		return ID;
	}
	public void setID(long id) 
	{
		ID=id;
	}
	public String getlist()
	{
		String list = ""; //TODO: This needs to output string of all courses assigned to this person
		return list;
	}
	public void print()
	{
		System.out.println(ID+"'s course:");
		for(int i=0;i<time.length;i++)
		{
			System.out.println(time[i]+course[i]);
			
		}
	}
	public void deletecourse(int a)
	{
		course[a-8]="null";
	}
	
}
