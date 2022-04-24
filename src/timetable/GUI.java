package timetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Main/GUI class
public class GUI implements ActionListener {
	// Action listener used to see if buttons pushed

	// declaring variables used in class
	// GUI specific
	private JFrame frame;
	private JPanel panel;
	private JButton nextButton;
	private JButton compareButton;

	// backend specific
	private boolean[] output = new boolean[66];
	private boolean[] buttonState = new boolean[66];

	// all ArrayLists that hold all information
	ArrayList<JButton> buttonlist = new ArrayList<JButton>();
	ArrayList<JLabel> titles = new ArrayList<JLabel>();
	ArrayList<JLabel> times = new ArrayList<JLabel>();
	ArrayList<boolean[]> timetable = new ArrayList<boolean[]>();

	// constructor for the GUI
	public GUI() {
		// setting everything to false
		for (int i = 0; i < 66; i++) {
			buttonState[i] = false;
		}
		// creating frame and setting parameter
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setBackground(Color.blue);

		// create all timetable buttons
		for (int i = 0; i < 66; i++) {
			buttonlist.add(new JButton());
			buttonlist.get(i).addActionListener(this);
		}

		// create labels for the days of the week
		titles.add(new JLabel("Time"));
		titles.add(new JLabel("Monday"));
		titles.add(new JLabel("Tuesday"));
		titles.add(new JLabel("Wednesday"));
		titles.add(new JLabel("Thursday"));
		titles.add(new JLabel("Friday"));

		// create labels for the times of the day
		for (int i = 0; i < 14; i++) {
			times.add(new JLabel((i + 7) + ":00"));
		}

		// Title for program
		JLabel mainTitle = new JLabel("TIMETABLE MATCHER");

		// creating "next" button
		nextButton = new JButton();
		nextButton.setText("NEXT");
		nextButton.addActionListener(this);

		// creating "compare" button
		compareButton = new JButton();
		compareButton.setText("Compare");
		compareButton.addActionListener(this);

		// create a new panel for GUI
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setBackground(Color.PINK);

		// creating layout
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// setting up defaults for constraints
		constraints.fill = GridBagConstraints.HORIZONTAL;

		// adding title of program to top left corner
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(mainTitle, constraints);

		// adding next button
		constraints.ipady = 25;
		constraints.ipadx = 100;
		constraints.gridx = 6;
		constraints.gridy = 14;
		panel.add(nextButton);

		// adding compare button
		constraints.ipady = 25;
		constraints.ipadx = 100;
		constraints.gridx = 6;
		constraints.gridy = 15;
		panel.add(compareButton);

		// adding days of the week
		for (int i = 0; i < 6; i++) {
			constraints.ipady = 25;
			constraints.ipadx = 100;
			constraints.gridx = i;
			constraints.gridy = 1;
			panel.add(titles.get(i), constraints);
		}

		// adding times of the day
		for (int i = 1; i < 14; i++) {
			constraints.ipady = 25;
			constraints.ipadx = 0;
			constraints.gridx = 0;
			constraints.gridy = i + 1;
			panel.add(times.get(i), constraints);
		}

		// adding all buttons in order 0-65 or 64?
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 14; j++) {
				constraints.insets = new Insets(0, 5, 0, 5);
				constraints.gridx = i;
				constraints.gridy = j + 1;
				buttonlist.get((j - 1) * 5 + (i - 1)).setBackground(Color.white);
				panel.add(buttonlist.get((j - 1) * 5 + (i - 1)), constraints);
			}
		}

		// adding frame to panel
		frame.add(panel, BorderLayout.CENTER);

		// setting up frame and making it visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Timetable matcher");
		frame.pack();
		frame.setVisible(true);
	}

	public boolean[] compareTimetable() {
		boolean[] returnlist = new boolean[66];
		for (int i = 1; i < timetable.size(); i++) {
			for (int j = 0; j < 66; j++) {
				returnlist[j] = timetable.get(i)[j] && timetable.get(i - 1)[j];
			}
		}
		return returnlist;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// getting inputs from GUI

		// next button pushed
		if (e.getSource() == nextButton) {
			// adding timetable to timetables list
			timetable.add(buttonState.clone());
			// reseting GUI ready for next timetable to be entered
			for (int i = 0; i < 66; i++) {
				if (buttonState[i] == true) {
					buttonState[i] = false;
					buttonlist.get(i).setBackground(Color.WHITE);
				}
			}
		}

		// compare button pushed
		if (e.getSource() == compareButton) {
			// setting output to the times everyone is free then displaying it in green
			output = compareTimetable();
			for (int i = 0; i < 66; i++) {
				if (output[i] == false) {
					buttonlist.get(i).setBackground(Color.GREEN);
				}
			}
		}

		// check if any timetable time slot button pushed
		for (int i = 0; i < 66; i++) {
			if (e.getSource() == buttonlist.get(i)) {
				// check it's state and update array and colour
				if (buttonState[i] == false) {
					buttonState[i] = true;
					buttonlist.get(i).setBackground(Color.BLACK);
				} else if (buttonState[i] == true) {
					buttonState[i] = false;
					buttonlist.get(i).setBackground(Color.WHITE);
				}
			}
		}
	}
}
