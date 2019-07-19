package Autom.LibrePlan;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class TestAbstract {
	
	WebDriver driver;
	PageIndex page_index;
	

	String ie = "ie";
	String ff = "firefox";
	String c = "chrome";

	String url = "http://localhost:8090/libreplan/common/layout/login.zul";

//	@Before
//	public void CreerLeWait() throws Exception {
//
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		
//	}
	public TestAbstract ()
	{
		driver = Outil.choisirUnNavigateur(c);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageLogin page_login = PageFactory.initElements(driver, PageLogin.class);
		page_login.login(driver);
			
	}	

	
}
