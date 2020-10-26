package tn.esprit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.ITimesheetService;
import tn.esprit.spring.services.TimesheetServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetSpringBootCoreDataJpaMvcRest1ApplicationTest {
	TimesheetServiceImpl timesheetServiceImpl = new TimesheetServiceImpl();

	@Autowired
	ITimesheetService iTimesheetService;

	@Test 
	public void saveTimesheetTest() throws ParseException { 
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

//		Mission mission = new Mission(1, "mission one", "mssion desc");
//		Employe employe = new Employe(1, "employe 1", "employe 1", "employe1@gmail.com", true, Role.INGENIEUR);
		Date dateDebut = dateFormat.parse("22/10/2020");
		Date dateFin = dateFormat.parse("31/10/2020");
		iTimesheetService.ajouterTimesheet(1, 1, dateDebut, dateFin);

	}
}
