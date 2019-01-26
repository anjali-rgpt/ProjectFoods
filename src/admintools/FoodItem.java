package admintools;

public class FoodItem {

	private String food_name;
	private double price;
	private int quantity;
	private String type;
	private double prep_time;
	
	public FoodItem() {
		food_name="UNDEF";
		price=0;
		quantity=0;
		type="UNDEF";
		prep_time=0;
	}
	
	public FoodItem(String food_name,double price,int quantity,String type,double prep_time) {
		this.food_name=food_name;
		this.price=price;
		this.quantity=quantity;
		this.type=type;
		this.prep_time=prep_time;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrep_time() {
		return prep_time;
	}

	public void setPrep_time(double prep_time) {
		this.prep_time = prep_time;
	}
	
	
}
