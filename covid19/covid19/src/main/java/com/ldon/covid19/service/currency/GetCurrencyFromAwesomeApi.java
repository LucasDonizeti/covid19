package com.ldon.covid19.service.currency;

import com.google.gson.Gson;
import com.ldon.covid19.model.CurrencyPrice;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
public class GetCurrencyFromAwesomeApi {

    public static List<CurrencyPrice> getCurrencyFromAwesomeApi() throws IOException, InterruptedException {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://economia.awesomeapi.com.br/all"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        CurrencyCO a = gson.fromJson(response.body(), CurrencyCO.class);

        List<CurrencyPrice> cp = new ArrayList<>();
        cp.add(ccoToCp(a.getUsd()));
        cp.add(ccoToCp(a.getUsdt()));
        cp.add(ccoToCp(a.getCad()));
        cp.add(ccoToCp(a.getEur()));
        cp.add(ccoToCp(a.getGpd()));
        cp.add(ccoToCp(a.getArs()));
        cp.add(ccoToCp(a.getBtc()));
        cp.add(ccoToCp(a.getLtc()));
        cp.add(ccoToCp(a.getJpy()));
        cp.add(ccoToCp(a.getChf()));
        cp.add(ccoToCp(a.getAud()));
        cp.add(ccoToCp(a.getCny()));
        cp.add(ccoToCp(a.getIls()));
        cp.add(ccoToCp(a.getEth()));
        cp.add(ccoToCp(a.getXpr()));
        return cp;
    }
    private static CurrencyPrice ccoToCp(CurrencyPrice cco){
        CurrencyPrice cp=new CurrencyPrice();
        cp.setCode(cco.getCode());
        cp.setCodein(cco.getCodein());
        cp.setName(cco.getName());
        cp.setHigh(cco.getHigh());
        cp.setLow(cco.getLow());
        cp.setVarBid(cco.getVarBid());
        cp.setPctChange(cco.getPctChange());
        cp.setCreateDate(cco.getCreateDate());
        return cp;
    }


}
