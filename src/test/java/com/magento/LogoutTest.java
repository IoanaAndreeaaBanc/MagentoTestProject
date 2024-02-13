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

        //6. Se verifica daca userul este logat
        System.out.println("Se verifica ca userul s-a logat cu succes");
        String welcomeMessage ="Welcome, test magento!";
        WebElement welcomeMessageArea = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
        sleep(2000);

        Assert.assertTrue(welcomeMessageArea.isDisplayed());
        Assert.assertEquals(welcomeMessage, welcomeMessageArea.getText());


        //7. Se selecteaza din header meniul userului
        System.out.println("Se selecteaza din header meniul userului");
        WebElement userMenuButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span"));
        userMenuButton.click();
        sleep(3000);

        //8. Se selecteaza butonul de sign out
        System.out.println("Se selecteaza butonul de sign out");
        WebElement signOutButton = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
        signOutButton.click();
        sleep(3000);

       //10.Se verifica ca mesajul "You are signed out" este afisat
        WebElement succesMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));
        String succesMessageContent = "You are signed out";
        Assert.assertTrue(succesMessage.getText().contains(succesMessageContent));
        Assert.assertEquals(succesMessage.getText(),succesMessageContent);



    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        //Inchide pagina

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
