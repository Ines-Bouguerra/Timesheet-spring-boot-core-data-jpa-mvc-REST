package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {

	@Autowired
	EntrepriseServiceImpl entrepriseService;
	
	@Autowired
	IEmployeService iEmployeService;
	
	
	@Test
public void getajout() throws ParseException { 
		
		Employe yasser = new Employe();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(1,debut,"location",23f);
		System.out.print("tesssssssst"+contrat);
		iEmployeService.ajouterContrat(contrat);
		
		
	}
	
	
	
	@Test
	public void ajouterEntreprise() throws ParseException{
		
		Entreprise  entreprise = new Entreprise("TELNET","SCIENCE") ;
		entrepriseService.ajouterEntreprise(entreprise);
	}
	
	 
	
	@Test
	public void ajouterDepartement() throws ParseException{
//		Departement departement = new Departement("Embarqué");
//		entrepriseService.ajouterDepartement(departement);
	}
	
	
	@Test
	public void affecterDepartementAEntreprise()throws ParseException{
		
//		entrepriseService.affecterDepartementAEntreprise(1,4);
				}
	
	
	@Test
	public void getAllDepartementsNamesByEntreprise() throws ParseException{
//		entrepriseService.getAllDepartementsNamesByEntreprise(1);
	}
	
	
	
	@Test
	public void deleteEntrepriseById() throws ParseException{
		entrepriseService.deleteEntrepriseById(5);
	}
	
	
	@Test
	public void deleteDepartementById() throws ParseException{
//		entrepriseService.deleteDepartementById(2);
	}
	
	@Test
	public void getEntrepriseById() throws ParseException{
//		entrepriseService.getEntrepriseById(2);
	}
	
	
}

