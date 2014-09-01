import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HundredDoors {
	// 100 closed doors
	// 100 opened doors
	// every 2nd door
	private final List<Door> allOpen = new ArrayList<>();
	private final List<Door> allClosed = new ArrayList<>();

	public HundredDoors() {
		for (int i = 0; i < 100; i++) {
			allOpen.add(new Door(true));
			allClosed.add(new Door(false));
		}
	}
	
	@Test
	public void a_hundred_closed_doors() {
		List<Door> doors = new ArrayList<>(allClosed);
		assertEquals(allClosed, doors);
	}
	
	@Test
	public void visit_each_door() {
		List<Door> doors = new ArrayList<>(allClosed);
		visit(doors);
		assertEquals(allOpen, doors);
	}

	private void visit(List<Door> doors) {
		for (Door door : doors) {
			door.isOpen = true;
		}
	}
}
