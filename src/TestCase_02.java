import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Chrome web driver adding
		System.setProperty("webdriver.chrome.driver", "/Users/appleuser/eclipse-workspace/TASK_1/TestCase_1/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.worldairfares.com");
		
		//testing round trip search functionality without direct flight check box
		
		WebElement radio2 = driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[1]/div/div[1]/div[2]"));
		
		
		Thread.sleep(2000);
		
		radio2.click();
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
		
		driver.findElement(By.xpath("//input[@placeholder = \"Departing On\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		
		String month = "September 2022";
		
		while(true) {
			String text = driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[2]/div/form/div[2]/div/div[1]/div[2]/div/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[2]")).getText();
			if(text.equals(month)) {
				break;
			} 
			else {
				driver.findElement(By.xpath("//*[@id=\"ngb-nav-0-panel\"]/div[2]/div/form/div[2]/div/div[1]/div[2]/div/div/ngb-datepicker/div[1]/ngb-datepicker-navigation/div[3]/button")).click();
			}
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()= 22 ]")).click();	
		
		Thread.sleep(2000);
		//System.out.println("done");
		
		
		//Searching
		WebElement search = driver.findElement(By.id("FSearchBtn"));
		search.submit();
	}
	

}

