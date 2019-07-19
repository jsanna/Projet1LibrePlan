package Autom.LibrePlan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Outil {
	
	public static WebDriver choisirUnNavigateur(String browser) {
		
		WebDriver driver;

		switch(browser) {

			case "chrome" : // Navigateur = Chrome
				System.setProperty("webdriver.chrome.driver",  "src/main/resources/driver/chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("Choix navigateur : Chrome");
				break;
		
			case "ie" : // Navigateur = IE
				System.setProperty("webdriver.ie.driver",  "src/main/resources/driver/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				System.out.println("Choix navigateur : InternetExplorer");
				break;
			
			default : // Navigateur par défaut = Firefox
				System.setProperty("webdriver.gecko.driver",  "src/main/resources/driver/geckodriver.exe");
				driver = new FirefoxDriver();
				System.out.println("Choix navigateur par défaut : Firefox");
				break;
		}
		return driver;
	}

	public static void renseignerChamp(WebElement we, String message) {
		we.clear();
		we.sendKeys(message);
	}
	
	public static void verificationTextWebElement(String expected, WebElement we) {
		try {
			assertEquals(expected, we.getText());
		}
		catch(Error e) {
			System.out.println("[FAIL] verifTextWebElement\nexpected = " +  expected + "\n real = " + we.getText());
			throw e;
		}
	}
	
	public static void verificationWebElementPresence(WebElement we) {
		try {
			assertTrue(we.isDisplayed());
		}
		catch(Error e) {
			System.out.println("[FAIL] element is not displayed");
			throw e;
		}
	}
	
	public static void verificationOngletAffiche(WebElement we, String attribute_name, String attribute) {
	assertEquals(we.getAttribute(attribute_name), attribute);
	}
	
	public void SelectOptionFromMenu (WebElement we, String option) {
		Select select = new Select(we);
		select.selectByValue(option);
	}
	
}
