package UI.Windows;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextArea;

import src.Main;

public class EditPatientData {

	private JFrame frmEditPatientData;
	private JButton saveButton;
	private JTextArea eventsBox;
	private JTextArea notesBox;
	private JTextField idenNum;
	private JTextField roomNum;
	private JTextField PCPBox;
	private JTextField patientName;
	private JButton backButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPatientData window = new EditPatientData(args);
					window.frmEditPatientData.setVisible(true);
					window.frmEditPatientData.setLocationRelativeTo(null);
					window.frmEditPatientData.setMinimumSize(new Dimension(450, 450));
					window.frmEditPatientData.setBounds(100, 100, 450, 450);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public EditPatientData(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		frmEditPatientData = new JFrame();
		frmEditPatientData.setVisible(true);
		frmEditPatientData.setResizable(false);
		frmEditPatientData.setLocationRelativeTo(null);
		frmEditPatientData.setTitle("Edit Patient Data");
		frmEditPatientData.getContentPane().setFont(new Font("Cambria", Font.PLAIN, 11));
		frmEditPatientData.setSize(450, 450);
		frmEditPatientData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditPatientData.getContentPane().setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 414, 2);
		frmEditPatientData.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Identifier #:");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 59, 101, 19);
		frmEditPatientData.getContentPane().add(lblNewLabel);
		
		JLabel lblRoom = new JLabel("Room #:");
		lblRoom.setFont(new Font("Cambria", Font.BOLD, 15));
		lblRoom.setBounds(10, 89, 70, 19);
		frmEditPatientData.getContentPane().add(lblRoom);
		
		JLabel lblPmc = new JLabel("Primary Care Provider ID:");
		lblPmc.setFont(new Font("Cambria", Font.BOLD, 15));
		lblPmc.setBounds(10, 119, 217, 19);
		frmEditPatientData.getContentPane().add(lblPmc);
		
		JLabel lblEvents = new JLabel("Events:");
		lblEvents.setFont(new Font("Cambria", Font.BOLD, 15));
		lblEvents.setBounds(10, 149, 55, 19);
		frmEditPatientData.getContentPane().add(lblEvents);
		
		JLabel lblNotes = new JLabel("Notes:");
		lblNotes.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNotes.setBounds(10, 261, 55, 19);
		frmEditPatientData.getContentPane().add(lblNotes);
		
		backButton = new JButton("🔙");
		backButton.setBounds(6, 6, 30, 30);
		backButton.setMinimumSize(new Dimension (30, 30));
		backButton.setMaximumSize(new Dimension (30, 30));
		frmEditPatientData.getContentPane().add(backButton);
		
		saveButton = new JButton("Save And Exit");
		saveButton.setBackground(new Color(255, 255, 255));
		saveButton.setBounds(321, 374, 123, 29);
		saveButton.setMinimumSize(new Dimension (123, 29));
		saveButton.setMaximumSize(new Dimension (123, 29));
		frmEditPatientData.getContentPane().add(saveButton);

		setup(args);
		backButtonFunctionality(args);
		saveButtonFunctionality(args);
		
		eventsBox.setBounds(10, 180, 434, 63);
		frmEditPatientData.getContentPane().add(eventsBox);
		
		notesBox.setBounds(10, 292, 434, 63);
		frmEditPatientData.getContentPane().add(notesBox);
		
		idenNum.setBounds(104, 51, 340, 31);
		idenNum.setEditable(false);
		frmEditPatientData.getContentPane().add(idenNum);
		idenNum.setColumns(10);
		
		roomNum.setColumns(10);
		roomNum.setBounds(79, 84, 365, 31);
		frmEditPatientData.getContentPane().add(roomNum);
		
		PCPBox.setColumns(10);
		PCPBox.setBounds(191, 116, 253, 31);
		frmEditPatientData.getContentPane().add(PCPBox);
		
		patientName.setBounds(42, 0, 402, 41);
		frmEditPatientData.getContentPane().add(patientName);
		patientName.setColumns(10);
	}

	protected String[] updateArgs(){
		String[] alteredArgs = new String[6];
		alteredArgs[0] = patientName.getText();
		alteredArgs[1] = idenNum.getText();
		alteredArgs[2] = roomNum.getText();
		alteredArgs[3] = PCPBox.getText();
		alteredArgs[4] = eventsBox.getText();
		alteredArgs[5] = notesBox.getText();

		return alteredArgs;
	}

	protected void backButtonFunctionality(String[] args){
		if(args == null){}
		else if(args.length == 1){
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmEditPatientData.dispose();
					String[] args2 = updateArgs();
					if(isGoodFormat(args2)){
						try {
							Main.addPtn(args2);
							exitOrNo.main(args2);
							frmEditPatientData.dispose();
						} catch (Exception exception) {
							// TODO: handle exception
						}
					}
					else{
						exitWithoutSaving.main(args2);
					}
				}
			});
		}
		else{
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmEditPatientData.dispose();
					String[] args2 = updateArgs();
					String[] newArgs = {args[0], args[1], args[2], args[3], args[4], args[5], args2[0], args2[1], args2[2], args2[3], args2[4], args2[5]};
					exitOrNo.main(newArgs);
				}
			});
		}
	}

	protected void saveButtonFunctionality(String[] args){
		if(args == null){}
		else if(args.length == 1){
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] newArgs = updateArgs();
					if(isGoodFormat(newArgs)){
						try {
							Main.addPtn(newArgs);
							HomePage.main(null);
							frmEditPatientData.dispose();
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Error with Nick's stuff", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
		else{
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] newArgs = updateArgs();
					if(isGoodFormat(newArgs)){
						try {
							Main.updatePtn(newArgs);
							PatientData.main(newArgs);
							frmEditPatientData.dispose();
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "Error with Nick's stuff", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
		}
	}

	protected void setup(String[] args){
		if(args == null){}
		else if(args.length == 1){
			patientName = new JTextField();
			idenNum = new JTextField(args[0]);
			roomNum = new JTextField();
			PCPBox = new JTextField();
			eventsBox = new JTextArea();
			notesBox = new JTextArea();
		}
		else{
			patientName = new JTextField(args[0]);
			idenNum = new JTextField(args[1]);
			roomNum = new JTextField(args[2]);
			PCPBox = new JTextField(args[3]);
			eventsBox = new JTextArea(args[4]);
			notesBox = new JTextArea(args[5]);
		}
	}

	protected Boolean isGoodFormat(String[] args2){
		return checkName(args2[0]) && checkPCP(args2[3]) && checkRoom(args2[2]);
	}

	private Boolean checkName(String name){
		try{
			String splitName[] = name.split(" ");
			if(!(splitName.length == 2)){
				JOptionPane.showMessageDialog(null, "Name must inclue Last Name and First Name separated by a single space", "ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Name must inclue Last Name and First Name separated by a single space", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	private Boolean checkPCP(String PCP){
		try{
			int PCPnum = Integer.parseInt(PCP);
			if(!(PCPnum < 11 && PCPnum > 0)){
				JOptionPane.showMessageDialog(null, "PCP must be an integer between 1 and 10", "ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "PCP must be an integer between 1 and 10", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	private Boolean checkRoom(String room){
		try{
			int roomNum = Integer.parseInt(room);
			if(!(roomNum < 110 && roomNum > 99)){
				JOptionPane.showMessageDialog(null, "Room number must be an integer value within 100 and 109", "ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Room number must be an integer value within 100 and 109", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}