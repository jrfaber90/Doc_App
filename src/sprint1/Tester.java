package sprint1;

public class Tester {

	public static void main(String[] args) {
		AppointmentManager appMan = new AppointmentManager();
		Physician phy = new Physician("Jon Snow");
		Patient pat = new Patient("Benjen Stark");
		Prescription script = new Prescription("GasBeGone", 15);
		Bill b = new Bill(pat);
		b.addCharge(1000);
		Appointment app = new Appointment("10/20/2019", "12:00", phy, pat);
		appMan.addAppointment(app);
		pat.addPrescription(script);
		
		Physician phy2 = new Physician("Bon Snow");
		Patient pat2 = new Patient("Jenjen Stark");
		Appointment app2 = new Appointment("11/19/2019", "7:00", phy2, pat2);
		appMan.addAppointment(app2);
		
		System.out.print(appMan.getAppointment("11/19/2019", "7:00", "Bon Snow" , "Jenjen Stark"));
		
		//appMan.viewPhysicianAppointments("11/19/2019", "7:00", "Bon Snow", "Jenjen Stark");
		//System.out.println(appMan.toString());
	}

}
