package com.example.project1602;


        //luokka mittaustuloksien tallennusta varten
public class MeasurementReadings {
    private int bloodpressurehigh, bloodpressurelow;
    private int heartbeat;
    private int weight;
    private String otherattention;
    private int date;


    public MeasurementReadings(int bloodpressurehigh, int bloodpressurelow, int heartbeat, int weight, String otherattention, int date) {
        this.bloodpressurehigh = bloodpressurehigh;
        this.bloodpressurelow = bloodpressurelow;
        this.heartbeat = heartbeat;
        this.weight = weight;
        this.otherattention = otherattention;
        this.date = date;
    }

    public int getBloodpressurehigh() {
        return bloodpressurehigh;
    }

    public void setBloodpressurehigh(int bloodpressurehigh) {
        this.bloodpressurehigh = bloodpressurehigh;
    }

    public int getBloodpressurelow() {
        return bloodpressurelow;
    }

    public void setBloodpressurelow(int bloodpressurelow) {
        this.bloodpressurelow = bloodpressurelow;
    }

    public int getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(int heartbeat) {
        this.heartbeat = heartbeat;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getOtherattention() {
        return otherattention;
    }

    public void setOtherattention(String otherattention) {
        this.otherattention = otherattention;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
