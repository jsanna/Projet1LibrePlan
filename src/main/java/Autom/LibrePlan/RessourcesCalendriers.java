package Autom.LibrePlan;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import java.util.List;

import org.apache.poi.sl.usermodel.Line;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.Color;
public class RessourcesCalendriers {
	@FindBy (xpath="//table[substring(@id,5)='q4-box']//td[text()='Créer']")
	public WebElement Creer;
@FindBy (xpath="//input[substring(@id,5)='45']")
public WebElement champNom;
@FindBy (xpath="//td[text()='Enregistrer']")
public WebElement bouttonEnr;
@FindBy (xpath="//tbody[substring(@id,5)='k4-rows']/tr/td[1]//span[2]")
List<WebElement> listCal;
@FindBy (xpath="//td[text()='Enregistrer et continuer']")
public WebElement bouttonEnrCon;
@FindBy (xpath="//td[5]//td[text()='Annuler']")
public WebElement bouttonAnn;
@FindBy (xpath="//span[substring(@id,7)='-open']")
public WebElement bouttonMoins;
@FindBy (xpath="//td/div/button[substring(@id,5)='7-b']")
public WebElement calendrier;
@FindBy (xpath="//div[text()='Liste de calendriers']")
public WebElement ListeDeCal;
@FindBy (xpath="//div[1]//div[text()='Nom']")
public WebElement ListeNom;
@FindBy (xpath="//div[1]//div[text()='Hérité de la date']")
public WebElement ListeHerDat;
@FindBy (xpath="//div[1]//div[text()='Héritages à jour']")
public WebElement ListeHerJour;
@FindBy (xpath="//div[1]//div[text()='Opérations']")
public WebElement ListeOpérations;
@FindBy (xpath="//td[text()='Créer Calendrier']")
public WebElement CreerCal;
@FindBy (xpath="//span[text()='Données de calendrier']")
public WebElement FormDon;
@FindBy (xpath="//span[text()='Calendrier - Test 1']")
public WebElement CalPres;
@FindBy (xpath="//td[substring(@id,5)='85-chdex']/span")
public WebElement TypeDer;
@FindBy (xpath="//div[@class='message_WARNING']")
public WebElement MesWar;
@FindBy (xpath="//span[text()='Calendrier - Test 1 existe déjà']")
public WebElement MesWarTest;
@FindBy (xpath="//span[text()='Calendrier de base \"Calendrier - Test Calendrier Dérivé\" enregistré']")
public WebElement MesCalDer;
@FindBy (xpath="//td[text()='Créer Calendrier: Calendrier - Test Calendrier Dérivé']")
public WebElement TitreDer;
@FindBy (xpath="//tr[td//span[text()='Calendrier - Test 1']]/following::tr//span[@class='z-dottree-line z-dottree-last']/following::span[text()='Calendrier - Test Calendrier Dérivé']")
public WebElement TestDeriv;
@FindBy (xpath="//tr[td//span[text()='Calendrier - Test 1']]/following::tr[@style='display: none;']")
public WebElement TestBoutonMoins;
@FindBy (xpath="//span[text()='Calendrier source']")
public WebElement TypeSource;

public int retournerNumeroDeLigne(String s){ 
	int ligneCourante = 1;
	int ligneSauvegarder=0;
	for(WebElement ligne : listCal){

		//	   List<WebElement> cases = ligne.findElements(By.xpath("td"));
		//	   System.out.println("span="+cases.get(2).getText());
		if(ligne.getText().equals(s)){
			System.out.println(s +  " est présent");

			ligneSauvegarder = ligneCourante;	
			
		}
		ligneCourante++;
	}
	
	return ligneSauvegarder;
	
}

public void selectDeriv(String san , WebDriver driver) {
	WebElement boutonder = driver.findElement(By.xpath("//div[substring(@id,5)='k4-body']//tbody[@class='z-treechildren']/tr["+retournerNumeroDeLigne(san)+"]/td[4]//img[contains(@src, 'derived1')]"));
	boutonder.click();
}

public void selectCopy(String san, WebDriver driver) {
	WebElement boutonder = driver.findElement(By.xpath("//div[substring(@id,5)='k4-body']//tbody[@class='z-treechildren']/tr["+retournerNumeroDeLigne(san)+"]/td[4]//img[contains(@src, 'copy1')]"));
	boutonder.click();
}
public void calEnr() {
	Creer.click();
	Outil.renseignerChamp(champNom, "Calendrier - Test 1");
	VerifCreCal();
	bouttonEnr.click();
}
public void calEnrCon(WebDriver driver) throws InterruptedException {
	VerifDer(driver);
	Outil.renseignerChamp(champNom, "Calendrier - Test 1");
	bouttonEnrCon.click();
	VerifColor();
	assertTrue(MesWarTest.isDisplayed());
	System.out.println("Le message \"Calendrier - Test 1 existe déjà\" apparait");
	Outil.renseignerChamp(champNom, "Calendrier - Test Calendrier Dérivé");
	bouttonEnrCon.click();
	assertTrue(MesCalDer.isDisplayed());
	System.out.println("Le message Calendrier de base \"Calendrier - Test Calendrier Dérivé\" enregistré est bien présent");
	assertTrue(TitreDer.isDisplayed());
	System.out.println("Le titre de la page est bien Créer Calendrier: Calendrier - Test Calendrier Dérivé");
	bouttonAnn.click();
}

public void calCopEnr() throws InterruptedException {
	assertTrue(TypeSource.isDisplayed());
	System.out.println("Le type est bien Calendrier Source");
	bouttonEnrCon.click();
	VerifColor();
	assertTrue(MesWarTest.isDisplayed());
	System.out.println("Le message \"Calendrier - Test 1 existe déjà\" apparait");
	Outil.renseignerChamp(champNom, "Calendrier - Test 2");
	bouttonEnr.click();
	assertTrue(ListeDeCal.isDisplayed());
	System.out.println("Nous sommes bien de retour sur le menu liste de calendrier");
}
public void moins() {
	bouttonMoins.click();
}
public void verifCal() {
	assertTrue(calendrier.isDisplayed());
	System.out.println("Calendrier est bien présent");
}
public void VerifTab() {
	assertTrue(ListeDeCal.isDisplayed());
	System.out.println("Nous sommes bien sur le menu Liste de Calendriers");
	assertTrue(ListeNom.isDisplayed());
	System.out.println("Le champ Nom est présent");
	assertTrue(ListeHerDat.isDisplayed());
	System.out.println("Le champ Hérité de la date est présent");
	assertTrue(ListeHerJour.isDisplayed());
	System.out.println("Le champ Héritages à jour est présent");
	assertTrue(ListeOpérations.isDisplayed());
	System.out.println("Le champ Opérations est présent");
	assertTrue(Creer.isDisplayed());
	System.out.println("Le bouton créer est présent");
}
public void VerifCreCal() {
	assertTrue(CreerCal.isDisplayed());
	System.out.println("Nous sommes bien sur le menu Créer Calendrier");
	assertTrue(FormDon.isDisplayed());
	System.out.println("Le formulaire Données de calendrier est bien présent");
	assertTrue(bouttonEnr.isDisplayed());
	System.out.println("Le bouton Enregistrer est présent");
	assertTrue(bouttonEnrCon.isDisplayed());
	System.out.println("Le bouton Enregistrer et continuer est présent");
	assertTrue(bouttonAnn.isDisplayed());
	System.out.println("Le bouton Annuler est présent");
}
public void VerifRetourCal() {
	assertTrue(ListeDeCal.isDisplayed());
	System.out.println("Nous sommes de retour sur la page Liste de Calendrier");
	assertTrue(CalPres.isDisplayed());
	System.out.println("Le calendrier Test 1 est présent");
}
public void VerifDer(WebDriver driver) throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, 100);
	assertTrue(champNom.getText().isEmpty());
	System.out.println("Le champ Nom est vide");
	wait.until(ExpectedConditions.textToBePresentInElement(TypeDer, "Dérivé du calendrier Calendrier - Test 1"));
	assertEquals("Dérivé du calendrier Calendrier - Test 1", TypeDer.getText());
	System.out.println("La valeur de Type est bien \"Dérivé du calendrier Calendrier - Test 1\"");
}
public void VerifColor() {
	String color = MesWar.getCssValue("color");
	System.out.println(color);
	String hex = Color.fromString(color).asHex();
	System.out.println(hex);
	assertTrue("#cc5013".equals(hex));
	System.out.println("Le cadre est bien orange");
}
public void VerifTabDer() {
	assertTrue(TestDeriv.isDisplayed());
	System.out.println("Test Calendrier Dérivé est bien le dérivé de Test 1");
}
public void VerifBoutonMoins() {
	assertTrue(bouttonMoins.isDisplayed());
	System.out.println("L'arborescence est bien refermé");
}
}