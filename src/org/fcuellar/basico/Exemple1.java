package org.fcuellar.basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exemple1 {
    public static void main(String[] args){
        //Instancia un objeto webDriver
        WebDriver driver;

        //Declarar Variables
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectedResult = "Welcome: Mercury Tours";

        //indicar la localizacion del archivo chromedriver.exe en la propiedad webdriver.chorme.driver
        //System.getProperty("user.dir") = C:\..\..\..\SeleniumBasic
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        //Abrir el navegador Chrome
        driver = new ChromeDriver();

        //Navegar en la pagina
        driver.get(baseURL);

        //Obtener titulo de la pagina
        actualResult = driver.getTitle();

        //imprimir el resultado usando el operador ternario
        System.out.println(actualResult.contentEquals(expectedResult)?"Prueba Pasada! " + actualResult : "Prueba Fallida!" + expectedResult);

        driver.close();



    }
}
