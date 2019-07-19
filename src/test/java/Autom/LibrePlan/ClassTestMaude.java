package Autom.LibrePlan;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ClassTestMaude extends TestAbstract{
	
	@Test
	public void Gre01() throws InterruptedException{
	// ACTION Connexion
	PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
	
	// ACTION Direction vers page Participants	
	page_index.clickMenu(driver, "Ressources", "Participants");
	}
}
