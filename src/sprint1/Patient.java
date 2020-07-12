package sprint1;

import java.io.Serializable;
import java.util.ArrayList;

public class Patient implements Serializable{
	
	private static final long serialVersionUID = 4656056028745021125L;
	private String name;
	private ArrayList<Prescription> meds = new ArrayList<>();
	private ArrayList<Bill> bills = new ArrayList<>();
	private ArrayList<Appointment> appts = new ArrayList<>();
	
	public Patient(String name) {
		this.name = name;
		Bill b = new Bill(this);
	}
	
	public void addPrescription(Prescription p) {
		meds.add(p);
	}
	
	public void addAppt(Appointment a) {
		appts.add(a);
	}
	
	public String getName() {
		return this.name;
	}

	public void addBill(Bill b) {
		bills.add(b);
	}
	
	@Override
	public String toString() {
		return name;
	}

	public String viewPrescriptions() {
		String pres = "";
		for(Prescription p : meds) {
			pres += p.toString();
		}
		
		return "\nList of Prescriptions:\n" + pres;
	}
	
	public String viewBills() {
		String billz = "";
		for(Bill b : bills) {
			billz += b.toString();
		}
		return billz;
	}
	
	public String viewAppts() {
		String apptz = "";
		for(Appointment a : appts) {
			apptz += a.toString();
		}
		return apptz;
	}
	
}