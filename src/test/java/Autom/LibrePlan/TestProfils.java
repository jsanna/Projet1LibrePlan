package Autom.LibrePlan;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TestProfils extends TestAbstract {
	@Before
	public void CreerLeWait() throws Exception {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	// @After
	public void sdfs() {
		driver.close();
	}

	@Test
	public void tester() { 
		// ACTION 1 Connexion à l'application - Profil Admin :
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		// VERIFICATION 2 Connexion réussie. Affichage de l'onglet "Calendrier".
		assertTrue("[FAIL pas de bouton calendrier]", index.calendrier.isDisplayed());
		// ACTION 2 Accéder à la page de gestion des profils
		index.clickMenu(driver, "Configuration", "Profils");
		PageProfils profil = PageFactory.initElements(driver, PageProfils.class);
		// VERIFICATION
		profil.verificationAffichagePageProfils(driver);
		// ACTION 3 Créer un profil - Accès au formulaire de création
		profil.bouton_creer.click();
		// VERIFICATION présence des éléments
		profil.VerificationPageCreerProfil(driver);
		// ACTION 4 Créer un profil - Saisie des informations
		String nom = "Shark";
		String option = "Machines";
		profil.creerProfilSaisieInfo(driver, nom, option);
		// VERIFICATION
		profil.verifCreationProfilSaisieInfo(driver, option);
		// ACTION 5 Conformité infobulle
		profil.passerSourisPoubelle(driver);
		// VERIFICATION
		// ACTION 6 Créer un profil - Ajout de plusieurs rôles
		String option1 = "Canevas", option2 = "Calendrier", option3 = "Profils", option4 = "Libellés";
		profil.creationPlusieursRoles(driver, option1, option2, option3, option4);
		// VERIFICATION
		profil.verificationPlusieursProfils(driver, option1, option2, option3, option4);
		// ACTION 7 Créer un profil - Ajout d'un rôle déjà ajouté
		profil.creationRoleExistant(driver, option);
		// VERIFICATION
		profil.verifcreationRoleExistant(driver, option);
		// ACTION 8 Créer un profil - Suppression d'un rôle ajouté
		profil.supprimerRole(driver, option4);
		// VERIFICATION
		profil.verificationRoleSuprimE(driver, option4);
		// ACTION 9 Créer un profil - Suppression de tous les rôles ajoutés
		profil.supprimerTousRoles(driver);
		// VERIFICATION
		profil.verifSupprimerTousRoles(driver);
		// ACTION 10 Créer un profil - enregistrement
		profil.bouton_enregistrer.click();
		// VERIFICATION
		profil.verifEnregistrement(driver, nom);
		// ACTION 11 Modifier un profil - accès page de modification :
		profil.modification(driver, nom);
		// VERIFICATION
		profil.verifAffichageModification(driver,nom);
		// ACTION 12 Modifier un profil - Ajout de plusieurs rôles :
		profil.creationPlusieursRoles(driver, option1, option2, option3, option4);
		// VERIFICATION
		profil.verificationPlusieursProfils(driver, option1, option2, option3, option4);
		// ACTION 13 Modifier un profil - enregistrement
		String nom2="tank";
		profil.modifierProfilFinal(driver,nom2);
		// VERIFICATION
		profil.verifiProfilFinal(driver, nom2);
	}

}
