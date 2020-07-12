package sprint1;

import java.io.Serializable;

public class Appointment implements Serializable {
	
	
	private static final long serialVersionUID = 7381111415934564510L;
	private String time;
	private String date;
	private Physician phy;
	private Patient pat;
	
	public Appointment createAppointment(String time, String date, Physician phy, Patient pat){
		Appointment a = new Appointment(null, null, null, null);
		int status = checkDateTime(date,time);
		if(status == 00)
			a = new Appointment(time, date, phy, pat);
		return a;
	}
	
	Appointment(String time, String date, Physician phy, Patient pat) {
			this.time = time;
			this.date = date;
			this.phy = phy;
			this.pat = pat;
	}

	public int checkDateTime(String date, String time) {
		int status = 00;
		if(!(date.contains("-")) || !(date.contains("/"))) {
			System.out.println("Error: Date must be formated as mm/dd/yyyy or mm-dd-yyyy");
			System.out.printf("User input: %d\n", date);
			status = 10;
		}
		
		if(!(time.contains(":")) && !(time.contains("AM"))) {
			System.out.println("Error: Time must be formated as ??:?? AM/PM");
			System.out.printf("User input: %d\n", time);
			if(status == 00)
				status = 10;
			else
				status = 11;
		}
		else if(!(time.contains(":")) && !(time.contains("PM"))) {
			System.out.println("Error: Time must be formated as ??:?? AM/PM");
			System.out.printf("User input: %d\n", time);
		}
		return status;
	}
	
	@Override
	public String toString() {
		return "Appointment:\nWhen: " + date + " at " + time + "\nPhysician: " + phy + "\nPatient: " + pat + "\n";
		
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Physician getPhy() {
		return phy;
	}

	public Patient getPat() {
		return pat;
	}
	
}

