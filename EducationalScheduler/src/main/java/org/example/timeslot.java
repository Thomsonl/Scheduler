package org.example;


public class timeslot {
	private long ID;
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
	public boolean addcourse(String a, classes b)
	{
		if(b.getCO()<b.getMO())
		{
			switch(a)
			{
			case "Monday":
				//if((course[1][b.gettime()-8]).equals("NULL\t"))
				course[1][b.gettime()-8]=(b.getCN()).concat("\t");
				//else
					//System.out.println("time conflict");
			case "Tuesday":
				course[2][b.gettime()-8]=(b.getCN()).concat("\t");
			case "Wednesday":
				course[3][b.gettime()-8]=(b.getCN()).concat("\t");
			case "Thurseday":
				course[4][b.gettime()-8]=(b.getCN()).concat("\t");
			case "Friday":
				course[5][b.gettime()-8]=(b.getCN()).concat("\t");
			case "Saturday":
				course[6][b.gettime()-8]=(b.getCN()).concat("\t");
			case "Sunday":
				course[7][b.gettime()-8]=(b.getCN()).concat("\t");
			}
			return true;
		}
		else
			return false;
	}
	public timeslot(long id)
	{
		ID=id;
		course=null;
	}
	
	public long getID()
	{
		return ID;
	}
	public void setID(long id) 
	{
		ID=id;
	}
	public void deletecourse(String a)
	{
		for(int i=1;i<8;i++)
		{
			for(int j=1;j<12;j++)
			{
				if(course[i][j].equals(a))
					course[i][j]="NULL\t";
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
