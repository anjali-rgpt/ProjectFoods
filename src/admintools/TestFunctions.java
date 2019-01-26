package admintools;
import java.util.Scanner;
import java.io.*;

public class TestFunctions {

	public void ExecuteAdmin() {
		// TODO Auto-generated method stub

		Scanner input=new Scanner(System.in);
		FoodTable table=new FoodTable();
		String storepath="C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\admintools\\StoreTableData.txt";
		File datafile=new File(storepath);
		Reader f;
		BufferedReader b;
		//System.out.
		try {
		f=new FileReader(datafile);
		b=new BufferedReader(f);
			
		if(b.readLine()==null ) {		
		    table.initialize();
		    System.out.println("Empty");
		    b.mark(0);
		    b.reset();
		}
		
		else {
			try {
				table.initialize();
				b.mark(0);
				b.reset();
				table.LoadTable(datafile);
				
			}
			catch(Exception e) {
			   System.out.println("Opening Issue: Empty or such");
			}
		}
		
		b.close();
		}
		
		catch(Exception e) {
			System.out.println("Not found");
		}
		int ch;
		while(true) {
			
			System.out.println("1. Add 2.Remove 3.Update Price 4.Update Qty 5.Quit");
			try {
			ch=input.nextInt();
			 
			if (ch==1) {
				String type,name;
				int q;
				double price, prep;
				System.out.print("\nEnter name:");
				name=input.next();
				System.out.print("\nEnter type:");
				type=input.next();
				System.out.print("\nEnter price:");
				price=input.nextDouble();
				System.out.print("\nEnter prep time:");
				prep=input.nextDouble();
				System.out.print("\nEnter quantity:");
				q=input.nextInt();
				
				FoodItem food=new FoodItem(name,price,q,type,prep);
				
				table.addItem(food);
			
			}
			else if (ch== 2) {
				String xname;
				System.out.print("\nEnter name:");
				xname=input.next();
				table.removeItem(xname);
			}
			else if(ch== 3) {
				String pname;
				System.out.print("\nEnter name:");
				pname=input.next();
				System.out.println("Enter new price:");
				double p=input.nextDouble();
				table.updatePrice(pname, p);
			}	
			else if(ch==4) {
				String qname;
				System.out.print("\nEnter name:");
				qname=input.next();
				System.out.println("Enter new quantity:");
				int qt=input.nextInt();
				table.updateQuantity(qname, qt);
			}	
			else if(ch==5) {
				try {
				table.SaveTable(datafile);
				}
				catch(Exception e) {
					System.out.println("Error Storing:"+e);
				}
				
				break;
			}
			
			else
				System.out.println("INVALID");
				
		}
		
			catch(Exception e) {
				System.out.println("Invalid Exception:"+e);
				//continue;
			}
		}
	}

}
