package org.fcuellar.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
    public static void main(String[] args) {
        //Instancia un objeto webDriver
        WebDriver driver;

        //Declarar Variables
        String baseURL = "http://live.demoguru99.com/index.php/checkout/cart/";
        String actualResult = "";
        String expectedResult = "$615.00";
        String chromepath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromepath);
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        //Click en el Link TV
        //agregar
        WebElement lnkTV = driver.findElement(By.linkText("TV"));
        lnkTV.click();

        //Click en el boton ADD To CART
        WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
        btnAddToCart.click();

        //obtener el precio
        WebElement lblSubTotal = driver.findElement(By.cssSelector("#shopping-cart-table > tbody > tr > td.product-cart-total > span > span"));
        actualResult = lblSubTotal.getText();

        if (actualResult.contentEquals(expectedResult)) {
            System.out.println("La prueba paso con éxito! es resultado actual es: " + actualResult + " es igual a " + expectedResult);
        } else {
            System.out.println("La prueba falló! :( el resultado actual es: " + actualResult + " NO es igual a " + expectedResult);
        }

        driver.close();
    }
}
