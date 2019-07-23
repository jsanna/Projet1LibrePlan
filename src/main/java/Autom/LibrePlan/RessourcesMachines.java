package Autom.LibrePlan;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RessourcesMachines {
	@FindBy (xpath="//td/div/button[substring(@id,5)='7-b']")
	public WebElement calendrier;
	@FindBy (xpath="//table[substring(@id,5)='x5-box']//td[text()='Créer']")
	public WebElement creer;
	@FindBy (xpath="//input[substring(@id,5)='g6']")
	public WebElement champCode;
	@FindBy (xpath="//input[substring(@id,5)='k6']")
	public WebElement champNom;
	@FindBy (xpath="//input[substring(@id,5)='n6']")
	public WebElement champDesc;
	@FindBy (xpath="//select[substring(@id,5)='s6']/option[@selected][text()='Ressource normale']")
	public WebElement champType;
	@FindBy (xpath="//input[substring(@id,5)='h6-real']")
	public WebElement boutonBox;
	@FindBy (xpath="//td[text()='Sauver et continuer']")
	public WebElement boutonSavCon;
	@FindBy (xpath="//table[substring(@id,5)='ld-box']//td[text()='Annuler']")
	public WebElement boutonAnn;
	@FindBy (xpath="//td[text()='Enregistrer']")
	public WebElement boutonEnr;
	@FindBy (xpath="//span[text()='Machine \"MACHINETEST1\" enregistré']")
	public WebElement boutonWarn;
	@FindBy (xpath="//td[text()='Modifier Machine: MACHINETEST1']")
	public WebElement titreElem;
	@FindBy (xpath="//div[text()='Machines Liste']")
	public WebElement TitreTab;
	
	
	public void verifCal() {
		assertTrue(calendrier.isDisplayed());
		System.out.println("Calendrier est bien présent");
	}
	public void boutonCreer() {
		creer.click();
	}
	public void verifTab() {
		assertTrue(champCode.getAttribute("value") !="");
		System.out.println("Le bouton Code possède bien une valeure");
		assertTrue(champNom.getText().isEmpty());
		System.out.println("Le champ nom est bien vide");
		assertTrue(champDesc.getText().isEmpty());
		System.out.println("Le champ Description est bien vide");
		assertTrue(champType.isDisplayed());
		System.out.println("La valeur de base est bien Ressource Normale");
		assertTrue(boutonEnr.isDisplayed());
		System.out.println("Le bouton Enregistrer est présent");
		assertTrue(boutonSavCon.isDisplayed());
		System.out.println("Le bouton Sauver et Continuer est présent");
		assertTrue(boutonAnn.isDisplayed());
		System.out.println("Le bouton Annuler est présent");
	}

public void remplirChamp() throws InterruptedException {
	boutonBox.click();
	Thread.sleep(500);
	Outil.renseignerChamp(champCode, "MACHINETEST1");
	Thread.sleep(500);
	Outil.renseignerChamp(champNom, "MACHINETEST1");
	Thread.sleep(500);
	Outil.renseignerChamp(champDesc, "MACHINETEST1");
	boutonSavCon.click();
	assertTrue(boutonWarn.isDisplayed());
	System.out.println("Le message de confirmation apparait correctement");
	assertTrue(titreElem.isDisplayed());
	System.out.println("Le titre du tableau a changé correctement");
	boutonAnn.click();
	Thread.sleep(500);
	assertTrue(TitreTab.isDisplayed());
	System.out.println("Nous sommes de retour sur le menu machine liste ");
}
}
