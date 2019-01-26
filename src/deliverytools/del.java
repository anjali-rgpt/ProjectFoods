package deliverytools;

import java.util.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.SwingUtilities;

public class  del extends JFrame{
	double a;
	double b=0;
	double d=0;
	String label[]=new String[6];
    double cost[]=new double[4];
    
	public void payment_admin(double c)
	{
		cost[0]=c;
		try {
			//FileInputStream f1=new FileInputStream("user_details");
			FileOutputStream f2=new FileOutputStream("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\deliverytools\\details.txt",true);
		double t;
		
		int f = 0;
		int fl=0;
		int fla=0;
		double p;
		String pno=null;
		String address=null;
		int flag=0;
		a=0.12*c;                     //a
		t=a+c;
		System.out.println("dine-in(d) or home delivery(h)?");
		char choice;
		Scanner in=new Scanner(System.in);
		while(flag==0)
		{
		choice=in.next().charAt(0);
		if(choice=='d')
		{
			flag=1;
			b=t;
		}
		else if(choice=='h')
		{
			flag=1;
			if(t<300)
			{	d=50;
			b=t+d;
			}
			else
				b=t;
			System.out.println("Enter 10 digits phone number: ");
			while(fl==0)
			{
			pno=in.next();
			if(pno.length()==10)
				fl=1;
			else
				System.out.println("Pleae re-enter a valid 10 digit phone number:");
			}
			label[4]="Phone number: "+pno;
			BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\Anjali Ragupathi\\\\eclipse-workspace\\\\ProjectFoods\\\\src\\\\deliverytools\\\\details.txt"));  
			String line = null;  
			while ((line = br.readLine()) != null)  
			{  //System.out.println(line);
				String data[]=line.split("/");
			    /*for(int i=0;i<10;i++)
			    {
			    	 if(line.charAt(i)==pno.charAt(i))
			    	     f=0;
			    	 else
			    		 f=1;
			    }*/
				if(data[0].contentEquals(pno))
				{ fla=1;
		    	System.out.println("Address available in our data base.\nYour food will be delivered to this address: ");
		    	 /*for(int j=10;j<line.length();j++)
				    {
		    		 address+=line.charAt(j);
				    }*/
		    	label[5]="Address: "+data[1];
		    	System.out.println(line);
		    	break;
					
				}
			  /*  if(f==0)
			    {
			    	fla=1;
			    	System.out.println("Address available in our data base./nYour food will be delivered to this address: ");
			    	 for(int j=10;j<line.length();j++)
					    {
			    		 address+=line.charAt(j);
					    }
			    	System.out.println(line);
			    	break;
			    	//br.mark(0);
				    //br.reset();
			    }*/
			}
			if(fla==0)
			    {
			    	System.out.println("Address not available in our database.\nplease enter address to be delivered:");
			    	address=in.next();
			    	label[5]="Address: "+address;
			    	String l=pno+'/'+address+"\n";
			    	byte b1[]=l.getBytes();
			    	f2.write(b1);//append to the file user_details.
			    	System.out.println("Address added to our data base./nYour food will be delivered to this address: ");
			    	System.out.println(address);
			    	
			    	br.mark(0);
				    br.reset();
			    }
			br.mark(0);
			br.reset();
			br.close();
			} 
		else
		{
			flag=0;
			System.out.println("Wrong option. Please Enter again: ");
		}
		}
		}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		cost[1]=a;
		cost[2]=d;
		cost[3]= b;
	
		/*cost[4]=Double.parseDouble(" ");
		cost[5]=Double.parseDouble(" ");*/
		label[0]="Total: ";
		label[1]="Tax: ";
		label[2]="Delivery Charge: ";
		label[3]="Grand Total: ";
	
		
	}
		String[] col_heads= {"  ","COST"};
	JTable del_table;
	
	
	public void initialize() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		}
		catch(Exception e) {
			System.out.println("Cannot create because of:"+e);
		}
	}
	
	
	private void makeGUI() {
		DefaultTableModel def=new DefaultTableModel(col_heads,0);
		del_table=new JTable(def);
		JScrollPane jsp=new JScrollPane(del_table);
		this.add(jsp);
		this.setTitle("BILL");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
	}


    

	public void LoadTable() throws Exception
	{
		DefaultTableModel m=(DefaultTableModel)del_table.getModel();
		Object[] da=new Object[2];
		   for(int i=0;i<4;i++) {
			//System.out.println(in[i]);
			
			/*String[] line=s.toString().split(";"
					+ "");*/
			//for(int j=0;j<line.length;j++)
			//	System.out.println(line[j]);
			da[0]=label[i];
			da[1]=cost[i];
			//data[2]=price[i];
			
			m.addRow(da);
		
	}
		   da[0]=label[4];
		   da[1]=null;
		   m.addRow(da);
		   da[0]=label[5];
		   da[1]=null;
		   m.addRow(da);
		   
}
}

	
