package Autom.LibrePlan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.List;

public class PageTypeAvancement extends PageMenu {
	@FindBy(xpath = "//div[substring(@id,5)='j4-cap']")
	private WebElement nom_type_avance;
	@FindBy(xpath = "//tr[substring(@id,5)='m4']/th/div")
	private List<WebElement> nom_tableau_types;
	@FindBy(xpath = "//td[text()='Créer']")
	WebElement bouton_creer;
	@FindBy(xpath = "//td[substring(@id,8)='cnt']")
	WebElement nom_creer_type;
	@FindBy(xpath = "//span[text()='Modifier']")
	WebElement nom_modifier;
	@FindBy(xpath = "//tbody[substring(@id,5)='25']/descendant::*[substring(@id,8)='chdextr']")
	private List<WebElement> tableau_modif;
	@FindBy(xpath = "//td[contains(.,'Enregistrer')]")
	WebElement bouton_enregistrer;
	@FindBy(xpath = "//td[contains(.,'Sauver et continuer')]")
	WebElement bouton_sauver_continuer;
	@FindBy(xpath = "//td[contains(.,'Annuler')]")
	WebElement bouton_annuler;
	@FindBy(xpath = "//input[substring(@id,5)='85-real']")
	WebElement checkbox_actif;
	@FindBy(xpath = "//input[substring(@id,5)='k5-real']")
	WebElement checkbox_pourcentage;
	@FindBy(xpath = "//tbody/descendant::*[@class='message_INFO']")
	WebElement message;
	@FindBy(xpath = "//div[substring(@id,5)='27']")
	WebElement message2;
	@FindBy(xpath = "//tbody[substring(@id,5)='o5']/tr")
	private List<WebElement> types_crees;

	public void verificationPage(WebDriver driver) {
		/*
		 * Affichage de la page "Types d'avancement Liste" contenant : - un tableau avec
		 * les colonnes suivantes : Nom Activé Prédéfini Opérations - un bouton [Créer]
		 */

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.textToBePresentInElement(nom_type_avance, "Types d'avancement Liste"));
		assertEquals("Types d'avancement Liste", nom_type_avance.getText());
		assertEquals("Nom", nom_tableau_types.get(0).getText());
		assertEquals("Activé", nom_tableau_types.get(1).getText());
		assertEquals("Prédéfini", nom_tableau_types.get(2).getText());
		assertEquals("Opérations", nom_tableau_types.get(3).getText());
		assertTrue(bouton_creer.isDisplayed());

	}

	public void verifAffichageCreerTypeAvancement(WebDriver driver) {
		/*
		 * Affichage de la page "Créer Type d'avancement". La page contient : * - un
		 * tableau intitulé "Modifier" avec les éléments suivants : * Nom d'unité :
		 * champ de saisie non renseigné Actif : case à* cocher cochée par défaut Valeur
		 * maximum par défaut : champ de saisie avec pour valeur par défaut "100,00"
		 * Précision : champ de saisie avec pour valeur par défaut "0,1000" Type :
		 * Valeur non modifiable "User" Pourcentage : case à cocher décochée par défaut
		 * - les boutons [Enregistrer], [Sauver et continuer] et [Annuler].
		 */
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(nom_creer_type.isDisplayed());
		assertTrue(nom_modifier.isDisplayed());
		assertEquals("Nom d'unité", tableau_modif.get(0).getText());
		assertEquals("", tableau_modif.get(1).getText());
		assertEquals("Actif", tableau_modif.get(2).getText());
		assertTrue("FAIL Actif n'est pas coché", checkbox_actif.isSelected());

		assertEquals("Valeur maximum par défaut", tableau_modif.get(4).getText());
		assertEquals("Précision", tableau_modif.get(6).getText());
		// z-decimalbox
		assertEquals("z-decimalbox",
				tableau_modif.get(5).findElement(By.xpath("descendant::input")).getAttribute("class"));
		assertEquals("z-decimalbox",
				tableau_modif.get(7).findElement(By.xpath("descendant::input")).getAttribute("class"));
		assertEquals("span", tableau_modif.get(9).findElement(By.xpath("*/*")).getTagName());
		assertFalse("FAIL pourcentage est coché", checkbox_pourcentage.isSelected());

		assertTrue(bouton_enregistrer.isDisplayed());
		assertTrue(bouton_sauver_continuer.isDisplayed());
		assertTrue(bouton_annuler.isDisplayed());

	}

	public void creerTypeAvancementSansPourcentage(WebDriver driver, String nom) {
		/*
		 * Créer un type d'avancement - sans pourcentage : 1 - Renseigner les éléments
		 * du tableau "Modifier" avec les valeurs suivantes Nom d'unité : Type
		 * avancement - Test 1 Actif : décocher la case Valeur maximum par défaut :
		 * saisir la valeur "10,00" Précision : laisser la valeur * par défaut Type :
		 * Valeur non modifiable "User" Pourcentage : ne pas cocher la case 2 - Cliquer
		 * sur le bouton [Enregistrer].
		 */
		Outil.renseignerChamp(tableau_modif.get(1).findElement(By.xpath("descendant::input")), nom);
		checkbox_actif.click();
		Outil.renseignerChamp(tableau_modif.get(5).findElement(By.xpath("descendant::input")), "10");
		bouton_enregistrer.click();

	}

	public int retournerNumeroDeLigneDansRolesCrees(String mot_recherche) {
		int ligneCourante = 0;
		for (WebElement ligne : types_crees) {
			List<WebElement> cases = ligne.findElements(By.xpath("td"));
			if (cases.get(0).findElement(By.xpath("descendant::span")).getText().trim().equals(mot_recherche)) {
				return ligneCourante;
			}
			ligneCourante++;

		}
		return -1;
	}

	public void verifcreerTypeAvancementSansPourcentage(WebDriver driver, String nom) {
		/*
		 * Retour sur la page "Types d'avancement Liste" sur laquelle : - le message
		 * suivant est affiché : "Type d'avancement "Type avancement - Test
		 * 1" enregistré" - le type d'avancement créé "Type avancement - Test 1"
		 * enregistré" est présent dans le tableau avec : Nom : Type avancement - Test 1
		 * Activé : Case décochée et non modifiable Prédéfini : Case décochée et non
		 * modifiable Opérations : colonne contenant une icône "Modifier" et "Supprimer"
		 */
		Outil.verificationTextWebElement("Type d'avancement \"" + nom + "\" enregistré", message);
		List<WebElement> cases = types_crees.get(retournerNumeroDeLigneDansRolesCrees(nom))
				.findElements(By.xpath("td"));
		assertEquals(nom, cases.get(0).getText());
		assertFalse(cases.get(1).findElement(By.xpath("descendant::input")).isSelected());
		assertFalse(cases.get(2).findElement(By.xpath("descendant::input")).isSelected());
		assertEquals("true", cases.get(1).findElement(By.xpath("descendant::input")).getAttribute("disabled"));
		assertEquals("true", cases.get(2).findElement(By.xpath("descendant::input")).getAttribute("disabled"));
		// descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/..
		// descendant::*[@src='/libreplan/common/img/ico_editar1.png']/..
		assertTrue(cases.get(3).findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_editar1.png']"))
				.isDisplayed());
		assertTrue(cases.get(3).findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_editar1.png']"))
				.isDisplayed());

	}

	public void verifAccesFormulaire(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(nom_creer_type));
		assertTrue(nom_creer_type.isDisplayed());
		assertTrue(nom_modifier.isDisplayed());
	}

	public void creerTypeSansPourcentage1de2(String nom) {
		/*
		 * Créer un type d'avancement - sans pourcentage (1/2) : Dans le tableau
		 * "Modifier" : 1 - Renseigner le champ "Nom d'unité" avec la valeur
		 * "Type avancement - Test 2". 2 - Cocher la case "Pourcentage".
		 */
		Outil.renseignerChamp(tableau_modif.get(1).findElement(By.xpath("descendant::input")), nom);
		checkbox_pourcentage.click();
	}

	public void verif1de2() {
		/*
		 * Le champ de saisie "Valeur maximum par défaut" est grisé et non modifiable.
		 */
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(null, tableau_modif.get(4).getAttribute("disabled"));
	}

	public void verif2de2(String nom) {
		/*
		 * Affichage du message suivant "Type d'avancement "Type d'avancement - Test
		 * 2" enregistré"
		 * Le titre de la page est
		 * "Modifier Type d'avancement: Type d'avancement - Test 2".
		 */
		Outil.verificationTextWebElement("Type d'avancement \"" + nom + "\" enregistré", message2);
		Outil.verificationTextWebElement("Modifier Type d'avancement: "+nom, nom_creer_type);
		
	}
	public void verif8(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.textToBePresentInElement(nom_type_avance, "Types d'avancement Liste"));
		assertEquals("Types d'avancement Liste", nom_type_avance.getText());
	}
	public void action9() {
		try {
		bouton_annuler.click();
		}
		catch (Exception e) {}
	}
	public void verif9(WebDriver driver, String nom) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Outil.verificationTextWebElement("Type d'avancement \"" + nom + "\" enregistré", message2);
		List<WebElement> cases = types_crees.get(retournerNumeroDeLigneDansRolesCrees(nom))
				.findElements(By.xpath("td"));
		assertEquals(nom, cases.get(0).getText());
		assertTrue(cases.get(1).findElement(By.xpath("descendant::input")).isSelected());
		assertFalse(cases.get(2).findElement(By.xpath("descendant::input")).isSelected());
		assertEquals("true", cases.get(1).findElement(By.xpath("descendant::input")).getAttribute("disabled"));
		assertEquals("true", cases.get(2).findElement(By.xpath("descendant::input")).getAttribute("disabled"));
		// descendant::*[@src='/libreplan/common/img/ico_borrar1.png']/..
		// descendant::*[@src='/libreplan/common/img/ico_editar1.png']/..
		assertTrue(cases.get(3).findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_editar1.png']"))
				.isDisplayed());
		assertTrue(cases.get(3).findElement(By.xpath("descendant::*[@src='/libreplan/common/img/ico_editar1.png']"))
				.isDisplayed());
	}

}
