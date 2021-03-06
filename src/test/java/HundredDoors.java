import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HundredDoors {
	// 100 closed doors
	// 100 opened doors
	// every 2nd door
	private final List<Door> doors = new ArrayList<>();

	public HundredDoors() {
		for (int i = 0; i < 100; i++) {
			doors.add(new Door(false));
		}
	}

	@Test
	public void a_hundred_closed_doors() {
		for (Door door : doors)
			assertFalse(door.isOpen);
	}

	@Test
	public void visit_each_door() {
		visit(doors, 1);
		assertEquals(everyDoorIsOpen(1), doors);
	}

	@Test
	public void visit_every_second_door() {
		visit(doors, 2);
		assertFalse(doors.get(0).isOpen);
		assertTrue(doors.get(1).isOpen);
	}

	@Test
	public void state_of_doors_are_dependant_on_previous_passes() {
		visit(doors, 1);
		visit(doors, 2);
		assertTrue(doors.get(0).isOpen);
		assertFalse(doors.get(1).isOpen);
		assertTrue(doors.get(98).isOpen);
		assertFalse(doors.get(99).isOpen);
		visit(doors, 3);
		assertTrue(doors.get(0).isOpen);
		assertFalse(doors.get(1).isOpen);
		assertFalse(doors.get(2).isOpen);
		assertFalse(doors.get(97).isOpen);
		assertFalse(doors.get(98).isOpen);
		assertFalse(doors.get(99).isOpen);
		
	}
	

	public static void main(String[] args) {
		HundredDoors hundredDoors = new HundredDoors();
		for (int i = 1; i < 101; i++) {
			hundredDoors.visit(hundredDoors.doors, i);
		}
		for (int i = 0; i < 100; i++) {
			System.out.println(String.valueOf(i+1) +" : " + hundredDoors.doors.get(i).isOpen);
		}
		
	}

	
	private List<Door> everyDoorIsOpen(int every) {
		List<Door> doors = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			doors.add(new Door(i % every == 0));
		}
		return doors;
	}

	private void visit(List<Door> doors, int jumpSequence) {
		for (int index = 0; index < doors.size(); index++) {
			if ((index + 1) % jumpSequence == 0) {
				Door door = doors.get(index);
				door.isOpen = !door.isOpen;
			}
		}
	}
}
