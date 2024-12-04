package UI.Windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;

import java.time.LocalDate;
import java.time.LocalTime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomView {

	private JFrame frame;
	private JTextField txt100;
	private JTextField txt101;
	private JTextField txt102;
	private JTextField txt103;
	private JTextField txt104;
	private JTextField txt105;
	private JTextField txt106;
	private JTextField txt107;
	private JTextField txt108;
	private JTextField txt109;

	private JButton btn100;
	private JButton btn101;
	private JButton btn102;
	private JButton btn103;
	private JButton btn104;
	private JButton btn105;
	private JButton btn106;
	private JButton btn107;
	private JButton btn108;
	private JButton btn109;

	private JTextField dateStart;
	private JTextField dateEnd;
	private JTextField timeStart;
	private JTextField timeEnd;

	private String validStartDate = "";
	private String validEndDate = "";
	private String validStartTime = "";
	private String validEndTime = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomView window = new RoomView();
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
	public RoomView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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
		
		dateStart = new JTextField();
		dateStart.setBounds(175, 36, 125, 27);
		dateStart.setColumns(10);
		frame.getContentPane().add(dateStart);

		JTextField dateStartLabel = new JTextField("Start Date (yyyy-dd-mm)");
		dateStartLabel.setBounds(30, 36, 140, 27);
		dateStartLabel.setColumns(10);
		dateStartLabel.setEditable(false);
		frame.getContentPane().add(dateStartLabel);
		
		dateEnd = new JTextField();
		dateEnd.setBounds(474, 36, 125, 27);
		dateEnd.setColumns(10);
		frame.getContentPane().add(dateEnd);

		JTextField dateEndLabel = new JTextField("End Date (yyyy-dd-mm)");
		dateEndLabel.setBounds(339, 36, 135, 27);
		dateEndLabel.setColumns(10);
		dateEndLabel.setEditable(false);
		frame.getContentPane().add(dateEndLabel);
		
		timeStart = new JTextField();
		timeStart.setBounds(175, 6, 125, 27);
		timeStart.setColumns(10);
		frame.getContentPane().add(timeStart);

		JTextField timeStartLabel = new JTextField("Start Time (hh-mm-ss)");
		timeStartLabel.setBounds(40, 6, 130, 27);
		timeStartLabel.setColumns(10);
		timeStartLabel.setEditable(false);
		frame.getContentPane().add(timeStartLabel);

		timeEnd = new JTextField();
		timeEnd.setBounds(474, 6, 125, 27);
		timeEnd.setColumns(10);
		frame.getContentPane().add(timeEnd);

		JTextField timeEndLabel = new JTextField("End Time (hh-mm-ss)");
		timeEndLabel.setBounds(349, 6, 125, 27);
		timeEndLabel.setColumns(10);
		timeEndLabel.setEditable(false);
		frame.getContentPane().add(timeEndLabel);

		JButton checkBookings = new JButton("Check Availability");
		checkBookings.setBounds(620, 6, 150, 27);
		frame.getContentPane().add(checkBookings);
		checkBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAvailability();
			}
		});
		
		btn100 = new JButton("100");
		btn100.setBounds(6, 65, 135, 100);
		btn100.setEnabled(false);
		frame.getContentPane().add(btn100);
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "100"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn101 = new JButton("101");
		btn101.setBounds(164, 65, 135, 100);
		btn101.setEnabled(false);
		frame.getContentPane().add(btn101);
		btn101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "101"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn102 = new JButton("102");
		btn102.setBounds(319, 65, 135, 100);
		btn102.setEnabled(false);
		frame.getContentPane().add(btn102);
		btn102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "102"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn103 = new JButton("103");
		btn103.setBounds(474, 65, 135, 100);
		btn103.setEnabled(false);
		frame.getContentPane().add(btn103);
		btn103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "103"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn104 = new JButton("104");
		btn104.setBounds(634, 65, 135, 100);
		btn104.setEnabled(false);
		frame.getContentPane().add(btn104);
		btn104.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "104"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn107 = new JButton("107");
		btn107.setBounds(319, 212, 135, 100);
		btn107.setEnabled(false);
		frame.getContentPane().add(btn107);
		btn107.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "107"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn108 = new JButton("108");
		btn108.setBounds(474, 212, 135, 100);
		btn108.setEnabled(false);
		frame.getContentPane().add(btn108);
		btn108.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "108"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn106 = new JButton("106");
		btn106.setBounds(164, 212, 135, 100);
		btn106.setEnabled(false);
		frame.getContentPane().add(btn106);
		btn106.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "106"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn105 = new JButton("105");
		btn105.setBounds(6, 212, 135, 100);
		btn105.setEnabled(false);
		frame.getContentPane().add(btn105);
		btn105.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "105"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		btn109 = new JButton("109");
		btn109.setBounds(634, 212, 135, 100);
		btn109.setEnabled(false);
		frame.getContentPane().add(btn109);
		btn109.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {validStartTime, validEndTime, validStartDate, validEndDate, "109"};
				BookRoom.main(args);
				frame.dispose();
			}
		});
		
		txt100 = new JTextField();
		txt100.setEditable(false);
		txt100.setBounds(6, 162, 135, 26);
		frame.getContentPane().add(txt100);
		txt100.setColumns(10);
		
		txt101 = new JTextField();
		txt101.setEditable(false);
		txt101.setColumns(10);
		txt101.setBounds(165, 162, 135, 26);
		frame.getContentPane().add(txt101);
		
		txt102 = new JTextField();
		txt102.setEditable(false);
		txt102.setColumns(10);
		txt102.setBounds(319, 162, 135, 26);
		frame.getContentPane().add(txt102);
		
		txt103 = new JTextField();
		txt103.setEditable(false);
		txt103.setColumns(10);
		txt103.setBounds(474, 162, 135, 26);
		frame.getContentPane().add(txt103);
		
		txt104 = new JTextField();
		txt104.setEditable(false);
		txt104.setColumns(10);
		txt104.setBounds(634, 162, 135, 26);
		frame.getContentPane().add(txt104);
		
		txt105 = new JTextField();
		txt105.setEditable(false);
		txt105.setColumns(10);
		txt105.setBounds(6, 309, 135, 26);
		frame.getContentPane().add(txt105);
		
		txt106 = new JTextField();
		txt106.setEditable(false);
		txt106.setColumns(10);
		txt106.setBounds(165, 309, 135, 26);
		frame.getContentPane().add(txt106);
		
		txt107 = new JTextField();
		txt107.setEditable(false);
		txt107.setColumns(10);
		txt107.setBounds(319, 309, 135, 26);
		frame.getContentPane().add(txt107);
		
		txt108 = new JTextField();
		txt108.setEditable(false);
		txt108.setColumns(10);
		txt108.setBounds(474, 309, 135, 26);
		frame.getContentPane().add(txt108);
		
		txt109 = new JTextField();
		txt109.setEditable(false);
		txt109.setColumns(10);
		txt109.setBounds(634, 309, 135, 26);
		frame.getContentPane().add(txt109);
	}

	private boolean verifyTimes(String startTime, String endTime, String startDate, String endDate) throws Exception{
		String[] argsStartDate = {"Invalid Start Date"};
		String[] argsEndDate = {"Invalid End Date"};
		String[] argsStartTime = {"Invalid Start Time"};
		String[] argsEndTime = {"Invalid End Time"};

		String currentTime = LocalDate.now().toString();
		currentTime = currentTime.substring(0, 8);
		String[] time = currentTime.split(":"); // hh:mm:ss

		String currentDate = LocalTime.now().toString();
		String[] date = currentDate.split("-"); // yyyy-mm=dd

		//Check Start Time
		String[] startTimeList = startTime.split("-");
		if(startTimeList.length != 3){
			warningPage.main(argsStartTime);
			return false;
		}
		for(int i = 0 ; i < 3 ; i++){
			int timeListVal = Integer.parseInt(startTimeList[i]);
			if(timeListVal < Integer.parseInt(time[i]) && timeListVal < 60 && timeListVal >= 0){
				warningPage.main(argsStartTime);
				return false;
			}
		}

		//Check Start Date
		String[] startDateList = startDate.split("-");
		if(startDateList.length != 3){
			warningPage.main(argsStartDate);
			return false;
		}
		for(int i = 0 ; i < 3 ; i++){
			int dateListVal = Integer.parseInt(startDateList[i]);
			if (i == 1){
				if(checkValidDay(startDateList)){}
			}
			if (i == 2){
				if(dateListVal <= 12 && dateListVal >= 1){}
			}
			if(dateListVal < Integer.parseInt(date[i])){
				warningPage.main(argsStartDate);
				return false;
			}
		}

		//Check End Time
		String[] endTimeList = endTime.split("-");
		if(endTimeList.length != 3){
			warningPage.main(argsEndTime);
			return false;
		}
		for(int i = 0 ; i < 3 ; i++){
			int timeListVal = Integer.parseInt(endTimeList[i]);
			if(timeListVal < Integer.parseInt(time[i]) && timeListVal < 60 && timeListVal >= 0){
				warningPage.main(argsEndTime);
				return false;
			}
		}

		//Check End Date
		String[] endDateList = endDate.split("-");
		if(endDateList.length != 3){
			warningPage.main(argsEndDate);
			return false;
		}
		for(int i = 0 ; i < 3 ; i++){
			if(Integer.parseInt(endDateList[i]) < Integer.parseInt(date[i])){
				warningPage.main(argsEndDate);
			return false;
			}
		}

		return true;
	}

	private boolean checkValidDay(String[] date){
		int month = Integer.parseInt(date[2]);
		int day = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[0]);

		boolean value = true;

		switch(month){
			case 1:
				if(day < 1 || day > 31){value = false;}
				break;
			case 2:
				if(day < 1 || day > 28){value = false;}
				if(day == 29 && year%4 == 0){value = true;}
				break;
			case 3:
				if(day < 1 || day > 31){value = false;}
				break;
			case 4:
				if(day < 1 || day > 30){value = false;}
				break;
			case 5:
				if(day < 1 || day > 31){value = false;}
				break;
			case 6:
				if(day < 1 || day > 30){value = false;}
				break;
			case 7:
				if(day < 1 || day > 31){value = false;}
				break;
			case 8:
				if(day < 1 || day > 31){value = false;}
				break;
			case 9:
				if(day < 1 || day > 30){value = false;}
				break;
			case 10:
				if(day < 1 || day > 31){value = false;}
				break;
			case 11:
				if(day < 1 || day > 30){value = false;}
				break;
			case 12:
				if(day < 1 || day > 31){value = false;}
				break;
			default:
				value = false;
				break;
		}

		return value;
	}

	private void checkAvailability(){
		try {
			if(!verifyTimes(timeStart.getText(), timeEnd.getText(), dateStart.getText(), dateEnd.getText())){
				return;
			}
		} catch (Exception e) {
			String[] exceptionArgs = {"Invalid Time or Date"};
			warningPage.main(exceptionArgs);
			return;
		}

		resetTextBoxes();

		for(Event event : getEvents()){
			int num = isConflictingDate(event, dateStart.getText(), dateEnd.getText());

			if(num == 0){
				continue;
			}

			else if(num == 1){
				boolean Conflicting = isConflictingTime(event, timeStart.getText(), timeEnd.getText());
				if(Conflicting){
					int roomNumber = Integer.parseInt(event.getRoom());
					setConflict(roomNumber);
				}
				else{continue;}
			}

			else if(num == 2){
				int roomNumber = Integer.parseInt(event.getRoom());
				setConflict(roomNumber);
			}
		}

		checkRemainingTextBoxes();

		validStartTime = timeStart.getText();
		validEndTime = timeEnd.getText();
		validStartDate = dateStart.getText();
		validEndDate = dateEnd.getText();

		enableButtons();
	}

	private void resetTextBoxes(){
		txt100.setText("");
		txt101.setText("");
		txt102.setText("");
		txt103.setText("");
		txt104.setText("");
		txt105.setText("");
		txt106.setText("");
		txt107.setText("");
		txt108.setText("");
		txt109.setText("");
	}

	private void checkRemainingTextBoxes(){
		if(txt100.getText().equals("")){txt100.setText("Available");}
		if(txt101.getText().equals("")){txt101.setText("Available");}
		if(txt102.getText().equals("")){txt102.setText("Available");}
		if(txt103.getText().equals("")){txt103.setText("Available");}
		if(txt104.getText().equals("")){txt104.setText("Available");}
		if(txt105.getText().equals("")){txt105.setText("Available");}
		if(txt106.getText().equals("")){txt106.setText("Available");}
		if(txt107.getText().equals("")){txt107.setText("Available");}
		if(txt108.getText().equals("")){txt108.setText("Available");}
		if(txt109.getText().equals("")){txt109.setText("Available");}
	}

	private void setConflict(int roomNumber){
		switch(roomNumber){
			case 100:
				txt100.setText("Unavailable");
				break;
			case 101:
				txt101.setText("Unavailable");
				break;
			case 102:
				txt102.setText("Unavailable");
				break;
			case 103:
				txt103.setText("Unavailable");
				break;
			case 104:
				txt104.setText("Unavailable");
				break;
			case 105:
				txt105.setText("Unavailable");
				break;
			case 106:
				txt106.setText("Unavailable");
				break;
			case 107:
				txt107.setText("Unavailable");
				break;
			case 108:
				txt108.setText("Unavailable");
				break;
			case 109:
				txt109.setText("Unavailable");
				break;
			default:
				break;
		}
	}

	//returns 0 if no conflict
	//returns 1 if need to check times
	//returns 2 if guaranteed conflict
	private int isConflictingDate(Event event, String dateStart, String dateEnd){
		String eventStartDate = event.getStartDate();
		String eventEndDate = event.getEndDate();

		if(compareDates(eventStartDate, dateEnd) == -1 || compareDates(dateStart, eventEndDate) == -1){
			return 0;
		}

		if(compareDates(eventStartDate, dateStart) >= 1 && compareDates(eventEndDate, dateEnd) <= 1){
			return 2;
		}

		return 1;
	}

	//return 0 if equals
	//return 1 if date2 is after date1
	//return -1 if date1 is after date2
	private int compareDates(String date1, String date2){ // yyyy-dd-mm
		String[] date1List = date1.split("-");
		String[] date2List = date2.split("-");

		if(Integer.parseInt(date1List[0]) > Integer.parseInt(date2List[0])){
			return -1;
		}
		if(Integer.parseInt(date2List[0]) > Integer.parseInt(date1List[0])){
			return 1;
		}

		if(Integer.parseInt(date1List[1]) > Integer.parseInt(date2List[1])){
			return -1;
		}
		if(Integer.parseInt(date2List[1]) > Integer.parseInt(date1List[1])){
			return 1;
		}

		if(Integer.parseInt(date1List[2]) > Integer.parseInt(date2List[2])){
			return -1;
		}
		if(Integer.parseInt(date2List[2]) > Integer.parseInt(date1List[2])){
			return 1;
		}

		return 0;
	}

	private boolean isConflictingTime(Event event, String timeStart, String timeEnd){
		String eventStartTime = event.getStartTime();
		String eventEndTime = event.getEndTime();

		if(compareTimes(eventStartTime, timeEnd) == -1 || compareTimes(timeStart, eventEndTime) == -1){
			return false;
		}

		return true;
	}
	
	//return 0 if equals
	//return 1 if time2 is after time1
	//return -1 if time1 is after time2
	private int compareTimes(String time1, String time2){ // hh-mm-ss
		String[] time1List = time1.split("-");
		String[] time2List = time2.split("-");

		if(Integer.parseInt(time1List[0]) > Integer.parseInt(time2List[0])){
			return -1;
		}
		if(Integer.parseInt(time2List[0]) > Integer.parseInt(time1List[0])){
			return 1;
		}

		if(Integer.parseInt(time1List[1]) - Integer.parseInt(time2List[1]) >= 30){ //need at least 30 minute buffer to be different enough
			return -1;
		}
		if(Integer.parseInt(time2List[1]) - Integer.parseInt(time1List[1]) >= 30){ //need at least 30 minute buffer to be different enough
			return 1;
		}

		return 0;
	}
	
	private void enableButtons(){
		btn100.setEnabled(true);
		btn101.setEnabled(true);
		btn102.setEnabled(true);
		btn103.setEnabled(true);
		btn104.setEnabled(true);
		btn105.setEnabled(true);
		btn106.setEnabled(true);
		btn107.setEnabled(true);
		btn108.setEnabled(true);
		btn109.setEnabled(true);
	}
}
