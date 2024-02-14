package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoutTest {
    WebDriver driver;
    String username = "test_magento@gmail.com";
    String password = "selenium@123";

    String url = "https://magento.softwaretestingboard.com/";

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void logoutTest(){
        Helper.login(username,password,driver);

        System.out.println("Se verifica ca userul s-a logat cu succes");
        WebElement welcomeMessageArea = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
        sleep(2000);
        Assert.assertTrue(welcomeMessageArea.isDisplayed());

        System.out.println("Click pe sageata din header");
        WebElement userMenuButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span"));
        userMenuButton.click();
        sleep(3000);

        System.out.println("Click pe butonul de Sign Out");
        WebElement signOutButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
        signOutButton.click();
        sleep(3000);

        System.out.println("Se verifica ca mesajul 'You are signed out' este afisat");
        WebElement successMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
        String successMessageContent = "You are signed out";
        Assert.assertEquals(successMessage.getText(),successMessageContent);
    }

    @AfterTest
    public void tearDown(){

        System.out.println(" Inchide pagina");
        driver.close();
    }

    public static void sleep(int miliseconds) {

        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}
