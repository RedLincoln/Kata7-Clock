package Presenter;

import Clock.Point;
import Model.Model;
import View.ModelDisplay;

import java.util.Observable;
import java.util.Observer;

public class Presenter implements Observer{
    private final Model model;
    private final ModelDisplay modelDisplay;
    
    public Presenter(Model model, ModelDisplay moodelDisplay) {
        this.model = model;
        this.modelDisplay = moodelDisplay;
        this.model.add(this);
    }
    
    private void toScreen(){
        Point[] time = new Point[3];
        time[0] = new Point(dx(model.getSeconds()), dy(model.getSeconds()));
        time[1] = new Point(dx(model.getMinutes()), dy(model.getMinutes()));
        time[2] = new Point(dx(model.getHours()), dy(model.getHours()));
        System.out.println(time[0].getX());
        modelDisplay.updateTime(time);
    }
    
    private double dx(double dø) {
        return  (Math.cos(dø));
    }
    
    
    private double dy(double dø) {
        return  (Math.sin(dø));
    }
    

    @Override
    public void update(Observable o, Object arg) {
        toScreen();
    }
    
}
