package org.example;

public class classes {
	private String ClassName;
	private String Professor;
	private int ClassID;
	private String RoomNum;
	private int MaxOccupancy;
	private int CurrentOccupancy;
	
	public classes()
	{
		ClassName=null;
		Professor=null;
		ClassID=0;
		RoomNum=null;
		MaxOccupancy=0;
		CurrentOccupancy=0;
	}
	public classes(String ClassNamenew, String Professornew, int ClassIDnew, String RoomNumnew, int MaxOccupancynew, int CurrentOccupancynew)
	{
		ClassName=ClassNamenew;
		Professor=Professornew;
		ClassID=ClassIDnew;
		RoomNum=RoomNumnew;
		MaxOccupancy=MaxOccupancynew;
		CurrentOccupancy=CurrentOccupancynew;
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
	public String getCN()
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
		System.out.println(ClassName);
		System.out.println(Professor);
		System.out.println(ClassID);
		System.out.println(RoomNum);
		System.out.println(CurrentOccupancy＋"/"＋MaxOccupancy);
	}

		
}
