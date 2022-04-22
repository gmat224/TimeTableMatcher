/*package timetable;

import java.util.Scanner;

public class Timetableproject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.out.println("Enter timetable avalble or not, 1 or zero");
		// Scanner in = new Scanner(System.in);
		// for (int i = 8; i < 20; i++) {
		// System.out.print("between " + i + ":00-" + (i + 1) + " : ");
		// int a = in.nextInt();
		// System.out.println("You entered integer " + a);
		// }
		// in.close();
		Scanner input = new Scanner(System.in);
		Timetable bob = new Timetable();
		// bob.setMonday(inputDay(input));
		// bob.setTuesday(inputDay(input));
		// bob.setWednesday(inputDay(input));
		// bob.setThursday(inputDay(input));
		// bob.setFriday(inputDay(input));
		new Gui();

		/*
		 * System.out.println("Monday: "); for (int i = 0; i < 12; i++) { // Printing
		 * and display the elements in ArrayList
		 * 
		 * System.out.print(bob.getMon(i)); } System.out.println("Tuesday: "); for (int
		 * i = 0; i < 12; i++) { // Printing and display the elements in ArrayList
		 * 
		 * System.out.print(bob.getTue(i)); } System.out.println("Wednesday: "); for
		 * (int i = 0; i < 12; i++) { // Printing and display the elements in ArrayList
		 * 
		 * System.out.print(bob.getWed(i)); } System.out.println("Thursday"); for (int i
		 * = 0; i < 12; i++) { // Printing and display the elements in ArrayList
		 * 
		 * System.out.print(bob.getThu(i)); } System.out.println("Friday: "); for (int i
		 * = 0; i < 12; i++) { // Printing and display the elements in ArrayList
		 * 
		 * System.out.print(bob.getFri(i)); }
		 
		input.close();
	}

//inputs
	public static int[] inputDay(Scanner in) {
		int temp[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println("Enter timetable avalble or not, 1 or zero");

		for (int i = 0; i < 12; i++) {
			System.out.print("between " + (i + 8) + ":00-" + (i + 9) + " : ");
			int a = in.nextInt();
			temp[i] = a;
		}

		return temp;
	}
}
*/