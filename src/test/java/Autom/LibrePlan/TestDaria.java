package Autom.LibrePlan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public class TestDaria extends TestAbstract {
	@Before
	public void CreerLeWait() throws Exception {

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
		
	List<WebElement> tableau;
	
	@Test
	public void tester()
	{
		WebDriverWait wait = new WebDriverWait(driver, 2);
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
		WebElement creer = driver.findElement(By.xpath("//span[@class ='create-button global-action z-button']"));
		assertTrue(creer.isDisplayed());
		//ACTION cliquer créer
		creer.click();
	/*	Affichage de la page "Créer Formulaire qualité" contenant un onglet "Formulaire qualité" avec :

			 

			- un formulaire de saisie des caractéristiques du formulaire de qualité comportant les éléments suivants :

			Nom : champ de saisie non renseigné
			Description : champ de saisie non renseigné
			Type de formulaire qualité : liste déroulante contenant les valeurs "par pourcentage" et "par élément". La valeur affichée par défaut est "par pourcentage".
			Avancement du rapport : case à cocher décochée par défaut
			- un bloc "Liste d'éléments du formulaire qualité" avec :

			bouton [Nouvel élément du formulaire qualité]
			un tableau ne comportant aucune ligne avec les colonnes "Nom", "Position", "Pourcentage" et "Opérations"
			- les boutons [Enregistrer], [Sauver et continuer] et [Annuler] */
	
		
		
		WebElement nom_de_page = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[substring(@id,8)='cnt']"))));
		assertEquals("FAIL page n'est pas créer formulaire qualité","Créer Formulaire qualité",nom_de_page.getText()); //qJEP55-cnt
		assertEquals("Fail sur nom Formulaire qualité","Formulaire qualité", driver.findElement(By.xpath("//span[@class='z-tab-text']")).getText());
		
		//formulaire
		tableau = driver.findElements(By.xpath("//*[substring(@id,8)='chdextr']"));
		assertTrue("FAIL champ Nom pas vide", tableau.get(1).getText().isEmpty());
		assertTrue("FAIL champ Description pas vide", tableau.get(3).getText().isEmpty());
		////td[substring(@id,8)='chdextr']/div/select
		
		Select menu = new Select(tableau.get(5).findElement(By.xpath("div/select")));
		System.out.println(menu.getFirstSelectedOption().getText());
		assertEquals("FAIL Type de formulaire qualité option1 par pourcentage","par pourcentage", menu.getOptions().get(0).getText());
		assertEquals("FAIL Type de formulaire qualité option1 par élément","par élément", menu.getOptions().get(1).getText());
		assertEquals("FAIL Type de formulaire qualité option1 par pourcentage est pas coché", "par pourcentage",menu.getFirstSelectedOption().getText());
		
	} 

}
