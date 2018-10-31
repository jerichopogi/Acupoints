package com.devs.jeric.acupoints;

public class Symptoms {
    private String symptomTitle;
    private int thumbnail;

    public Symptoms(){

    }

    public Symptoms(String symptomTitle, int title) {
        this.symptomTitle = symptomTitle;
        this.thumbnail = title;
    }

    public String getSymptomtitle() {
        return symptomTitle;
    }

    public void setSymptomtitle(String symptomtitle) {
        this.symptomTitle = symptomtitle;
    }

    public int getThumbnail(){
        return thumbnail;
    }
}
