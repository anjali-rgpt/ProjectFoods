package preptools;
import java.io.BufferedReader;
import admintools.FoodItem;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import admintools.*;

public class TestThread {

	public void ExecutePrep() {
		// TODO Auto-generated method stub

		
		FoodItem[] trayorder=new FoodItem[25];
		double totalprep=0.0;
		int j=0, flag=0;
		try {
		FileReader file=new FileReader("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\customerinterface\\order.txt");
        BufferedReader reader=new BufferedReader(file);
        reader.mark(0);
        reader.reset();
	      String i=null;
		  while((i=reader.readLine())!=null)
			  
		    {
              String[] line=i.split(" ");
              String n=line[0];
              System.out.println(n);
              String t=line[3];
              System.out.println(t);
              double p=Double.parseDouble(line[2]);
              System.out.println(p);
              int q=Integer.parseInt(line[1]);
              System.out.println(line[1]);
              double prp=Double.parseDouble(line[4]);
              System.out.println(prp);
              totalprep+=prp;
              FoodItem f=new FoodItem(n,p,q,t,prp);
              trayorder[j++]=f;
		   } 
		 reader.close();
		}
		catch(Exception e) {
			System.out.println("Error in reading file");
		}

		
		
		//for(int j=0;j<trayorder.length;j++)
		//	System.out.println(trayorder[j].getFood_name());
		Thread[] myThreads; // New array of threads
		myThreads = new Thread[25]; // Same size as our int array

		for (int i = 0; i < trayorder.length && trayorder[i]!=null; i++) {
		    CookTime wt = new CookTime(trayorder[i]);
		    myThreads[i] = new Thread(wt);
		}
		
		try {
			for(int m=0;m<trayorder.length && myThreads[m]!=null;m++) {
				
				System.out.println(trayorder[m].getFood_name()+" is now cooking");
				myThreads[m].join();
				if(myThreads[m+1]==null && !myThreads[m].isAlive()) {
					flag=1;
					orderConfirmed();
					break;
				}
			}
			
			
		}
		catch(Exception e) {
			System.out.println("Interruption of main thread");
		}
		

       
	}
	
	
	public static void orderConfirmed() {
		JFrame jf=new JFrame("Order ready for pickup");
		jf.setSize(275,100);
		jf.setResizable(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JLabel jlab=new JLabel("Thank you for dining with Amrita Foods");
		JLabel msg=new JLabel("Please pick up your order at counter");
		//jf.add(jlab);
		jf.add(msg);
		jf.setVisible(true);
	}

}
