package UI.Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import src.Main;

public class exitOrNo{

	private JFrame frame;
	private JTextField txtExitWithoutSaving;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					exitOrNo window = new exitOrNo(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public exitOrNo(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton exitButton = new JButton("DISCARD CHANGES");
		exitButton.setBounds(6, 37, 117, 29);
		frame.getContentPane().add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(args.length == 6){
					HomePage.main(null);
					frame.dispose();
				}
				else{
					String newArgs[] = {args[0], args[1], args[2], args[3], args[4], args[5]};
					PatientData.main(newArgs);
					frame.dispose();
				}
			}
		});
		
		JButton exAndSave = new JButton("EXIT AND SAVE");
		exAndSave.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		exAndSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(args.length == 6){
					try {
						Main.addPtn(args);
						HomePage.main(null);
						frame.dispose();
					} catch (Exception exception) {
						// TODO: handle exception
					}
				}
				else{
					String newArgs[] = {args[6], args[7], args[8], args[9], args[10], args[11]};
					PatientData.main(newArgs);
					frame.dispose();
				}
			}
		});
		exAndSave.setBounds(127, 37, 117, 29);
		frame.getContentPane().add(exAndSave);
		
		txtExitWithoutSaving = new JTextField();
		txtExitWithoutSaving.setHorizontalAlignment(SwingConstants.CENTER);
		txtExitWithoutSaving.setEditable(false);
		txtExitWithoutSaving.setText("Exit Without Saving?");
		txtExitWithoutSaving.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		txtExitWithoutSaving.setBounds(50, -1, 150, 36);
		frame.getContentPane().add(txtExitWithoutSaving);
		txtExitWithoutSaving.setColumns(10);
	}
}
