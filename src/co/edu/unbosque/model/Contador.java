package co.edu.unbosque.model;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Juan Pablo Araque
 * @version 1.0
 */
public class Contador {
	private Timer timer;
    private int segundos=20;
    private boolean isTimerRunning;

    /**
     * @author Juan Pablo Araque
     */
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

    /**
     * @author Juan Pablo Araque
     * @param timeout
     * @param interval
     */
    public void start(int timeout, int interval) {
        timer.schedule(task, timeout, interval);
    }
}
