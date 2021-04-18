import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio1 {

    @Test
    public void netflixPageTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.netflix.com/uy/");

        System.out.println("--->Titulos con etiqueta h1<---");
        List<WebElement> listaH1s = driver.findElements(By.tagName("h1"));
        System.out.println("La cantidad de h1s es: " + listaH1s.size());
        for (WebElement h1: listaH1s){
            System.out.println("h1: " + h1.getText());
        }

        System.out.println("--->Titulos con etiqueta h2<---");
        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));
        System.out.println("La cantidad de h2s es: " + listaH2s.size());
        for (WebElement h2: listaH2s){
            System.out.println("h2: " + h2.getText());
        }

        driver.navigate().refresh();

        System.out.println("--->Botones de la pagina<---");
        List<WebElement> listaBotones = driver.findElements(By.tagName("button"));
        System.out.println("La cantidad de botones es: " + listaBotones.size());
        for (WebElement botonesHome: listaBotones){
            System.out.println("El texto del boton es: " + botonesHome.getText());
        }

        System.out.println("--->Divs de la pagina<---");
        List<WebElement> listaDivs = driver.findElements(By.name("div"));
        System.out.println("La cantidad de divs es: " + listaDivs.size());

        System.out.println("--->Titulo de la Pagina<---");
        System.out.println("El titulo de la pagina es: " + driver.getTitle());

        System.out.println("--->Links de la pagina<---");
        List<WebElement> listaLinks = driver.findElements(By.name("a"));
        System.out.println("La cantidad de links es: " + listaLinks.size());
    }
}
