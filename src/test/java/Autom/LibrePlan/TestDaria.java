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

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
		
	
	@Test
	public void tester()
	{
		WebDriverWait wait = new WebDriverWait(driver, 2);
		PageIndex index = PageFactory.initElements(driver, PageIndex.class);
		assertTrue("[FAIL pas de bouton calendrier]",index.calendrier.isDisplayed());
		
		//ACTION 2	Passer la souris sur l'onglet "Ressources" puis dans le sous-menu qui s'affiche, cliquer sur l'item "Formulaires de qualité".
		index.clickMenu(driver, "Ressources", "Formulaires qualité");
		FormulaireQualite formulaire = PageFactory.initElements(driver, FormulaireQualite.class);
		

		assertEquals("FAIL page n'est pas Formulaire de qualité", "LibrePlan: formulaires qualité",driver.getTitle());
		formulaire.VerificationFormulaireQualiteListe(driver);
		
		assertTrue(formulaire.bouton_creer.isDisplayed());
		//ACTION 3 cliquer créer
		formulaire.bouton_creer.click();
		
		//VERIFICATION des elements de page
		WebElement nom_de_page = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[substring(@id,8)='cnt']"))));
		assertEquals("FAIL page n'est pas créer formulaire qualité","Créer Formulaire qualité",nom_de_page.getText()); //qJEP55-cnt
		assertEquals("Fail sur nom Formulaire qualité","Formulaire qualité", driver.findElement(By.xpath("//span[@class='z-tab-text']")).getText());
		formulaire.VerificationFormulaireEnregistrement(driver);
		//ACTION 4 Créer un formulaire de qualité - saisie des informations (1/3) :
		String nom_du_formulaire = "Formulaire Test 1";
		formulaire.creerFormulaireQualitePremiereSaisie(driver, nom_du_formulaire);
		//VERIFICATION saisie précédente
		formulaire.verificationCreationFormulaireQualitéPremiereSaisie(driver);
		//ACTION 5 Créer un formulaire de qualité - saisie des informations (2/3) :
		String text_formulaire1 = "Formulaire - Element 1";
		formulaire.creerFormiulaireQualiteDeuxiemeSaisie(driver, text_formulaire1, 20);
		//VERIFICATION saisie précédente
		formulaire.VerificationFormiulaireQualiteDeuxiemeSaisie(driver);
		//ACTION 6 Créer un formulaire de qualité - saisie des informations (3/3) :
		String text_formulaire2 = "Formulaire - Element 2";
		formulaire.creerFormiulaireTroisiemeSaisie(driver, text_formulaire2, 40);
		//VERIFICATION saisie précédente
		formulaire.verificationFormiulaireTroisiemeSaisie(driver, text_formulaire1, text_formulaire2);
		//ACTION 7 Enregistrement du formulaire 
		formulaire.sauveretcontinuer.click();
		//VERIFICATION Affichage du message suivant dans un cadre vert :"Formulaire qualité "Formulaire Test 1" enregistré" 
		//Le titre de la page est "Modifier Formulaire qualité: Formulaire Test 1".
		formulaire.verificationEnregistrementDuFormulaire(driver);
		//ACTION 8 Retour sur la page de gestion des formulaires qualité 
		formulaire.annuler.click();
		//VERIFICATION Retour sur la page "Formulaires qualité Liste" sur laquelle le formulaire qui vient d'être créé est affiché à la dernière ligne du tableau
		formulaire.verificationCreationDuFormulaireAuRetour(driver, nom_du_formulaire);
		//ACTION 9 Cliquer sur le nom du formulaire qui vient d'être créé dans la colonne "Nom".
		formulaire.clickSurNomDuFormulaire(driver);
		//VERIFICATION Affichage de la page "Modifier Formulaire qualité: Formulaire Test 1" contenant un onglet "Formulaire qualité".
		formulaire.VerificationAllerSurLaRedaction(driver);
		//ACTION 10 Sélectionner dans la liste déroulante "Type de formulaire qualité", la valeur "par élément".
		formulaire.Selectionner(driver);
		//VERIFICATION La colonne "Pourcentage" n'est plus affichée dans le tableau.
		formulaire.verificationAbscencePourcentage(driver);
		
		//ACTION 11 Enregistrement du formulaire 
		formulaire.enregistrer.click();
		//VERIFICATION 
		formulaire.verificationEnregistrementDuFormulaireFinal(driver,nom_du_formulaire);
		
	}
}
