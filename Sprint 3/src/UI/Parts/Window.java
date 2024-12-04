package UI.Parts;

import java.awt.Component;
import javax.swing.JFrame;

public class Window extends JFrame{
    final String DEFAULTTITLE = "";
    final int DEFAULTSIZE = 500;
    final int DEFAULTLOCATION = 300;

    public Window (String title){
        super(title);
        super.setSize(DEFAULTSIZE, DEFAULTSIZE);
        super.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
    }

    public Window (String title, int width, int height){
        super(title);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
    }
    
    public Window(String title, int x, int y, int width, int height){
        super(title);
        super.setSize(width, height);
        super.setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
    }

    public void addItem(String borderLayout, Component comp){
        super.getContentPane().add(borderLayout, comp);
    }

    public void setContentPanel(MainPanel panel){
        super.setContentPane(panel);
        super.pack(); // Set size to preferred size of buttons and stuff in the content panel
    }

    public void setVisible(boolean visible){
        super.setVisible(visible);
    }

    public boolean isVisible(){
        return super.isVisible();
    }
}