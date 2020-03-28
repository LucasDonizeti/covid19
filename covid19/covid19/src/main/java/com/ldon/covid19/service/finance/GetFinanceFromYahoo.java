package com.ldon.covid19.service.finance;

import com.ldon.covid19.model.Indice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author LucasDonizeti
 */
public class GetFinanceFromYahoo {

    public static List<Indice> financeCrowler() {
        String url = "https://finance.yahoo.com/world-indices";
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/ldon/covid19/service/chromedriver_win32 (1)/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to URL
        driver.get(url);

        // Find the table element using xpath
        WebElement table = driver.findElement(By.xpath("//*[@id=\"yfin-list\"]/div[2]/div/div/table/tbody"));

        // Go through each major version
        List<WebElement> mainVersions = table.findElements(By.tagName("tr"));
        List<IndiceCO> indiceCOList = new ArrayList<>();
        for (WebElement mver : mainVersions) {
            IndiceCO indiceCO = new IndiceCO();
            List<WebElement> attributes = mver.findElements(By.tagName("td"));
            indiceCO.setSimbolo(attributes.get(0).findElements(By.tagName("a")).get(0).getText());
            indiceCO.setNome(attributes.get(1).getText());
            indiceCO.setPreco(attributes.get(2).getText());
            indiceCO.setVariacao(attributes.get(3).getText());
            indiceCO.setVariacaoRange(attributes.get(4).getText());

            indiceCOList.add(indiceCO);
        }
        List<Indice> indiceList = new ArrayList<>();
        indiceList = toIndiceCoFromIndice(indiceCOList);
        for (Indice x : indiceList) {
            System.out.println(x.toString());
        }
        // Close driver
        driver.quit();
        return indiceList;

    }

    private static List<Indice> toIndiceCoFromIndice(List<IndiceCO> indiceCOList) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateAtt = dateFormat.format(date);
        List<Indice> indiceList = new ArrayList<>();
        for (IndiceCO indiceCO : indiceCOList) {
            Indice indice = new Indice();
            indice.setNome(indiceCO.getNome());
            indice.setSimbolo(indiceCO.getSimbolo());
            indice.setPreco(convertNum(indiceCO.getPreco()));
            indice.setVariacao(convertNum(indiceCO.getVariacao()));
            indice.setVariacaoRange(convertNum(indiceCO.getVariacaoRange()));
            indice.setDateAtt(dateAtt);
            indiceList.add(indice);
        }
        return indiceList;
    }

    private static float convertNum(String aux) {
        aux = aux.replace("%", "#");
        aux = aux.replace("+", "#");
        aux = aux.replace(",", "#");
        String[] a = aux.split("#");
        String b = "";
        for (String x : a) {
            b += x;
        }
        return Float.parseFloat(b);
    }
}
