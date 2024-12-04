package UI.Parts;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;

public class MainPanel extends JPanel{
    GridBagConstraints gbc = null;

    public MainPanel(boolean isYAxis){ //For main panel
        super();
        if(isYAxis){super.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));}
        else{super.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));}
    }

    public void addItem(Component comp){
        super.add(comp);
        super.validate();
    }

    public void addItem(int gridx, int gridy, Component comp){
        if(gbc != null){
            gbc.gridx = gridx;
            gbc.gridy = gridy;
        }
        this.addItem(comp);
    }
}
