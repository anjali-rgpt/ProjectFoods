package admintools;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.SwingUtilities;

public class FoodTable extends JFrame implements AdminOps,Serializable {

	String[] col_heads= {"FOOD_NAME","TYPE","PRICE","QUANTITY","PREP_TIME"};
	JTable food_table;
	
	
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
		food_table=new JTable(def);
		JScrollPane jsp=new JScrollPane(food_table);
		this.add(jsp);
		this.setTitle("INVENTORY");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        this.pack();
        this.setVisible(true);
	}


	public void addItem(FoodItem f) {
		// TODO Auto-generated method stub
		String fname=f.getFood_name();
		String ftype=f.getType();
		int fqty=f.getQuantity();
		double fprice=f.getPrice();
		double fprep=f.getPrep_time();
		
		Object[]row=new Object[5];
		row[0]=fname;
		row[1]=ftype;
		row[2]=fprice;
		row[3]=fqty;
		row[4]=fprep;
		
		DefaultTableModel model = (DefaultTableModel) food_table.getModel();
		model.addRow(row);
		System.out.println("ITEM ADDED");	
	}


	
	public void removeItem(String fname) {
		// TODO Auto-generated method stub
		for(int i = 0; i < food_table.getRowCount(); i++){//For each row
	        for(int j = 0; j < food_table.getColumnCount(); j++){//For each column in that row
	            if(food_table.getModel().getValueAt(i, 0).equals(fname)){//Search the model
	                System.out.println("Deleting");
	                DefaultTableModel model = (DefaultTableModel) food_table.getModel();
	                model.removeRow(i);
	            }
	        }//For loop inner
	    }
	}


	@Override
	public void updatePrice(String f, double newprice) {
		// TODO Auto-generated method stub
		for(int i = 0; i < food_table.getRowCount(); i++){//For each row
	        for(int j = 0; j < food_table.getColumnCount(); j++){//For each column in that row
	            if(food_table.getModel().getValueAt(i, 0).equals(f)){//Search the model
	               System.out.println("Updating price");
	                DefaultTableModel model = (DefaultTableModel) food_table.getModel();
	                model.setValueAt(newprice, i, 2);
	                break;
	            }
	        }//For loop inner
	    }
	}


	@Override
	public void updateQuantity(String f, int newqty) {
		// TODO Auto-generated method stub
		for(int i = 0; i < food_table.getRowCount(); i++){//For each row
	        for(int j = 0; j < food_table.getColumnCount(); j++){//For each column in that row
	            if(food_table.getModel().getValueAt(i,0).equals(f)){//Search the model
	                System.out.println("Updating quantity");
	                DefaultTableModel model = (DefaultTableModel) food_table.getModel();
	                model.setValueAt(newqty, i, 3);
	                break;
	            }
	        }//For loop inner
	    }
	}
	
	public void SaveTable(File f) throws Exception{
		//DefaultTableModel m=(DefaultTableModel)food_table.getModel();
		Writer fos=new FileWriter("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\admintools\\StoreTableData.txt");
		BufferedWriter bos=new BufferedWriter(fos);
		for(int i=0;i<food_table.getRowCount();i++) {
			for(int j=0;j<food_table.getColumnCount();j++) {
				
				if(j==0 || j==1 )
					bos.write((String)food_table.getModel().getValueAt(i, j)+";");
				else
					bos.write(String.valueOf(food_table.getModel().getValueAt(i, j))+";");
				bos.flush();
			}
			bos.write("\n");
		}
		bos.close();
		fos.close();
	}
	
	public void LoadTable(File f) throws Exception
	{
		DefaultTableModel m=(DefaultTableModel)food_table.getModel();
		Reader fis=new FileReader("C:\\Users\\Anjali Ragupathi\\eclipse-workspace\\ProjectFoods\\src\\admintools\\StoreTableData.txt");
		BufferedReader bis=new BufferedReader(fis);
		//String first=bis.readLine().trim();
		String s=null;
		//Object[] rows=bis.lines().toArray();
		while((s=bis.readLine())!=null) {
			System.out.println(s.toString());
			Object[] data=new Object[6];
			String[] line=s.toString().split(";"
					+ "");
			//for(int j=0;j<line.length;j++)
			//	System.out.println(line[j]);
			data[0]=line[0];
			data[1]=line[1];
			data[2]=Double.parseDouble(line[2]);
			data[3]=Integer.parseInt(line[3]);
			data[4]=Double.parseDouble(line[4]);
			data[5]="";
			m.addRow(data);
			//System.out.println("ADDED");
		}
        bis.close();
	}
}
