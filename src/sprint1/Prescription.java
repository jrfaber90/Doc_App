package sprint1;

import java.io.Serializable;

public class Prescription implements Serializable {
	
	private static final long serialVersionUID = 6633472206763837604L;
	private String name;
	private int quantity;
	
	public Prescription(String n, int c) {
		this.setName(n);
		this.setQuantity(c);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("Prescription name: %s \nQuantity: %d\n", this.name, this.quantity);
	}

}
