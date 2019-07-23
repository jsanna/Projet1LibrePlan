package Autom.LibrePlan;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class ClassTestCreerProjet extends TestAbstract {

	@Before
	public void setUp() {
		System.out.println("@Before.");
		driver.manage().window().maximize();
	}
	
	@Test
	public void testerCreerProjet () throws SQLException, Exception {
		
		// ACTION : Appel de la page (index) qui se connecte à l'application avec les identifiants (login/passord)
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		// index.clickMenu(driver, "Configuration", "Profils");
		
		// ACTION : Sélection du bouton : "Créer un nouveau projet"
		//          Aller sur la nouvelle iframe
		index.creer_nouveau_projet.click();
		
		// ACTION: Instanciation de la page objects (PageCreerProjet) : page_creer_projet
		PageCreerProjet page_creer_projet = PageFactory.initElements(driver, PageCreerProjet.class);
		
		// VERIFICATION : Assertion des éléments de la page créer Projets
		page_creer_projet.verifPageCreerProjets(driver);
		
		// ACTION : [Pas 3] Inserer les données pour créer un projet
		page_creer_projet.insertPageCreerProjets(driver);
		
		// ACTION : [Pas 4-5] Assertion des éléments de la page menu Projets
		page_creer_projet.verifMenuCreerProjets(driver);

		// ACTION : [Pas 6] Assertion sur les boutons (Enregistrer et Annuler) et popups de l'édition du projet
		page_creer_projet.verifBoutonsMenuProjets(driver);
		
		// ACTION : [Pas 7] Assertion sur la fenêtre de confirmation de sortie de l'édition du projet
		page_creer_projet.verifSortieCreerProjets(driver, 7);
		
		// ACTION : [Pas 8] Clic sur 'Annuler' sur la fenêtre de confirmation de sortie de l'édition du projet
		page_creer_projet.verifAnnulationCreerProjets(driver, 8);
		
		// ACTION : [Pas 9] Assertion sur la fenêtre de confirmation de sortie de l'édition du projet
		page_creer_projet.verifSortieCreerProjets(driver, 9);
		
		// ACTION : [Pas 10] Clic sur 'Annuler' sur la fenêtre de confirmation de sortie de l'édition du projet
		page_creer_projet.verifAnnulationCreerProjets(driver, 10);
		
		// ACTION : [Pas 11] Vérifier la création du projet
		index.clickMenu(driver, "Calendrier", "Projets");
		Thread.sleep(400);
		page_creer_projet.verifCreationProjet(driver);

		// ACTION : [Pas 12] Vérifier la ligne de création des éléments du projet
		page_creer_projet.verifElementsCreationProjet(driver);
		
		// VERIFICATION : Vérifier en BDD la ligne de création des éléments du projet
		// ATTENTION : Ne fonctionne pas avec Postgres
		// page_creer_projet.compareData("order_element", "src/main/resources/datasets/compare_order_element.xml", "id","init_date","deadline");
	}

}
