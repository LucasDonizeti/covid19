package com.ldon.covid19.service.pandemic;

import com.google.gson.Gson;
import com.ldon.covid19.model.CountriesStat;
import com.ldon.covid19.service.pandemic.CountrieStatConvertObjects;
import com.ldon.covid19.service.pandemic.Csco;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateAtt = dateFormat.format(date);
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
            cs.setDateAtt(dateAtt);
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
}
