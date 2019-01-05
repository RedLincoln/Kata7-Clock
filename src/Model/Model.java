package Model;

import java.util.*;

public class Model {
    private final List<Observer> observers = new ArrayList<>();
    private final static double dt = 1;
    private double seconds_dø = 2*Math.PI/60;
    private double minutes_dø = seconds_dø/60;
    private double hours_dø = minutes_dø/12;
    private double seconds_ø = Math.PI*3/2;
    private double minutes_ø = Math.PI*3/2;
    private double hours_ø = Math.PI*3/2;
    private int period = 2000;
    private Timer timer;

    
    public Model()
    {
        updateTimer();
    }

    public void updateTimer(){
        timer = new Timer();
        period = period/2;
        timer.schedule(timerTask(), 0, period);
    }

    public double getSeconds() {
        return seconds_ø;
    }

    public double getMinutes() {
        return minutes_ø;
    }

    public double getHours() {
        return hours_ø;
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step(dt);
                updateObservers();
            }
        };
    }

    private void updateObservers() {
        for (Observer observer : observers) {
            observer.update(null,null);
        }
    }

    private void step(double dt) {
        seconds_ø = normalize(seconds_ø + seconds_dø * dt);
        minutes_ø = normalize(minutes_ø + minutes_dø * dt);
        hours_ø = normalize(hours_ø + hours_dø * dt);
    }

    private double normalize(double ø) {
        return (ø + Math.PI*2) % (Math.PI*2);
    }


    public void add(Observer observer) {
        observers.add(observer);
    }
}
