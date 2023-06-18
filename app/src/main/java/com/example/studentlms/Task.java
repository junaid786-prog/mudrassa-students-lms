package com.example.studentlms;

import java.util.Date;

public class Task {
    private String rollNo;
    private String sabaq;
    private String sabaqi;
    private String manzil;
    private Date date;

    public Task(String rollNo, String sabaq, String sabaqi, String manzil, Date date) {
        this.rollNo = rollNo;
        this.sabaq = sabaq;
        this.sabaqi = sabaqi;
        this.manzil = manzil;
        this.date = date;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getSabaq() {
        return sabaq;
    }

    public String getSabaqi() {
        return sabaqi;
    }

    public String getManzil() {
        return manzil;
    }

    public Date getDate() {
        return date;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setSabaq(String sabaq) {
        this.sabaq = sabaq;
    }

    public void setSabaqi(String sabaqi) {
        this.sabaqi = sabaqi;
    }

    public void setManzil(String manzil) {
        this.manzil = manzil;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "rollNo='" + rollNo + '\'' +
                ", sabaq='" + sabaq + '\'' +
                ", sabaqi='" + sabaqi + '\'' +
                ", manzil='" + manzil + '\'' +
                ", date=" + date +
                '}';
    }
}
