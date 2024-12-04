package UI.Parts;

import javax.swing.JTextField;

public class TextInput extends JTextField{
    final int COLUMNS = 24;
    final String INITIALTEXT = "";

    public TextInput(String initialText, int columns){
        super(
            ((Object) initialText == null) ? ("") : (initialText), 
            ((Object) columns == null) ? (24) : (columns)
        );
    }

    public String getText(){
        return super.getText();
    }
}
