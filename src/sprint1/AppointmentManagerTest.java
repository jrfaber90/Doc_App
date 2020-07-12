package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppointmentManagerTest {

	@Test
	final void testAppointmentManager() {
		AppointmentManager appMan = new AppointmentManager();
	}

	@Test
	final void testGetAppointment() {
		AppointmentManager appMan = new AppointmentManager();
		Physician phy = new Physician("Jon Snow");
		Physician phy2 = new Physician("Rob Stark");
		Physician phy3 = new Physician("Bran Stark");
		Patient pat1 = new Patient("Sansa");
		Patient pat2 = new Patient("Benjen");
		Patient pat3 = new Patient("Arya");
		Appointment app1 = new Appointment("10/15/2019", "12:00", phy, pat1);
		Appointment app2 = new Appointment("10/15/2019", "8:00", phy2, pat2);
		Appointment app3 = new Appointment("10/15/2019", "10:00", phy3, pat2);
		Appointment app4 = new Appointment("10/15/2019", "2:00", phy, pat3);
		appMan.addAppointment(app1);
		appMan.addAppointment(app2);
		appMan.addAppointment(app3);
		appMan.addAppointment(app4);
//		int expected = 1;
//		int actual = appMan.getAppointment("10/15/2019", "8:00", "Rob Stark", "Benjen");
//		assertEquals(expected, actual);
		
	}

	@Test
	final void testViewPatientAppointment() {
		AppointmentManager appMan = new AppointmentManager();
		Physician phy = new Physician("Jon Snow");
		Patient pat2 = new Patient("Benjen");
		Appointment app2 = new Appointment("10/15/2019", "8:00", phy, pat2);
		Appointment app3 = new Appointment("10/15/2019", "10:00", phy, pat2);
		
		appMan.viewPatientAppointment("10/15/2019", "8:00", "Jon Snow", "Benjen");
	}

	@Test
	final void testViewPhysicianAppointments() {
		AppointmentManager appMan = new AppointmentManager();
		Physician phy = new Physician("Jon Snow");
		Patient pat2 = new Patient("Benjen");
		Appointment app2 = new Appointment("10/15/2019", "8:00", phy, pat2);
		Appointment app3 = new Appointment("10/15/2019", "10:00", phy, pat2);
		
		//appMan.viewPhysicianAppointments("10/15/2019", "8:00", "Jon Snow", "Benjen");
	}

	@Test
	final void testDeleteAppointment() {
		AppointmentManager appMan = new AppointmentManager();
		Physician phy = new Physician("Jon Snow");
		Physician phy2 = new Physician("Rob Stark");
		Physician phy3 = new Physician("Rob Stark");
		Patient pat1 = new Patient("Sansa");
		Patient pat2 = new Patient("Benjen");
		Patient pat3 = new Patient("Arya");
		Appointment app1 = new Appointment("10/15/2019", "12:00", phy, pat1);
		Appointment app2 = new Appointment("10/15/2019", "8:00", phy2, pat2);
		Appointment app3 = new Appointment("10/15/2019", "10:00", phy3, pat2);
		Appointment app4 = new Appointment("10/15/2019", "2:00", phy, pat3);
		appMan.addAppointment(app1);
		appMan.addAppointment(app2);
		appMan.addAppointment(app3);
		appMan.addAppointment(app4);
		
		boolean expected = true;
		boolean actual = appMan.deleteAppointment("10/15/2019", "8:00", "Rob Stark", "Benjen");
		assertEquals(expected, actual);
	}

	@Test
	final void testUpdateAppointment() {
		AppointmentManager appMan = new AppointmentManager();
		Physician phy = new Physician("Jon Snow");
		Patient pat1 = new Patient("Sansa");
		Appointment app1 = new Appointment("10/15/2019", "12:00", phy, pat1);
		Appointment app2 = appMan.updateAppointment("10/15/2019", "12:00", "Jon Snow", "Sansa", "2:00", "10/16/2019");
		Appointment expected = app2;
		Appointment actual = appMan.updateAppointment("10/15/2019", "12:00", "Jon Snow", "Sansa", "2:00", "10/16/2019");
		assertEquals(expected,actual);
	}

	@Test
	final void testToString() {
		AppointmentManager appMan = new AppointmentManager();
		Physician phy = new Physician("Jon Snow");
		Physician phy2 = new Physician("Rob Stark");
		Physician phy3 = new Physician("Rob Stark");
		Patient pat1 = new Patient("Sansa");
		Patient pat2 = new Patient("Benjen");
		Patient pat3 = new Patient("Arya");
		Appointment app1 = new Appointment("10/15/2019", "12:00", phy, pat1);
		Appointment app2 = new Appointment("10/15/2019", "8:00", phy2, pat2);
		Appointment app3 = new Appointment("10/15/2019", "10:00", phy3, pat2);
		Appointment app4 = new Appointment("10/15/2019", "2:00", phy, pat3);
		appMan.addAppointment(app1);
		appMan.addAppointment(app2);
		appMan.addAppointment(app3);
		appMan.addAppointment(app4);
		appMan.toString();
	}



}
