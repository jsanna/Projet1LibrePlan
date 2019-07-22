package Autom.LibrePlan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormulaireQualite {
	/*
	 * Cliquer sur le bouton [Créer].
	 *
	 * 
	 * un formulaire de saisie des caractéristiques du formulaire de qualité
	 * comportant les éléments suivants :
	 * 
	 * Nom : champ de saisie non renseigné Description : champ de saisie non
	 * renseigné Type de formulaire qualité : liste déroulante contenant les valeurs
	 * "par pourcentage" et "par élément". La valeur affichée par défaut est
	 * "par pourcentage". Avancement du rapport : case à cocher décochée par défaut
	 */

	@FindBy(xpath = "//tr[substring(@id,5)='t4']/th/div")
	private List<WebElement> tableau_donnees;
	@FindBy(xpath = "//span[@class ='create-button global-action z-button']")
	public WebElement bouton_creer;
	
	//"Modifier Formulaire qualité: Formulaire Test 1".
	@FindBy(xpath = "//td[substring(@id,8)='cnt']")
	WebElement modif_formulaire;
	@FindBy(xpath = "//span[@class='z-tab-text']")
	WebElement formulaire_qualite;
	@FindBy(xpath = "//tbody[substring(@id,5)='h5']/descendant::*[substring(@id,8)='chdextr']")
	private List<WebElement> tableau_creation;
	@FindBy(xpath = "//div[substring(@id,5) ='_6-head']/table/tbody[2]/tr")
	private List<WebElement> tableau_liste_delements;
	@FindBy(xpath = "//td[text()='Enregistrer']")
	WebElement enregistrer;
	@FindBy(xpath = "//td[text()='Sauver et continuer']")
	WebElement sauveretcontinuer;
	@FindBy(xpath = "//td[text()='Annuler']")
	WebElement annuler;
	@FindBy(xpath = "//td[@class='z-button-cm'][contains(.,'Nouvel élément du formulaire qualité')]")
	WebElement nouvel_element;
	@FindBy(xpath = "//*[substring(@id,5)='56']/tr")
	List<WebElement> liste_delements_formulaire_qualite;
	@FindBy(xpath = "//tbody/descendant::*[@class='message_INFO']")
	WebElement message;
	@FindBy(xpath = "//*[substring(@id,5)='x4']/tr")
	List<WebElement> formulaires_crees;
	@FindBy(xpath = "//div[substring(@id,5)='j4-cap']")
	WebElement formulaire_qualite_liste;
	public void VerificationFormulaireQualiteListe(WebDriver driver) {
		assertFalse(tableau_donnees.isEmpty());
		assertEquals("FAIL tableau n'a pas le meme quantite de colonnes", 3, tableau_donnees.size());
		Outil.verificationTextWebElement("Nom", tableau_donnees.get(0));
		Outil.verificationTextWebElement("Description", tableau_donnees.get(1));
		Outil.verificationTextWebElement("Opérations", tableau_donnees.get(2));
	}

	public void VerificationFormulaireEnregistrement(WebDriver driver) {
		System.out.println(tableau_creation.get(1).getText());
		assertTrue("FAIL champ Nom pas vide", tableau_creation.get(1).getText().isEmpty());

		assertTrue("FAIL champ Description pas vide", tableau_creation.get(3).getText().trim().isEmpty());
		//// td[substring(@id,8)='chdextr']/div/select

		Select menu = new Select(tableau_creation.get(5).findElement(By.xpath("div/select")));
		// System.out.println(menu.getFirstSelectedOption().getText());
		Outil.verificationTextWebElement("par pourcentage", menu.getOptions().get(0));
		Outil.verificationTextWebElement("par élément", menu.getOptions().get(1));
		assertEquals("FAIL Type de formulaire qualité option1 par pourcentage est pas coché", "par pourcentage",
				menu.getFirstSelectedOption().getText());
		// Checkbox //td[substring(@id,8)='chdextr']/div/span/input/label
		assertFalse("FAIL Avancement du rapport est coché",
				driver.findElement(By.xpath("//input[substring(@id,5)='v5-real']")).isSelected());
		// Liste d'éléments du formulaire qualité
		Outil.verificationTextWebElement("Liste d'éléments du formulaire qualité",
				driver.findElement(By.xpath("//div[substring(@id,8)='cap'][@class='z-panel-header ']")));
		// bouton [Nouvel élément du formulaire qualité]
		assertTrue(nouvel_element.isDisplayed());
		// Tableau Liste d'éléments du formulaire qualité (récuperer les lignes)
		// //div[substring(@id,5) ='_6-head']

		// Verifier que il n'y a pas de lignes avec de contenu
		assertEquals("FAIL Tableau Liste d'éléments du formulaire qualité n'est pas vide", 1,
				tableau_liste_delements.size());
		Outil.verificationTextWebElement("Nom\nPosition\nPourcentage\nOpérations", tableau_liste_delements.get(0));

		assertTrue(enregistrer.isDisplayed());
		assertTrue(sauveretcontinuer.isDisplayed());
		assertTrue(annuler.isDisplayed());
		tableau_creation.clear();
	}

	public void creerFormulaireQualitePremiereSaisie(WebDriver driver, String nom) {
		// 1 - Renseigner les éléments du formulaire avec les valeurs suivantes :

		Outil.renseignerChamp(tableau_creation.get(1).findElement(By.xpath("div/input")), nom);
		Outil.renseignerChamp(tableau_creation.get(3).findElement(By.xpath("div/textarea")), nom);
		Select menu = new Select(tableau_creation.get(5).findElement(By.xpath("div/select")));
		menu.getOptions().get(0).click();
		// CLICK POUR COCHER
		// driver.findElement(By.xpath("//input[substring(@id,5)='v5-real']")).click();
		// 2 - Dans le bloc "Liste d'éléments du formulaire qualité", cliquer sur le
		// bouton [Nouvel élément du formulaire qualité]*/
		nouvel_element.click();

	}

	public void verificationCreationFormulaireQualitéPremiereSaisie(WebDriver driver) {
		// XPATH HINT /descendant::button[contains(.,'"+ title.trim()+"')]/..

		// - Nom : champ de saisie non renseigné
		assertTrue(liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::input[1]")).getText()
				.isEmpty());
		// - Position : renseigné avec la valeur "1"
		assertEquals("1",
				liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::span[1]")).getText());

		// - Pourcentage : champ de saisie non renseigné
		assertTrue(liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::input[2]")).getText()
				.isEmpty());
		// - Opérations : une icône (poubelle) de suppression
		assertTrue(
				liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::span[4]")).isDisplayed());
	}

	public void creerFormiulaireQualiteDeuxiemeSaisie(WebDriver driver, String nom, int pourcentage) {
		// 1 - Pour la ligne à renseigner dans le tableau du bloc "Liste d'éléments du
		// formulaire qualité", saisir les valeurs pour les champs suivants :

		// - Nom : Formulaire - Element 1 - Pourcentage : 20

		// 2 - Cliquer sur le bouton [Nouvel élément du formulaire qualité]

		Outil.renseignerChamp(liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::input[1]")),
				nom);
		Outil.renseignerChamp(liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::input[2]")),
				"" + pourcentage);
		nouvel_element.click();
		liste_delements_formulaire_qualite.clear();
	}

	public void VerificationFormiulaireQualiteDeuxiemeSaisie(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[substring(@id,5)='56']/tr[2]"))));
		assertEquals("1",
				liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::span[1]")).getText());
		assertEquals("2",
				liste_delements_formulaire_qualite.get(1).findElement(By.xpath("descendant::span[1]")).getText());
	}

	public void creerFormiulaireTroisiemeSaisie(WebDriver driver, String nom, int pourcentage) {
		/*
		 * 1 - Pour la ligne à renseigner dans le tableau du bloc
		 * "Liste d'éléments du formulaire qualité", saisir les valeurs pour les champs
		 * suivants : - Nom : Formulaire - Element 2 - Pourcentage : 40 2 - Faire un
		 * clic de souris en dehors du tableau et du formulaire.
		 */

		Outil.renseignerChamp(liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::input[1]")),
				nom);
		Outil.renseignerChamp(liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::input[2]")),
				"" + pourcentage);
		
		liste_delements_formulaire_qualite.clear();
	}

	public void verificationFormiulaireTroisiemeSaisie(WebDriver driver, String formulaire1, String formulaire2) {
		/*
		 * La valeur de la colonne "Position" pour ces lignes est : - Ligne
		 * "Formulaire - Element 1" -> "Position" = "1" - Ligne "Formulaire - Element 2"
		 * -> "Position" = "2"
		 */
		// WebDriverWait wait = new WebDriverWait(driver,2);
		// wait.until(ExpectedConditions.attributeContains(By.xpath("descendant::input[1]"),
		// "Value", formulaire1));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(formulaire1, liste_delements_formulaire_qualite.get(0)
				.findElement(By.xpath("descendant::input[1]")).getAttribute("Value"));
		assertEquals(formulaire2, liste_delements_formulaire_qualite.get(1)
				.findElement(By.xpath("descendant::input[1]")).getAttribute("Value"));
		assertEquals("1",
				liste_delements_formulaire_qualite.get(0).findElement(By.xpath("descendant::span[1]")).getText());
		assertEquals("2",
				liste_delements_formulaire_qualite.get(1).findElement(By.xpath("descendant::span[1]")).getText());
		liste_delements_formulaire_qualite.clear();
	}

	public void verificationEnregistrementDuFormulaire(WebDriver driver) {
		/*
		 * Affichage du message suivant dans un cadre vert :
		 * 
		 * "Formulaire qualité "Formulaire Test 1" enregistré" Le titre de la page est
		 * "Modifier Formulaire qualité: Formulaire Test 1".
		 */
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.textToBePresentInElement(modif_formulaire,
				"Modifier Formulaire qualité: Formulaire Test 1"));
		// Thread.sleep(millis);
		assertEquals("Modifier Formulaire qualité: Formulaire Test 1", modif_formulaire.getText());
		assertEquals("Formulaire qualité \"Formulaire Test 1\" enregistré", message.getText());
	}

	public void verificationCreationDuFormulaireAuRetour(WebDriver driver, String nom) {
		/*
		 * VERIFICATION Retour sur la page "Formulaires qualité Liste" sur laquelle le
		 * formulaire qui vient d'être créé est affiché à la dernière ligne du tableau
		 */

		// Formulaires qualité Liste
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.textToBePresentInElement(formulaire_qualite_liste, "Formulaires qualité Liste"));
		assertEquals("Formulaires qualité Liste", formulaire_qualite_liste.getText());
		assertTrue(formulaire_qualite_liste.isDisplayed());
		assertEquals(nom, formulaires_crees.get(0).findElement(By.xpath("td[1]/descendant::span")).getText());
		assertEquals(nom, formulaires_crees.get(0).findElement(By.xpath("td[2]/descendant::span")).getText());

	}
	public void clickSurNomDuFormulaire(WebDriver driver) {
		formulaires_crees.get(0).findElement(By.xpath("td[1]/descendant::span")).click();
	}
  public void VerificationAllerSurLaRedaction(WebDriver driver){
	//  Affichage de la page "Modifier Formulaire qualité: Formulaire Test 1" 
	  //contenant un onglet "Formulaire qualité".
	  WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.textToBePresentInElement(modif_formulaire,
				"Modifier Formulaire qualité: Formulaire Test 1"));
	  assertTrue(modif_formulaire.isDisplayed());
	  assertTrue(formulaire_qualite.isDisplayed());
	  
  }
  public void Selectionner (WebDriver driver) {
	  Select menu = new Select(tableau_creation.get(5).findElement(By.xpath("div/select")));
	  menu.getOptions().get(1).click();
	  tableau_liste_delements.clear();
	    }
  public void verificationAbscencePourcentage(WebDriver driver) {
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		assertEquals("display: none; width: 180px;",tableau_liste_delements.get(0).findElement(By.xpath("th[3]")).getAttribute("style"));
	  
  }
  public void verificationEnregistrementDuFormulaireFinal (WebDriver driver, String nom_du_formulaire) {
	  WebDriverWait wait = new WebDriverWait(driver, 3);
	  wait.until(ExpectedConditions.textToBePresentInElement(message, "Formulaire qualité \"Formulaire Test 1\" enregistré"));
	  assertEquals("Formulaire qualité \"Formulaire Test 1\" enregistré", message.getText());
	  assertEquals(1,formulaires_crees.size());
	// wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//td[1]/div/span[text()='Formulaire Test 1']")), nom_du_formulaire));
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  assertEquals(nom_du_formulaire,formulaires_crees.get(0).findElement(By.xpath("td[1]/descendant::span")).getText());
	  assertEquals(nom_du_formulaire,formulaires_crees.get(0).findElement(By.xpath("td[2]/descendant::span")).getText());
	  
  }
  
}
