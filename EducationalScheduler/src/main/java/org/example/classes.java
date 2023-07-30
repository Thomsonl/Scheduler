package org.example;

public class classes {
	private String ClassName;
	private String Professor;
	private int ClassID;
	private String RoomNum;
	private int MaxOccupancy;
	private int CurrentOccupancy;
	private String Time;
	
	public classes()
	{
		ClassName=null;
		Professor=null;
		ClassID=0;
		Time=null;
		RoomNum=null;
		MaxOccupancy=0;
		CurrentOccupancy=0;
	}
	public classes(String ClassName, String Time, String Professor, double ClassID, String RoomNum, double MaxOccupancy, double CurrentOccupancy)
    {
		this.Time = Time;
		this.ClassName = ClassName;
		this.Professor = Professor;
		this.ClassID = (int) ClassID;
		this.RoomNum = RoomNum;
		this.MaxOccupancy = (int) MaxOccupancy;
		this.CurrentOccupancy= (int) CurrentOccupancy;
	}
	/*public void settime(String a)
	{
		if(Integer.valueOf(a)<20&&Integer.valueOf(a)>7)
			time=a;
		else
			System.out.println("invalid time");
	}*/
	public String gettime()
	{
		return Time;
	}
	public void setCN(String a)
	{
		ClassName=a;
	}
	public void setPro(String a)
	{
		Professor=a;
	}
	public void setCID(int a)
	{
		ClassID=a;
	}
	public void setRN(String a)
	{
		RoomNum=a;
	}
	public void setMO(int a)
	{
		MaxOccupancy=a;
	}
	public void setCO(int a)
	{
		CurrentOccupancy=a;
	}
	public  String getCN()
	{
		return ClassName;
	}
	public String getPro()
	{
		return Professor;
	}
	public String getRN()
	{
		return RoomNum;
	}
	public int getMO()
	{
		return MaxOccupancy;
	}
	public int getCO()
	{
		return CurrentOccupancy;
	}
	public int getCID()
	{
		return ClassID;
	}
	public void print()
	{
		System.out.println(Time+":00");
		System.out.println(ClassName);
		System.out.println(Professor);
		System.out.println(ClassID);
		System.out.println(RoomNum);
		System.out.println(CurrentOccupancy+"/"+MaxOccupancy);
	}
		
}
