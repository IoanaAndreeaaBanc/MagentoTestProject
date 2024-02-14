package com.magento;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyWishListTest {

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
        public void addToMyWishList() {

            //1.Deschide pagina https://magento.softwaretestingboard.com
            //2.Click pe Sign In din header
            //3.Completeaza campul email
            //4.Completeaza campul password
            //5.Clik pe butonul Sign In de la formular
            Helper.login(username,password,driver);
            sleep(3000);


            System.out.println("Click pe optiunea Sale din bara de navigare");
            WebElement saleButton = driver.findElement(By.id("ui-id-8"));
            saleButton.click();

            System.out.println("Click pe optiunea Jackets din meniul WOMEN'S DEALS");
            WebElement jacketsButton = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[2]/a"));
            jacketsButton.click();

            System.out.println("Click pe primul produs din lista");

            WebElement firstListItem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/a/span/span/img"));
            firstListItem.click();
            sleep(3000);
            WebElement firstListItemName = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[1]/h1/span"));
            String itemName = firstListItemName.getText();

            System.out.println("Click pe butonul Add to wish list");
            WebElement addToWishListButton = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]"));
            addToWishListButton.click();
            sleep(3000);

            System.out.println("Se verifica, ca elementul selectat este adaugat la WishList");
            WebElement wishListItem = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[1]/ol/li/div/strong/a"));
            Assert.assertEquals(itemName, wishListItem.getText());
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
