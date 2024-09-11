package GERMANY_LOGINPAGE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import junit.framework.Assert;

public class Login_page {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("WebDriver.chrome.driver", "E:\\Java class\\chromedriver-win64\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://app.germanyiscalling.com/common/login/");
		driver.manage().window().maximize();
	}

	@Test(priority=5)
	public void login_with_valid_id_pass() throws InterruptedException
	{
		driver.get("https://app.germanyiscalling.com/common/login/");
		// Locate email field and enter email 
		driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("abhinavjangde97@gmail.com");

		Thread.sleep(3000);
		// Locate password field and enter password
		driver.findElement(By.cssSelector("input[type='password']")).click();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Abhinavjangde@!");
		Thread.sleep(3000);
		//click on login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		//Verify if login was successful by checking the page title
		String message_expected ="Upload your CV, and we'll analyze it to provide a report on your profile's strength and insights into the German job market. Get started now";		 
		String message_actual = driver.findElement(By.xpath("//p[@id='card_text']")).getText();
		Assert.assertTrue(message_actual.contains(message_expected));
		Thread.sleep(3000);
		
	}

	@Test(priority=3)
	public void Login_with_Vailiduser_invailid_password() throws InterruptedException
	{
		driver.get("https://app.germanyiscalling.com/common/login/");

		// Locate and enter valid email 
		driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("abhijangde97@gmail.com");

		Thread.sleep(3000);

		// Locate and enter invalid password
		driver.findElement(By.cssSelector("input[type='password']")).click();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Abhinav@199");

		Thread.sleep(3000);
		//click on login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		//Verify if login was unsuccessful by checking the page title

		String message_expected ="Please enter a correct username and password. Note that both fields may be case-sensitive.";		 
		String message_actual = driver.findElement(By.xpath("//li[contains(text(),'Please enter a correct username and password. Note')]")).getText();
		Assert.assertTrue(message_actual.contains(message_expected));

		Thread.sleep(3000);

	}
	@Test(priority=2)
	public void Login_with_invailiduser_validpassword() throws InterruptedException
	{
		driver.get("https://app.germanyiscalling.com/common/login/");
		// Locate and enter invalid email
		driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("abhijangde@gmail.com");

		Thread.sleep(3000);
		// Locate and enter valid password
		driver.findElement(By.cssSelector("input[type='password']")).click();
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Abhinav@1997!");

		Thread.sleep(3000);
		//click on login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		 // Verify if login failed with the correct error message
		String message_expected ="Please enter a correct username and password. Note that both fields may be case-sensitive.";		 
		String message_actual = driver.findElement(By.xpath("//li[contains(text(),'Please enter a correct username and password. Note')]")).getText();
		Assert.assertTrue(message_actual.contains(message_expected));  
		Thread.sleep(3000);

	}

	@Test(priority=1)
	public void Login_with_blanck_input() throws InterruptedException
	{
		driver.get("https://app.germanyiscalling.com/common/login/");

		// Click the login button without entering credentials

		driver.findElement(By.id("username")).click();
		//click on password field
		driver.findElement(By.cssSelector("input[type='password']")).click();

		//click on login button
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Verify error message for blank input
		String message_expected ="Email: This field is required.";
					 
		String message_actual = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[3]/ul/li[1]")).getText();
		Assert.assertTrue(message_actual.contains(message_expected));
		Thread.sleep(3000);
		
			
		}
	@Test(priority=4)
			
		public void Login_with_invaliduser_invalidpassword() throws InterruptedException
		{
			driver.get("https://app.germanyiscalling.com/common/login/");
			// Locate and enter invalid email
			driver.findElement(By.xpath("//input[@type=\"text\"]")).click();
			driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("abhijangde@gmail.com");

			Thread.sleep(3000);
			// Locate and enter invalid password
			driver.findElement(By.cssSelector("input[type='password']")).click();
			driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Abhinav@1997!");

			Thread.sleep(3000);
			//click on login button
			driver.findElement(By.cssSelector("button[type='submit']")).click();

			// Verify if login failed with the correct error message
			String message_expected ="Please enter a correct username and password. Note that both fields may be case-sensitive.";		 
			String message_actual = driver.findElement(By.xpath("//li[contains(text(),'Please enter a correct username and password. Note')]")).getText();
			Assert.assertTrue(message_actual.contains(message_expected));  
			Thread.sleep(3000);
			}
	
	@Test(priority=6)
				public void CHECk_CV_ANALYSIS() throws InterruptedException
				{
		      //click on choose file and upload resume
			
				WebElement im= driver.findElement(By.xpath("//input[@type=\"file\"]"));
				im.sendKeys("C:\\Users\\HP\\Desktop");
				
				//click on submit button
				driver.findElement(By.xpath("//button[@type=\"submit\"]"));
				
				Thread.sleep(3000);
				//LOGOUT BUTTON
				driver.findElement(By.xpath("//*[@id=\"dropdownUser1\"]/span")).click();
				Thread.sleep(3000);

				driver.findElement(By.xpath("//*[@id=\"dropdownUser1\"]/span")).click();
				Thread.sleep(3000);
				}
	@AfterClass
	public void teardown() {
		driver.quit();  

	}
}



