package src;

//Class for creating objects for Primary Care Providers
public class pcpType {
    String drFname;
    String drLname;
    String specialty;
    //Chose not to assign patient to Dr since Dr is already assigned to patient in PatientType class

    //default constructor
    public pcpType() {
        this.drFname = "";
        this.drLname = "";
        this.specialty = "";
    }

    //constructor
    public pcpType(String drFname, String drLname, String specialty) {
        this.drFname = drFname;
        this.drLname = drLname;
        this.specialty = specialty;
    }

    //Getters
    public String getDrFname() {return drFname;}
    public String getDrLname() {return drLname;}
    public String getSpecialty() {return specialty;}

    //Setters
    public void setDrFname(String drFname) {this.drFname = drFname;}
    public void setDrLname(String drLname) {this.drLname = drLname;}
    public void setSpecialty(String specialty) {this.specialty = specialty;}

    //Print function for all Dr info
    public void printDrInfo(){
        System.out.println("Dr: " + drLname + " Info\n");
        System.out.println(drFname + " " + drLname);
        System.out.println("Specialty: " + specialty);

    }


}
