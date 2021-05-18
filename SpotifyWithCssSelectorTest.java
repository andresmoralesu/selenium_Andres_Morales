package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {

    private WebDriver getSpotifyDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/");
        return driver;
    }

    @Test
    public void spotifyByPlaceHolder(){
        WebDriver driver = getSpotifyDriver();
        Assert.assertEquals(driver.getTitle(), "Registrarte - Spotify");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.spotify.com/uy/signup/?sp_t_counter=1");
        System.out.println("Title--> " + driver.getTitle());
        System.out.println("URL--> " + driver.getCurrentUrl());

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@testing.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@testing.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("Pruebas2021!");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("testerman");

        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("02");
        WebElement monthElement = driver.findElement(By.cssSelector("select[name='month']"));
        Select monthSelector = new Select(monthElement);
        monthSelector.selectByValue("06");
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1990");
        driver.findElement(By.xpath("(//*[contains(text(),'Hombre')])[1]")).click();
    }
}
