package deliverytools;



public class deltest {

	public void ExecuteDelivery(double tp) {
		// TODO Auto-generated method stub
		del d=new del();
		d.payment_admin(tp);
		d.initialize();
		try{
			d.LoadTable();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
