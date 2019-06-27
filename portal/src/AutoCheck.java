import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AutoCheck {

    public static void main(String[] args) throws InterruptedException, IOException {
// Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.get("https://portal.aait.edu.et");
        driver.findElement(By.id("UserName")).sendKeys("ATR/9805/09");
        driver.findElement(By.id("Password")).sendKeys("1111"); //password changed
        driver.findElement(By.className("btn-success")).click();
        Thread.sleep(5000);

        WebElement grade = driver.findElement(By.id("ml2"));
        System.out.println("ml2 found");
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(grade));
        grade.click();

        List<WebElement> grades = driver.findElements(By.xpath("//table[@class=\"table table-bordered table-striped table-hover\"]"));
        var writer=new FileWriter("gradeReport.txt");
        for( WebElement wl: grades){
            writer.write(wl.getText()+"\n");
        }
        writer.close();
        Thread.sleep(5000);
        driver.quit();
    }
}









