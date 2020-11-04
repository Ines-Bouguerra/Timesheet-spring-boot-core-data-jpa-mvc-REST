package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.ContratService;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	
	@Autowired
	EmployeServiceImpl employeService;
	@Autowired
	ContratService contratService;
	@Autowired
	ITimesheetService iTimesheetService;
	@Autowired
	IEmployeService iEmployeService;
	@Autowired
	IEntrepriseService iEntrepriseService;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void addOrUpEmploye() throws ParseException {
		Employe employe = new Employe(2, "amine", "bousbih", "a@gmail.com", "123456l", true, Role.INGENIEUR);
		assertNotNull(iEmployeService.addOrUpdateEmploye(employe));
	
	}
	
	@Test
	public void addOrEmploye() throws ParseException {
		Employe employe = new Employe(5,"aminb", "bousbih", "a.b@gmail.com", "1234562", true, Role.INGENIEUR);
		assertNotNull(iEmployeService.ajouterEmploye(employe));
	}
	
		
	@Test
	public void updateMail() throws ParseException {
		iEmployeService.mettreAjourEmailByEmployeId("amin.bousbih@gmail.com",3);
	}
	
	@Test
	public void affectEmployDepartment() throws ParseException {
		employeService.affecterEmployeADepartement(2,1);
	}
	
	
	@Test
	public void desaffectEmployDepartment() throws ParseException {
		employeService.desaffecterEmployeDuDepartement(5,1);
	}  
	
	
	@Test
	public void addContrat() throws ParseException {
		Date date = dateFormat.parse("31/10/2020");
		Contrat contrat = new Contrat(date,"cdi",500);
		employeService.ajouterContrat(contrat);
	}
	
//	@Test
//	public void affectEmplContrat() throws ParseException {
//		employeService.affecterContratAEmploye(1,2);
//	}
	
	@Test
	public void getEmployePrenomById() throws ParseException {
		assertNotNull(employeService.getEmployePrenomById(1));

	}  

	@Test
	public void deleteEmpById() throws ParseException {
//		assertNotNull(employeService.deleteEmployeById(7));
	}   
	
		
	
	@Test
	public void deleteContById() throws ParseException {
		employeService.deleteContratById(10);
	} 
	
	
	
	
	@Test
	public void nbrEmploye() throws ParseException {
		assertNotNull(employeService.getNombreEmployeJPQL());
	} 
	
	
	

	@Test
	public void getAllEmployes() throws ParseException {
		assertNotNull(employeService.getAllEmployeNamesJPQL());
	}
	
	
	
	@Test
	public void getEmployesByEntreprise() throws ParseException {
		Entreprise entreprise = new Entreprise("esprit","education");
		iEntrepriseService.ajouterEntreprise(entreprise);
		assertNotNull(employeService.getAllEmployeByEntreprise(entreprise));
	}
	
	@Test
	public void mettreAjourEmailByEmployeIdJPQL() throws ParseException {
		employeService.mettreAjourEmailByEmployeIdJPQL("ab@gmail.com",2);
	}
	
	
	
	@Test
	public void deleteAllContratJPQL() throws ParseException {
		employeService.deleteAllContratJPQL();
	}
	
	
	
	
//	@Test
//	public void getSalaireMoyenByDepartementId() throws ParseException {
//		assertNotNull(employeService.getSalaireMoyenByDepartementId(1));
//	}
	
	
//	
//	@Test
//	public void authenticate() throws ParseException {
////		employeService.authenticate("ab@gmail.com","123456l5555");
//	}
//	
	
	
	
	
}
