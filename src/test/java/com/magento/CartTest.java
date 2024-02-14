package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTest {
    WebDriver driver;

    String url = "https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html";

    @BeforeTest
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void cartTest(){

        System.out.println("Deschide pagina https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html");
        sleep(2000);


        System.out.println("Se selecteaza primul produsul Olivia 1/4 Zip Light Jacket din lista");
        WebElement selectedItem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/a/span/span/img"));
        selectedItem.click();
        sleep(2000);

        System.out.println("Click pe marimea M");
        WebElement sizeButton = driver.findElement(By.id("option-label-size-143-item-168"));
        sizeButton.click();
        sleep(3000);


        System.out.println("Click pe culoarea dorita");
        WebElement colorButton = driver.findElement(By.id("option-label-color-93-item-50"));
        colorButton.click();
        sleep(2000);



        System.out.println("Click pe butonul Add to cart");
        WebElement addToCartButton  = driver.findElement(By.id("product-addtocart-button"));
        addToCartButton.click();
        sleep(4000);

        System.out.println("Click pe pictograma cosului de cumparaturi de langa campul de cautare");
        WebElement cart = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
        cart.click();
        sleep(2000);


        System.out.println("Verificam daca  produsul selectat 'Olivia 1/4 Zip Light Jacket' exista in cos");
        WebElement cartItem = driver.findElement(By.xpath("//*[@id=\"mini-cart\"]/li/div/div/strong/a"));
        Assert.assertEquals(cartItem.getText(),"Olivia 1/4 Zip Light Jacket");
    }

    @AfterTest()
    public void tearDown(){
        System.out.println(" Inchide pagina");
    }

    public static void sleep(int miliseconds) {

        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }


}
