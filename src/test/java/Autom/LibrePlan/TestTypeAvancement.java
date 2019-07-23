package Autom.LibrePlan;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class TestTypeAvancement extends TestAbstract {
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

		// ACTION 1 Connexion réussie. Affichage de l'onglet "Calendrier".
		WebDriverWait wait = new WebDriverWait(driver, 2);
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		// VERIFICATION
		assertTrue("[FAIL pas de bouton calendrier]", index.calendrier.isDisplayed());
		// ACTION 2 Accéder à la page de gestion des types d'avancement
		/*
		 * Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui
		 * s'affiche, cliquer sur l'item "Types d'avancement".
		 */
		index.clickSurRessourcesPuisTypes(driver);
		PageTypeAvancement type = PageFactory.initElements(driver, PageTypeAvancement.class);
		// VERIFICATION
		type.verificationPage(driver);
		// ACTION 3 Créer un type d'avancement - Accès au formulaire de création
		type.bouton_creer.click();
		// VERIFICATION
		type.verifAffichageCreerTypeAvancement(driver);
		// ACTION 4 Créer un type d'avancement - sans pourcentage
		String nom = "Test 1 Actif";
		type.creerTypeAvancementSansPourcentage(driver, nom);
		// VERIFICATION
		type.verifcreerTypeAvancementSansPourcentage(driver, nom);
		// ACTION 5 Créer un type d'avancement - Accès au formulaire de création 
		type.bouton_creer.click();
		// VERIFICATION
		type.verifAccesFormulaire(driver);
		// ACTION 6	Créer un type d'avancement - sans pourcentage (1/2)
		String nom2 = "Type avancement - Test 2";
		type.creerTypeSansPourcentage1de2(nom2);
		// VERIFICATION
		type.verif1de2();
		// ACTION 7	Créer un type d'avancement - sans pourcentage (2/2)
		type.bouton_sauver_continuer.click();
		// VERIFICATION
		type.verif2de2(nom2);
		// ACTION 8 Retour à la page de gestion des types d'avancement
		type.bouton_annuler.click();
		// VERIFICATION
		type.verif8(driver);
		// ACTION 9 Conformité du type d'avancement ajouté
		type.action9();
		// VERIFICATION
		type.verif9(driver, nom2);
		
	}
}
