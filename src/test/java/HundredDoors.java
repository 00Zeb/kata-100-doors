import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HundredDoors {
	// 100 closed doors
	// 100 opened doors
	// every 2nd door
	@SuppressWarnings("serial")
	private static final List<Door> allClosed = new ArrayList<Door>() {
		{
			for (int i = 0; i < 100; i++) {
				add(new Door(false));
			}
		}
	};

	@Test
	public void a_hundred_closed_doors() {
		List<Door> doors = new ArrayList<>(allClosed);
		assertEquals(allClosed, doors);
	}

	private static class Door {
		boolean isOpen;

		public Door(boolean isOpen) {
			this.isOpen = isOpen;
		}
	}
}
