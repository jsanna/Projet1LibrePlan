package Autom.LibrePlan;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RessourcesCritere {

	@FindBy (xpath="//tr/td[.='Créer']")
	public WebElement creer;
	@FindBy (xpath="//td/div/button[substring(@id,5)='7-b']")
	public WebElement calendrier;
	@FindBy (xpath="//td/div/input[substring(@id,5)='e5']")
	public WebElement champNom;
	@FindBy (xpath="//td/div/i/input[substring(@id,5)='h5-real']")
	public WebElement champType;
	@FindBy (xpath="//td/div/span/input[substring(@id,5)='k5-real']")
	public WebElement champValeur;
	@FindBy (xpath="//td/div/span/input[substring(@id,5)='n5-real']")
	public WebElement champHierarchie;
	@FindBy (xpath="//td/div/span/input[substring(@id,5)='q5-real']")
	public WebElement champActive;
	@FindBy (xpath="//td/div/textarea[substring(@id,5)='t5']")
	public WebElement champDescription;
	@FindBy (xpath="//tr/td[text()='Enregistrer']")
	public WebElement enregistrer;
	@FindBy (xpath="//tr/td[text()='Annuler']")
	public WebElement annuler;
	@FindBy (xpath="//tr/td[text()='Sauver et continuer']")
	public WebElement sauverContinuer;
	@FindBy (xpath="//tbody[substring(@id,5)='r4']/tr/td[1]//span")
	List<WebElement> listCritere;
	@FindBy (xpath="//body/div[3]//div//td[text()='Annuler']")
	public WebElement annulerFrame;
	@FindBy (xpath="//td[text()='OK']")
	public WebElement validerFrame;
	@FindBy (xpath="//div[text()='Nom']")
	public WebElement Nom;
	@FindBy (xpath="//div[text()='Code']")
	public WebElement Code;
	@FindBy (xpath="//div[text()='Type']")
	public WebElement Type;
	@FindBy (xpath="//div[text()='Activé']")
	public WebElement Active;
	@FindBy (xpath="//div[text()='Opérations']")
	public WebElement Operations;
	@FindBy (xpath="//span[text()='Modifier']")
	public WebElement TableMod;
	@FindBy (xpath="//span[text()='Type de critère \"Critère - Test bouton [Sauver et continuer]\" enregistré']")
	public WebElement MessageSC;
	@FindBy (xpath="//td[text()='Modifier Type de critère: Critère - Test bouton [Sauver et continuer]']")
	public WebElement TitreSC;
	@FindBy (xpath="//span[text()='Type de critère \"Critère - Test bouton [Sauver et continuer] 2\" enregistré']")
	public WebElement MessageSC2;
	@FindBy (xpath="//td[text()='Modifier Type de critère: Critère - Test bouton [Sauver et continuer] 2']")
	public WebElement TitreSC2;
	@FindBy (xpath="//span[text()='Critère - Test bouton [Sauver et continuer] 2'. Êtes-vous sûr ?']")
	public WebElement MessagePop;
	@FindBy (xpath="//div[@class='z-window-modal z-window-modal-shadow']")
	public WebElement PopUp;
	
	//Renseigne les champs et clique sur le bouton annuler
	public void clickCritereAnn(WebDriver driver) {
		Outil.renseignerChamp(champNom, "Critère - Test bouton [Annuler]");
		Outil.renseignerChamp(champType, "Participant");
		Outil.renseignerChamp(champDescription, "Critère - Test bouton [Annuler]");
		annuler.click();
	}
	//Renseigne les champs et clique sur le bouton enregistrer en vérifiant les éléments de la table
	public void clickCritereEnr(WebDriver driver) throws InterruptedException {
		Outil.renseignerChamp(champNom, "Critère - Test bouton [Enregistrer]");
		Outil.renseignerChamp(champType, "Participant");
		Outil.renseignerChamp(champDescription, "Critère - Test bouton [Enregistrer]");
		Thread.sleep(1000);
		VerifTabMod();
		enregistrer.click();
	}
	//Renseigne les champs et clique sur le bouton sauver et continuer
	public void clickSauverCon(WebDriver driver) {
		Outil.renseignerChamp(champNom, "Critère - Test bouton [Sauver et continuer]");
		Outil.renseignerChamp(champType, "Participant");
		Outil.renseignerChamp(champDescription, "Critère - Test bouton [Sauver et continuer]");
		sauverContinuer.click();
	}
	//Modifie le nom et clique sur annuler
	public void modifierSauverConAnn(WebDriver driver) {
		Outil.renseignerChamp(champNom, "Critère - Test bouton [Sauver et continuer] 2");
		annuler.click();
	}
	//Modifie le champs nom en vérifiant la présence des messages après la sauvegarde et ressort en cliquant sur annuler.
	public void modifierSauverConEnr(WebDriver driver) throws InterruptedException {
		Outil.renseignerChamp(champNom, "Critère - Test bouton [Sauver et continuer] 2");
		champDescription.click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath("//td[text()='Modifier Type de critère: Critère - Test bouton [Sauver et continuer] 2']")).isDisplayed());
		sauverContinuer.click();
		assertTrue(MessageSC2.isDisplayed());
		System.out.println("Le message de modification est bien affiché");
		assertEquals(TitreSC2.getText(),"Modifier Type de critère: Critère - Test bouton [Sauver et continuer] 2");
		System.out.println("Le titre de la page a bien été modifié");
		annuler.click();
	}
	//Clique sur le bouton annuler de la pop up
	public void frameAnn(WebDriver driver){
		annulerFrame.click();
	}
	//Clique sur la bouton valider de la pop up
	public void frameVal(WebDriver driver) {
		validerFrame.click();
	}
	//Boucle permettant de récupérer une ligne à partir d'un string
	public int retournerNumeroDeLigne(String s){ 
		int ligneCourante = 1;
		int ligneSauvegarder=0;
		for(WebElement ligne : listCritere){

			//	   List<WebElement> cases = ligne.findElements(By.xpath("td"));
			//	   System.out.println("span="+cases.get(2).getText());
			if(ligne.getText().equals(s)){
				System.out.println(s + "est présent");

				ligneSauvegarder = ligneCourante;	
				
			}
			ligneCourante++;
		}
		
		return ligneSauvegarder;
		
	}
	//Permet de cliquer sur le bouton modifier en utilisant la boucle RetournerNumeroDeLigne pour trouver un élément
	public void selectModifier(String toto , WebDriver driver) {
		WebElement boutondif = driver.findElement(By.xpath("//div[substring(@id,5)='k4-body']//tbody[@class='z-rows']/tr["+retournerNumeroDeLigne(toto)+"]/td[5]//img[contains(@src, 'editar')]"));
		boutondif.click();
	}
	//Permet de cliquer sur un élément en se servant de la boucle RetournerNumeroDeLigne
	public void selectModifier2(String toto , WebDriver driver) {
		WebElement boutondif = driver.findElement(By.xpath("//div[substring(@id,5)='k4-body']//tbody[@class='z-rows']/tr["+retournerNumeroDeLigne(toto)+"]"));
		boutondif.click();
	}
	//Permet de cliquer sur le bouton delete en utilisant la boucle RetournerNumeroDeLigne pour trouver un élément
	public void selectDel(String toto , WebDriver driver) {
		WebElement boutondif = driver.findElement(By.xpath("//div[substring(@id,5)='k4-body']//tbody[@class='z-rows']/tr["+retournerNumeroDeLigne(toto)+"]/td[5]//img[contains(@src, 'borrar')]"));
		boutondif.click();
	}
	//Vérifie la présence du bouton Calendrier
	public void verifCal() {
		assertTrue(calendrier.isDisplayed());
		System.out.println("Calendrier est bien présent");
	}
	//Vérifie la présence des éléments de la table
	public void verifTab() {
		assertTrue(Nom.isDisplayed());
		System.out.println("La colonne Nom est présente");
		assertTrue(Code.isDisplayed());
		System.out.println("La colonne Code est présente");
		assertTrue(Type.isDisplayed());
		System.out.println("La colonne Type est présente");
		assertTrue(Active.isDisplayed());
		System.out.println("La colonne Active est présente");
		assertTrue(Operations.isDisplayed());
		System.out.println("La colonne Opérations est présente");
		assertTrue(creer.isDisplayed());
		System.out.println("Le bouton Créer est présent");
	}
	//Vérifie la présence des boutons lors de la création d'un critère
	public void VerifTabMod() {
		assertTrue(TableMod.isDisplayed());
		System.out.println("La table Modifier est présente");
		assertTrue(enregistrer.isDisplayed());
		System.out.println("Le bouton Enregistrer est présent");
		assertTrue(annuler.isDisplayed());
		System.out.println("Le bouton Annuler est présent");
		assertTrue(sauverContinuer.isDisplayed());
		System.out.println("Le bouton Sauver et Continuer est présent");
	}
	//Vérifie la présence des messages de création
	public void verifSC() throws InterruptedException{
		assertTrue(MessageSC.isDisplayed());
		assertEquals(TitreSC.getText(),"Modifier Type de critère: Critère - Test bouton [Sauver et continuer]");
	}
	//Vérifie la présence de la pop up et de ses boutons
	public void verifPop() {
		assertTrue(PopUp.isDisplayed());	
		System.out.println("La pop-up est présente");
		assertTrue(validerFrame.isDisplayed());
		System.out.println("Le bouton Ok est présent");
		assertTrue(annulerFrame.isDisplayed());
		System.out.println("Le bouton Annuler est présent");
	}
}
