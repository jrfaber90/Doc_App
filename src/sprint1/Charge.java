package sprint1;

import java.io.Serializable;

public class Charge implements Serializable {
	
	private static final long serialVersionUID = -7986390711718087094L;
	private String description;
	private double cost;
	
	public Charge(String descript, double cost) {
		this.description = descript;
		this.cost = cost;
	}
	
	public void changeCharge(double num , String str) {
		this.cost = num;
		this.description = str;
	}
	
	@Override
	public String toString() {
		return String.format("Description: %s, Cost: $%.2f", this.description, this.cost);
	}
	
}
