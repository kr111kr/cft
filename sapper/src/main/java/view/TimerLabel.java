package view;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings ("serial")
public class TimerLabel extends JLabel
{
    private Timer timer;
    public TimerLabel (/*Timer timer*/)
    {
        timer = new Timer();
       // new timerTaskCust;
        timer.scheduleAtFixedRate(new timerTaskCust(), 0, 1000);
     //   JLabel timerLabel = new TimerLabel(new Timer());
        this.setFont(new Font(this.getFont().getFontName(), this.getFont().getStyle(), 16));
    }

    public void cleanTimer(){
        if (timer != null) {
            timer.cancel();
            TimerLabel.this.setText(String.format("%04d", 0));//("%02d:%02d", 0, 0));
        }
    }

    public void startTimer(){
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(new timerTaskCust(), 0, 1000);
    }

    public String stopTimer(){
      //  String s = TimerLabel.this.getText();
        if (timer != null) {
            timer.cancel();
        }
        System.out.println(TimerLabel.this.getText());
        return TimerLabel.this.getText();
    }

    //private TimerTask timerTask = new TimerTask()
    public class timerTaskCust extends TimerTask
    {
        private volatile int time = -1;

        private Runnable refresher = new Runnable()
        {
            @Override
            public void run ()
            {
                int t = time;
                TimerLabel.this.setText(String.format("%04d", t ));//"%02d:%02d", t / 60, t % 60));
            }
        };

        @Override
        public void run ()
        {
            time++;
            SwingUtilities.invokeLater(refresher);

        }
    }

   /* public class timerTaskCust extends TimerTask
    {
        private volatile int time = -1;

        private Runnable refresher = new Runnable()
        {
            @Override
            public void run ()
            {
                int t = time;
                TimerLabel.this.setText(String.format("%02d:%02d", t / 60, t % 60));
            }
        };

        @Override
        public void run ()
        {
            time++;
            SwingUtilities.invokeLater(refresher);

        }
    };
*/
  /*  public static void main (String[] args)
    {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel timerLabel = new TimerLabel(new Timer());
        timerLabel.setFont(new Font(timerLabel.getFont().getFontName(), timerLabel.getFont().getStyle(), 36));
        frame.add(timerLabel);
        frame.pack();
        frame.setVisible(true);
    }*/

    /*public JLabel getTimer()
    {
       // JFrame frame = new JFrame();
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JLabel timerLabel = new TimerLabel(new Timer());
        //timerLabel.setFont(new Font(timerLabel.getFont().getFontName(), timerLabel.getFont().getStyle(), 36));
       // frame.add(timerLabel);
      //  frame.pack();
       // frame.setVisible(true);
        return timerLabel;
    }*/
}


//private TimerTask timerTask = new TimerTask()
