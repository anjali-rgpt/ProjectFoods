package admintools;

public interface AdminOps {

	public void addItem(FoodItem f);
	public void removeItem(String fname);
	public void updatePrice(String f,double newprice);
	public void updateQuantity(String f,int newqty);
}
