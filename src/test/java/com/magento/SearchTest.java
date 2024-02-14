package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


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

        System.out.println("Deschide pagina https://magento.softwaretestingboard.com");

        System.out.println("Clik pe casuta de cautare");
        WebElement searchTextbox = driver.findElement(By.id("search"));
        searchTextbox.click();
        sleep(2000);

        System.out.println("Introducem 'maya' in casuta de cautare");
        searchTextbox.sendKeys(searchTerm);
        sleep(2000);

        System.out.println("Apasam enter");
        searchTextbox.sendKeys(Keys.ENTER);
        sleep(2000);

        System.out.println("Verificam daca rezultatele cautarii dupa 'maya' sunt afisate pe pagina");
        WebElement listItem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li/div/div/strong/a"));
        Assert.assertTrue(listItem.getText().toLowerCase().contains(searchTerm));
        sleep(2000);

    }

    @AfterTest
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
