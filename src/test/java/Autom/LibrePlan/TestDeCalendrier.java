package Autom.LibrePlan;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class TestDeCalendrier extends TestAbstract {
	@Test
	public void testRessourcesCalendriers () throws InterruptedException {
		//Permet de se connecter à l'application
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		RessourcesCalendriers calendrier= PageFactory.initElements(driver, RessourcesCalendriers.class);
		//Verifie la présence du bouton Calendrier
		calendrier.verifCal();
		//Clique sur le bouton Ressources puis Calendriers
		index.clickMenu(driver, "Ressources", "Calendriers");
		//Vérifie la présence des éléments du tableau Calendrier
		calendrier.VerifTab();
		//Renseigne le champs Nom du calendrier et enregistre en vérifiant la présence des éléments.
		calendrier.calEnr();
		Thread.sleep(500);
		calendrier.VerifRetourCal();
		Thread.sleep(500);
		//Va chercher sur le tableau le bouton dérivé propre à "Calendrier - Test 1"
		calendrier.selectDeriv("Calendrier - Test 1", driver);
		//Renseigne les champs du tableau dérivé et enregistre, en vérifiant la présence d'un message dans un cadre orange
		calendrier.calEnrCon(driver);
		//Verifie que Test Calendrier Dérivé est bien le dérivé de Test 1
		calendrier.VerifTabDer();
		//Clique sur le bouton "-"
		calendrier.moins();
		//Verifie la fermeture de l'arborescence
		calendrier.VerifBoutonMoins();
		Thread.sleep(500);
		//Va chercher dans le tableau le bouton copier propre à "Calendrier - Test 1"
		calendrier.selectCopy("Calendrier - Test 1", driver);
		//Modifie le champ Nom de la copie et enregistre
		calendrier.calCopEnr();
	}
}
