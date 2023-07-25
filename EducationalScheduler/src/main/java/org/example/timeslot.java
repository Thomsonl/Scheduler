package org.example;


public class timeslot {
	private long ID;
	private String[] time= {"8: ","9: ","10: ","11: ","12: ","13: ","14: ","15: ","16: ","17: ","18: ","19: "};
	private classes[] course=null;
	public timeslot(long id)
	{
		ID=id;
		time=null;
		course=null;
		
	}
	public boolean addcourse(int a,classes b)//a is the time and b is the course
	{
		if (b.getCO()>=b.getMO())
		{
			return false;
		}
		course[a-8]=b;
		return true; //Probably switch this and run a add occupancy method before adding, should ensure that once added, co is not > than mo
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
		for(int i=0;i<time.length;i++)
		{
			System.out.println(time[i]+course[i]);
			
		}
	}
	public void deletecourse(int a)
	{
		course[a-8]=null;
	}
	
}
