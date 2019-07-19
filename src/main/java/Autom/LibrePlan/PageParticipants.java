package Autom.LibrePlan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
//	@FindBy(xpath="//table[substring(@id,5)='p5-box']")
//	private WebElement btn_filtre;
	@FindBy(xpath="//table[substring(@id,5)='p5-box']/tbody/tr/td[text()='Filtre']")
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
	
	@FindBy(xpath="//tbody[substring(@id,5)='i6']/tr/td/div")
	private List<WebElement> tableau_donnees_personnelles;
	
	@FindBy(xpath="//input[substring(@id,5)='q6']")
	private WebElement chmp_prenom;
	
	@FindBy(xpath="//input[substring(@id,5)='w6']")
	private WebElement chmp_nom;

	@FindBy(xpath="//input[substring(@id,5)='z6']")
	private WebElement chmp_id;
	
	public void verifPageParticipantsPas2(WebDriver driver) throws InterruptedException {
		// VERIFICATION affichage page Participants
		Thread.sleep(3000);
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
		assertEquals(btn_filtre.getCssValue("color"), "#58A758");
		;
		
		// VERIFICATION bouton créer
		Outil.verificationWebElementPresence(btn_creer);
		Outil.verificationTextWebElement("Créer", txt_creer);
		
		System.out.println("[PAS 2] Vérification Page Participants effectuée.");
		}
	
	public void clickBtnCreer() {
		btn_creer.click();
	}	
	
	public void verifPageCreerParticipant() {
		// VERIFICATION affichage page Créer participant		
//		Outil.verificationTextWebElement("Créer Participant", txt_creer_participant);
		
		// VERIFICATION onglet données personnelles affiché par défaut	
		Outil.verificationOngletAffiche(onglet_donnees_personnelles, "class", "z-tab z-tab-seld");
			
		System.out.println("[PAS 3] Vérification Page Créer Participant effectuée.");
	}
		
//	public void verifOngletDonneesPersonnelles() {
//		assertFalse(tableau_donnees_personnelles.isEmpty());
//		assertEquals("FAIL Le tableau n'a pas la même quantité de colonnes", 5, tableau_donnees_personnelles.size());
//		Outil.verificationTextWebElement("Code", tableau_donnees_personnelles.get(0));
//		Outil.verificationTextWebElement("Prénom", tableau_donnees_personnelles.get(1));
//		Outil.verificationTextWebElement("Nom", tableau_donnees_personnelles.get(2));
//		Outil.verificationTextWebElement("ID", tableau_donnees_personnelles.get(3));
//		Outil.verificationTextWebElement("Type", tableau_donnees_personnelles.get(4));
//		
//		System.out.println("[PAS 4] Vérification Onglet Données Personnelles effectuée.");
//	}
	
	public void creationNouvelUtilisateur() {
		// ACTION rentrées de valeurs
		Outil.renseignerChamp(chmp_prenom, "Jean");
		Outil.renseignerChamp(chmp_nom, "Du");
		Outil.renseignerChamp(chmp_id, "jdu");
	}
}
