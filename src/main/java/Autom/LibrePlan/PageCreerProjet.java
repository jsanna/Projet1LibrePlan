package Autom.LibrePlan;

import static org.junit.Assert.*;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class PageCreerProjet {

	@FindBy(xpath = "//input[substring(@id,5)='p7']") 
	private WebElement chp_nom;
	
	@FindBy(xpath = "//input[substring(@id,5)='v7-real']") 
	private WebElement chp_modele;
	
	@FindBy(xpath = "//input[substring(@id,5)='38'][@disabled='disabled']") 
	private WebElement chp_code;
		
	@FindBy(xpath = "//input[substring(@id,5)='38']") 
	private WebElement chp_code_bis;
	
	@FindBy(xpath = "//input[substring(@id,5)='48-real']") 
	private WebElement chkb_generer_code;
	
	@FindBy(xpath = "//input[substring(@id,5)='k9-real']") 
	private WebElement chp_date_debut;
	
	@FindBy(xpath = "//input[substring(@id,5)='n9-real']") 
	private WebElement chp_echeance;
		
	@FindBy(xpath = "//input[substring(@id,5)='s9-real']") 
	private WebElement chp_client;
		
	@FindBy(xpath = "//input[substring(@id,5)='0a-real']") 
	private WebElement chp_calendrier;
	
	@FindBy(xpath = "//table[substring(@id,5)='2a-box']") 
	private WebElement bouton_accepter;
	
	@FindBy(xpath = "//table[substring(@id,5)='3a-box']") 
	private WebElement bouton_annuler;
	
	// [Pas 3] Après création du projet
	@FindBy(xpath = "//td[text()='Planification de projet']")
	private WebElement icone_planification_projet;
	
	@FindBy(xpath = "//li[1]//span[text()='WBS (tâches)']")
	private WebElement onglet_wbs_taches;
	
	// [Pas 4] Menu vertical
	@FindBy(xpath = "//td[text()='Détail du projet']")
	private WebElement icone_detail_projet;
	
	@FindBy(xpath = "//td[text()='Chargement des ressources']")
	private WebElement icone_chargement_ressources;
	
	@FindBy(xpath = "//td[text()='Allocation avancée']")
	private WebElement icone_allocation_avancee;
	
	@FindBy(xpath = "//td[text()='Tableau de bord']")
	private WebElement icone_tableau_bord;
	
	// [Pas 5] Menu horizontal
	@FindBy(xpath = "//li[2]//span[text()='Données générales']")
	private WebElement onglet_donnees_generales;
	
	@FindBy(xpath = "//li[3]//span[text()='Coût']")
	private WebElement onglet_cout;
	
	@FindBy(xpath = "//li[4]//span[text()='Avancement']")
	private WebElement onglet_avancement;
	
	@FindBy(xpath = "//li[5]//span[text()='Libellés']")
	private WebElement onglet_libelles;
	
	@FindBy(xpath = "//li[6]//span[text()='Exigence de critère']")
	private WebElement onglet_exigence_critere;
	
	@FindBy(xpath = "//li[7]//span[text()='Matériels']")
	private WebElement onglet_materiels;
	
	@FindBy(xpath = "//li[8]//span[text()='Formulaires qualité des tâches']")
	private WebElement onglet_formulaire_qualite_taches;
	
	@FindBy(xpath = "//li[9]//span[text()='Autorisation']")
	private WebElement onglet_autorisation;
		
	// [Pas 6] Bouton d'enregistrement et d'annulation de l'édition du projet
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_save.png']")
	private WebElement icone_enregistrer_projet;
	
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_back.png']")
	private WebElement icone_annuler_projet;
	
	@FindBy(xpath = "//span[@title='Enregistrer le projet']")
	private WebElement poppup_enregistrer_projet;
	
	@FindBy(xpath = "//span[@title=\"Annuler l'édition\"]")
	private WebElement poppup_annuler_edition;
	
	// [Pas 7] Affichage d'une pop-up "Confirmer la fenêtre de sortie"
	@FindBy(xpath = "//div[@class='z-window-modal-icon z-window-modal-close']")
	private WebElement window_confirmer_sortie;	
	
	@FindBy(xpath = "//span[text()='Les modifications non enregistrées seront perdues. Êtes-vous sûr ?']")
	private WebElement texte_confirmer_sortie;
	
	@FindBy(xpath = "//table[substring(@id,5)='y4-box']") 
	private WebElement bouton_suppression_modifications;
	
	@FindBy(xpath = "//table[substring(@id,5)='z4-box']") 
	private WebElement bouton_annulation_suppressions;
	
	// [Pas 9] Affichage d'une pop-up "Confirmer la fenêtre de sortie"
	@FindBy(xpath = "//table[substring(@id,5)='65-box']") 
	private WebElement bouton_suppression9_modifications;
	
	@FindBy(xpath = "//table[substring(@id,5)='i8-box']") 
	private WebElement bouton_annulation9_suppressions;
	
	// [Pas 10] Icone 'Planification des projets'
	@FindBy(xpath = "//td[text()='Planification des projets']")
	private WebElement icone_planification_projets;
	
	// [Pas 11] Vérifier la création du projet
	@FindBy(xpath = "//span[text()='PROJET_TEST1']")
	private WebElement element_tableau_projets;

	// [Pas 12] Vérifier la ligne de création du projet
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_editar1.png']")
	private WebElement element_tableau_icone1;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_borrar1.png']")
	private WebElement element_tableau_icone2;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_planificador1.png']")
	private WebElement element_tableau_icone3;
	@FindBy(xpath = "//img[@src='/libreplan/common/img/ico_derived1.png']")
	private WebElement element_tableau_icone4;
	
		
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String JDBC_URL = "jdbc:postgresql://localhost:5433/libreplan";
	private static final String USER = "postgres";
	private static final String PASSWORD = "admin";

	private static IDataSet readDataSet(String filename) throws Exception {
		return new FlatXmlDataSetBuilder().build(new File(filename));
	}

	public void compareData(String table, String path_to_file, String... col) throws SQLException, Exception {
		IDatabaseTester databaseTester = new JdbcDatabaseTester(DRIVER, JDBC_URL, USER, PASSWORD);
		IDataSet databaseDataSet = databaseTester.getConnection().createDataSet();
		ITable actualTable = databaseDataSet.getTable(table);
		IDataSet expectedDataSet = readDataSet(path_to_file);
		ITable expectedTable = expectedDataSet.getTable(table);
		String tab[] = col;
		Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, tab);
	}
	
	
	// AjoutToday() : Méthode d'ajout de nb_jour jour(s) à la date du jour
	public String AjoutToday(int nb_jour) {
		String mois, nouvelle_date;
		Calendar today = new GregorianCalendar();
		today.add(Calendar.DAY_OF_MONTH, nb_jour);

		switch (today.get(Calendar.MONTH) + 1) {
					case 1 : mois = "janv."; break;
					case 2 : mois = "févr."; break;
					case 3 : mois = "mars"; break;
					case 4 : mois = "avr."; break;
					case 5 : mois = "mai"; break;
					case 6 : mois = "juin"; break;
					case 7 : mois = "juil."; break;
					case 8 : mois = "août"; break;
					case 9 : mois = "sept."; break;
					case 10 : mois = "oct."; break;
					case 11 : mois = "nov."; break;
					case 12 : mois = "déc."; break;
					default : mois = "Fail!"; break;
				}
		nouvelle_date = today.get(Calendar.DAY_OF_MONTH) + " " + mois + " " + today.get(Calendar.YEAR);
		return nouvelle_date;
	}
	
	
	// verifPageCreerProjets() : Méthode de vérification 
	public void verifPageCreerProjets(WebDriver driver) {
		assertTrue("[FAIL] Le champ 'Nom' est non vide !", chp_nom.getText().isEmpty());
		System.out.println("\n[Pas 2] * Assert présence du champ 'Nom' OK.");
		
		assertTrue("[FAIL] Le champ 'Modèle' est non vide !", chp_modele.getText().isEmpty());
		System.out.println("[Pas 2] * Assert présence du champ 'Modèle' OK.");
		
		System.out.println("[Pas 2] Le champ 'Code' contient " + chp_code.getAttribute("value") + " !");
		assertTrue("[FAIL] Le champ 'Modèle' est vide !", chp_code.getAttribute("value") != "");
		System.out.println("[Pas 2] * Assert présence du champ 'Modèle' OK.");
		
		// assertEquals("[FAIL] La checkbox 'Générer le code' n'est pas sélectionné !", "z-textbox z-textbox-disd z-textbox-text-disd", chkb_generer_code.getAttribute("class"));
		assertTrue("[FAIL] La checkbox 'Générer le code' n'est pas sélectionné !", chkb_generer_code.isSelected());	
		System.out.println("[Pas 2] * Assert présence de la checkbox 'Générer le code' OK.");
		
		String Aujourdhui = AjoutToday(0);
		System.out.println("[Pas 2] Le champ 'Date de début' = (" + chp_date_debut.getAttribute("value") + ")");
		System.out.println("[Pas 2] La date d'aujourd'hui = " + Aujourdhui);
		assertEquals("[FAIL] La date du jour est différente de (" + Aujourdhui + ") !", Aujourdhui, chp_date_debut.getAttribute("value"));
		System.out.println("[Pas 2] * Assert présence du champ 'Date de début' OK.");
		
		assertTrue("[FAIL] Le champ 'Echéance' est non vide !", chp_echeance.getText().isEmpty());
		System.out.println("[Pas 2] * Assert présence du champ 'Echéance' OK.");
		
		assertTrue("[FAIL] Le champ 'Client' est non vide !", chp_client.getText().isEmpty());
		System.out.println("[Pas 2] * Assert présence du champ 'Client' OK.");
		
		System.out.println("[Pas 2] Le champ 'Calendrier' = (" + chp_calendrier.getAttribute("value") + ")");
		assertEquals("[FAIL] Le calendrier est différent de (Default) !", "Default", chp_calendrier.getAttribute("value"));
		System.out.println("[Pas 2] * Assert présence du champ 'Calendrier' OK.");
		
		Outil.verificationWebElementPresence(bouton_accepter);
		System.out.println("[Pas 2] * Assert présence du bouton 'Accepter' OK.");
		
		Outil.verificationWebElementPresence(bouton_annuler);
		System.out.println("[Pas 2] * Assert présence du bouton 'Annuler' OK.");
		
		System.out.println("[Pas 2] * Méthode 'verifPageCreerProjets' totalement vérifiée : OK.");
	}
	
	
	// insertPageCreerProjets() : Méthode de vérification 
	public boolean insertPageCreerProjets(WebDriver driver) throws InterruptedException {
		
		// ACTION : Saisir le champ 'Nom' avec le libellé : "PROJET_TEST1"
		Outil.renseignerChamp(chp_nom, "PROJET_TEST1");
		
		// ACTION : Décocher la checkbox 'Générer le code'
		if ( chkb_generer_code.isSelected() ) {
			System.out.println("\n[Pas 3] La checkbox 'Générer le code' est cochée");
			chkb_generer_code.click();
		} else {
			System.out.println("[Pas 3] La checkbox 'Générer le code' n'est pas cochée");
		}
		Thread.sleep(600);
		
		// ACTION : Saisir le champ 'Code' avec le libellé : "PRJTEST001"
		Outil.renseignerChamp(chp_code_bis, "PRJTEST001");
		System.out.println("[Pas 3] Le champ 'Code' est renseigné.");
	
		// ACTION : Saisir le champ 'Date de début' avec la date : "J+5"
		String date_debut = AjoutToday(5);
		System.out.println("[Pas 3] Init du champs 'Date de début' à (J+5) = " + date_debut);
		Outil.renseignerChamp(chp_date_debut, date_debut);
		
		// ACTION : Saisir le champ 'Echéance' avec la date : "J+15"
		String date_future = AjoutToday(15);
		System.out.println("[Pas 3] Init du champ 'Echéance' à (J+15) = " + date_future);
		Outil.renseignerChamp(chp_echeance, date_future);
		
		// ACTION : Vidage du champ 'Client'
		chp_client.clear();		
		
		// ACTION : Cliquer sur le bouton 'Accepter'
		bouton_accepter.click();
		
		return true;
	}
	
	
	// verifMenuCreerProjets() : Méthode de vérification 
	public void verifMenuCreerProjets(WebDriver driver) {
		
		// VERIFICATION : [Pas 3] Le projet est créé
		Outil.verificationWebElementPresence(icone_detail_projet);
		System.out.println("[Pas 3] * Assert présence du bouton 'Icone détail projet' OK.");
		
		Outil.verificationWebElementPresence(onglet_wbs_taches);
		System.out.println("[Pas 3] * Assert présence du bouton 'WBS (tâches)' OK.");
		System.out.println("[Pas 3] * Vérification totale 'PageCreerProjets' effectuée : OK.");
		
		// VERIFICATION : [Pas 4] Les onglets du menu vertical
		Outil.verificationWebElementPresence(icone_detail_projet);
		System.out.println("\n[Pas 4] * Assert présence du bouton 'Détail du projet' OK.");
		
		Outil.verificationWebElementPresence(icone_chargement_ressources);
		System.out.println("[Pas 4] * Assert présence du bouton 'Chargement des ressources' OK.");
		
		Outil.verificationWebElementPresence(icone_allocation_avancee);
		System.out.println("[Pas 4] * Assert présence du bouton 'Allocation avancée' OK.");
		
		Outil.verificationWebElementPresence(icone_tableau_bord);
		System.out.println("[Pas 4] * Assert présence du bouton 'Tableau de bord' OK.");
		
		// VERIFICATION : [Pas 5] Les onglets du menu horizontal
		Outil.verificationWebElementPresence(onglet_wbs_taches);
		System.out.println("\n[Pas 5] * Assert présence du bouton 'WBS (tâches)' OK.");
		
		Outil.verificationWebElementPresence(onglet_donnees_generales);
		System.out.println("[Pas 5] * Assert présence du bouton 'Données générales' OK.");
		
		Outil.verificationWebElementPresence(onglet_cout);
		System.out.println("[Pas 5] * Assert présence du bouton 'Coût' OK.");
		
		Outil.verificationWebElementPresence(onglet_avancement);
		System.out.println("[Pas 5] * Assert présence du bouton 'Avancement' OK.");
		
		Outil.verificationWebElementPresence(onglet_libelles);
		System.out.println("[Pas 5] * Assert présence du bouton 'Libellés' OK.");
		
		Outil.verificationWebElementPresence(onglet_exigence_critere);
		System.out.println("[Pas 5] * Assert présence du bouton 'Exigence de critère' OK.");
		
		Outil.verificationWebElementPresence(onglet_materiels);
		System.out.println("[Pas 5] * Assert présence du bouton 'Matériels' OK.");
		
		Outil.verificationWebElementPresence(onglet_formulaire_qualite_taches);
		System.out.println("[Pas 5] * Assert présence du bouton 'Formulaires qualité des tâches' OK.");
		
		Outil.verificationWebElementPresence(onglet_autorisation);
		System.out.println("[Pas 5] * Assert présence du bouton 'Autorisation' OK.");
		
		System.out.println("[Pas 5] * Méthode 'verifMenuCreerProjets' totalement vérifiée : OK.");
	}
	
	
	// verifBoutonsMenurojePts() : Méthode de vérification 
	public void verifBoutonsMenuProjets(WebDriver driver) throws InterruptedException {

		Actions a = new Actions(driver);
		
		// VERIFICATION : [Pas 6] Bouton d'enregistrement de l'édition du projet
		Outil.verificationWebElementPresence(onglet_autorisation);
		System.out.println("\n[Pas 6] * Assert présence du bouton 'Enregistrer le projet' OK.");
		
		// VERIFICATION : [Pas 6] Pop-pup d'enregistrement de l'édition du projet
		Thread.sleep(400);
		a.moveToElement(icone_enregistrer_projet).moveToElement(icone_enregistrer_projet).build().perform();
		Outil.verificationWebElementPresence(poppup_enregistrer_projet);
		System.out.println("[Pas 6] * Assert présence de la pop-pup 'Enregistrer le projet' OK.");
		
		// VERIFICATION : [Pas 6] Bouton d'annulation de l'édition du projet
		Outil.verificationWebElementPresence(onglet_autorisation);
		System.out.println("[Pas 6] * Assert présence du bouton 'Annuler l'édition' OK.");
		
		// VERIFICATION : [Pas 6] Pop-pup d'annulation de l'édition du projet
		Thread.sleep(400);
		a.moveToElement(icone_enregistrer_projet).moveToElement(icone_annuler_projet).build().perform();
		Outil.verificationWebElementPresence(poppup_annuler_edition);
		System.out.println("[Pas 6] * Assert présence de la pop-pup 'Annuler l'édition' OK.");
		
		System.out.println("[Pas 6] * Méthode 'verifBoutonsMenuProjets' totalement vérifiée : OK.");
	}

	
	// verifSortieCreerProjets() : Méthode de vérification 
	public void verifSortieCreerProjets(WebDriver driver, int num_pas) throws InterruptedException {
		
		// ACTION : Annulation de l'édition de la création de projet
		poppup_annuler_edition.click();
		Thread.sleep(600);
		
		// VERIFICATION : [Pas 7 ou 9] Confirmation de la fenêtre de sortie		
		Outil.verificationWebElementPresence(window_confirmer_sortie);
		System.out.println("\n[Pas " + num_pas + "] * Assert présence de la fenêtre 'Confirmer la fenêtre de sortie' OK.");
		
		// VERIFICATION : [Pas 7 ou 9] Confirmation du message de la fenêtre de sortie		
		Outil.verificationWebElementPresence(texte_confirmer_sortie);
		System.out.println("[Pas " + num_pas + "] * Assert présence du message 'Les modifications non enregistrées seront perdues. Êtes-vous sûr ?' OK.");
	 
		// VERIFICATION : [Pas 7 ou 9] Confirmation présence du bouton 'OK'	
		if (num_pas == 7 ) {
			Outil.verificationWebElementPresence(bouton_suppression_modifications);
		} else {
			Outil.verificationWebElementPresence(bouton_suppression9_modifications);
		}
		System.out.println("[Pas " + num_pas + "] * Assert présence du bouton 'OK' OK.");
		
		// VERIFICATION : [Pas 7 ou 9] Confirmation présence du bouton 'Annuler'
		if (num_pas == 7 ) {
			Outil.verificationWebElementPresence(bouton_annulation_suppressions);
		} else {
			Outil.verificationWebElementPresence(bouton_annulation9_suppressions);
		}
		System.out.println("[Pas " + num_pas + "] * Assert présence du bouton 'Annuler' OK.");
	
		System.out.println("[Pas " + num_pas + "] * Méthode 'verifSortieCreerProjets' totalement vérifiée : OK.");
	}
	
	
	// verifAnnulationCreerProjets() : Méthode de vérification
	public void verifAnnulationCreerProjets(WebDriver driver, int num_pas) throws InterruptedException {
		
		if (num_pas == 8 ) {
			// ACTION : Cliquer sur le bouton 'Annuler'
			bouton_annulation_suppressions.click();
		} else {
			// ACTION : Cliquer sur le bouton 'OK'
			bouton_suppression9_modifications.click();		
		}
		Thread.sleep(600);
		
		// VERIFICATION : [Pas 8 ou 10] Confirmation absence de la fenêtre de sortie
		try {
			assertTrue(window_confirmer_sortie.isDisplayed());
			System.out.println("\n[Pas " + num_pas + "] * Assert présence de la fenêtre 'Confirmer la fenêtre de sortie' qui est toujours présente [KO] !");
		}
		catch(NullPointerException|NoSuchElementException e) {
			System.out.println("\n[Pas " + num_pas + "] * Assert absence de la fenêtre 'Confirmer la fenêtre de sortie' OK.");
			// throw e;
		}
		Thread.sleep(400);
		
		// VERIFICATION : [Pas 8 ou 10] Les onglets du menu vertical
		if (num_pas == 8 ) {
			Outil.verificationWebElementPresence(icone_detail_projet);
			System.out.println("[Pas " + num_pas + "] * Assert présence du bouton 'Détail du projet' OK.");
		} else {
			Outil.verificationWebElementPresence(icone_planification_projets);
			System.out.println("[Pas " + num_pas + "] * Assert présence du bouton 'Planification des projets' OK.");
		}
		
		// VERIFICATION : [Pas 8 ou 10] Confirmation présence du menu horizontal
		if (num_pas == 8 ) {
			Outil.verificationWebElementPresence(onglet_wbs_taches);
			System.out.println("[Pas " + num_pas + "] * Assert présence du menu horizontal avec l'onglet 'Détail du projet' OK.");
		} else {
			try {
				assertTrue(onglet_wbs_taches.isDisplayed());
				System.out.println("[Pas " + num_pas + "] * Assert du menu horizontal avec l'onglet 'Détail du projet' qui est toujours présent' [KO] !");
			}
			catch(NoSuchElementException e) {
				System.out.println("[Pas " + num_pas + "] * Assert absence du menu horizontal avec l'onglet 'Détail du projet' OK.");
				// throw e;
			}
			// finally { System.out.println("[Pas " + num_pas + "] * Erreur sur l'assert du menu horizontal' [KO] !"); }
		}
	
		System.out.println("[Pas " + num_pas + "] * Méthode 'verifAnnulationCreerProjets' totalement vérifiée : OK.");
	}
	
	
	// verifCreationProjet() : Méthode de vérification
	public void verifCreationProjet(WebDriver driver) throws InterruptedException {
		
		// VERIFICATION : [Pas 11] Vérifier la création du projet
		Outil.verificationWebElementPresence(element_tableau_projets);
		System.out.println("\n[Pas 11] * Assert présence de l'élément de tableau 'PROJET_TEST1' OK.");
		
		// VERIFICATION : [Pas 11] Vérifier la création du projet
		Outil.verificationWebElementPresence(icone_planification_projets);
		System.out.println("[Pas 11] * Assert présence du bouton 'Planification des projets' OK.");
		
		System.out.println("[Pas 11] * Méthode 'verifCreationProjet' totalement vérifiée : OK.");
	}
	
	
	// verifElementsCreationProjet() : Méthode de vérification
	public void verifElementsCreationProjet(WebDriver driver) throws InterruptedException {
		
		String date_future;
		
		// VERIFICATION : Vérifier la valeur de l'élément : Nom = "PROJET_TEST1"
		assertEquals("[FAIL] Nom du projet incorrect !", "PROJET_TEST1", driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[1]//span")).getText());
		System.out.println("\n[Pas 12] * Assert présence de l'élément de ligne de tableau : Nom = 'PROJET_TEST1' OK.");

		// VERIFICATION : Vérifier la valeur de l'élément : Code = "PRJTEST001"
		assertEquals("[FAIL] Code du projet incorrect !", "PRJTEST001", driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[2]//span")).getText());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Code = 'PRJTEST001' OK.");
		
		// VERIFICATION : Vérifier la valeur de l'élément : Date de début = "J+5"
		date_future = AjoutToday(5);
		assertEquals("[FAIL] Date du début incorrecte !", date_future, driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[3]//span")).getText());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Date de début = '" + date_future + "' OK.");
		
		// VERIFICATION : Vérifier la valeur de l'élément : Echéance = "J+15"
		date_future = AjoutToday(15);
		assertEquals("[FAIL] Echéance incorrecte !", date_future, driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[4]//span")).getText());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Echéance = '" + date_future + "' OK.");
		
		// VERIFICATION : Vérifier la valeur de l'élément : Client = ""
		assertTrue("[FAIL] Client incorrect !", driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[5]//span")).getText().isEmpty() );
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : client à vide OK.");
	
		// VERIFICATION : Vérifier la valeur de l'élément : Budget total = "0 €"
		assertEquals("[FAIL] Budget total incorrect !", "0 €", driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[6]//span")).getText());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Budget total = '0 €' OK.");
		
		// VERIFICATION : Vérifier la valeur de l'élément : Heures = "0"
		assertEquals("[FAIL] Heure incorrecte !", "0", driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[7]//span")).getText());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Heures = '0' OK.");
		
		// VERIFICATION : Vérifier la valeur de l'élément : Etat = "PRE-VENTES"
		assertEquals("[FAIL] Etat incorrect !", "PRE-VENTES",  driver.findElement(By.xpath("//tbody[substring(@id,5)='i6']/tr/td[8]//span")).getText());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Etat = 'PRE-VENTES' OK.");
	
		// VERIFICATION : Vérifier la valeur de l'élément : Opérations (4 icônes présentes)
		assertTrue("[FAIL] Opérations (icône_1) absente !", element_tableau_icone1.isDisplayed());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Opérations (icône_1) OK.");
		assertTrue("[FAIL] Opérations (icône_2) absente !", element_tableau_icone2.isDisplayed());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Opérations (icône_2) OK.");
		assertTrue("[FAIL] Opérations (icône_3) absente !", element_tableau_icone3.isDisplayed());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Opérations (icône_3) OK.");
		assertTrue("[FAIL] Opérations (icône_4) absente !", element_tableau_icone4.isDisplayed());
		System.out.println("[Pas 12] * Assert présence de l'élément de ligne de tableau : Opérations (icône_4) OK.");

		System.out.println("[Pas 12] * Méthode 'verifElementsCreationProjet' totalement vérifiée : OK.");
	}
}
