import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HundredDoors {
	// 100 closed doors
	// 100 opened doors
	// every 2nd door
	@SuppressWarnings("serial")
	private static final List<Door> allOpen = new ArrayList<Door>() {
		{
			for (int i = 0; i < 100; i++) {
				add(new Door(true));
			}
		}
	};
	@SuppressWarnings("serial")
	private static final List<Door> allClosed = new ArrayList<Door>() {
		{
			for (int i = 0; i < 100; i++) {
				add(new Door(false));
			}
		}
	};
	
	private static class Door {
		boolean isOpen;

		public Door(boolean isOpen) {
			this.isOpen = isOpen;
		}

		@Override
		public int hashCode() {
			return 31 * 1 + (isOpen ? 1231 : 1237);
		}

		@Override
		public boolean equals(Object obj) {
			if (getClass() != obj.getClass())
				return false;
			return isOpen == ((Door) obj).isOpen;
		}

		@Override
		public String toString() {
			return String.valueOf(isOpen);
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
