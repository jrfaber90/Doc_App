package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PatientTest {

//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}

	@Test
	@DisplayName("Create and test a new Patient Constructor.")
	final void testPatient() {
		Patient expectedPatient = new Patient("Robert Roland");
		String actualPatient = expectedPatient.getName();
		assertEquals(expectedPatient,actualPatient);
	}

//	@Test
//	@DisplayName("Should return a String of appointments that the patien has.")
//	final void testViewAppointments() {
//		Patient pat = new Patient("Robert Roland");
//		Physician phy = new Physician("Dr. Mark");
//		Appointment a = new Appointment("08:30","10/15/2019", phy, pat);
//			}
//
//	@Test
//	final void testViewBills() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testViewMeds() {
//		fail("Not yet implemented"); // TODO
//	}

	@Test
	@DisplayName("Get name should return patient name")
	final void testGetName() {
		String expectedName = "Robert Roland";
		Patient p = new Patient("Robert Roland");
		String actualName = p.getName();
		assertEquals(expectedName,actualName);
	}

//	@Test
//	final void testObject() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testGetClass() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testHashCode() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testEquals() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testClone() {
//		fail("Not yet implemented"); // TODO
//	}

	@Test
	final void testToString() {
		String expectedToString = "Patient name - Robert Roland";
		Patient p = new Patient("Robert Roland");
		String actualToString = p.toString();
		assertEquals(expectedToString,actualToString);
	}

//	@Test
//	final void testNotify() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testNotifyAll() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testWaitLong() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testWaitLongInt() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testWait() {
//		fail("Not yet implemented"); // TODO
//	}
//
//	@Test
//	final void testFinalize() {
//		fail("Not yet implemented"); // TODO
//	}

}
