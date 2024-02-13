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
        // 1. Deschidem pagina principa
        System.out.println("Deschide pagina principala");
        sleep(2000);

        //2. Se selecteaza primul produs din lista
        System.out.println("Se selecteaza primul produs din lista");

        WebElement firstListItem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/a/span/span/img"));
        firstListItem.click();
        sleep(2000);

        //3. Se selecteaza marimea M
        System.out.println("Se selecteaza marimea M");

        WebElement sizeButton = driver.findElement(By.id("option-label-size-143-item-168"));
        sizeButton.click();
        sleep(3000);


        //4. Se selecteaza culoarea dorita
        System.out.println("Se selecteaza culoarea dorita");

        WebElement colorButton = driver.findElement(By.id("option-label-color-93-item-50"));
        colorButton.click();
        sleep(2000);

        //5. Se selecteaza cantitatea dorita
        System.out.println("Se selecteaza cantitatea dorita");

        WebElement quantityTextBox = driver.findElement(By.id("qty"));
        quantityTextBox.clear();
        String quantity = "2";
        quantityTextBox.sendKeys(quantity);
        sleep(3000);

        //6. Se selecteaza butonul Add to cart
        System.out.println("Se selecteaza butonul Add to cart");

        WebElement addToCartButton  = driver.findElement(By.id("product-addtocart-button"));
        addToCartButton.click();
        sleep(4000);

        //7. Se verifica continutul cosului de cumoaraturi
        System.out.println("Verifica continutul cosului de cumaparaturi");

        WebElement cartNumber = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]"));
        Assert.assertEquals(cartNumber.getText(), quantity);

        WebElement cart = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
        cart.click();
        sleep(2000);

        WebElement cartQuantityTextBox = driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[1]/span[1]"));
        Assert.assertEquals(cartQuantityTextBox.getText(),quantity);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        //Inchide pagina

        System.out.println(" Inchide pagina");
       // driver.close();
    }

    public static void sleep(int miliseconds) {

        try {
            Thread.sleep((miliseconds));
        } catch (InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }


}
