package com.ldon.covid19.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * author LucasDonizeti
 */
@Entity
public class CountriesStat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Country;
    private float cases;
    private float deaths;
    private float totalRecovered;
    private float newDeaths;
    private float newCases;
    private float criticalCases;
    private float activeCases;
    private BigDecimal porcentageOfPop;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public float getCases() {
        return cases;
    }

    public void setCases(float cases) {
        this.cases = cases;
    }

    public float getDeaths() {
        return deaths;
    }

    public void setDeaths(float deaths) {
        this.deaths = deaths;
    }

    public float getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(float totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public float getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(float newDeaths) {
        this.newDeaths = newDeaths;
    }

    public float getNewCases() {
        return newCases;
    }

    public void setNewCases(float newCases) {
        this.newCases = newCases;
    }

    public float getCriticalCases() {
        return criticalCases;
    }

    public void setCriticalCases(float criticalCases) {
        this.criticalCases = criticalCases;
    }

    public float getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(float activeCases) {
        this.activeCases = activeCases;
    }

    public BigDecimal getPorcentageOfPop() {
        return porcentageOfPop;
    }

    public void setPorcentageOfPop(BigDecimal porcentageOfPop) {
        this.porcentageOfPop = porcentageOfPop;
    }

    @Override
    public String toString() {
        return "CountriesStat{" +
                "id:" + id +
                ", Country:" + Country +
                ", cases:" + cases +
                ", deaths:" + deaths +
                ", totalRecovered:" + totalRecovered +
                ", newDeaths:" + newDeaths +
                ", newCases:" + newCases +
                ", criticalCases:" + criticalCases +
                ", activeCases:" + activeCases +
                ", porcentageOfPop:" + porcentageOfPop +
                '}';
    }
}
