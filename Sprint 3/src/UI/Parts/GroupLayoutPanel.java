package UI.Parts;

import javax.swing.*;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import java.awt.*;

// https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
//Reference above site for how to use GroupLayout

public class GroupLayoutPanel extends JPanel{
    private GroupLayout layout = new GroupLayout(this);
    private SequentialGroup horizontalGroup = layout.createSequentialGroup();
    private SequentialGroup verticalGroup = layout.createSequentialGroup();

    public GroupLayoutPanel(){
        super();
        super.setLayout(layout);
        // super.setAutoCreateGaps(true);
        // super.setAutoCreateContainerGaps(true);
    }

    public void addItem(Component comp){
        super.add(comp);
        super.validate();
    }

    public void addHorizontalItem(Component item){
        horizontalGroup.addComponent(item);
    }

    public void addHorizontalItems(Component items[]){
        for(Component item : items){
            horizontalGroup.addComponent(item);
        }
    }

    public void addHorizontalParallelGroup(Component items[], GroupLayout.Alignment align){
        ParallelGroup group = layout.createParallelGroup(align);
        for(Component item : items){
            group.addComponent(item);
        }
        horizontalGroup.addGroup(group);
    }

    public void addVerticalItem(Component item){
        verticalGroup.addComponent(item);
    }

    public void addVerticalItems(Component items[]){
        for(Component item : items){
            verticalGroup.addComponent(item);
        }
    }

    public void addVerticalParallelGroup(Component items[], GroupLayout.Alignment align){
        ParallelGroup group = layout.createParallelGroup(align);
        for(Component item : items){
            group.addComponent(item);
        }
        verticalGroup.addGroup(group);
    }

    public void finish(){
        layout.setHorizontalGroup(horizontalGroup);
        layout.setVerticalGroup(verticalGroup);
    }
}
