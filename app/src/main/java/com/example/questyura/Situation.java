package com.example.questyura;

public class Situation {
    private String subject;
    private String text;
    private int dk;
    private int da;
    private int dr;
    private Situation[] directions;
    //конструктор для нового вопроса
    public Situation(String subject, String text, int directionsSize,
                     int dk, int da, int dr) {
        this.subject = subject;
        this.text = text;
        this.dk = dk;
        this.da = da;
        this.dr = dr;
        directions = new Situation[directionsSize];
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDk() {
        return dk;
    }

    public void setDk(int dk) {
        this.dk = dk;
    }

    public int getDa() {
        return da;
    }

    public void setDa(int da) {
        this.da = da;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public Situation[] getDirections() {
        return directions;
    }
}
