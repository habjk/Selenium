import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Autotest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
// Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "C:\\Gecko\\geckodriver.exe");
        WebDriver driver;
        driver = new FirefoxDriver();
//Launch the some site
       // driver.get("https://portal.aait.edu.et/");
        driver.manage().window().maximize();
        String url = "https://accounts.google.com/signin";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
        email_phone.sendKeys("habibjmk@gmail.com");
        driver.findElement(By.id("identifierNext")).click();
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("12345678");//password changed
        Thread.sleep(1000);
        driver.findElement(By.className("CwaK9")).click();


        Thread.sleep(1000);
        List<WebElement> unread = driver.findElements(By.xpath("//*[@class='zA zE']"));
        System.out.println(unread.size() + " Unread Messages");
        var writer=new FileWriter("NewMessages.txt");
        writer.write("Sir you have "+unread.size()+"new messages.\n");
        for (WebElement message: unread ) {
            writer.write(message.getText()+"\n");
        }
        writer.close();
        driver.quit();
    }
}
//news site web scrapper















