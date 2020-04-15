package com.ldon.covid19.service.pandemicbr;

import com.ldon.covid19.model.CityData;
import com.ldon.covid19.model.StateData;

import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
public class CityAndStateData {
    private List<CityData> cityDataList= new ArrayList<>();
    private List<StateData> stateDataList=new ArrayList<>();

    public CityAndStateData(List<CityData> cityDataList, List<StateData> stateDataList) {
        this.cityDataList = cityDataList;
        this.stateDataList = stateDataList;
    }

    public List<CityData> getCityDataList() {
        return cityDataList;
    }

    public void setCityDataList(List<CityData> cityDataList) {
        this.cityDataList = cityDataList;
    }

    public List<StateData> getStateDataList() {
        return stateDataList;
    }

    public void setStateDataList(List<StateData> stateDataList) {
        this.stateDataList = stateDataList;
    }
}
