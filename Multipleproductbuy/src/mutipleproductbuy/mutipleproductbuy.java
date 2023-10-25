package mutipleproductbuy;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;
//import fileHandle.ExcelDataConfig;


public class mutipleproductbuy {
	
	
	@Test(dataProvider = "Signin data")
	    public void websiteSignin(String email,String password) throws InterruptedException  {
		System.setProperty("webdriver.chrome.driver", "F:\\chrome driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://artemis-web.mymapanalytics.com/product/productList");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("cookies_btn")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div[3]/a")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div[3]/ul/li[1]/a/i")).click();
		Thread.sleep(5000);
		System.out.println("Sign IN page open");
		driver.findElement(By.id("txtEmail")).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id("txtpassword")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id("btn_signin")).click();
		
		Thread.sleep(8000);
		
         String URL="https://artemis-web.mymapanalytics.com/home/dashboard";
		
		driver.getCurrentUrl();
		if(driver.getCurrentUrl().equals(URL))
		  {
			
			Thread.sleep(2000);
			
			driver.navigate().to("https://artemis-web.mymapanalytics.com/product/productList");
			//driver.findElement(By.xpath("/html/body/main/header/div/div/div/div/div/nav/div/div/ul/li[9]/a")).click();
			Thread.sleep(8000);

			WebElement ele=driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div[2]/div/div[1]/a"));
			JavascriptExecutor js= (JavascriptExecutor) driver ;
			js.executeScript("arguments[0]. scrollIntoView(true);", ele);

			Thread.sleep(10000);

			driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div[3]/div/div[2]/button")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div[2]")).click();
			Thread.sleep(5000);

			WebElement ele1=driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div/div[2]/div[2]/div/ul"));
			JavascriptExecutor js1= (JavascriptExecutor) driver ;
			js1.executeScript("arguments[0]. scrollIntoView(true);", ele1);

			Thread.sleep(1000);

			driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div/div[2]/div[2]/div/div[1]/a")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[2]/div[1]/div/div/form/fieldset[1]/div[2]/div[1]/div/div")).click();

			Thread.sleep(5000);


			WebElement ele2=driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[2]/div[1]/div/div/form/fieldset[2]/div[2]"));
			JavascriptExecutor js2= (JavascriptExecutor) driver ;
			js2.executeScript("arguments[0]. scrollIntoView(true);", ele2);

			Thread.sleep(2000);

			driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[2]/div[1]/div/div/form/fieldset[2]/div[2]/div[1]/label/div[1]")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[2]/div[1]/div/div/form/fieldset[2]/button[1]")).click();

			Thread.sleep(2000);
			
			
			System.out.println("Go to payment page");

			WebElement ele3=driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[2]/div[1]/div/div/form/fieldset[3]/div[4]/h4"));
			JavascriptExecutor js3= (JavascriptExecutor) driver ;
			js3.executeScript("arguments[0]. scrollIntoView(true);", ele3);

			Thread.sleep(2000);

			driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[2]/div[1]/div/div/form/fieldset[3]/div[4]/div/div[2]")).click();

			Thread.sleep(2000);

			System.out.println("Card details entered");

			driver.findElement(By.id("username1")).sendKeys("John smith");

	        Thread.sleep(1000);

			//driver.findElement(By.xpath("//*[@class='card-info']/div[4]/div/div/div/iframe")).sendKeys("4242424242424242","04/24","242","42424");

			driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[2]/div[1]/div/div/form/fieldset[3]/div[5]/div[4]/div/div/div/iframe")).sendKeys("4242424242424242","04/24","242","42424");

			Thread.sleep(2000);

			driver.findElement(By.id("btn_next3")).click();

			Thread.sleep(20000);
			
			driver.findElement(By.xpath("/html/body/main/header/div/div/div/div/div/nav/div/div/div[1]/div/ul/div/li")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btn_logout\"]")).click();
			Thread.sleep(1000);
	        }
		else
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html/body/div[6]/div/div[6]/button[1]")).click();
            Thread.sleep(3000);
			
		}
		
		Thread.sleep(6000);
		driver.close();
		
		
		
	}	

	 @DataProvider(name="Signin data")
	public Object[][] passData() throws FileNotFoundException 
	{
		
		ExcelDataConfig config= new ExcelDataConfig("C:\\Users\\admin\\eclipse-workspace\\Multipleproductbuy\\testdata\\test data.xlsx");
		int rows=config.getRowCount(0);
		Object[][] data= new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0]=config.getData(0, i, 0);
			data[i][1]=config.getData(0, i, 1);
		}
		
		
		
		return data;
	}
	
}
