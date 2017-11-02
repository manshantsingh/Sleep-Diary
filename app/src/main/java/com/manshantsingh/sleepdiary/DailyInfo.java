package com.manshantsingh.sleepdiary;

/**
 * Created by mansh on 9/16/2017.
 */

public class DailyInfo {
    private int id;
    private String sleepDate;
    private String bedIn;
    private String sleepTry;
    private String sleepTime;
    private String wakeTime;
    private String bedOut;

    private int numWakes;
    private int numCoffee;

    private int sleepRate;
    private int feelRate;

    public DailyInfo() {
        // Default values for a new form info
        numWakes = 0;
        numCoffee = 0;
    }

    public DailyInfo(int _id, String _sleepDate, String _bedIn, String _sleepTry, String _sleepTime,
                     String _wakeTime, String _bedOut, int _numWakes, int _sleepRate, int _feelRate, int _numCoffee) {
        this(_sleepDate, _bedIn, _sleepTry, _sleepTime, _wakeTime, _bedOut, _numWakes, _sleepRate, _feelRate, _numCoffee);
        id = _id;
    }

    public DailyInfo(String _sleepDate, String _bedIn, String _sleepTry, String _sleepTime,
                     String _wakeTime, String _bedOut, int _numWakes, int _sleepRate, int _feelRate, int _numCoffee) {
        sleepDate = _sleepDate;
        bedIn = _bedIn;
        sleepTry = _sleepTry;
        sleepTime = _sleepTime;
        wakeTime = _wakeTime;
        bedOut = _bedOut;
        numWakes = _numWakes;
        sleepRate = _sleepRate;
        feelRate = _feelRate;
        numCoffee = _numCoffee;
    }

    private String timeToString(int time) {
        return "";
    }

    private int stringToTime(String time) {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSleepDate() {
        return sleepDate;
    }

    public void setSleepDate(String sleepDate) {
        this.sleepDate = sleepDate;
    }

    public String getBedIn() {
        return bedIn;
    }

    public void setBedIn(String bedIn) {
        this.bedIn = bedIn;
    }

    public String getSleepTry() {
        return sleepTry;
    }

    public void setSleepTry(String sleepTry) {
        this.sleepTry = sleepTry;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getWakeTime() {
        return wakeTime;
    }

    public void setWakeTime(String wakeTime) {
        this.wakeTime = wakeTime;
    }

    public String getBedOut() {
        return bedOut;
    }

    public void setBedOut(String bedOut) {
        this.bedOut = bedOut;
    }

    public int getNumWakes() {
        return numWakes;
    }

    public void setNumWakes(int numWakes) {
        this.numWakes = numWakes;
    }

    public int getSleepRate() {
        return sleepRate;
    }

    public void setSleepRate(int sleepRate) {
        this.sleepRate = sleepRate;
    }

    public int getFeelRate() {
        return feelRate;
    }

    public void setFeelRate(int feelRate) {
        this.feelRate = feelRate;
    }

    public int getNumCoffee() {
        return numCoffee;
    }

    public void setNumCoffee(int numCoffee) {
        this.numCoffee = numCoffee;
    }
}
