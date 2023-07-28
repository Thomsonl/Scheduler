package org.example;


public class timeslot {
	private long ID;
	String[] monday_array = new String[10];
	String[] tuesday_array;
	String[] wednesday_array;
	String[] thursday_array;
	String[] friday_array;
	String[] saturday_array;
	String[] sunday_array;
	private String[][] course= 
		{
				{"\t","8:00-9:00\t","9:00-10:00\t","10:00-11:00\t","11:00-12:00\t","12:00-13:00\t","13:00-14:00\t","14:00-15:00\t","15:00-16:00\t","16:00-17:00\t","17:00-18:00\t","18:00-19:00\t"},
				{"Monday|\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"},
				{"Tuesday|\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"},
				{"Wednesday|\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"},
				{"Thurseday|\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"},
				{"Friday|\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t",},
				{"Saturday|\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t",},
				{"Sunday|\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t","NULL\t"}
		};

	//On account creation
	public timeslot(long id) {
		ID=id;
		monday_array = {null, null, null, null, null, null, null, null, null, null};
		tuesday_array = {null, null, null, null, null, null, null, null, null, null};
		wednesday_array = {null, null, null, null, null, null, null, null, null, null};
		thursday_array = {null, null, null, null, null, null, null, null, null, null};
		friday_array = {null, null, null, null, null, null, null, null, null, null};
		saturday_array = {null, null, null, null, null, null, null, null, null, null};
		sunday_array = {null, null, null, null, null, null, null, null, null, null};
	}

	//Loading timeslot information
	public timeslot(long id, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
		ID=id;
		monday_array = monday.split(",");
		tuesday_array = tuesday.split(",");
		wednesday_array = wednesday.split(",");
		thursday_array = thursday.split(",");
		friday_array = friday.split(",");
		saturday_array = saturday.split(",");
		sunday_array = sunday.split(",");


	}

	public boolean addcourse(String a, classes b)
	{
		if(b.getCO()<b.getMO())
		{
			switch(a)
			{
			case "Monday":
				//if((course[1][b.gettime()-8]).equals("NULL\t"))
				course[1][b.gettime()-7]=(b.getCN()).concat("\t");
				//else
					//System.out.println("time conflict");
			case "Tuesday":
				course[2][b.gettime()-7]=(b.getCN()).concat("\t");
			case "Wednesday":
				course[3][b.gettime()-7]=(b.getCN()).concat("\t");
			case "Thursday":
				course[4][b.gettime()-7]=(b.getCN()).concat("\t");
			case "Friday":
				course[5][b.gettime()-7]=(b.getCN()).concat("\t");
			case "Saturday":
				course[6][b.gettime()-7]=(b.getCN()).concat("\t");
			case "Sunday":
				course[7][b.gettime()-7]=(b.getCN()).concat("\t");
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
			for(int i=1;i<12;i++)
			{
				if(course[1][i].equals(b))
					{
					course[1][i]="NULL\t";
					}
			}
		case "Tuesday":
				for(int i=1;i<12;i++)
			{
				if(course[2][i].equals(b))
				   course[2][i]="NULL\t";
			}
		case "Wednesday":
				for(int i=1;i<12;i++)
			{
				if(course[3][i].equals(b))
						
				   course[3][i]="NULL\t";
			}
		case "Thursday":
				for(int i=1;i<12;i++)
			{
				if(course[4][i].equals(b))
				   course[4][i]="NULL\t";
			}
		case "Friday":
				for(int i=1;i<12;i++)
			{
				if(course[5][i].equals(b))
				   course[5][i]="NULL\t";
			}
		case "Saturday":
				for(int i=1;i<12;i++)
			{
				if(course[6][i].equals(b))
				   course[6][i]="NULL\t";
			}
		case "Sunday":
				for(int i=1;i<12;i++)
			{
				if(course[7][i].equals(b))
				   course[7][i]="NULL\t";
		}		
		}
	}
	public void printcourse()
	{
		System.out.println(ID+"'s course:");
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<12;j++)
			{
				System.out.print(course[i][j]);
				if(j==11)
					System.out.println();
			}
			
		}
	}
	public String[] getlist()
	{
		String[] a=null;
		int k=0;
		for(int i=1;i<8;i++)
		{
			for(int j=1;j<12;j++)
			{
				if(!((course[i][j]).equals("NULL\t")))
				{
					a[k]=course[i][j];
					k++;
				}
			}
			
		}
		
		return a;
	}
	
}
