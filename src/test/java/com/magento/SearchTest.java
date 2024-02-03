package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Locale;

public class SearchTest {
    WebDriver driver;

    String url = "https://magento.softwaretestingboard.com/";

    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void searchTest()
    {
        String searchTerm = "maya";

        //1. Deschide pagina
        System.out.println("Deschide pagina");

        //2. Selectem casuta de cautare si introducem cuvantul dupa care vrem sa facem cautarea
        System.out.println("Selectem casuta de cautare si introducem cuvantul dupa care vrem sa facem cautarea");

        WebElement searchTextbox = driver.findElement(By.id("search"));
        searchTextbox.sendKeys(searchTerm);

        //3. Executam cautarea
        System.out.println("Executam cautarea");
        searchTextbox.submit();

        //4. Verificam ca denumirea produsului returnat contine cuvantul dupa care s-a facut cautarea
        System.out.println("Verificam ca denumirea produsului returnat contine cuvantul dupa care s-a facut cautarea");

        WebElement listItem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li/div/div/strong/a"));
        Assert.assertTrue(listItem.getText().toLowerCase().contains(searchTerm));

        //5. Verificam ca elementul web care afiseaza termenii dupa care s-a facut cautarea contin cuvantul cautat
        System.out.println("Verificam ca elementul web care afiseaza termenii dupa care s-a facut cautarea contin cuvantul cautat");

        WebElement relatedSearchTerms = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/dl/dd/a"));
        Assert.assertTrue(relatedSearchTerms.getText().toLowerCase().contains(searchTerm));
    }


    @AfterTest(alwaysRun = true)
    public void tearDown()
    {
        System.out.println(" Inchide pagina");
        driver.close();
    }

    public static void sleep(int miliseconds)
    {
        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

}
