package preptools;
import javax.swing.JFrame;
import javax.swing.JLabel;

import admintools.*;

public class CookTime extends Thread{
	String name;
	Thread t;
	FoodItem x;
	//FoodItem[] tray=new FoodItem[25];
	static int i=0;

	public CookTime() {
		
	}
	
	public CookTime(FoodItem f) {
		System.out.println("Food name:"+f.getFood_name());
		x=f;
		//flist=tray;
		t=new Thread(this,f.getFood_name());
		t.start();
	}
	
	public void run() {
		try {
			System.out.println("Starting preparation of :"+x.getFood_name());
			Thread.sleep(1000*60*(int)
					x.getPrep_time()*x.getQuantity());
		}
		catch(Exception e) {
			System.out.println("Interruption");
		}
		
		if((i+1)==24)
			System.out.println("TRAY SPACE MAXXED");
		else {
		//tray[i++]=x;
		System.out.println(x.getFood_name()+"Added to tray");
		}
	}
	
	
	
	
}
