package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

    public static void login(String username, String password, WebDriver driver)
    {
        System.out.println("Deschide pagina https://magento.softwaretestingboard.com/");
        sleep(2000);

        System.out.println("Click pe Sign In din header");
        WebElement signInButtonLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a"));
        signInButtonLink.click();
        sleep(2000);

        System.out.println("Completeaza campul email");
        WebElement usernameInput = driver.findElement(By.id("email"));
        usernameInput.sendKeys(username);
        sleep(2000);

        System.out.println("Completeaza campul password");
        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys(password);
        sleep(2000);

        System.out.println("Clik pe butonul Sign In de la formular");
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
