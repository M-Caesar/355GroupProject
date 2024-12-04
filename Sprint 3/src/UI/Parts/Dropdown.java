package UI.Parts;

import javax.swing.JComboBox;

public class Dropdown extends JComboBox<String> {
    public Dropdown(String[] options){
        super(options);
    }

    public String getSelectedItem(){
        return (String) super.getSelectedItem();
    }

    // public void addItem(String option){
    //     addItem(option);
    // }

    // public void removeItem(String option){
    //     removeItem(option);
    // }
}