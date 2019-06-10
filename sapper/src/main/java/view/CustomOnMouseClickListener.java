package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

abstract public class CustomOnMouseClickListener extends MouseAdapter {
    private boolean wasDoubleClick;
    private Timer timer;

    @Override
    public final void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            if(e.getClickCount() == 2){
                wasDoubleClick = true;
            } else {
                wasDoubleClick = false;
                timer = new Timer(250, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (wasDoubleClick) {
                            wasDoubleClick = false; // reset flag
                            onDoubleLeftButton();
                        } else {
                            onLeftButton();
                        }
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        } else if (e.getButton() == MouseEvent.BUTTON3){
            onRightButton();
        }
    }

    abstract public void onLeftButton();

    abstract public void onRightButton();

    abstract public void onDoubleLeftButton();
}
