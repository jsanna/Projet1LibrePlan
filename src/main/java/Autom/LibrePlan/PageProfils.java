package Autom.LibrePlan;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class PageProfils {

	@FindBy(xpath = "//div[substring(@id,5)='j4-cap']")
	private WebElement nom_profils_liste;

	// contient (2 Texte)
	@FindBy(xpath = "//tr[substring(@id,5)='m4']/th/div")
	private List<WebElement> nom_tableau_profils_liste;

	// contient lignes "tr"
	@FindBy(xpath = "//tbody[substring(@id,5)='p4']/tr")
	private WebElement profils_liste;
	@FindBy(xpath = "//tbody[substring(@id,5)='p4']/tr")
	private List<WebElement> tableau_profils_liste;

	@FindBy(xpath = "//td[text()='Créer']")
	WebElement bouton_creer;

	@FindBy(xpath = "//td[substring(@id,8)='cnt']")
	WebElement nom_redaction;
	@FindBy(xpath = "//*[text()='Données de profil']")
	WebElement nom_donnees_profile;

	@FindBy(xpath = "//fieldset[substring(@id,5)='b5']/legend/span")
	WebElement nom_association;
	// (0)=texte, (1) input
	@FindBy(xpath = "//tbody[substring(@id,5)='75']/tr/td/div/descendant::*")
	private List<WebElement> tableau_Nom;

	@FindBy(xpath = "//fieldset/descendant::tbody/tr/td[substring(@id,8)='chdex']")
	private List<WebElement> liste_roles_et_bouton;
	@FindBy(xpath = "//fieldset/descendant::tbody/tr/td[substring(@id,8)='chdex']/descendant::input")
	WebElement champ_saisie_dansliste;
	@FindBy(xpath = "//fieldset/descendant::td[substring(@id,8)='chdex']/descendant::i[substring(@id,8)='btn']")
	WebElement champ_deroulante;
	@FindBy(xpath = "//fieldset/descendant::td[text()='Ajouter un rôle']")
	WebElement bouton_ajouter_role;
	@FindBy(xpath = "//tr[substring(@id,5)='h5']/th/div")
	private List<WebElement> nom_info_roles;
	@FindBy(xpath = "//td[contains(.,'Enregistrer')]")
	WebElement bouton_enregistrer;
	@FindBy(xpath = "//td[contains(.,'Sauver et continuer')]")
	WebElement bouton_sauver_continuer;
	@FindBy(xpath = "//td[contains(.,'Annuler')]")
	WebElement bouton_annuler;
	@FindBy(xpath = "//table[substring(@id,5)='e5-cave']/tbody") /// td[2]
	WebElement options_deroulantes_roles;
	@FindBy(xpath = "//tbody[substring(@id,5)='67']/tr")
	private List<WebElement> roles_crees;
	@FindBy(xpath = "//tbody[substring(@id,5)='67']")
	WebElement tableau_roles_crees;
	@FindBy(xpath = "//tbody/descendant::*[@class='message_INFO']")
	WebElement message;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_editar1.png']/..")
	private List<WebElement> redactions;

	public void verificationAffichagePageProfils(WebDriver driver) {
		/*
		 * Affichage de la page "Profils Liste". La page contient : - un tableau avec
		 * les colonnes suivantes : "Nom" "Actions". Cette colonne contient une icône de
		 * modification et une icône de suppression - un bouton [Créer]
		 */
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.textToBePresentInElement(nom_profils_liste, "Profils Liste"));
		assertEquals("Profils Liste", nom_profils_liste.getText());
		assertEquals("Nom de profil", nom_tableau_profils_liste.get(0).getText());
		assertEquals("Actions", nom_tableau_profils_liste.get(1).getText());
		// src="/libreplan/common/img/ico_editar1.png"
		// src="/libreplan/common/img/ico_borrar1.png"

		assertTrue(profils_liste.findElement(By.xpath("descendant::img[@src='/libreplan/common/img/ico_editar1.png']"))
				.isDisplayed());
		assertTrue(profils_liste.findElement(By.xpath("descendant::img[@src='/libreplan/common/img/ico_borrar1.png']"))
				.isDisplayed());

		assertTrue(bouton_creer.isDisplayed());
	}

	public void VerificationPageCreerProfil(WebDriver driver) {
		/*
		 * Affichage de la page "Créer Profil" contenant un onglet "Données de profil"
		 * avec : - Un champ de saisie "Nom" non renseigné - Un bloc
		 * "Association avec les rôles" contenant : une liste déroulante sans valeur
		 * affichée par défaut un bouton [Ajouter un rôle] un tableau avec les colonnes
		 * "Nom du rôle" et "Actions" - Les boutons [Enregistrer], [Sauver et continuer]
		 * et [Annuler]
		 */
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(nom_redaction.isDisplayed());
		assertTrue(nom_donnees_profile.isDisplayed());
		assertEquals("Nom", tableau_Nom.get(0).getText());
		assertEquals("", tableau_Nom.get(1).getText());
		assertEquals("Association avec les rôles", nom_association.getText());
		assertEquals("", champ_saisie_dansliste.getText());
		assertTrue(champ_deroulante.isDisplayed());
		assertTrue(bouton_ajouter_role.isDisplayed());
		assertEquals("Nom du rôle", nom_info_roles.get(0).getText());
		assertEquals("Actions", nom_info_roles.get(1).getText());
		assertTrue(bouton_enregistrer.isDisplayed());
		assertTrue(bouton_sauver_continuer.isDisplayed());
		assertTrue(bouton_annuler.isDisplayed());
	}

	public void creerProfilSaisieInfo(WebDriver driver, String nom, String option) {
		/*
		 * 1 - Saisir une valeur dans le champ "Nom". 2 - Dans le bloc
		 * "Association avec les rôles" : - sélectionner un rôle dans la liste
		 * déroulante - cliquer sur le bouton [Ajouter un rôle]
		 * 
		 */
		Outil.renseignerChamp(tableau_Nom.get(1), nom);
		champ_deroulante.click();
		options_deroulantes_roles.findElement(By.xpath("descendant::td[contains(.,'" + option.trim() + "')]/.."))
				.click();
		bouton_ajouter_role.click();
	}

	public void verifCreationProfilSaisieInfo(WebDriver driver, String option) {
		/*
		 * Le rôle sélectionné dans la liste déroulante est ajouté dans le tableau. Dans
		 * la colonne "Actions" associé à ce rôle, présence d'une icône représentant une
		 * poubelle.
		 */
		assertTrue(roles_crees.get(0).findElement(By.xpath("descendant::span[contains(.,'" + option.trim() + "')]/.."))
				.isDisplayed());
		assertTrue(roles_crees.get(0)
				.findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_borrar1.png']")).isDisplayed());
	}

	public void passerSourisPoubelle(WebDriver driver) {
		// Passer la souris sur l'icône représentant une poubelle.
		Actions a = new Actions(driver);

		a.moveToElement(roles_crees.get(0)
				.findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/..")));
		a.build().perform();

		a.build().perform();

	}

	public void verifPoubelleAffichageSupprimer(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.attributeToBe(By.xpath(
				"//tbody[substring(@id,5)='67']/descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/ancestor::span/table"),
				"class", "z-button-over"));
		assertEquals("", "z-button-over",
				roles_crees.get(0)
						.findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/.."))
						.getAttribute("class"));
	}

	public void creationPlusieursRoles(WebDriver driver, String option1, String option2, String option3,
			String option4) {
		/*
		 * 1- Dans le bloc "Association avec les rôles" : - sélectionner un rôle dans la
		 * liste déroulante - cliquer sur le bouton [Ajouter un rôle] 2 - Répéter les
		 * actions du point 1, 3 fois
		 */
		champ_deroulante.click();
		options_deroulantes_roles.findElement(By.xpath("descendant::td[contains(.,'" + option1.trim() + "')]/.."))
				.click();
		bouton_ajouter_role.click();

		champ_deroulante.click();
		options_deroulantes_roles.findElement(By.xpath("descendant::td[contains(.,'" + option2.trim() + "')]/.."))
				.click();
		bouton_ajouter_role.click();
		champ_deroulante.click();
		options_deroulantes_roles.findElement(By.xpath("descendant::td[contains(.,'" + option3.trim() + "')]/.."))
				.click();
		bouton_ajouter_role.click();
		champ_deroulante.click();
		options_deroulantes_roles.findElement(By.xpath("descendant::td[contains(.,'" + option4.trim() + "')]/.."))
				.click();
		bouton_ajouter_role.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(nom_redaction);
		actions.click();
		actions.build().perform();
	}

	public void verificationPlusieursProfils(WebDriver driver, String option1, String option2, String option3,
			String option4) {
		assertTrue(tableau_roles_crees
				.findElement(By.xpath("descendant::span[contains(.,'" + option1.trim() + "')]/..")).isDisplayed());
		assertTrue(tableau_roles_crees
				.findElement(By.xpath("descendant::span[contains(.,'" + option2.trim() + "')]/..")).isDisplayed());
		assertTrue(tableau_roles_crees
				.findElement(By.xpath("descendant::span[contains(.,'" + option3.trim() + "')]/..")).isDisplayed());
		assertTrue(tableau_roles_crees
				.findElement(By.xpath("descendant::span[contains(.,'" + option4.trim() + "')]/..")).isDisplayed());
	}

	public void creationRoleExistant(WebDriver driver, String option) {
		champ_deroulante.click();
		options_deroulantes_roles.findElement(By.xpath("descendant::td[contains(.,'" + option.trim() + "')]/.."))
				.click();
		bouton_ajouter_role.click();
	}

	public void verifcreationRoleExistant(WebDriver driver, String option) {
		assertTrue(tableau_roles_crees.findElement(By.xpath("descendant::span[contains(.,'" + option.trim() + "')]/.."))
				.isDisplayed());
		// peut-etre ajouter un message is not displayed
	}

	public int retournerNumeroDeLigneDansRolesCrees(String mot_recherche) {
		int ligneCourante = 0;
		for (WebElement ligne : roles_crees) {
			List<WebElement> cases = ligne.findElements(By.xpath("td"));
			if (cases.get(0).findElement(By.xpath("descendant::span")).getText().trim().equals(mot_recherche)) {
				return ligneCourante;
			}
			ligneCourante++;

		}
		return -1;
	}

	public void supprimerRole(WebDriver driver, String role) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//tbody[substring(@id,5)='67']/tr[1]/descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/..")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		roles_crees.get(retournerNumeroDeLigneDansRolesCrees(role))
				.findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/..")).click();
	}

	public void verificationRoleSuprimE(WebDriver driver, String role) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("FAIL role n'était pas supprimé", -1, retournerNumeroDeLigneDansRolesCrees(role));
	}

	public void supprimerTousRoles(WebDriver driver) {
		// WebDriverWait wait = new WebDriverWait(driver, 3);
		for (int i = 3; i > -1; i--) {
			// wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[substring(@id,5)='67']/tr[1]/descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/..")));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// elem.findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/..")).click();
			roles_crees.get(i).findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/.."))
					.click();
		}
		// roles_crees.clear();
	}

	public void verifSupprimerTousRoles(WebDriver driver) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("", 0, roles_crees.size());
	}

	public int retournerNumeroDeLigneDansProfils(String mot_recherche) {
		int ligneCourante = 0;
		for (WebElement ligne : tableau_profils_liste) {
			List<WebElement> cases = ligne.findElements(By.xpath("td"));
			if (cases.get(0).findElement(By.xpath("descendant::span")).getText().trim().equals(mot_recherche)) {
				return ligneCourante;
			}
			ligneCourante++;

		}
		return -1;
	}

	public void verifEnregistrement(WebDriver driver, String nom) {
		/*
		 * Retour sur la page "Profils Liste" sur laquelle : - le message suivant est
		 * affiché dans un cadre vert situé au dessus du titre de la page :
		 * "Profil "XXXX" enregistré" -> XXXX étant le nom du profil ajouté - le profil
		 * qui a été ajouté est présent dans le tableau
		 */

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.textToBePresentInElement(nom_profils_liste, "Profils Liste"));
		assertEquals("Profils Liste", nom_profils_liste.getText());
		assertEquals("", "Profil \"" + nom + "\" enregistré", message.getText());
		assertEquals(message.getCssValue("color"),"rgba(0, 102, 0, 1)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(profils_liste.findElement(By.xpath("//div/span[contains(text(),'Shark')]")).isDisplayed());
		assertTrue(profils_liste.findElement(By.xpath("//div/span[contains(text(),'" + nom + "')]")).isDisplayed());
		// Assertion que notre profil est present dans le tableau
		assertTrue(retournerNumeroDeLigneDansProfils(nom) != -1);
	}

	public void modification(WebDriver driver, String nom) {
		// Dans la colonne "Actions", du profil qui vient d'être ajouté,
		// cliquer sur l'icône de modification.
		// descendant::img[@src='/libreplan/common/img/ico_editar1.png']
		redactions.get(retournerNumeroDeLigneDansProfils(nom)).click();

	}

	// Modifier Profil: Shark
	public void verifAffichageModification(WebDriver driver, String nom) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.textToBePresentInElement(nom_redaction, "Modifier Profil: "+nom));
		assertEquals("Modifier Profil: "+nom, nom_redaction.getText());
		assertEquals(0, roles_crees.size());
	}

	public void modifierProfilFinal(WebDriver driver, String nom) {
		Outil.renseignerChamp(tableau_Nom.get(1), nom);
		bouton_enregistrer.click();
	}

	public void verifiProfilFinal(WebDriver driver, String nom) {
		/*
		 * Retour sur la page "Profils Liste" sur laquelle : - le message suivant est
		 * affiché dans un cadre vert situé au dessus du titre de la page :
		 * "Profil "YYYY" enregistré" -> YYYY étant le nom du profil modifié - le profil
		 * qui a été modifié est présent dans le tableau avec son nom modifié
		 */
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(nom_profils_liste));
		assertEquals("Profils Liste", nom_profils_liste.getText());
		assertEquals("", "Profil \"" + nom + "\" enregistré", message.getText());
		assertEquals(message.getCssValue("color"),"rgba(0, 102, 0, 1)");
		assertTrue(profils_liste.findElement(By.xpath("//div/span[contains(text(),'tank')]")).isDisplayed());
		assertTrue(profils_liste.findElement(By.xpath("//div/span[contains(text(),'" + nom + "')]")).isDisplayed());

	}

}
