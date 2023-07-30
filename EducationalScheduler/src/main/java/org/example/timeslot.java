package org.example;

public class timeslot {
	private long ID;
	private String[] period= {"8:00-9:00","9:00-10:00","10:00-11:00","11:00-12:00","12:00-13:00","13:00-14:00","14:00-15:00","15:00-16:00","16:00-17:00","17:00-18:00","18:00-19:00","19:00-20:00",};
	private String[] monday;
	private String[] tuesday;
	private String[] wednesday;
	private String[] thursday;
	private String[] friday;
	private String[] saturday;
	private String[] sunday;
	

	//On account creation
	public timeslot(long id) {
		ID = id;
		String[] nullArray = {null, null, null, null, null, null, null, null, null, null, null, null};
		this.monday = nullArray;
		this.tuesday= nullArray;
		this.wednesday = nullArray;
		this.thursday = nullArray;
		this.friday= nullArray;
		this.saturday = nullArray;
		this.sunday = nullArray;
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
				monday[Integer.valueOf(b.gettime().charAt(0))-8]=(b.getCN()).concat("\t");
				//else
					//System.out.println("time conflict");
			case "Tuesday":
				tuesday[Integer.valueOf(b.gettime().charAt(0))-8]=(b.getCN()).concat("\t");
			case "Wednesday":
				wednesday[Integer.valueOf(b.gettime().charAt(0))-8]=(b.getCN()).concat("\t");
			case "Thursday":
				thursday[Integer.valueOf(b.gettime().charAt(0))-8]=(b.getCN()).concat("\t");
			case "Friday":
				friday[Integer.valueOf(b.gettime().charAt(0))-8]=(b.getCN()).concat("\t");
			case "Saturday":
				saturday[Integer.valueOf(b.gettime().charAt(0))-8]=(b.getCN()).concat("\t");
			case "Sunday":
				sunday[Integer.valueOf(b.gettime().charAt(0))-8]=(b.getCN()).concat("\t");
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
		String output = new String();
		for (int i = 0; i < monday.length - 1; i++){
			output += monday[i] + ",";
		}
		output += monday[monday.length - 1];
		return output;
	}
	public String gettuesdayday()
	{	
		String output = new String();
		for (int i = 0; i < tuesday.length - 1; i++){
			output += tuesday[i] + ",";
		}
		output += tuesday[tuesday.length - 1];
		return output;
	}
	public String getwednesdayday()
	{	
		String output = new String();
		for (int i = 0; i < wednesday.length - 1; i++){
			output += wednesday[i] + ",";
		}
		output += wednesday[wednesday.length - 1];
		return output;
	}
	public String getthursday()
	{	
		String output = new String();
		for (int i = 0; i < thursday.length - 1; i++){
			output += thursday[i] + ",";
		}
		output += thursday[thursday.length - 1];
		return output;
	}
	public String getfriday()
	{	
		String output = new String();
		for (int i = 0; i < friday.length - 1; i++){
			output += friday[i] + ",";
		}
		output += friday[friday.length - 1];
		return output;
	}
	public String getsaturdday()
	{	
		String output = new String();
		for (int i = 0; i < saturday.length - 1; i++){
			output += saturday[i] + ",";
		}
		output += saturday[saturday.length - 1];
		return output;
	}
	public String getsunday()
	{	
		String output = new String();
		for (int i = 0; i < sunday.length - 1; i++){
			output += sunday[i] + ",";
		}
		output += sunday[sunday.length - 1];
		return output;
	}
	
	//Acessor methods for all arrays that return string version of array(example: [1,2,3,4] -> "1,2,3,4")
	
}
