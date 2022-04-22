package timetable;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	
	
	public GUI() {
		frame = new JFrame();
		JToggleButton button0 = new JToggleButton("click me");
		button0.addActionListener(this);
		label = new JLabel("somethig");
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button0);
		panel.add(label);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Timetable matcher");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("thios" + count);
	}
	
}
