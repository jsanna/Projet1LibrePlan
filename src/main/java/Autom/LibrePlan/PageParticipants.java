package Autom.LibrePlan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageParticipants {
	@FindBy(xpath="//span[substring(@id,5)='n4']")
	private WebElement txt_filtre_par;
	
	@FindBy(xpath="//input[substring(@id,5)='q4-real']")
	private WebElement chmp_filtre_par;
	
	@FindBy(xpath="//i[substring(@id,5)='q4-btn']")
	private WebElement btn_filtre_par;
	
	@FindBy(xpath="//span[substring(@id,5)='e5']")
	private WebElement txt_details_personnels;
	
	@FindBy(xpath="//input[substring(@id,5)='f5']")
	private WebElement btn_details_personnels;
	
	@FindBy(xpath="//div[substring(@id,5)='g5']")
	private WebElement btn_plus_options;
	
	@FindBy(xpath="//span[substring(@id,5)='p5']")
	private WebElement btn_filtre;
	
	@FindBy(xpath="//table[substring(@id,5)='_6-box']")
	private WebElement btn_creer;

	public void verifPageParticipants(WebDriver driver) {
		assertEquals("LibrePlan: Participants", driver.getTitle());
			//verif tableau à faire
			// verification - champ de recherche "Filtré par"
		Outil.verificationTextWebElement("Filtré par", txt_filtre_par);
		Outil.verificationWebElementPresence(chmp_filtre_par);
		Outil.verificationWebElementPresence(btn_filtre_par);
			// verification - champ de recherche "Détail personnel"
		Outil.verificationTextWebElement("Détails personnels", txt_details_personnels);
		Outil.verificationWebElementPresence(btn_details_personnels);
			// verification - bouton plus d'option
		Outil.verificationWebElementPresence(btn_plus_options);
			// verification - bouton filtre
		Outil.verificationWebElementPresence(btn_filtre);
			// verification - bouton créer
		Outil.verificationWebElementPresence(btn_creer);
		}
}
