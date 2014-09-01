import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HundredDoors {
	// 100 closed doors
	// 100 opened doors
	// every 2nd door
	private final List<Door> allOpen = new ArrayList<>();
	private final List<Door> allClosed = new ArrayList<>();
	private final List<Door> doors;

	public HundredDoors() {
		for (int i = 0; i < 100; i++) {
			allOpen.add(new Door(true));
			allClosed.add(new Door(false));
		}
		doors = new ArrayList<>(allClosed);
	}
	
	@Test
	public void a_hundred_closed_doors() {
		assertEquals(allClosed, doors);
	}
	
	@Test
	public void visit_each_door() {
		visit(doors);
		assertEquals(allOpen, doors);
	}

	private void visit(List<Door> doors) {
		for (Door door : doors) {
			door.isOpen = true;
		}
	}
}
