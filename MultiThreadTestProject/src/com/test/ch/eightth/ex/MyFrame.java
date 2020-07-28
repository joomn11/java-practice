package com.test.ch.eightth.ex;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame implements ActionListener {

	private final JLabel label = new JLabel("Event Dispatching Thread Sample");
	private final JButton button = new JButton("countUp");

	public MyFrame() {
		super("MyFrame");
		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(label);
		getContentPane().add(button);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			countUp();
		}
	}

	private void countUp() {
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					final String str = "" + i;
					/*System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + str + ")");
					label.setText(str);*/
					final Runnable executor = new Runnable() {

						@Override
						public void run() {
							System.out.println(Thread.currentThread().getName() + ":countUp:setText(" + str + ")");
							label.setText(str);
						}
					};
					SwingUtilities.invokeLater(executor);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		}.start();
	}

}
