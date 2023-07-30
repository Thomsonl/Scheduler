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
				switch(b.gettime())
				{
				case"8:00-9:00":
					monday[0]=b.getCN();
				case"9:00-10:00":
					monday[1]=b.getCN();
				case"10:00-11:00":
					monday[2]=b.getCN();
				case"11:00-12:00":
					monday[3]=b.getCN();
				case"12:00-13:00":
					monday[4]=b.getCN();
				case"13:00-14:00":
					monday[5]=b.getCN();
				case"14:00-15:00":
					monday[6]=b.getCN();
				case"15:00-16:00":
					monday[7]=b.getCN();
				case"16:00-17:00":
					monday[8]=b.getCN();
				case"17:00-18:00":
					monday[9]=b.getCN();
				case"18:00-19:00":
					monday[10]=b.getCN();
				case"19:00-20:00":
					monday[11]=b.getCN();
					
				}
			case "Tuesday":
				switch(b.gettime())
				{
				case"8:00-9:00":
					tuesday[0]=b.getCN();
				case"9:00-10:00":
					tuesday[1]=b.getCN();
				case"10:00-11:00":
					tuesday[2]=b.getCN();
				case"11:00-12:00":
					tuesday[3]=b.getCN();
				case"12:00-13:00":
					tuesday[4]=b.getCN();
				case"13:00-14:00":
					tuesday[5]=b.getCN();
				case"14:00-15:00":
					tuesday[6]=b.getCN();
				case"15:00-16:00":
					tuesday[7]=b.getCN();
				case"16:00-17:00":
					tuesday[8]=b.getCN();
				case"17:00-18:00":
					tuesday[9]=b.getCN();
				case"18:00-19:00":
					tuesday[10]=b.getCN();
				case"19:00-20:00":
					tuesday[11]=b.getCN();
					
				}
			case "Wednesday":
				switch(b.gettime())
				{
				case"8:00-9:00":
					wednesday[0]=b.getCN();
				case"9:00-10:00":
					wednesday[1]=b.getCN();
				case"10:00-11:00":
					wednesday[2]=b.getCN();
				case"11:00-12:00":
					wednesday[3]=b.getCN();
				case"12:00-13:00":
					wednesday[4]=b.getCN();
				case"13:00-14:00":
					wednesday[5]=b.getCN();
				case"14:00-15:00":
					wednesday[6]=b.getCN();
				case"15:00-16:00":
					wednesday[7]=b.getCN();
				case"16:00-17:00":
					wednesday[8]=b.getCN();
				case"17:00-18:00":
					wednesday[9]=b.getCN();
				case"18:00-19:00":
					wednesday[10]=b.getCN();
				case"19:00-20:00":
					wednesday[11]=b.getCN();
					
				}
			case "Thursday":
				switch(b.gettime())
				{
				case"8:00-9:00":
					thursday[0]=b.getCN();
				case"9:00-10:00":
					thursday[1]=b.getCN();
				case"10:00-11:00":
					thursday[2]=b.getCN();
				case"11:00-12:00":
					thursday[3]=b.getCN();
				case"12:00-13:00":
					thursday[4]=b.getCN();
				case"13:00-14:00":
					thursday[5]=b.getCN();
				case"14:00-15:00":
					thursday[6]=b.getCN();
				case"15:00-16:00":
					thursday[7]=b.getCN();
				case"16:00-17:00":
					thursday[8]=b.getCN();
				case"17:00-18:00":
					thursday[9]=b.getCN();
				case"18:00-19:00":
					thursday[10]=b.getCN();
				case"19:00-20:00":
					thursday[11]=b.getCN();
					
				}
			case "Friday":
				switch(b.gettime())
				{
				case"8:00-9:00":
					friday[0]=b.getCN();
				case"9:00-10:00":
					friday[1]=b.getCN();
				case"10:00-11:00":
					friday[2]=b.getCN();
				case"11:00-12:00":
					friday[3]=b.getCN();
				case"12:00-13:00":
					friday[4]=b.getCN();
				case"13:00-14:00":
					friday[5]=b.getCN();
				case"14:00-15:00":
					friday[6]=b.getCN();
				case"15:00-16:00":
					friday[7]=b.getCN();
				case"16:00-17:00":
					friday[8]=b.getCN();
				case"17:00-18:00":
					friday[9]=b.getCN();
				case"18:00-19:00":
					friday[10]=b.getCN();
				case"19:00-20:00":
					friday[11]=b.getCN();
					
				}
			case "Saturday":
				switch(b.gettime())
				{
				case"8:00-9:00":
					saturday[0]=b.getCN();
				case"9:00-10:00":
					saturday[1]=b.getCN();
				case"10:00-11:00":
					saturday[2]=b.getCN();
				case"11:00-12:00":
					saturday[3]=b.getCN();
				case"12:00-13:00":
					saturday[4]=b.getCN();
				case"13:00-14:00":
					saturday[5]=b.getCN();
				case"14:00-15:00":
					saturday[6]=b.getCN();
				case"15:00-16:00":
					saturday[7]=b.getCN();
				case"16:00-17:00":
					saturday[8]=b.getCN();
				case"17:00-18:00":
					saturday[9]=b.getCN();
				case"18:00-19:00":
					saturday[10]=b.getCN();
				case"19:00-20:00":
					saturday[11]=b.getCN();
					
				}
			case "Sunday":
				switch(b.gettime())
				{
				case"8:00-9:00":
					sunday[0]=b.getCN();
				case"9:00-10:00":
					sunday[1]=b.getCN();
				case"10:00-11:00":
					sunday[2]=b.getCN();
				case"11:00-12:00":
					sunday[3]=b.getCN();
				case"12:00-13:00":
					sunday[4]=b.getCN();
				case"13:00-14:00":
					sunday[5]=b.getCN();
				case"14:00-15:00":
					sunday[6]=b.getCN();
				case"15:00-16:00":
					sunday[7]=b.getCN();
				case"16:00-17:00":
					sunday[8]=b.getCN();
				case"17:00-18:00":
					sunday[9]=b.getCN();
				case"18:00-19:00":
					sunday[10]=b.getCN();
				case"19:00-20:00":
					sunday[11]=b.getCN();
					
				}
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
