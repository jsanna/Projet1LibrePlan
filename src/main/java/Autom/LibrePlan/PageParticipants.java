package Autom.LibrePlan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class PageParticipants {
	@FindBy(xpath="//tr[substring(@id,5)='t5']/th/div")
	private List<WebElement> tableau_participants;
	
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
	
	@FindBy(xpath="//td[substring(@id,5)='h5-cnt']")
	private WebElement txt_plus_options;
	
	@FindBy(xpath="//table[substring(@id,5)='p5-box']")
	private WebElement btn_filtre;
	
	@FindBy(xpath="//table[substring(@id,5)='p5-box']/tbody/tr[2]/td[2]")
	private WebElement txt_filtre;
	
	@FindBy(xpath="//table[substring(@id,5)='_6-box']")
	private WebElement btn_creer;
	
	@FindBy(xpath="//table[substring(@id,5)='_6-box']/tbody/tr[2]/td[2]")
	private WebElement txt_creer;
	
	// Page Créer Participants
	@FindBy(xpath="//td[substring(@id,6)='6-cnt']")
	private WebElement txt_creer_participant;
	
	@FindBy(xpath="//span[.='Données personnelles']/../../../..")
	private WebElement onglet_donnees_personnelles;
	

	public void verifPageParticipantsPas2(WebDriver driver) {
		// VERIFICATION affichage page Participants
		assertEquals("LibrePlan: Participants", driver.getTitle());
		
		// VERIFICATION tableau
		assertFalse(tableau_participants.isEmpty());
		assertEquals("FAIL Le tableau n'a pas la même quantité de colonnes", 6, tableau_participants.size());
		Outil.verificationTextWebElement("Surnom", tableau_participants.get(0));
		Outil.verificationTextWebElement("Prénom", tableau_participants.get(1));
		Outil.verificationTextWebElement("ID", tableau_participants.get(2));
		Outil.verificationTextWebElement("Code", tableau_participants.get(3));
		Outil.verificationTextWebElement("En file", tableau_participants.get(4));
		Outil.verificationTextWebElement("Opérations", tableau_participants.get(5));
		
		// VERIFICATION  champ de recherche "Filtré par"
		Outil.verificationTextWebElement("Filtré par", txt_filtre_par);
		Outil.verificationWebElementPresence(chmp_filtre_par);
		Outil.verificationWebElementPresence(btn_filtre_par);
		
		// VERIFICATION champ de recherche "Détail personnel"
		Outil.verificationTextWebElement("Détails personnels", txt_details_personnels);
		Outil.verificationWebElementPresence(btn_details_personnels);
		
		// VERIFICATION bouton plus d'option
		Outil.verificationWebElementPresence(btn_plus_options);
		Outil.verificationTextWebElement("Plus d'options", txt_plus_options);
		
		// VERIFICATION bouton filtre
		Outil.verificationWebElementPresence(btn_filtre);
		Outil.verificationTextWebElement("Filtre", txt_filtre);
		
		// VERIFICATION bouton créer
		Outil.verificationWebElementPresence(btn_creer);
		Outil.verificationTextWebElement("Créer", txt_creer);
		
		System.out.println("[PAS 2] Vérification Page Participants effectuée.");
		}
	
	public void clickBtnCreer(WebDriver driver) {
		btn_creer.click();
		
		// VERIFICATION affichage page Créer participant		
		//Outil.verificationTextWebElement("Créer Participant", txt_creer_participant);
		Outil.verificationOngletAffiche(onglet_donnees_personnelles, "class", "z-tab z-tab-seld");
	}
}
