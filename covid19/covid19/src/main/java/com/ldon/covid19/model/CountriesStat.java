package com.ldon.covid19.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * author LucasDonizeti
 */
@Entity
public class CountriesStat {
    @Id
    private String country;
    private int cases;
    private int deaths;
    private int totalRecovered;
    private int newDeaths;
    private int newCases;
    private int criticalCases;
    private int activeCases;
    private BigDecimal porcentageOfPop;
    private String dateAtt;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCases() {
        return cases;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public int getCriticalCases() {
        return criticalCases;
    }

    public void setCriticalCases(int criticalCases) {
        this.criticalCases = criticalCases;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    public BigDecimal getPorcentageOfPop() {
        return porcentageOfPop;
    }

    public void setPorcentageOfPop(BigDecimal porcentageOfPop) {
        this.porcentageOfPop = porcentageOfPop;
    }

    public String getDateAtt() {
        return dateAtt;
    }

    public void setDateAtt(String dateAtt) {
        this.dateAtt = dateAtt;
    }

    @Override
    public String toString() {
        return "CountriesStat{" +
                ", Country:" + country +
                ", cases:" + cases +
                ", deaths:" + deaths +
                ", totalRecovered:" + totalRecovered +
                ", newDeaths:" + newDeaths +
                ", newCases:" + newCases +
                ", criticalCases:" + criticalCases +
                ", activeCases:" + activeCases +
                ", porcentageOfPop:" + porcentageOfPop +
                ", dateAtt:" + dateAtt +
                '}';
    }
}
