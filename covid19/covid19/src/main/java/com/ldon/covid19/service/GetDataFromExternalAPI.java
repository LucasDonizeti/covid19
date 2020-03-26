package com.ldon.covid19.service;

import com.google.gson.Gson;
import com.ldon.covid19.model.CountriesStat;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * author LucasDonizeti
 */
public class GetDataFromExternalAPI {

    public static List<CountriesStat> getAllData() throws IOException, InterruptedException {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://coronavirus-monitor.p.rapidapi.com/coronavirus/cases_by_country.php"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .setHeader("x-rapidapi-host", "coronavirus-monitor.p.rapidapi.com")
                .setHeader("x-rapidapi-key", "f2f913f67cmsh0a10dab6f71d96dp17e2b0jsneb841f620a3a")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        CountrieStatConvertObjects a = gson.fromJson(response.body(), CountrieStatConvertObjects.class);

        return conversion(a);

    }

    private static List<CountriesStat> conversion(CountrieStatConvertObjects cscos) {
        List<CountriesStat> countriesStatList = new ArrayList();
        for (Csco csco : cscos.getCountries_stat()) {
            CountriesStat cs = new CountriesStat();
            cs.setCountry(csco.getCountry_name());
            cs.setCases((int) valueStringToInt(csco.getCases()));
            cs.setDeaths((int) valueStringToInt(csco.getDeaths()));
            cs.setTotalRecovered((int) valueStringToInt(csco.getTotal_recovered()));
            cs.setNewDeaths((int) valueStringToInt(csco.getNew_deaths()));
            cs.setNewCases((int) valueStringToInt(csco.getNew_cases()));
            cs.setCriticalCases((int) valueStringToInt(csco.getSerious_critical()));
            cs.setActiveCases((int) valueStringToInt(csco.getActive_cases()));
            BigDecimal x = new BigDecimal(valueStringToInt(csco.getTotal_cases_per_1m_population()));
            cs.setPorcentageOfPop(x.divide(new BigDecimal(10000)));
            countriesStatList.add(cs);
        }
        return countriesStatList;
    }


    private static float valueStringToInt(String n) {
        String[] a = n.split(",");
        String aux = "";
        for (String x : a) {
            aux += x;
        }
        return Float.parseFloat(aux);
    }
    /*
    private String Country;
    private float cases;
    private float deaths;
    private float totalRecovered;
    private float newDeaths;
    private float newCases;
    private float criticalCases;
    private float activeCases;
    private long porcentageOfPop;
     */

}
