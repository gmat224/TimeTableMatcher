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
import javax.swing.JToggleButton;

public class GUI implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	
	ArrayList<JToggleButton> buttonlist = new ArrayList<JToggleButton>();
	ArrayList<JLabel> titles = new ArrayList<JLabel>();
	ArrayList<JLabel> times = new ArrayList<JLabel>();
	
	
	
	public GUI() {
		frame = new JFrame();
		frame.setPreferredSize(new Dimension(1000, 800));
		frame.setBackground(Color.blue);
		for(int i=0; i<66; i++) {
			buttonlist.add(new JToggleButton());
			buttonlist.get(i).addActionListener(this);
		}
		titles.add(new JLabel("Time"));
		titles.add(new JLabel("Monday"));
		titles.add(new JLabel("Tuesday"));
		titles.add(new JLabel("Wednesday"));
		titles.add(new JLabel("Thursday"));
		titles.add(new JLabel("Friday"));
		for (int i=0; i<14; i++) {
			times.add(new JLabel((i+7) +":00"));
		}
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		JLabel mainTitle = new JLabel("TIMETABLE MATCHER");
		frame.getContentPane().setBackground(Color.black);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 0.0;
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(mainTitle, constraints);
		JButton nextButton = new JButton();
		nextButton.setText("NEXT");
		constraints.ipady = 25;
		constraints.ipadx = 100;
		constraints.gridx = 6;
		constraints.gridy = 14;
		
		panel.add(nextButton);
		
		for(int i=0; i<6; i++) {
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.ipady = 25;
			constraints.ipadx = 100;
			constraints.gridx = i;
			constraints.gridy = 1;
			panel.add(titles.get(i), constraints);
		}
		for(int i=1; i<14; i++) {
			constraints.ipady = 25;
			constraints.ipadx = 0;
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridx = 0;
			constraints.gridy = i+1;
			panel.add(times.get(i), constraints);
		}
		for(int i=1; i<6; i++) {
			for(int j=1; j<14; j++) {
				constraints.fill = GridBagConstraints.HORIZONTAL;
				constraints.insets = new Insets(0, 5, 0, 5);
				constraints.gridx = i;
				constraints.gridy = j+1;
				buttonlist.get((j-1)*5+(i-1)).setBackground(Color.white);
				panel.add(buttonlist.get((j-1)*5+(i-1)), constraints);
			}
		}

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Timetable matcher");

		frame.pack();

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 66; i++) {
			if (e.getSource() == buttonlist.get(i)) {
				System.out.println(i);
			}
	}
	}
	
}
