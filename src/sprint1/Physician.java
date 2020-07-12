package sprint1;

import java.io.Serializable;

public class Physician implements Serializable {

	private static final long serialVersionUID = -4947736697605980763L;
	private String name = "";

	public Physician(String name) {
		this.name = "Dr." + name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = "Dr." + name;
	}
	
	public String toString() {
		String str = this.name;
		return str;
	}
}
