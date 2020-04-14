package com.ldon.covid19.service.pandemic;

import java.util.List;

/**
 * author LucasDonizeti
 */
public class CountrieStatConvertObjects {
    private List<Csco> countries_stat;

    public List<Csco> getCountries_stat(){
        return countries_stat;
    }
    public void setCountries_stat(List<Csco> cscoList){
        this.countries_stat=cscoList;
    }
}
