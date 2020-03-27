package com.ldon.covid19.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * author LucasDonizeti
 */
@Entity
public class CurrencyPrice {
    private String code;
    private String codein;
    @Id
    private String name;
    private float high;
    private float low;
    private float varBid;
    private float pctChange;
    @SerializedName("create_date")
    private String createDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodein() {
        return codein;
    }

    public void setCodein(String codein) {
        this.codein = codein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getVarBid() {
        return varBid;
    }

    public void setVarBid(float varBid) {
        this.varBid = varBid;
    }

    public float getPctChange() {
        return pctChange;
    }

    public void setPctChange(float pctChange) {
        this.pctChange = pctChange;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String create_date) {
        this.createDate = create_date;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code:" + code +
                ", codein:" + codein +
                ", name:" + name +
                ", high:" + high +
                ", low:" + low +
                ", varBid:" + varBid +
                ", pctChange:" + pctChange +
                ", createDate:" + createDate +
                '}';
    }
}
