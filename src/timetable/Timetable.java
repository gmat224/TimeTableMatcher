package timetable;

public class Timetable {
	private String name;
	private int[] timeBlockMonday = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] timeBlockTuesday = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] timeBlockWednesday = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] timeBlockThursday = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private int[] timeBlockFriday = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public Timetable() {
		this.name = null;
	}

	public void setMonday(int mon[]) {
		for (int i = 0; i < mon.length; i++) {
			this.timeBlockMonday[i] = mon[i];
		}
	}

	public void setTuesday(int tue[]) {
		for (int i = 0; i < tue.length; i++) {
			this.timeBlockTuesday[i] = tue[i];
		}
	}

	public void setWednesday(int wed[]) {
		for (int i = 0; i < wed.length; i++) {
			this.timeBlockWednesday[i] = wed[i];
		}
	}

	public void setThursday(int thu[]) {
		for (int i = 0; i < thu.length; i++) {
			this.timeBlockThursday[i] = thu[i];
		}
	}

	public void setFriday(int fri[]) {
		for (int i = 0; i < fri.length; i++) {
			this.timeBlockFriday[i] = fri[i];
		}
	}

	public String getName() {
		return this.name;
	}

	public int getMon(int i) {
		return this.timeBlockMonday[i];
	}

	public int getTue(int i) {
		return this.timeBlockTuesday[i];
	}

	public int getWed(int i) {
		return this.timeBlockWednesday[i];
	}

	public int getThu(int i) {
		return this.timeBlockThursday[i];
	}

	public int getFri(int i) {
		return this.timeBlockFriday[i];
	}

}
