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
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.ContratService;
import tn.esprit.spring.services.EmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testAppTimeSheet {
	@Autowired
	EmployeService employeService;
	@Autowired
	ContratService contratService ;
	
	@Test
	public void contextLoads() throws ParseException {
		/*
		Employe yasser = new Employe("yasser","Bel Haj Ali","testmdp","yasser.belhajali@esprit.tn",true);
		employeService.addEmploye(yasser);
		*/
		
		Employe yasser =employeService.findEmploye(1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Date debut = dateFormat.parse("21/10/2020");
		Contrat contrat = new Contrat(debut,"Contrat a vie",32F,yasser);
		contratService.addContrat(contrat);
		
		
	}

}
