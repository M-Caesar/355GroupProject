package UI.Windows;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRoom {

	private JFrame frame;
	private JButton btnConf;

	private JTextArea txtMRNArea;
	private JTextField txtMRN;

	private JTextArea PCPTextArea;
	private JTextField txtPCP;

	private JTextArea txtST;
	private JTextField txtStartTime;

	private JTextArea txtET;
	private JTextField txtEndTime;

	private JTextArea startDateArea;
	private JTextField startDateTxt;

	private JTextArea endDateArea;
	private JTextField endDateTxt;

	private JTextArea txtEvent;
	private JTextField txtEventType;

	private JTextArea txtRoomNum;
	private JTextField txtRoom;

	private JTextArea notesBox;
	private JTextField txtNotes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { //{ST, ET, SD, ED, ROOM}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRoom window = new BookRoom(args);
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
	public BookRoom(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 406, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setMinimumSize(new Dimension(413,450));

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

		txtMRNArea = new JTextArea();
		txtMRNArea.setBounds(109, 69, 285, 26);
		frame.getContentPane().add(txtMRNArea);

		txtMRN = new JTextField();
		txtMRN.setText("Patient's MRN:");
		txtMRN.setEditable(false);
		txtMRN.setColumns(10);
		txtMRN.setBounds(6, 69, 103, 26);
		frame.getContentPane().add(txtMRN);
		
		PCPTextArea = new JTextArea();
		PCPTextArea.setBounds(109, 107, 285, 26);
		frame.getContentPane().add(PCPTextArea);

		// txtPCP = new JTextArea();
		// txtPCP.setBounds(109, 107, 285, 26);
		// frame.getContentPane().add(txtPCP);

		txtPCP = new JTextField();
		txtPCP.setEditable(false);
		txtPCP.setText("PCP:");
		txtPCP.setBounds(6, 107, 97, 26);
		frame.getContentPane().add(txtPCP);
		txtPCP.setColumns(10);

		txtST = new JTextArea(args[0]);
		txtST.setEditable(false);
		txtST.setBounds(109, 145, 285, 26);
		frame.getContentPane().add(txtST);
		
		txtStartTime = new JTextField();
		txtStartTime.setEditable(false);
		txtStartTime.setText("Start Time:");
		txtStartTime.setColumns(10);
		txtStartTime.setBounds(6, 145, 88, 26);
		frame.getContentPane().add(txtStartTime);

		txtET = new JTextArea(args[1]);
		txtET.setEditable(false);
		txtET.setBounds(106, 183, 288, 26);
		frame.getContentPane().add(txtET);
		
		txtEndTime = new JTextField();
		txtEndTime.setEditable(false);
		txtEndTime.setText("End Time:");
		txtEndTime.setColumns(10);
		txtEndTime.setBounds(6, 183, 88, 26);
		frame.getContentPane().add(txtEndTime);

		startDateArea = new JTextArea(args[2]);
		startDateArea.setEditable(false);
		startDateArea.setBounds(106, 221, 288, 26);
		frame.getContentPane().add(startDateArea);
		
		startDateTxt = new JTextField();
		startDateTxt.setEditable(false);
		startDateTxt.setText("Start Date:");
		startDateTxt.setColumns(10);
		startDateTxt.setBounds(6, 221, 88, 26);
		frame.getContentPane().add(startDateTxt);

		endDateArea = new JTextArea(args[3]);
		endDateArea.setEditable(false);
		endDateArea.setBounds(106, 259, 288, 26);
		frame.getContentPane().add(endDateArea);
		
		endDateTxt = new JTextField();
		endDateTxt.setEditable(false);
		endDateTxt.setText("End Date:");
		endDateTxt.setColumns(10);
		endDateTxt.setBounds(6, 259, 88, 26);
		frame.getContentPane().add(endDateTxt);

		txtEvent = new JTextArea();
		txtEvent.setBounds(106, 297, 288, 26);
		frame.getContentPane().add(txtEvent);
		
		txtEventType = new JTextField();
		txtEventType.setEditable(false);
		txtEventType.setText("Event Type:");
		txtEventType.setColumns(10);
		txtEventType.setBounds(6, 297, 88, 26);
		frame.getContentPane().add(txtEventType);

		txtRoomNum = new JTextArea(args[4]);
		txtRoomNum.setEditable(false);
		txtRoomNum.setBounds(106, 335, 288, 26);
		frame.getContentPane().add(txtRoomNum);

		txtRoom = new JTextField();
		txtRoom.setText("Room #:");
		txtRoom.setEditable(false);
		txtRoom.setColumns(10);
		txtRoom.setBounds(6, 335, 88, 26);
		frame.getContentPane().add(txtRoom);

		txtNotes = new JTextField();
		txtNotes.setText("Notes:");
		txtNotes.setEditable(false);
		txtNotes.setColumns(10);
		txtNotes.setBounds(6, 373, 88, 26);
		frame.getContentPane().add(txtNotes);
		
		notesBox = new JTextArea();
        notesBox.setLineWrap(true); // Enable line wrapping [1, 2, 3] 
        notesBox.setWrapStyleWord(true); // Wrap at word boundaries [1, 3, 5] 
		
		JScrollPane notesScroll = new JScrollPane(notesBox);
		notesScroll.setBounds(106, 373, 288, 60);
		frame.getContentPane().add(notesScroll);

		btnConf = new JButton("Confirm & Book");
        btnConf.setBounds(228, 449, 166, 29);
        frame.getContentPane().add(btnConf);
		btnConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verify();
			}
		});
	}

	private void verify(){
		try {
			if(!verifyPCP(PCPTextArea.getText())){
				return;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "PCP must be an integer between 1 and 10", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}

		Event newEvent = new Event();
		addEvent(event);

		HomePage.main(null);
		frame.dispose();
	}

	private boolean verifyPCP(String PCP){
		int PCPnum = Integer.parseInt(PCP);
		if(!(PCPnum < 11 && PCPnum > 0)){
			JOptionPane.showMessageDialog(null, "PCP must be an integer between 1 and 10", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
