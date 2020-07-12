package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrescriptionTest {

	@Test
	final void testPrescription() {
		Prescription pre = new Prescription("GasBGone", 30);
	}

	@Test
	final void testGetQuantity() {
		Prescription pre = new Prescription("GasBGone", 30);
		int expected = 30;
		int actual = pre.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	final void testSetQuantity() {
		Prescription pre = new Prescription("GasBGone", 30);
		int expected = 45;
		pre.setQuantity(45);
		int actual = pre.getQuantity();
		assertEquals(expected, actual);
	}

	@Test
	final void testGetName() {
		Prescription pre = new Prescription("GasBGone", 30);
		String expected = "GasBGone";
		String actual = pre.getName();
		assertEquals(expected,actual);
	}

	@Test
	final void testSetName() {
		Prescription pre = new Prescription("GasBGone", 30);
		String expected = "GasAway";
		pre.setName("GasAway");
		String actual = pre.getName();
		assertEquals(expected,actual);
	}

	@Test
	final void testToString() {
		Prescription pre = new Prescription("GasBGone", 30);
		pre.toString();
	}

}
