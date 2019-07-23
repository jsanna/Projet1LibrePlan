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

public class PageParticipants {
	@FindBy(xpath="//tr[substring(@id,5)='r5']/th/div")
	private List<WebElement> tableau_participants;
	
	@FindBy(xpath="//span[substring(@id,5)='n4']")
	private WebElement txt_filtre_par;
	
	@FindBy(xpath="//input[substring(@id,5)='q4-real']")
	private WebElement chmp_filtre_par;
	
	@FindBy(xpath="//i[substring(@id,5)='q4-btn']")
	private WebElement btn_filtre_par;
	
	@FindBy(xpath="//span[substring(@id,5)='c5']")
	private WebElement txt_details_personnels;
	
	@FindBy(xpath="//input[substring(@id,5)='d5']")
	private WebElement btn_details_personnels;
	
	@FindBy(xpath="//div[substring(@id,5)='e5']")
	private WebElement btn_plus_options;
	
	@FindBy(xpath="//td[substring(@id,5)='f5-cnt']")
	private WebElement txt_plus_options;
	
	@FindBy(xpath="//table[substring(@id,5)='n5-box']/tbody/tr/td[text()='Filtre']")
	private WebElement btn_filtre;
	
	@FindBy(xpath="//table[substring(@id,5)='n5-box']/tbody/tr[2]/td[2]")
	private WebElement txt_filtre;
	
	@FindBy(xpath="//table[substring(@id,5)='y5-box']")
	private WebElement btn_creer;
	
	@FindBy(xpath="//table[substring(@id,5)='y5-box']/tbody/tr[2]/td[2]")
	private WebElement txt_creer;
	
	// Page Créer Participants
	@FindBy(xpath="//td[text()='Créer Participant']")
	private WebElement txt_creer_participant;

	@FindBy(xpath="//span[.='Données personnelles']/../../../..")
	private WebElement onglet_donnees_personnelles;
	
	// Données Personnelles
	@FindBy(xpath="//span[contains(text(),'Données de base')]")
	private WebElement txt_donnees_bases;
	
	@FindBy(xpath="//span[text()='Code']")
	private WebElement txt_code;
	
	@FindBy(xpath="//table[substring(@id,6)='6-real']/descendant::input[@disabled]")
	private WebElement chmp_code;
	
	@FindBy(xpath="//span[substring(@id,5)='hi'][contains(text(),'WORKER')]")
	private WebElement btn_code_value;
	
	@FindBy(xpath="//span[text()='Prénom']")
	private WebElement txt_prenom;
	
	@FindBy(xpath="//span[text()='Nom']")
	private WebElement txt_nom;
	
	@FindBy(xpath="//span[text()='ID']")
	private WebElement txt_id;
	
	@FindBy(xpath="//label[text()='Non lié']")
	private WebElement txt_non_lie;
	
	@FindBy(xpath="//label[text()='Non lié']/preceding-sibling::input")
	private WebElement btn_non_lie;
	
	@FindBy(xpath="//label[text()='Utilisateur existant']")
	private WebElement txt_utilisateur_existant;
	
	@FindBy(xpath="//label[text()='Utilisateur existant']/preceding-sibling::input")
	private WebElement btn_utilisateur_existant;
	
	@FindBy(xpath="//label[text()='Créer un nouvel utilisateur']")
	private WebElement txt_creer_nouvel_utilisateur;
	
	@FindBy(xpath="//label[text()='Créer un nouvel utilisateur']/preceding-sibling::input")
	private WebElement btn_creer_nouvel_utilisateur;
	
	@FindBy(xpath="//input[substring(@id,5)='o6']")
	private WebElement chmp_prenom;
	
	@FindBy(xpath="//input[substring(@id,5)='u6']")
	private WebElement chmp_nom;

	@FindBy(xpath="//input[substring(@id,5)='x6']")
	private WebElement chmp_id;
	
	@FindBy(xpath="//option[@selected='selected'][text()='Ressource normale']")
	private WebElement chmp_type_ressource_normale;
	
	@FindBy(xpath="//div[contains(text(),'Nouvel utilisateur')]/../descendant::tbody/tr[1]/td[2]/div/input")
	private WebElement chmp_nom_utilisateur;
	
	@FindBy(xpath="//div[contains(text(),'Nouvel utilisateur')]/../descendant::tbody/tr[2]/td[2]/div/input")
	private WebElement chmp_mdp;
	
	@FindBy(xpath="//div[contains(text(),'Nouvel utilisateur')]/../descendant::tbody/tr[3]/td[2]/div/input")
	private WebElement chmp_confirmation_mdp;
	
	@FindBy(xpath="//div[contains(text(),'Nouvel utilisateur')]/../descendant::tbody/tr[4]/td[2]/div/input")
	private WebElement chmp_email;
	
	@FindBy(xpath="//td[text()='Enregistrer']")
	private WebElement btn_enregistrer_nouvel_utilisateur;
	
	@FindBy(xpath="//div[substring(@id,5)='p5-body']/table/tbody[2]/tr")
	private List<WebElement> tableau_supprimer;
	
	@FindBy(xpath="span[@title='Supprimer']")
	private WebElement btn_supprimer;
	
	@FindBy(xpath="//td[text()='OK']")
	private WebElement btn_ok;
	
	@FindBy(xpath="//td[text()='Oui']")
	private WebElement btn_oui;
		
	//Liste des participants (nouvel utilisateur)
	@FindBy(xpath="//input[substring(@id,5)='d5']")
	private WebElement chmp_details_personnels;
	
	@FindBy(xpath="//table[substring(@id,6)='5-prev']/descendant::button")
	private WebElement btn_prev;
	
	@FindBy(xpath="//table[substring(@id,6)='5-next']")
	private WebElement btn_next;
	
	@FindBy(xpath="//table[substring(@id,6)='5-last']/descendant::button")
	private WebElement btn_last;
	
	@FindBy(xpath="//table[substring(@id,6)='5-first']/descendant::button")
	private WebElement btn_first;
	
	@FindBy(xpath="//a[text()='[Déconnexion]']")
	private WebElement btn_deconnexion;
	
	@FindBy (xpath = "//input[@name = 'j_username']")
	private static WebElement utilisateur;
	
	@FindBy (xpath = "//input[@name = 'j_password']")
	private static WebElement mot_de_passe;
	
	@FindBy (xpath = "//input[@name = 'button']")
	private static WebElement submit;
	
	
	// VERIFICATION PAS 2
	public void verifPageParticipants(WebDriver driver) throws InterruptedException {
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
//		String s = btn_plus_options.getCssValue("border-bottom");
//		System.out.println(s);
//		assertTrue("...",s.contains("#B2CCD9"));
		
		// VERIFICATION bouton filtre
		Outil.verificationWebElementPresence(btn_filtre);
		Outil.verificationTextWebElement("Filtre", txt_filtre);
//		assertEquals(btn_filtre.getCssValue("color"), "#58A758");
		;
		
		// VERIFICATION bouton créer
		Outil.verificationWebElementPresence(btn_creer);
		Outil.verificationTextWebElement("Créer", txt_creer);
		
		System.out.println("[PAS 2] Vérification Page Participants effectuée.");
		}
	
	public void clickBtnCreer() {
		btn_creer.click();
	}	
	
	public void verifFormulaireCreation() {
		// VERIFICATION affichage page Créer participant		
//		Outil.verificationTextWebElement("Créer Participant", txt_creer_participant);
		
		// VERIFICATION onglet données personnelles affiché par défaut	
		Outil.verificationOngletAffiche(onglet_donnees_personnelles, "class", "z-tab z-tab-seld");
		
			
		System.out.println("[PAS 3] Vérification Page Créer Participant effectuée.");
	}
	
	// VERIFICATION PAS 4
	public void verifOngletDonneesPersonnelles(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.textToBePresentInElement(txt_donnees_bases, "Données de base"));
		Outil.verificationTextWebElement("Données de base", txt_donnees_bases);
		
		//VERIFICATION champ code présent & non modifiable
		Outil.verificationWebElementPresence(chmp_code);
		
		// VERIFICATION valeur par défaut
//		Impossibilité de faire l'assert car chmp_code en hidden
		
		// VERIFICATION couleur champ code (gris)
//		String color = btn_code.getCssValue("background");
//		System.out.println(color);
//		String hex = Color.fromString(color).asHex();
//		System.out.println(hex);
//		assertTrue("#ECEAE4".equals(hex));
		
		// VERIFICATION présence champs & vides par défaut
//		Impossibilité de faire l'assert car chmp_code en hidden
//		assertFalse(chmp_prenom.getText().isEmpty());
//		assertFalse(chmp_nom.getText().isEmpty());
//		assertFalse(chmp_id.getText().isEmpty());
//		assertFalse(chmp_id.getText().isEmpty());

		assertTrue(chmp_type_ressource_normale.isDisplayed());
	}
	
	public void creationNouvelUtilisateur(String prenom, String nom, String id, String nom_utilisateur) {
		// ACTION rentrées de valeurs
		Outil.renseignerChamp(chmp_prenom, prenom);
		Outil.renseignerChamp(chmp_nom, nom);
		Outil.renseignerChamp(chmp_id, id);
		
		// ACTION création d'un nouvel utilisateur
		btn_creer_nouvel_utilisateur.click();
		Outil.renseignerChamp(chmp_nom_utilisateur, nom_utilisateur);
		Outil.renseignerChamp(chmp_mdp, "$jdumdp1");
		Outil.renseignerChamp(chmp_confirmation_mdp, "$jdumdp1");
		Outil.renseignerChamp(chmp_email, " jdu@test.fr");
		btn_enregistrer_nouvel_utilisateur.click();
	}
	
	public void creationPlusieursUtilisateurs(WebDriver driver) throws InterruptedException {
	// Création de plusieurs utilisateurs
		String[] prenom = new String[15];
		prenom [0] = "Quentin";
		prenom [1] = "Baltazar";
		prenom [2] = "Jessica";
		prenom [3] = "Marie";
		prenom [4] = "Patrick";
		prenom [5] = "Alexandra";
		prenom [6] = "Gauthier";
		prenom [7] = "Elisabeth";
		prenom [8] = "Odile";
		prenom [9] = "Dartagnan";
		prenom [10] = "Paul";
		prenom [11] = "Mathieu";
		prenom [12] = "Fabrice";
		prenom [13] = "Gertrude";
		prenom [14] = "Adrien";
		
		String[] nom = new String[15];
		nom [0] = "Dussert";
		nom [1] = "Arthur";
		nom [2] = "Bonno";
		nom [3] = "Melissandre";
		nom [4] = "Pro";
		nom [5] = "Lemaitre";
		nom [6] = "Gourdin";
		nom [7] = "Topaze";
		nom [8] = "Gorgeous";
		nom [9] = "Rutil";
		nom [10] = "Bella";
		nom [11] = "Lajoie";
		nom [12] = "Boris";
		nom [13] = "Mouli";
		nom [14] = "Alberto";
		
		String[] id = new String[15];
		id [0] = "qdussert";
		id [1] = "barthur";
		id [2] = "jbonno";
		id [3] = "mmelissandre";
		id [4] = "ppro";
		id [5] = "alemaitre";
		id [6] = "ggourdin";
		id [7] = "etopaze";
		id [8] = "ogorgeous";
		id [9] = "drutil";
		id [10] = "pbella";
		id [11] = "mlajoie";
		id [12] = "fboris";
		id [13] = "gmouli";
		id [14] = "aalberto";
		
		String[] nom_utilisateur = new String[15];
		nom_utilisateur [0] = "qdussert";
		nom_utilisateur [1] = "barthur";
		nom_utilisateur [2] = "jbonno";
		nom_utilisateur [3] = "mmelissandre";
		nom_utilisateur [4] = "ppro";
		nom_utilisateur [5] = "alemaitre";
		nom_utilisateur [6] = "ggourdin";
		nom_utilisateur [7] = "etopaze";
		nom_utilisateur [8] = "ogorgeous";
		nom_utilisateur [9] = "drutil";
		nom_utilisateur [10] = "pbella";
		nom_utilisateur [11] = "mlajoie";
		nom_utilisateur [12] = "fboris";
		nom_utilisateur [13] = "gmouli";
		nom_utilisateur [14] = "aalberto";
	
		// boucle
		
		for(int i=0; i<15; i++) {
			Thread.sleep(1000);
			btn_creer.click();
			creationNouvelUtilisateur(prenom[i], nom[i], id[i],nom_utilisateur[i]);
		}
		
	}
	
	public void filtreDetailsPeronnels() {
		// ACTION recherche utilisateur
		Outil.renseignerChamp(chmp_details_personnels, "Jean");
		btn_filtre.click();
		btn_plus_options.click();
		
	}
	
	public void navigation_next(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(btn_next));
		btn_next.click();
		System.out.println("next");
	}
	
	public void navigation_prev() {
		btn_prev.click();
		System.out.println("prev");
	}
	
	public void navigation_last() {
		btn_last.click();
		System.out.println("last");
	}
	
	public void navigation_first() {
		btn_first.click();
		System.out.println("first");
	}
	
	public void reconnexion(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(btn_deconnexion));
		btn_deconnexion.click();

		Outil.renseignerChamp(utilisateur, "jdu");
		Outil.renseignerChamp(mot_de_passe, "$jdumdp1");
		submit.click();
	}
	
	public void supprimerTousRoles(WebDriver driver) {
		if(tableau_supprimer.size()>0) {
			int i = tableau_supprimer.size()-1;
		while (i>=0) {
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tableau_supprimer.get(i).findElement(By.xpath("/descendant::span[@title='Supprimer']"))
					.click();
			btn_ok.click();
			btn_oui.click();
			i--;
		}
		}
	
	}
	public void supprimerLigne() {
		btn_supprimer.click();
		btn_ok.click();
		btn_oui.click();
	}
}
