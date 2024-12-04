package UI.Parts;

import javax.swing.JLabel;

public class Label extends JLabel {

    public Label(String text){
        super();
        setText(text);
    }

    public void setText(String text){
        super.setText(text);
    }

    public String getText(){
        return super.getText();
    }
}
