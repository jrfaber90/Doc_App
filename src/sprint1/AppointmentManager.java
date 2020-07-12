package sprint1;

import java.io.Serializable;
import java.util.ArrayList;


public class AppointmentManager implements Serializable {

	private static final long serialVersionUID = -8934792904729072370L;
	
	private static ArrayList<Appointment> appointments;
	private static ArrayList<Patient> patients;
	private static ArrayList<Physician> physicians;

	public static void main(String[] args) {
		
	}

	public AppointmentManager() {
		appointments = new ArrayList<Appointment>();
		patients = new ArrayList<Patient>();
		physicians = new ArrayList<Physician>();
	}

	public void addAppointment(Appointment app) {
		appointments.add(app);
	}
	
	public void addPatient(Patient pat) {
		patients.add(pat);
	}
	
	public void addPhysician(Physician phy) {
		physicians.add(phy);
	}
	
	public ArrayList<Patient> getPatList(){
		return AppointmentManager.patients;
	}
	
	public ArrayList<Appointment> getAppList(){
		return AppointmentManager.appointments;
	}
	
	public ArrayList<Physician> getPhyList(){
		return AppointmentManager.physicians;
	}

//	Completed, Needs to be tested - tested completed during refactoring hw by zoe
	public Appointment getAppointment(String date, String time, String phy, String pat) {
		for (int i = 0; i < appointments.size(); i++) {
			Appointment a = appointments.get(i);
			if (a.getDate().equals(date) && a.getTime().equals(time)) {
				if (a.getPat().getName().equals(pat) && a.getPhy().getName().equals(phy)) {
					return a;
				}
			} else {
				System.out.println("The appointment does not exist.");
			}
		}

		return null;
	}

	public void viewPatientAppointment(String date, String time, String phy, String pat) {
		String listOfAppointments = "";
		for (int i = 0; i < appointments.size(); i++) {
			Appointment a = appointments.get(i);
			Patient tempPat = a.getPat();

			String patName = tempPat.getName();

			int matchPatName = patName.compareTo(pat);

			if (matchPatName == 0)
				listOfAppointments += a.toString();
		}
		System.out.print(listOfAppointments);
	}

	public String viewPhysicianAppointments(String phy) {
		String listOfAppointments = "";
		for (int i = 0; i < appointments.size(); i++) {
			Appointment a = appointments.get(i);
			Physician tempPhys = a.getPhy();

			String physName = tempPhys.getName();

			int matchPhysName = physName.compareTo(phy);

			if (matchPhysName == 0)
				listOfAppointments += a.toString() + "\n";
		}
		
		return listOfAppointments;
	}

	public boolean deleteAppointment(String date, String time, String phy, String pat) {
		boolean status = false;
		for (int i = 0; i < appointments.size(); i++) {
			Appointment a = appointments.get(i);
			String tempDate = a.getDate();
			String tempTime = a.getTime();
			Physician tempPhys = a.getPhy();
			Patient tempPat = a.getPat();

			String physName = tempPhys.getName();
			String patName = tempPat.getName();

			int matchDate = tempDate.compareTo(date);
			int matchTime = tempTime.compareTo(time);
			int matchPhysName = physName.compareTo(phy);
			int matchPatName = patName.compareTo(pat);

			if (matchDate == 0 && matchTime == 0 && matchPhysName == 0 && matchPatName == 0)
				appointments.remove(i);
			status = true;
		}
		return status;
	}

	public Appointment updateAppointment(String date, String time, String phy, String pat, String newTime,
			String newDate) {
		boolean status = false;
		Appointment updatedApp = null;
		for (int i = 0; i < appointments.size(); i++) {
			Appointment a = appointments.get(i);
			String tempDate = a.getDate();
			String tempTime = a.getTime();
			Physician tempPhys = a.getPhy();
			Patient tempPat = a.getPat();

			String physName = tempPhys.getName();
			String patName = tempPat.getName();

			int matchDate = tempDate.compareTo(date);
			int matchTime = tempTime.compareTo(time);
			int matchPhysName = physName.compareTo(phy);
			int matchPatName = patName.compareTo(pat);

			if (matchDate == 0 && matchTime == 0 && matchPhysName == 0 && matchPatName == 0) {
				appointments.remove(i);
				status = true;
			}

			if (status) {
				updatedApp = new Appointment(newDate, newTime, tempPhys, tempPat);
				status = false;
			}
		}
		return updatedApp;
	}

	public void viewBill(Patient pat) {
//		pat.viewBills();
	}

	public void viewMeds(Patient pat) {
		pat.viewPrescriptions();
	}

	
	public Physician getPhysician(String name) {
		Physician dummy = new Physician(name);
		int index = 0;
		for(Physician phy : physicians) {
			if (dummy.getName().equals(phy.getName()))
				index = physicians.indexOf(phy);
		}
		return physicians.get(index);
	}
	
	public Patient getPatient(String name) {
		Patient dummy = new Patient(name);
		int index = 0;
		for(Patient p : patients) {
			if (dummy.getName().equals(p.getName()))
				index = patients.indexOf(p);
		}
		return patients.get(index);
	}
			
	public String toString() {
		String str = "";
		if(appointments.size() > 0)
			for (Appointment app : appointments) {
				str += app.toString() + "\n";
			}
		return str;
	}

}
