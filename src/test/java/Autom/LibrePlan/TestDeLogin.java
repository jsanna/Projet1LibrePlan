package Autom.LibrePlan;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class TestDeLogin {
	WebDriver driver;

	String ie = "ie";
	String ff = "firefox";
	String c = "chrome";

	String url = "http://localhost:8090/libreplan/common/layout/login.zul";

	@Before
	public void CreerLeWait() throws Exception {

		driver = Outil.choisirUnNavigateur(c);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	//@After
	public void TearDown() throws Exception {
		driver.close();
	
	}
	@Test
	public void allerSurIndex ()
	{
		driver.get(url);
		PageLogin page_index = PageFactory.initElements(driver, PageLogin.class);
		page_index.login(driver);
	}

}
