package finalproject;

import javax.swing.ImageIcon;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Scanner;
import admintools.*;
import customerinterface.*;
import deliverytools.*;
import preptools.*;
import orderconfirm.*;
import userCheck.*;

public class TestClass  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input=new Scanner(System.in);
		JFrame label=new JFrame("Welcome");
		label.setSize(275,100);
		label.setResizable(true);
		//label.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon iconLogo = new ImageIcon("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\finalproject\\My Post.jpg");
		JLabel lb=new JLabel();
		lb.setIcon(iconLogo);
		label.add(lb);
		label.setVisible(true);
		
		int ch=0;
		try {
		while(true) {
			System.out.println("Welcome to Amrita Foods");
			System.out.println("1 for admin, 2 for user, 3 to quit:");
			ch=input.nextInt();
			if(ch==1) {
				UserValidity u=new UserValidity(1);
				if(u.SysAdmin()) {
				
				TestFunctions t=new TestFunctions();
				t.ExecuteAdmin();
				break;
				}
				else
				{
					System.out.println("Unauthorized access");
					break;
				}
			}
			
			else if(ch==2){
				
				int cancel=0;
				amritafood a=new amritafood();    //sanjana
				a.ExecuteCustomerUI();
				test order=new test();            //aradhana
				deltest delivery=new deltest();    //abhinaya
				double q=order.ExecuteConfirm();
				System.out.println(q);
				delivery.ExecuteDelivery(q);
				System.out.println("Click 1 to cancel , 2 to confirm:");
				cancel=input.nextInt();
				
				if(cancel==1)
					continue;
				else if(cancel==2)
				{
				
				FoodTable f=new FoodTable();
				
				File xp=new File("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\admintools\\StoreTableData.txt");
				f.initialize();
				f.LoadTable(xp);
				//System.out.println("HERE");
				
			   Reader fr=new FileReader("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\customerinterface\\order.txt");
			   BufferedReader bfr=new BufferedReader(fr);
			   String yr=null;
			   while((yr=bfr.readLine())!=null) {
				   System.out.println(yr);
				   String[] lin=yr.split(" ");
				   System.out.println(lin[0]);
				   f.updateQuantity(lin[0], Integer.parseInt(lin[5])-Integer.parseInt(lin[1]));
			   }
			   bfr.close();
			   f.SaveTable(xp);
				
				
				TestThread tq=new TestThread();
				tq.ExecutePrep();
				System.out.println("THANK YOU");
				break;
				}
				
				else 
					System.out.println("Invalid. Your order will be removed from system.");
	            
				
			}
			
			else
				System.out.println("Invalid");
		}
        
	}
	
	catch(Exception e) {
		System.out.println("Exception:"+e);
	}
	}
}
