package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    String username = "test_magento@gmail.com";
    String password = "selenium@123";
    String invalidPassword = "selenium@1233";

    String url = "https://magento.softwaretestingboard.com/";

    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();//face ecranul fullsize
    }

    @Test(testName = "Invalid Login test", priority = 1)
    public void invalidLogin() {

//        //1.Deschide pagina principala
//        System.out.println("Deschide pagina prinicipala");
//        System.out.println("Asteapta 2 secunde");
//        sleep(2000);
//
//        //2.Navigheaza la pagina de login
//        System.out.println("Navigheaza la pagina de login");
//        WebElement signInButtonLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
//        signInButtonLink.click();
//        sleep(2000);
//
//        //3.Se selecteaza si se introduce usernameul
//        System.out.println("Se introduce username");
//        WebElement usernameInput = driver.findElement(By.id("email"));
//        usernameInput.sendKeys(username);
//        sleep(2000);
//
//        //4. Se selecteza si se introduce parola
//        System.out.println("Se introduce parola");
//        WebElement passwordInput = driver.findElement(By.id("pass"));
//        passwordInput.sendKeys(invalidPassword);
//        sleep(2000);
//
//        //5. Se selecteaza butonul de login
//        System.out.println("Se apasa butonul de login");
//        WebElement loginButton = driver.findElement(By.id("send2"));
//        loginButton.click();
//        sleep(2000);

        Helper.login(username,invalidPassword,driver);

        //6. Se verifica ca userul nu este logat
        System.out.println("Se verifica ca mesajul de eroare apare");
        String errorMessage ="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        WebElement errorMessageArea = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
        Assert.assertTrue(errorMessageArea.isDisplayed());
        Assert.assertEquals(errorMessage, errorMessageArea.getText());
        sleep(2000);
    }

    @Test(testName = "Login test", priority = 2)
    public void validLogin() {

//        //1.Deschide pagina principala
//        System.out.println("Deschide pagina prinicipala");
//        System.out.println("Asteapta 2 secunde");
//        sleep(2000);
//
//        //2.Navigheaza la pagina de login
//        System.out.println("Navigheaza la pagina de login");
//        WebElement signInButtonLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
//        signInButtonLink.click();
//        sleep(2000);
//
//        //3.Se selecteaza si se introduce usernameul
//        System.out.println("Se introduce username");
//        WebElement usernameInput = driver.findElement(By.id("email"));
//        usernameInput.sendKeys(username);
//        sleep(2000);
//
//        //4. Se selecteza si se introduce parola
//        System.out.println("Se introduce parola");
//        WebElement passwordInput = driver.findElement(By.id("pass"));
//        passwordInput.sendKeys(password);
//        sleep(2000);
//
//        //5. Se selecteaza butonul de login
//        System.out.println("Se apasa butonul de login");
//        WebElement loginButton = driver.findElement(By.id("send2"));
//        loginButton.click();
//        sleep(2000);

        Helper.login(username,password,driver);

        //6. Se verifica daca userul este logat
        System.out.println("Se verifica ca userul s-a logat cu succes");
        String welcomeMessage ="Welcome, test magento!";
        WebElement welcomeMessageArea = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"));
        sleep(2000);

        Assert.assertTrue(welcomeMessageArea.isDisplayed());
        Assert.assertEquals(welcomeMessage, welcomeMessageArea.getText());
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
