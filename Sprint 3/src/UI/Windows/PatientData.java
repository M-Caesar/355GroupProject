package UI.Windows;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextArea;

public class PatientData {

	private JFrame frame;
	private JButton editButton;
	private JTextField idenNum;
	private JTextField roomNum;
	private JTextField PCPBox;
	private JTextArea eventsBox;
	private JTextArea notesBox;
	private JTextField patientName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientData window = new PatientData(args);
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
					window.frame.setMinimumSize(new Dimension(450, 450));
					window.frame.setBounds(100, 100, 450, 450);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public PatientData(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle("Patient Data");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setFont(new Font("Cambria", Font.PLAIN, 11));
		frame.setSize(450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 414, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Identifier #:");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 59, 101, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room #:");
		lblRoom.setFont(new Font("Cambria", Font.BOLD, 15));
		lblRoom.setBounds(10, 89, 70, 19);
		frame.getContentPane().add(lblRoom);
		
		JLabel lblPmc = new JLabel("Primary Care Provider:");
		lblPmc.setFont(new Font("Cambria", Font.BOLD, 15));
		lblPmc.setBounds(10, 119, 217, 19);
		frame.getContentPane().add(lblPmc);
		
		JLabel lblEvents = new JLabel("Events:");
		lblEvents.setFont(new Font("Cambria", Font.BOLD, 15));
		lblEvents.setBounds(10, 149, 55, 19);
		frame.getContentPane().add(lblEvents);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNotes.setBounds(10, 261, 55, 19);
		frame.getContentPane().add(lblNotes);
		
		JButton backButton = new JButton("🔙");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				HomePage.main(null);
			}
		});
		backButton.setBounds(6, 6, 30, 30);
		backButton.setMinimumSize(new Dimension (30, 30));
		backButton.setMaximumSize(new Dimension (30, 30));
		frame.getContentPane().add(backButton);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EditPatientData.main(args);
			}
		});
		editButton.setBackground(new Color(255, 255, 255));
		editButton.setBounds(321, 374, 123, 29);
		editButton.setMinimumSize(new Dimension (123, 29));
		editButton.setMaximumSize(new Dimension (123, 29));
		frame.getContentPane().add(editButton);
		
		idenNum = new JTextField(args[1]);
		idenNum.setEditable(false);
		idenNum.setColumns(10);
		idenNum.setBounds(104, 54, 340, 31);
		frame.getContentPane().add(idenNum);
		
		roomNum = new JTextField(args[2]);
		roomNum.setEditable(false);
		roomNum.setColumns(10);
		roomNum.setBounds(79, 84, 365, 31);
		frame.getContentPane().add(roomNum);
		
		PCPBox = new JTextField(args[3]);
		PCPBox.setEditable(false);
		PCPBox.setColumns(10);
		PCPBox.setBounds(191, 116, 253, 31);
		frame.getContentPane().add(PCPBox);
		
		eventsBox = new JTextArea(args[4]);
		eventsBox.setEditable(false);
		eventsBox.setBounds(10, 180, 434, 63);
		frame.getContentPane().add(eventsBox);
		
		notesBox = new JTextArea(args[5]);
		notesBox.setEditable(false);
		notesBox.setBounds(10, 292, 434, 63);
		frame.getContentPane().add(notesBox);
		
		patientName = new JTextField(args[0]);
		patientName.setEditable(false);
		patientName.setColumns(10);
		patientName.setBounds(42, 0, 402, 41);
		frame.getContentPane().add(patientName);
	}
}
