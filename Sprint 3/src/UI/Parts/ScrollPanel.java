package UI.Parts;

import javax.swing.JScrollPane;
import java.awt.Component;

public class ScrollPanel extends JScrollPane{
    final String DEFAULTTITLE = "";
    final int DEFAULTSIZE = 500;
    final int DEFAULTLOCATION = 300;

    public ScrollPanel(Component panel){
        super(panel);
        super.setSize(DEFAULTSIZE, DEFAULTSIZE);
        super.setLocation(DEFAULTLOCATION, DEFAULTLOCATION);
    }

    public ScrollPanel(Component panel, int x, int y, int width, int height){
        super(panel);
        super.setSize(width, height);
        super.setLocation(x, y);
    }

    public void addItem(Component comp){
        super.add(comp);
        super.validate();
    }
}
