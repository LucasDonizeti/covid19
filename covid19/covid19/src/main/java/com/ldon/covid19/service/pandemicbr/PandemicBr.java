package com.ldon.covid19.service.pandemicbr;

import com.google.gson.Gson;
import com.ldon.covid19.model.CityData;
import com.ldon.covid19.model.StateData;

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
public class PandemicBr {
    public static void main(String[] args) throws IOException, InterruptedException {
        CityAndStateData csd = getCityAndStateDataList();
        csd.getCityDataList().forEach(c -> System.out.println(c.toString()));
        csd.getStateDataList().forEach(s -> System.out.println(s.toString()));
    }


    public static CityAndStateData getCityAndStateDataList() throws IOException, InterruptedException {
        List<StateData> sd = new ArrayList<>();
        List<CityData> cd = new ArrayList<>();
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newBuilder().build();
        String nextlink = "https://brasil.io/api/dataset/covid19/caso/data/?format=json&page=1";

        while (true) {
            System.out.println("GET: " + nextlink);
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(nextlink))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println("body:" + response.body());
            ResponseObject a = gson.fromJson(response.body(), ResponseObject.class);
            List<CityObject> results = a.getResults();
            for (CityObject x : results) {
                if (x.isIs_last() && x.getCity_ibge_code() != null) {
                    if (x.getCity() == null) {
                        System.out.println(x.toString());
                        StateData std = new StateData();
                        std.setIbgeCode(x.getCity_ibge_code());
                        std.setConfirmed(x.getConfirmed());
                        std.setDate(x.getDate());
                        std.setDeaths(x.getDeaths());
                        std.setPop(x.getEstimated_population_2019());
                        std.setState(x.getState());
                        sd.add(std);
                    } else {
                        System.out.println(x.toString());
                        CityData ctd = new CityData();
                        ctd.setCity(x.getCity());
                        ctd.setIbgeCode(x.getCity_ibge_code());
                        ctd.setConfirmed(x.getConfirmed());
                        ctd.setDate(x.getDate());
                        ctd.setDeaths(x.getDeaths());
                        ctd.setPop(x.getEstimated_population_2019());
                        ctd.setState(x.getState());
                        cd.add(ctd);
                    }
                }
            }
            if (a.getNext() == null) {
                break;
            }
            nextlink = a.getNext();
        }

        return new CityAndStateData(cd, sd);
    }

    class ResponseObject {
        private String next;
        private String previous = null;

        private ArrayList<CityObject> results = new ArrayList<>();

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }

        public ArrayList<CityObject> getResults() {
            return results;
        }

        public void setResults(ArrayList<CityObject> results) {
            this.results = results;
        }
    }

    class CityObject {
        private String city;
        private String city_ibge_code;
        private int confirmed;
        private String date;
        private int deaths;
        private int estimated_population_2019;
        private boolean is_last;
        private String place_type;
        private String state;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity_ibge_code() {
            return city_ibge_code;
        }

        public void setCity_ibge_code(String city_ibge_code) {
            this.city_ibge_code = city_ibge_code;
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

        public int getEstimated_population_2019() {
            return estimated_population_2019;
        }

        public void setEstimated_population_2019(int estimated_population_2019) {
            this.estimated_population_2019 = estimated_population_2019;
        }

        public boolean isIs_last() {
            return is_last;
        }

        public void setIs_last(boolean is_last) {
            this.is_last = is_last;
        }

        public String getPlace_type() {
            return place_type;
        }

        public void setPlace_type(String place_type) {
            this.place_type = place_type;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }
}