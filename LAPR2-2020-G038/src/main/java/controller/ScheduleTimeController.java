/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author LAPR2-2020-G038
 */
public class ScheduleTimeController {
    
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;
    private int sec;
    
    Calendar calendar = Calendar.getInstance();
    
    public void setDate(int year, int month, int day, int hour, int min, int sec){
        this.year=year;
        this.month=month;
        this.day=day;
        this.hour=hour;
        this.min=min;
        this.sec=sec;
       }
    
    Timer timer = new Timer();
     TimerTask timerTask = new TimerTask(){
             
             
     @Override
    public void run() {
        
    }
};
}
