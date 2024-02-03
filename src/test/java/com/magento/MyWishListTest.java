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

            //1.Deschide pagina principala
            //2.Navigheaza la pagina de login
            //4. Se selecteza si se introduce parola
            //3.Se selecteaza si se introduce usernameul
            //5. Se selecteaza butonul de login
            Helper.login(username,password,driver);
            sleep(3000);

            //6.Selectam optiunea Sale din bara de navigare
            System.out.println("Selectam optiunea Sale din bara de navigare");
            WebElement saleButton = driver.findElement(By.id("ui-id-8"));
            saleButton.click();

            //7. Selectam optiunea Jackets din meniul WOMEN'S DEALS
            System.out.println("Selectam optiunea Jackets din meniul WOMEN'S DEALS");
            WebElement jacketsButton = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[2]/a"));
            jacketsButton.click();

            //8. Se selecteaza primul produs din lista
            System.out.println("Se selecteaza primul produs din lista");

            WebElement firstListItem = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[1]/div/a/span/span/img"));
            firstListItem.click();
            sleep(3000);

            WebElement firstListItemName = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[1]/h1/span"));

            String itemName = firstListItemName.getText();


            //9. Se adauga produsul la WishList
            System.out.println("Se adauga produsul la WishList");

            WebElement addToWishListButton = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[2]/div[5]/div/a[1]"));
            addToWishListButton.click();
            sleep(3000);

            //10. Se verifica, ca elementul selectat este adaugat la WishList
            System.out.println("Se verifica, ca elementul selectat este adaugat la WishList");

            WebElement wishListItem = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[1]/ol/li/div/strong/a"));

            Assert.assertEquals(itemName, wishListItem.getText());

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
