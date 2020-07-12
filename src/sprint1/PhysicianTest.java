package sprint1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhysicianTest {


	@Test
	final void testPhysician() {
		Physician phy = new Physician("Jon Snow");
	}

	@Test
	final void testGetName() {
		Physician phy = new Physician("Jon Snow");
		String expected = "Jon Snow";
		assertEquals(expected,phy.getName());
	}

	@Test
	final void testSetName() {
		Physician phy = new Physician("Dan");
		phy.setName("Jon Snow");
		assertEquals("Jon Snow", phy.getName());
	}

	@Test
	final void testToString() {
		Physician phy = new Physician("Jon Snow");
		phy.toString();
	}

}
