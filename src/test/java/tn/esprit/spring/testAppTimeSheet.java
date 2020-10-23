package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContartRepository;
import tn.esprit.spring.services.ContratService;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testAppTimeSheet {
	@Autowired
	EmployeServiceImpl employeService;
	@Autowired
	ContratService contratService ;
	
	@MockBean
	ContartRepository contratrepository ;
	
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/*
	@Test
	public void contextLoads() throws ParseException {
		Employe yasser = new Employe("yasser","Bel Haj Ali","testmdp","yasser.belhajali@esprit.tn",true);
		employeService.addEmploye(yasser);
		 Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(debut,"Contrat a vie",32F,yasser);
		contratService.addContrat(contrat);
		}
		*/
	
	@Test //// Test pour la methode allContrats Si elle returne 2 on valide sinon Erreur
	public void getContratTest() throws ParseException { 
		Employe yasser =employeService.findEmploye(1);
		 Date debut = dateFormat.parse("21/10/2020");
		when(contratrepository.findAll()).thenReturn(Stream
				.of(new Contrat(debut,"Contrat de location",32F,yasser), new Contrat(debut,"Contrat de vente",440F,yasser)).collect(Collectors.toList()));
		assertEquals(2, contratService.allContrats().size());
	}
	
	@Test //// Test pour la methode Ajout 
	public void saveContratTest() throws ParseException { 
		Employe yasser =employeService.findEmploye(1);
		 Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(debut,"Contrat TEST",245F,yasser);
		when(contratrepository.save(contrat)).thenReturn(contrat);
		assertEquals(contrat, contratService.addContrat(contrat));
	}
	
	@Test
	public void deleteUserTest() throws ParseException { /// vrifier si la methode a bien ete appeler et combien de fois 
		Employe yasser =employeService.findEmploye(1);
		 Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(debut,"Contrat TEST",245F,yasser);
		contratService.deleteContart(contrat);
		verify(contratrepository,times(1)).delete(contrat);
	}
	
}
