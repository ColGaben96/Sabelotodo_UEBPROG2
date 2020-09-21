package co.edu.unbosque.model;

import java.util.Timer;
import java.util.TimerTask;


public class Contador {
	private Timer timer;
    private int segundos=20;
    private boolean isTimerRunning;
    
    public Contador() {
    	timer=new Timer();
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            isTimerRunning = true;
            if(segundos > 0) {
                segundos--;
            }
            else {
            	isTimerRunning = false;
                timer.cancel();
                timer.purge();
            } 
        }
    };
    public void start(int timeout, int interval) {
        timer.schedule(task, timeout, interval);
    }
}
