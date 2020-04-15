package com.ldon.covid19.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * author LucasDonizeti
 */
@Entity
public class StateData {
    @Id
    private String ibgeCode;
    private int confirmed;
    private String date;
    private int deaths;
    private int pop;
    private String state;

    public String getIbgeCode() {
        return ibgeCode;
    }

    public void setIbgeCode(String ibgeCode) {
        this.ibgeCode = ibgeCode;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StateData{" +
                "ibgeCode=" + ibgeCode +
                ", confirmed=" + confirmed +
                ", date=" + date +
                ", deaths=" + deaths +
                ", pop=" + pop +
                ", state=" + state +
                '}';
    }
}
