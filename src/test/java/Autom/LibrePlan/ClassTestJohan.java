package Autom.LibrePlan;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassTestJohan extends TestAbstract{
	@Test
	
	public void testRessourcesCritere () throws InterruptedException {
		//Connexion à l'application
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		RessourcesCritere categorie = PageFactory.initElements(driver, RessourcesCritere.class);
		//Vérifie l'affichage du bouton Calendrier
		categorie.verifCal();
		//Clique sur le bouton Ressources puis sur le bouton Critère
		index.clickMenu(driver, "Ressources", "Critère");
		//Vérifie la présence des élements de la table
		categorie.verifTab();
		//Clique sur le bouton cliquer
		categorie.creer.click();
		Thread.sleep(500);
		//Vérifie la présence des éléments du tableau
		categorie.VerifTabMod();
		//Renseigne les champs et clique sur annuler
		categorie.clickCritereAnn(driver);
		Thread.sleep(500);
		//Verifie que le tableau n'a pas été enregistré
		int retour = categorie.retournerNumeroDeLigne("Critère - Test bouton [Annuler]");
		if (retour == 0) {
			System.out.println("La ligne Annuler n'est pas présente");
		}
		//Clique sur le bouton créer
		categorie.creer.click();
		//Renseigne les champs et clique sur Enregistrer
		categorie.clickCritereEnr(driver);
		//Clique sur le bouton créer
		categorie.creer.click();
		//Renseigne les champs et clique sur le bouton Sauver et Continuer
		categorie.clickSauverCon(driver);
		//Verifie la présence des messages de validation
		categorie.verifSC();
		//Clique sur le bouton annuler
		categorie.annuler.click();
		Thread.sleep(500);
		//Clique sur le bouton modifier du nouvel élément
		categorie.selectModifier("Critère - Test bouton [Sauver et continuer]", driver);
		Thread.sleep(500);
		//Verifie que le titre est le bon
		assertTrue(driver.findElement(By.xpath("//td[text()='Modifier Type de critère: Critère - Test bouton [Sauver et continuer]']")).isDisplayed());
		//Modifie les champs, clique sur sauver et continuer puis sur annuler
		categorie.modifierSauverConAnn(driver);
		Thread.sleep(500);
		//Clique sur le nom du critère pour le modifier
		categorie.selectModifier2("Critère - Test bouton [Sauver et continuer]", driver);
		//Modifie les champs, clique sur sauver et continuer puis sur annuler
		categorie.modifierSauverConEnr(driver);
		Thread.sleep(500);
		//Clique sur le bouton delete du critère
		categorie.selectDel("Critère - Test bouton [Sauver et continuer] 2", driver);
		//Vérifie les élements de la pop up
		categorie.verifPop();
		//Clique sur le bouton annuler
		categorie.frameAnn(driver);
		Thread.sleep(500);
		//Clique sur le bouton delete du critère
		categorie.selectDel("Critère - Test bouton [Sauver et continuer] 2", driver);
		//Vérifie la présence des élements de la pop up
		categorie.verifPop();
		//Valide et supprime l'élément
		categorie.frameVal(driver);
		
}		
}
