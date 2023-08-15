package newsel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Greenkart001 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  ChromeDriver driver= new ChromeDriver();
  driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  //Adding cucumber to the cart and taking screenshots
  driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/div[2]/form/input")).sendKeys("Cucumber");

 
  WebElement cart=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[3]/button"));
 //taking element screenshot
  
      try {
  File source=cart.getScreenshotAs(OutputType.FILE);  
  FileUtils.copyFile(source, new File("./screenshot/cart.jpg"));
      }
      catch(IOException e) {
          e.printStackTrace();
         }
	
 		//taking page creenshot
      
      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[3]/button")).click();
      try
      {

       File pageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      		FileUtils.copyFile(pageScreenshot, new File("./screenshot/cartadded.jpg"));
      				
      }


            catch(IOException e) {
                e.printStackTrace();
               }
      
           driver.findElement(By.xpath("//img[@alt='Cart']")).click();
           driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();
           WebElement country= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select"));
           Select choose= new Select(country);
           choose.selectByVisibleText("Albania");
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/input")).click();
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();
           
	}
	
	
}
           
