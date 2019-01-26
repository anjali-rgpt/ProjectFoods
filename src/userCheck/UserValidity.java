package userCheck;

import java.util.Scanner;
import java.io.*;

public class UserValidity {

	String access=null;
	String user=null;
	String pass=null;
	Scanner input=new Scanner(System.in);
	
	public UserValidity(int i) {
		if(i==1)
			access="admin";
		if(i==2)
			access="cust";
	}
	
	public boolean SysAdmin() {
		System.out.println("Enter user name:");
		user=input.next();
		System.out.println("Enter password:");
		pass=input.next();
		if(user.toLowerCase().equals("sysadmin")&& pass.toLowerCase().equals("root"))
			return true;
		else
			return false;
	}
	
	
}
