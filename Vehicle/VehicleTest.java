package Vehicle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VehicleTest {
	private Vehicle v = new Vehicle();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetVehicleWidthRelevantToLaneNum() {
		assertEquals(30,v.getVehicleWidthRelevantToLaneNum(3));
		assertEquals(20,v.getVehicleWidthRelevantToLaneNum(8));
		assertEquals(15,v.getVehicleWidthRelevantToLaneNum(15));
		assertEquals(10,v.getVehicleWidthRelevantToLaneNum(22));
		//fail("Not yet implemented");
	}

	@Test
	public void testGetVehicleHeightRelevantToLaneNum() {
		assertEquals(50,v.getVehicleHeightRelevantToLaneNum(5));
		assertEquals(35,v.getVehicleHeightRelevantToLaneNum(8));
		assertEquals(25,v.getVehicleHeightRelevantToLaneNum(15));
		assertEquals(15,v.getVehicleHeightRelevantToLaneNum(22));
		//fail("Not yet implemented");
	}

}
