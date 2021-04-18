package Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class registrationFacebookTest {

    private WebDriver getFacebookDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        return driver;
    }

    @Test
    public void fullRegistrationTest() throws InterruptedException{
        WebDriver driver = getFacebookDriver();
        Assert.assertEquals(driver.getTitle(), "Facebook - Entrar o registrarse");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        System.out.println("Titulo--> " + driver.getTitle());
        System.out.println("URL---> " +driver.getCurrentUrl());
        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.name("reg_passwd__")).sendKeys("123456789");

        WebElement diaNacimiento = driver.findElement(By.name("birthday_day"));
        Select dia = new Select(diaNacimiento);
        dia.selectByVisibleText("26");

        WebElement mesNacimiento = driver.findElement(By.name("birthday_month"));
        Select mes = new Select(mesNacimiento);
        mes.selectByVisibleText("jun");

        WebElement añoNacimiento = driver.findElement(By.name("birthday_year"));
        Select año = new Select(añoNacimiento);
        año.selectByVisibleText("1980");

        List<WebElement> listaSexos = driver.findElements(By.name("sex"));
        Assert.assertEquals(listaSexos.size(), 3);
        WebElement maleElement = listaSexos.get(1);
        maleElement.click();
    }
}
