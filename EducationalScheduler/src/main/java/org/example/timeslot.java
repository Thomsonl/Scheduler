package org.example;

import java.util.Arrays;

public class timeslot {
	private long ID;
	String[]period= {"8:00-9:00\t","9:00-10:00\t","10:00-11:00\t","11:00-12:00\t","12:00-13:00\t","13:00-14:00\t","14:00-15:00\t","15:00-16:00\t","16:00-17:00\t","17:00-18:00\t","18:00-19:00\t","19:00-20:00\t",};
	String[] monday =  {"NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"};
	String[] tuesday= {"NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"};;
	String[] wednesday= {"NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"};;
	String[] thursday= {"NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"};;
	String[] friday= {"NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"};;
	String[] saturday= {"NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"};;
	String[] sunday= {"NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"};;
	

	//On account creation
	public timeslot(long id) {
		ID=id;
	}

	//Loading timeslot information
	public timeslot(long id, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
		ID=id;
		this.monday = monday.split(",");
		this.tuesday= tuesday.split(",");
		this.wednesday = wednesday.split(",");
		this.thursday = thursday.split(",");
		this.friday= friday.split(",");
		this.saturday = saturday.split(",");
		this.sunday = sunday.split(",");


	}

	public boolean addcourse(String a, classes b)
	{
		if(b.getCO()<b.getMO())
		{
			switch(a)
			{
			case "Monday":
				//if((course[1][b.gettime()-8]).equals("NULL\t"))
				monday[b.gettime()-8]=(b.getCN()).concat("\t");
				//else
					//System.out.println("time conflict");
			case "Tuesday":
				tuesday[b.gettime()-8]=(b.getCN()).concat("\t");
			case "Wednesday":
				wednesday[b.gettime()-8]=(b.getCN()).concat("\t");
			case "Thursday":
				thursday[b.gettime()-8]=(b.getCN()).concat("\t");
			case "Friday":
				friday[b.gettime()-8]=(b.getCN()).concat("\t");
			case "Saturday":
				saturday[b.gettime()-8]=(b.getCN()).concat("\t");
			case "Sunday":
				sunday[b.gettime()-8]=(b.getCN()).concat("\t");
			}
			return true;
		}
		else
			return false;
	}
	
	public long getID()
	{
		return ID;
	}
	public void setID(long id) 
	{
		ID=id;
	}
	public void deletecourse(String a,String b)
	{
		switch(a)
		{
		case "Monday":
			for(int i=0;i<12;i++)
			{
				if(monday[i].equals(b))
					monday[i]="NULL\t";
			}
		case "Tuesday":
				for(int i=0;i<12;i++)
			{
				if(tuesday[i].equals(b))
				   tuesday[i]="NULL\t";
			}
		case "Wednesday":
				for(int i=0;i<12;i++)
			{
				if(wednesday[i].equals(b))
						
				   wednesday[i]="NULL\t";
			}
		case "Thursday":
				for(int i=0;i<12;i++)
			{
				if(thursday[i].equals(b))
				   thursday[i]="NULL\t";
			}
		case "Friday":
				for(int i=0;i<12;i++)
			{
				if(friday[i].equals(b))
				   friday[i]="NULL\t";
			}
		case "Saturday":
				for(int i=0;i<12;i++)
			{
				if(saturday.equals(b))
				   saturday[i]="NULL\t";
			}
		case "Sunday":
				for(int i=0;i<12;i++)
			{
				if(sunday[i].equals(b))
				   sunday[i]="NULL\t";
		}		
		}
	}
	public void printcourse()
	{
		System.out.println(ID+"'s course:");
		System.out.print("\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(period[i]);
			if(i==11)
				System.out.println();
		}
		System.out.print("Monday:\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(monday[i]);
			if(i==11)
				System.out.println();
		}
		System.out.print("Tuesday:\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(tuesday[i]);
			if(i==11)
				System.out.println();
		}
		System.out.print("Wednesday:\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(wednesday[i]);
			if(i==11)
				System.out.println();
		}
		System.out.print("Thursday:\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(thursday[i]);
			if(i==11)
				System.out.println();
		}
		System.out.print("Friday:\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(friday[i]);
			if(i==11)
				System.out.println();
		}
		System.out.print("Saturday:\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(saturday[i]);
			if(i==11)
				System.out.println();
		}
		System.out.print("Sunday:\t");
		for(int i=0;i<12;i++)
		{
			System.out.print(sunday[i]);
			if(i==11)
				System.out.println();
		}
			
		
	}
	public String getmonday()
	{
		return Arrays.toString(monday);
	}
	public String gettuesdayday()
	{
		return Arrays.toString(tuesday);
	}
	public String getwednesdayday()
	{
		return Arrays.toString(wednesday);
	}
	public String getthursday()
	{
		return Arrays.toString(thursday);
	}
	public String getfriday()
	{
		return Arrays.toString(friday);
	}
	public String getsaturdday()
	{
		return Arrays.toString(saturday);
	}
	public String getsunday()
	{
		return Arrays.toString(sunday);
	}
	
	//Acessor methods for all arrays that return string version of array(example: [1,2,3,4] -> "1,2,3,4")
	
}
