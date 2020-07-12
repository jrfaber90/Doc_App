package sprint1;

import org.junit.jupiter.api.Test;

class ChargeTest {
	private Charge t1 = new Charge("Cast", 600);
	
	@Test
	void testCharge() {
		Charge test = new Charge("Routine Check up", 500);
		System.out.println(test.toString());
	}

	void testChangeCharge() {
		t1.changeCharge(10000 , "Knee Replacement");
		System.out.println(t1.toString());
	}

	@Test
	void testToString() {
		Charge t2 = new Charge("Eye Exam", 350.60);
		System.out.println(t2.toString());
	}

}
