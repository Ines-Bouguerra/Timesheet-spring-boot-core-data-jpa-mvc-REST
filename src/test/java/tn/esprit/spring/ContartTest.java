package tn.esprit.spring;

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


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContartRepository;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IContratServiceImpl;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContartTest {
	
	@Autowired
	IContratServiceImpl icontrat;
	
	@Autowired
	IEmployeService iemployeService;
	
	@MockBean
	ContartRepository contratrepository;
	
	
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	/*@Test
		public void getajout() throws ParseException { 
		// TEST
		Employe yasser = new Employe();
		employeService.addOrUpdateEmploye(yasser); 	
		yasser =iemployeService.findEmploye(1);
		//System.out.print(yasser.getEmail()+"yasssssssser");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(debut,"allocation",900f);
		System.out.print("tesssssssst"+contrat); 
			iemployeService.affecterContratAEmploye(4, 2);
		
	}*/
	
	

	@Test //// Test pour la methode allContrats Si elle returne 2 on valide sinon Erreur
	public void getContratTest() throws ParseException { 
		 Date debut = dateFormat.parse("21/10/2020");
		when(contratrepository.findAll()).thenReturn(Stream.of(new Contrat(debut,"Contrat de location",32F), new Contrat(debut,"Contrat de vente",440F)).collect(Collectors.toList()));
		assertEquals(2, icontrat.allContrats().size());
	}

	@Test //// Test pour la methode Ajout 
	public void saveContratTest() throws ParseException { 
		
		 Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(debut,"Contrat TEST",245F);
		when(contratrepository.save(contrat)).thenReturn(contrat);
		assertEquals(contrat, icontrat.addContart(contrat));
	}
	
	@Test
	public void deleteUserTest() throws ParseException { /// vrifier si la methode a bien ete appeler et combien de fois 
		
		 Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(debut,"Contrat TEST",245F);
		icontrat.deleteContart(contrat);
		verify(contratrepository,times(1)).delete(contrat);
	}
	
	
	
	
	

}
