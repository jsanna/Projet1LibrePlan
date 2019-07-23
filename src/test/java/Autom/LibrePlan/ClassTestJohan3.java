package Autom.LibrePlan;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class ClassTestJohan3 extends TestAbstract{
	@Test
	public void testRessourcesMachines () throws InterruptedException {
	//Permet de se connecter à l'application
			PageIndex index = PageFactory.initElements(driver, PageIndex.class);
			RessourcesMachines machines= PageFactory.initElements(driver, RessourcesMachines.class);
			//Verifie la présence du bouton Calendrier
			machines.verifCal();
			//Clique sur le bouton Ressources puis Calendriers
			index.clickMenu(driver, "Ressources", "Machines");
			//clique sur creer
			machines.boutonCreer();
			machines.verifTab();
			machines.remplirChamp();
	}
}
