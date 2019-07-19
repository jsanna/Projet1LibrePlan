package Autom.LibrePlan;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ClassTestMaude extends TestAbstract{
	
	@Test
	public void Gre01() throws InterruptedException{
	// ACTION Connexion
	PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
	
	// VERIFICATION onglet calendrier présent
	assertEquals("Calendrier ", driver.findElement(By.xpath("//td/div/button[substring(@id,5)='7-b']")).getText());
	
	// ACTION Direction vers page Participants	
	page_index.clickMenu(driver, "Ressources", "Participants");
	
	// VERIFICATION page Participants
	assertEquals("LibrePlan: Participants", driver.getTitle());
		//verif tableau à faire
	assertTrue(driver.findElement(By.xpath("//input[substring(@id,4)='Qq4-real']")).isDisplayed());
	}
}
