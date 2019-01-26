package orderconfirm;
import java.util.Scanner;
import java.io.*;
public class test {

	public double ExecuteConfirm() {
		
		// TODO Auto-generated method stub
		myclass c=new myclass();
		Scanner input=new Scanner(System.in);
		File datafile=new File("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\customerinterface\\order.txt");
		Reader f;
		BufferedReader b;
		//System.out.
		try {
		f=new FileReader(datafile);
		b=new BufferedReader(f);
			
		if(b.readLine()==null ) {		
		    c.initialize();
		    System.out.println("Empty");
		    b.mark(0);
		    b.reset();
		    return 0;
		}
		
		else {
			try {
				//System.out.println("IN");
				c.initialize();
				b.mark(0);
				b.reset();
				c.calprice();
				c.LoadTable();
				

			}
			catch(Exception e) {
			   System.out.println("Opening Issue: Empty or such");
			}
		}
		
		b.close();
		return c.calprice()/2;
		}
		
		catch(Exception e) {
			System.out.println("Not found");
		}
		return 0;
		
		

	}

}
