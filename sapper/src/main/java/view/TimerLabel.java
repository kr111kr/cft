package view;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class TimerLabel extends JLabel {
    private static final String TIME_FORMAT = "%04d";

    private Timer timer;

    public TimerLabel() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new timerTaskCust(), 0, 1000);
        this.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 16));
    }

    public void cleanTimer() {
        if (timer != null) {
            timer.cancel();
            TimerLabel.this.setText(String.format(TIME_FORMAT, 0));
        }
    }

    public void startTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new timerTaskCust(), 0, 1000);
    }

    public String stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
        System.out.println(TimerLabel.this.getText());
        return TimerLabel.this.getText();
    }

    public class timerTaskCust extends TimerTask {
        private volatile int time = -1;

        private Runnable refresher = () -> {
            int t = time;
            TimerLabel.this.setText(String.format(TIME_FORMAT, t));
        };

        @Override
        public void run() {
            time++;
            SwingUtilities.invokeLater(refresher);
        }
    }
}