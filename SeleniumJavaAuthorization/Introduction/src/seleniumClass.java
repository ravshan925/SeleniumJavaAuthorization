import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class seleniumClass {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/ravshan/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//maximize web page window
		driver.manage().window().maximize();

		// -------- wait globally after each command !!!!!!!!!!!!!!
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		//get TItle of Web Page	
		System.out.println("Title of Web Page: " + driver.getTitle());
		//get URL of Web Page
		System.out.println("URL of Web Page: " + driver.getCurrentUrl());

		//find login input and set value  
		driver.findElement(By.id("inputUsername")).sendKeys("defect");
		//find password input and set value 
		driver.findElement(By.name("inputPassword")).sendKeys("Password");
		
		//Checkboxes
		//checkboxOne ("Remember my username")
		driver.findElement(By.id("chkboxOne")).click();
		//checkboxTwo ("I agree to the terms and privacy policy")
		driver.findElement(By.id("chkboxTwo")).click();

		//Sign in
		//
		driver.findElement(By.className("signInBtn")).click();

		//display error title in console
		String pError = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println("Error Text: " + pError);
		//click "Forgot your password?" button
		driver.findElement(By.linkText("Forgot your password?")).click();

		// Wait 1s for opening Reset login page 1 second
		Thread.sleep(1000); 
		//set name 
		driver.findElement(By.xpath("//input[@placeholder = 'Name']")).sendKeys("John");
		//set email 
		driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("john@email.com");
		//send Phone Number Key in input
		driver.findElement(By.xpath("//input[@placeholder = 'Phone Number']")).sendKeys("+1 123 456 789");
		//click reset button
		driver.findElement(By.className("forgot-pwd-btn-conainer")).findElement(By.className("reset-pwd-btn")).click();
		//Set text as a string and print it
		String temporaryPassword = driver.findElement(By.className("infoMsg")).getText();
		System.out.println("Get Password: "  + temporaryPassword);
		//Click go to Login Page
		driver.findElement(By.className("go-to-login-btn")).click();
		//find login input and set value  
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("ravshan123");
		//find password input and set value 
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		// Wait 1s for opening reset login page 1 secund = 1000
		Thread.sleep(1000);
		//Sign in
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		//display "Successfully login" text on console
		String text = driver.findElement(By.xpath("//p[contains(text(),'You are successfully logged in')]")).getText();
		System.out.println("Text: " + text);
		//
		String tagh2 = driver.findElement(By.tagName("h2")).getText();
		System.out.println("Tag Title: " + tagh2);
		//
		String tagh1 = driver.findElement(By.tagName("h1")).getText();
		System.out.println("Tag Welcome Title: " + tagh1);
		//
		//wait 5 second
		Thread.sleep(5000);
		//click Logout Button
		driver.findElement(By.className("logout-btn")).click();
		//
		//wait 5 second
		Thread.sleep(5000);
		//close driver
		driver.close();
		
	}
}