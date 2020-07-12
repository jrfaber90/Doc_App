package sprint1;

import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	ArrayList<Bill> bills = new ArrayList<Bill>();
	private String date;
	private double amount;
	private String note;
	private Patient p;
	private ArrayList<Charge> charges = new ArrayList<>();

	public Bill( Patient p) {
		this.p = p;
		bills.add(this);
	}

	public Bill(String date) {
		this.date = date;
	}
	
	public Bill(double amount, String date, String note, Patient p) {
		this.amount = amount;
		this.date = date;
		this.note = note;
		this.p = p;
		bills.add(this);
	}
	
	public void addCharge(double amount) {
		this.amount = amount;
	}

	public String getBills(String name) {
		String b = "";
		for(int i = 0; i < bills.size(); i++) {
			Bill bill = bills.get(i);
			Patient billPat = bill.getPatient();
			String patName = billPat.getName();
			int matchPatName = patName.compareTo(name);
			
			if(matchPatName == 0) {
				bill = bills.get(i);
				b += bill.toString();
			}
			else b += "Patient does not have any bills on file.";
		}
		return b;
	}

	public Patient getPatient() {
		return p;
	}

	public void setBills(ArrayList<Bill> bills) {
		this.bills = bills;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
		
	}
	
	public void addCharge(Charge c) {
		this.charges.add(c);

	}
	
	@Override
    public String toString() {
		String printBill = null;
		for(int i = 0; i < charges.size(); i++) {
			printBill += String.format("Appointment Date: %d\nCharges:\n%d", this.date, charges.get(i).toString());
		}
		
        return printBill;
    }
}
