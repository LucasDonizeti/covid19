package com.ldon.covid19.service.news;

import com.ldon.covid19.model.Notice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author LucasDonizeti
 */
public class GetNewsFromNbc {
    public static List<Notice> getNoticeFromNbc() {
        String url = "https://www.nbcnews.com/health/coronavirus";
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/ldon/covid19/service/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement table = driver.findElement(By.className("articlesWrapper___2IhQz")).findElement(By.tagName("ul"));

        List<WebElement> mainVersions = table.findElements(By.tagName("li"));
        System.out.println(mainVersions);
        List<Notice> noticias = new ArrayList<>();
        for (WebElement mver : mainVersions) {
            try {
                Notice n = new Notice();
                WebElement noticia = mver.findElement(By.tagName("div"));
                String timestamp = noticia.findElement(By.tagName("div")).getText();
                WebElement conteudo = noticia.findElement(By.tagName("h2")).findElement(By.tagName("a"));
                String link = conteudo.getAttribute("href");
                String titulo = conteudo.getText();
                if (!link.isEmpty() && !titulo.isEmpty() && !timestamp.isEmpty()) {
                    n.setLink(link);
                    n.setTitulo(titulo);
                    n.setTimestamp(noticeTimeConvert(timestamp));
                    noticias.add(n);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        driver.quit();
        for (Notice n : noticias) {
            System.out.println("titulo: " + n.getTitulo());
            System.out.println("data: " + n.getTimestamp());
            System.out.println("link: " + n.getLink());
        }
        return noticias;
    }

    private static Date noticeTimeConvert(String timestamp) {
        timestamp = timestamp.replace("ago", "");
        String tempo = timestamp.replaceAll("[^0-9]", "");
        timestamp = timestamp.replaceAll(tempo, "");
        GregorianCalendar c = new GregorianCalendar();
        if (timestamp.compareTo("d") == 1)
            c.add(Calendar.DAY_OF_MONTH, -Integer.parseInt(tempo));
        return c.getTime();
    }
}
