package Autom.LibrePlan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;



public class TestDaria extends TestAbstract {
	List<WebElement> tableau;
	
	@Test
	public void tester()
	{
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		assertTrue("[FAIL pas de bouton calendrier]",index.calendrier.isDisplayed());
		
//		Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Formulaires de qualité".
		index.clickMenu(driver, "Ressources", "Formulaires qualité");
		
		
	/*	Affichage de la page "Formulaires qualité Liste".

		 

		La page contient :

		- un tableau avec les colonnes suivantes :

		Nom
		Description
		Opérations
		- un champ de saisie "Filtrer les formulaires qualité par: nom" associé à un bouton [Filtre]

		 

		- un bouton [Créer]
		*/
		
		assertEquals("FAIL page n'est pas Formulaire de qualité", "LibrePlan: formulaires qualité",driver.getTitle());
		// Tableau Xpath //tr[substring(@id,5)='t4']
		tableau = driver.findElements(By.xpath("//tr[substring(@id,5)='t4']/th/div"));
		
		assertFalse(tableau.isEmpty());
		assertEquals("FAIL tableau n'a pas le meme quantite de colonnes", 3, tableau.size());
		Outil.verificationTextWebElement("Nom", tableau.get(0));
		Outil.verificationTextWebElement("Description", tableau.get(1));
		Outil.verificationTextWebElement("Opérations", tableau.get(2));
		
		assertTrue(driver.findElement(By.xpath("//span[@class ='create-button global-action z-button']")).isDisplayed());
		
		
		
	}

}
