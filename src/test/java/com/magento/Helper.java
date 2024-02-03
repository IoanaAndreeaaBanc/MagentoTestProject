package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    public static void login(String username, String password, WebDriver driver)
    {
        //1.Deschide pagina principala
        System.out.println("Deschide pagina prinicipala");
        System.out.println("Asteapta 2 secunde");
        sleep(2000);

        //2.Navigheaza la pagina de login
        System.out.println("Navigheaza la pagina de login");
        WebElement signInButtonLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        signInButtonLink.click();
        sleep(2000);

        //3.Se selecteaza si se introduce usernameul
        System.out.println("Se introduce username");
        WebElement usernameInput = driver.findElement(By.id("email"));
        usernameInput.sendKeys(username);
        sleep(2000);

        //4. Se selecteza si se introduce parola
        System.out.println("Se introduce parola");
        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys(password);
        sleep(2000);

        //5. Se selecteaza butonul de login
        System.out.println("Se apasa butonul de login");
        WebElement loginButton = driver.findElement(By.id("send2"));
        loginButton.click();
        sleep(2000);

    }

    public static void sleep(int miliseconds) {

        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }
}
