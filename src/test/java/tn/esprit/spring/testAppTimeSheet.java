package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testAppTimeSheet {
	@Autowired
	EmployeService employeService;

	@Test
	public void contextLoads() {
		
		Employe yasser = new Employe("yasser","Bel Haj Ali","testmdp","yasser.belhajali@esprit.tn",true);
		employeService.addEmploye(yasser);
		
	}

}
