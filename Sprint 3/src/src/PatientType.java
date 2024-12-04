package src;

import java.time.LocalDateTime;
import java.util.Scanner;

//Class for creating patient objects
public class PatientType {
    String patientFName;
    String patientLName;
    String SSN;
    String MRN;
    String roomNumber;
    int birthDay;
    int birthMonth;
    int birthYear;
    int adminDay;
    int adminMonth;
    int adminYear;
    pcpType pcp;
    boolean insurance;
    String chart;
    //Need to change this to schedule type
    String event;
    Schedule schedule;
    int disDay;
    int disMonth;
    int disYear;
    String gender;
    String diagnosis;
    String pcpString;

    //default constructor
    public PatientType()
    {
        this.patientFName = "";
        this.patientLName = "";
        this.SSN = "";
        this.MRN = "";
        this.roomNumber = "";
        this.birthDay = 1;
        this.birthMonth = 1;
        this.birthYear = 1900;
        this.adminDay = 1;
        this.adminMonth = 1;
        this.adminYear = 1900;
        this.pcp = null;
        this.insurance = false;
        this.chart = "";
        this.event = "";
        this.schedule = new Schedule();
        this.disDay = 1;
        this.disMonth = 1;
        this.disYear = 1900;
        this.gender = "";
        this.diagnosis = "";
        this.pcpString = "";
    }

    //initialized constructor
    public PatientType(String fname, String lname, String SSN, String MRN, String newRoom, int birthDay, int birthMonth, int birthYear, int aDay,
                   int aMonth, int aYear, pcpType newpcp, boolean insurance, String chart, String event, int disDay, int disMonth, int disYear, String gender, String diagnosis, String pcpString ) {
        this.patientFName = fname;
        this.patientLName = lname;
        this.SSN = SSN;
        this.MRN = MRN;
        this.roomNumber = newRoom;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.adminDay = aDay;
        this.adminMonth = aMonth;
        this.adminYear = aYear;
        this.pcp = newpcp;
        this.insurance = insurance;
        this.chart = chart;
        this.event = event;
        this.schedule = new Schedule();
        this.disDay = disDay;
        this.disMonth = disMonth;
        this.disYear = disYear;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.pcpString = pcpString;
    }

    //getters
    public String getPatientFName() {return patientFName;}
    public String getPatientLName() {return patientLName;}
    public String getSSN() {return SSN;}
    public String getMRN() {return MRN;}
    public String getRoomNumber() {return roomNumber;}
    public int getBirthDay() {return birthDay;}
    public int getBirthMonth() {return birthMonth;}
    public int getBirthYear() {return birthYear;}
    public int getAdminDay() {return adminDay;}
    public int getAdminMonth() {return adminMonth;}
    public int getAdminYear() {return adminYear;}
    public pcpType getPcp() {return pcp;}
    public boolean getInsurance() {return insurance;}
    public String getChart() {return chart;}
    public String getEvent() {return event;}
    public Schedule getSchedule() {return schedule;}
    public int getDisDay() {return disDay;}
    public int getDisMonth() {return disMonth;}
    public int getDisYear() {return disYear;}
    public String getGender() {return gender;}
    public String getDiagnosis() {return diagnosis;}
    public String getPcpString() {return pcpString;}


    //setters
    public void setfname(String fname) { this.patientFName = fname;}
    public void setlname(String lname) { this.patientLName = lname; }
    public void setSSN(String SSN) { this.SSN = SSN; }
    public void setMRN(String MRN) { this.MRN = MRN; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public void setBirthDay(int birthDay) { this.birthDay = birthDay; }
    public void setBirthMonth(int birthMonth) { this.birthMonth = birthMonth; }
    public void setBirthYear(int birthYear) { this.birthYear = birthYear; }
    public void setAdminDay(int aDay) { this.adminDay = aDay; }
    public void setAdminMonth(int aMonth) { this.adminMonth = aMonth; }
    public void setAdminYear(int aYear) { this.adminYear = aYear; }
    public void setPcp(pcpType pcp) { this.pcp = pcp; }
    public void setInsurance(boolean insurance) { this.insurance = insurance; }
    public void setChart(String chart) { this.chart = chart; }
    public void setEvent(String event) { this.event = event; }
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
    public void setDisDay(int disDay) { this.disDay = disDay; }
    public void setDisMonth(int disMonth) { this.disMonth = disMonth; }
    public void setDisYear(int disYear) { this.disYear = disYear; }
    public void setGender(String gender) { this.gender = gender; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setPcpString(String pcpString) { this.pcpString = pcpString; }

    //Method for creating a new event for the patient via user input
    public void createEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the event: ");
        String ename = scanner.nextLine();
        System.out.println("Enter the type of the event: ");
        String etype = scanner.nextLine();
        System.out.println("Enter some information about the event: ");
        String einfo = scanner.nextLine();
        System.out.println("Enter the day of the event: ");
        int day = scanner.nextInt();
        System.out.println("Enter the month of the event: ");
        int month = scanner.nextInt();
        System.out.println("Enter the year of the event: ");
        int year = scanner.nextInt();
        System.out.println("Enter time of event: ");
        int hr = scanner.nextInt();
        int min = scanner.nextInt();
        LocalDateTime date = LocalDateTime.of(month,day,year,hr,min);
        System.out.println("Enter the patient room number");
        String room = scanner.nextLine();
        Event newEvent = new Event(ename,etype,einfo,date,room);
        this.schedule.addEvent(newEvent);

    }

    //Method for adding already initalized event to patient schedule
    public void newEvent(Event newEvent) {
        this.schedule.addEvent(newEvent);
    }

    //prints entire patient schedule
    //need to find way to organize schedule by date
    public void showSchedule() {
        System.out.println("------------Paitient Schedule------------");
        this.schedule.printAllEvents();

    }

    //Method for printing all patient information
    public void printPatient() {
        System.out.println("----------Info for patient: " + this.getPatientFName() + "-----------");
        System.out.println("First name: " + this.getPatientFName());
        System.out.println("Last name: " + this.getPatientLName());
        System.out.println("Gender: " + this.getGender());
        System.out.println("DOB: " + this.getBirthMonth() + "/" + this.getBirthDay() + "/" + this.getBirthYear());
        System.out.println("Social Security Number: " + this.getSSN());
        System.out.println("Patient MRN: " + this.getMRN());
        System.out.println("Room Number: " + this.getRoomNumber());
        System.out.println("Admission date: " + this.getAdminMonth() + "/" + this.getAdminDay() + "/" + this.getAdminYear());
        System.out.println("Discharge date: " + this.getDisMonth() + "/" + this.getDisDay() + "/" + this.getDisYear());
        System.out.println("PCP: Dr." + this.pcp.drLname);
        System.out.println("Insured?: " + this.getInsurance());
        System.out.println("Chart: " + this.getChart());
        System.out.println("Upcoming event: " + this.getEvent());
        this.showSchedule();
    }
}
