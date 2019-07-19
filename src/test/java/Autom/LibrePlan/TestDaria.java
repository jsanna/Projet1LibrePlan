package Autom.LibrePlan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class TestDaria extends TestAbstract {
	public void tester()
	{
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		assertTrue("[FAIL pas de bouton calendrier]",index.calendrier.isDisplayed());
		
		/*
			public void clickSurRessourcesPuisParticipants (WebDriver driver)
	{
		Actions a = new Actions(driver);
		//Peut etre il faut une pause Thread.sleep
		a.moveToElement(ressources).build().perform();
		//Peut etre il faut une pause Thread.sleep
		a.moveToElement(ressources)
				.moveToElement(driver.findElement(By.xpath("//a[@href = '/libreplan/qualityforms/qualityForms.zul']"))).click()
				.build().perform();
	}  
*/
		
	//	Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Formulaires de qualité".
		
	/*	Affichage de la page "Formulaires qualité Liste".

		 

		La page contient :

		- un tableau avec les colonnes suivantes :

		Nom
		Description
		Opérations
		- un champ de saisie "Filtrer les formulaires qualité par: nom" associé à un bouton [Filtre]

		 

		- un bouton [Créer]
		*/
		
		
	}

}
