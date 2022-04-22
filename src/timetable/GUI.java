package timetable;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class GUI implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	
	private int count = 0;
	
	ArrayList<JToggleButton> buttonlist = new ArrayList<JToggleButton>();
	ArrayList<JLabel> titles = new ArrayList<JLabel>();
	ArrayList<JLabel> times = new ArrayList<JLabel>();
	
	
	
	public GUI() {
		frame = new JFrame();
		for(int i=0; i<78; i++) {
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
		
		for(int i=0; i<6; i++) {
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridx = i;
			constraints.gridy = 0;
			panel.add(titles.get(i), constraints);
		}
		for(int i=1; i<14; i++) {
			constraints.fill = GridBagConstraints.HORIZONTAL;
			constraints.gridx = 0;
			constraints.gridy = i;
			panel.add(times.get(i), constraints);
		}
		for(int i=1; i<6; i++) {
			for(int j=1; j<14; j++) {
				constraints.fill = GridBagConstraints.HORIZONTAL;
				constraints.gridx = i;
				constraints.gridy = j;
				System.out.println((j-1)*5+(i-1)+ "  x = " + i + "  y = "+ j);
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
		if (e.getSource() == buttonlist.get(0)) {
			count++;
			label.setText("thios" + count);
		}
		else if (e.getSource() == buttonlist.get(1)){
			count--;
			label.setText("this" + count);
		}else if (e.getSource() == buttonlist.get(5)){
			count--;
			label.setText("this" + count);
		}else if (e.getSource() == buttonlist.get(3)){
			count--;
			label.setText("this" + count);
		}

	}
	
}
