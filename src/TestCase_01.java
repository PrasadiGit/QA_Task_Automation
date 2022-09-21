import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_01 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Chrome web driver adding
		System.setProperty("webdriver.chrome.driver", "/Users/appleuser/eclipse-workspace/TASK_1/TestCase_1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.worldairfares.com");
		
		//testing round trip search functionality without direct flight check box
		
		WebElement radio1 = driver.findElement(By.id("RoundTrip"));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//radio1.click();
		//System.out.println(radio1.isSelected());
		
		// departing From
		driver.findElement(By.xpath("//ng-select[@placeholder= \"Departing From\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement from = driver.findElement(By.xpath("//input[@placeholder = \"Please Search\"]"));
		from.sendKeys("CMB");
		
		Thread.sleep(2000);
		
		from.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id=\"aafae611920d-0\"]")).sendKeys(Keys.ENTER);
		
		//Going To
		
		driver.findElement(By.xpath("//ng-select[@placeholder = \"Going To\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement to = driver.findElement(By.xpath("//input[@placeholder= \"Please Search\"]"));
		to.sendKeys("SIN");
		
		Thread.sleep(2000);
		
		to.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		//Departing
		
		driver.findElement(By.xpath("//input[@placeholder = \"Departing\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		String month = "Sep 2022";
		
		while(true) {
			String text = driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[2]/div/form/div[2]/div/div[1]/div[1]/div/app-datepicker-range/div/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[2]")).getText();
			if(text.equals(month)) {
				break;
			} 
			else {
				driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[2]/div/form/div[2]/div/div[1]/div[1]/div/app-datepicker-range/div/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[6]/button")).click();
			}
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()= 28 ]")).click();	
		
		Thread.sleep(2000);
		//System.out.println("done");
		
		// Returning
		
		driver.findElement(By.xpath("//input[@placeholder = \"Returning\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder = \"Returning\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		String Rmonth = "Nov 2022";
		
		while(true) {
			String Rtext = driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[2]/div/form/div[2]/div/div[1]/div[1]/div/app-datepicker-range/div/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[5]")).getText();
			if(Rtext.equals(Rmonth)) {
				break;
			} 
			else {
				driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[2]/div/form/div[2]/div/div[1]/div[1]/div/app-datepicker-range/div/div[1]/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[6]/button")).click();
			}
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[2]/div/form/div[2]/div/div[1]/div[1]/div/app-datepicker-range/div/div[1]/div/ngb-datepicker/div[2]/div[2]/ngb-datepicker-month/div[3]/div[6]/span")).click();
		
		Thread.sleep(2000);
		
		WebElement search = driver.findElement(By.id("FSearchBtn"));
		search.submit();
	}
	

}
