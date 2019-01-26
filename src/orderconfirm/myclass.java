package orderconfirm;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
//import java.util.Iterator;
//import java.util.Vector;

import javax.swing.SwingUtilities;

public class myclass extends JFrame {
	double totprice=0;
	int[] quan=new int[100];
	double price[]=new double[100];
	String[] name=new String[100];
	String[] in=new String[100];
	String[] col_heads= {"FOOD_NAME","PRICE","QUANTITY"};
	JTable bill_table;
	public void initialize() {
		try {
			//System.out.println("In initializable");
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
		bill_table=new JTable(def);
		JScrollPane jsp=new JScrollPane(bill_table);
		this.add(jsp);
		this.setTitle("ORDER");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
	}
	public void LoadTable() throws Exception
	{
		DefaultTableModel m=(DefaultTableModel)bill_table.getModel();
		
		//Reader fis=new FileReader("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\admintools\\StoreTableData.txt");
		//BufferedReader bis=new BufferedReader(fis);
		//String first=bis.readLine().trim();
		//String s=null;
		//Object[] rows=bis.lines().toArray();
		   Object[] data=new Object[5];
		   for(int i=0;i<quan.length && quan[i]!=0;i++) {
			System.out.println(in[i]);
			
			/*String[] line=s.toString().split(";"
					+ "");*/
			//for(int j=0;j<line.length;j++)
			//	System.out.println(line[j]);
			data[0]=name[i];
			data[1]=price[i];
			data[2]=quan[i];
			
			m.addRow(data);
			//System.out.println("ADDED");
		}
		data[0]="Total";
		data[1]="-";
		data[2]=totprice;
		m.addRow(data);
			  
	}

public double calprice()throws Exception	     
         {
	     FileReader file=new FileReader("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\customerinterface\\order.txt");
         BufferedReader reader=new BufferedReader(file);
         //System.out.println("Whoo");
         reader.mark(0);
         reader.reset();
	      String i=null;int j=0;
		  while((i=reader.readLine())!=null && j<in.length)
			  
		    {
			in[j]=i;
		    String[] temp = i.split(" ");
		    name[j]=temp[0]; 
		    quan[j]=Integer.parseInt(temp[1]);
		    System.out.println(quan[j]);
		    price[j]=Double.parseDouble(temp[2]);
		    //System.out.println("here now");
		    totprice+=quan[j]*price[j];  
		    j++;
		   } 
		 reader.close();
		 return totprice;
	  }
	   
	  
	
	
	

}

