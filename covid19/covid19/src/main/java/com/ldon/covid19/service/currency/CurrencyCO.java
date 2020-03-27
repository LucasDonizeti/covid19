package com.ldon.covid19.service.currency;

import com.google.gson.annotations.SerializedName;
import com.ldon.covid19.model.CurrencyPrice;

/**
 * author LucasDonizeti
 */

public class CurrencyCO {
    @SerializedName("USD")
    private USD usd;
    @SerializedName("USDT")
    private USDT usdt;
    @SerializedName("CAD")
    private CAD cad;
    @SerializedName("EUR")
    private EUR eur;
    @SerializedName("GBP")
    private GBP gpd;
    @SerializedName("ARS")
    private ARS ars;
    @SerializedName("BTC")
    private BTC btc;
    @SerializedName("LTC")
    private LTC ltc;
    @SerializedName("JPY")
    private JPY jpy;
    @SerializedName("CHF")
    private CHF chf;
    @SerializedName("AUD")
    private AUD aud;
    @SerializedName("CNY")
    private CNY cny;
    @SerializedName("ILS")
    private ILS ils;
    @SerializedName("ETH")
    private ETH eth;
    @SerializedName("XRP")
    private XRP xpr;


    public USD getUsd() {
        return usd;
    }

    public void setUsd(USD usd) {
        this.usd = usd;
    }

    public USDT getUsdt() {
        return usdt;
    }

    public void setUsdt(USDT usdt) {
        this.usdt = usdt;
    }

    public CAD getCad() {
        return cad;
    }

    public void setCad(CAD cad) {
        this.cad = cad;
    }

    public EUR getEur() {
        return eur;
    }

    public void setEur(EUR eur) {
        this.eur = eur;
    }

    public GBP getGpd() {
        return gpd;
    }

    public void setGpd(GBP gpd) {
        this.gpd = gpd;
    }

    public ARS getArs() {
        return ars;
    }

    public void setArs(ARS ars) {
        this.ars = ars;
    }

    public BTC getBtc() {
        return btc;
    }

    public void setBtc(BTC btc) {
        this.btc = btc;
    }

    public LTC getLtc() {
        return ltc;
    }

    public void setLtc(LTC ltc) {
        this.ltc = ltc;
    }

    public JPY getJpy() {
        return jpy;
    }

    public void setJpy(JPY jpy) {
        this.jpy = jpy;
    }

    public CHF getChf() {
        return chf;
    }

    public void setChf(CHF chf) {
        this.chf = chf;
    }

    public AUD getAud() {
        return aud;
    }

    public void setAud(AUD aud) {
        this.aud = aud;
    }

    public CNY getCny() {
        return cny;
    }

    public void setCny(CNY cny) {
        this.cny = cny;
    }

    public ILS getIls() {
        return ils;
    }

    public void setIls(ILS ils) {
        this.ils = ils;
    }

    public ETH getEth() {
        return eth;
    }

    public void setEth(ETH eth) {
        this.eth = eth;
    }

    public XRP getXpr() {
        return xpr;
    }

    public void setXpr(XRP xpr) {
        this.xpr = xpr;
    }

    public class XRP extends CurrencyPrice {
    }

    public class ETH extends CurrencyPrice {
    }

    public class ILS extends CurrencyPrice {
    }

    public class CNY extends CurrencyPrice {
    }

    public class AUD extends CurrencyPrice {
    }

    public class CHF extends CurrencyPrice {
    }

    public class JPY extends CurrencyPrice {
    }

    public class LTC extends CurrencyPrice {
    }

    public class BTC extends CurrencyPrice {
    }

    public class ARS extends CurrencyPrice {
    }

    public class GBP extends CurrencyPrice {
    }

    public class EUR extends CurrencyPrice {
    }

    public class CAD extends CurrencyPrice {
    }

    public class USDT extends CurrencyPrice {
    }

    public class USD extends CurrencyPrice {
    }

}
