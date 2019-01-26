package customerinterface;

import java.io.*;
import java.util.*;
//import admintools.*;

public class amritafood {
	//private int quantity;
	public void ExecuteCustomerUI()throws FileNotFoundException,IOException
	{	Scanner s=new Scanner(System.in);
		//FileInputStream f=new FileInputStream("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\customerinterface\\order.txt");
		//FileOutputStream f1=new FileOutputStream("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\customerinterface\\order.txt");
		File f=new File("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\admintools\\StoreTableData.txt");
	    File f2=new File("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\customerinterface\\order.txt");
		System.out.println("WELCOME TO AMRITA FOOD");
		BufferedReader reader=new BufferedReader(new FileReader(f));
		BufferedWriter writer=new BufferedWriter(new FileWriter(f2));
		System.out.println("MENU:");
		System.out.println("ITEM   TYPE   PRICE");
		
		String s2=null;
		
		//System.out.println("s--"+s1);
		//Object[] rows=bis.lines().toArray();
		while((s2=reader.readLine())!=null) {
			//System.out.println(s1.toString());
			Object[] data2=new Object[5];
			String[] line2=s2.toString().split(";"+"");
			//for(int j=0;j<line.length;j++)
			//	System.out.println(line[j]);
			System.out.println(line2[0]+"  "+line2[1]+"  "+line2[2]);
		}
		//reader.mark(0);
		//reader.reset();
		reader=new BufferedReader(new FileReader(f));
		
			
		System.out.println("PLEASE GIVE YOUR ORDER");
		int flag=0;
		while(true)
		{
			
			System.out.println("\nENTER ITEM: ");
			String order=s.next();
			String s1=null;
			
			//System.out.println("s--"+s1);
			//Object[] rows=bis.lines().toArray();
			while((s1=reader.readLine())!=null) {
				//System.out.println(s1.toString());
				Object[] data=new Object[5];
				String[] line1=s1.toString().split(";"+"");
				//for(int j=0;j<line.length;j++)
				//	System.out.println(line[j]);
				data[0]=line1[0];
				String t=line1[0];
				//System.out.println(t+" "+order);
				flag=0;
				if(t.equals(order))
				{
					flag=1;
					data[1]=line1[1];
					data[2]=Double.parseDouble(line1[2]);
					data[3]=Integer.parseInt(line1[3]);
					data[4]=Double.parseDouble(line1[4]);

					System.out.println("\nENTER QUANTITY");
					String quantity=s.next();
					String price=data[2].toString();
					if((int)data[3]>=Integer.parseInt(quantity))
					{
						System.out.println("X");
						String ss=order+" "+quantity+" "+price+" "+data[1].toString()+" "+data[4].toString()+" "+data[3].toString();
						//byte[] b=ss.getBytes();
						writer.write(ss);
						writer.write("\n");
						//System.out.println("Written:"+ss);
						flag=1;
						reader.mark(0);
						reader.reset();
						break;
					}
					else
					{
						System.out.println("\nSORRY REQUIRED QUANTITY NOT AVAILABLE");
					}
				}
			
				//else
				//{
					
				//	System.out.println("\nSORRY ITEM NOT AVALIABLE");
				//}
				//s1=reader.readLine();
				reader.mark(0);
				reader.reset();
				
				
			}

			if(flag==0)
				System.out.println("\nSORRY ITEM NOT AVAILABLE");
			
			
			System.out.println("DO YOU WANT TO ORDER MORE?\nIF YES PRESS 1 ELSE 0");
			try{
				int n=s.nextInt();
				if(n==0)
				{
					break;
				}

			}
			catch(Exception e)
			{
				System.out.println("ENTER VALID INPUT");
				System.out.println("DO YOU WANT TO ORDER MORE?\nIF YES PRESS 1 ELSE 0");
				int n=s.nextInt();
				if(n==0)
				{
					break;
				}
				System.out.println("INVALID INPUT");

				//continue;
			}
			;
		reader.close();
		reader=new BufferedReader(new FileReader(f));
			
		}
		
		reader.close();
		writer.close();
	}
}