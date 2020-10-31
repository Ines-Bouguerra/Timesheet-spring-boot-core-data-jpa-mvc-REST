package tn.esprit.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.ContratService;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IMissionService;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetTest {
	@Autowired
	EmployeServiceImpl employeService;
	@Autowired
	ContratService contratService;
	@Autowired
	ITimesheetService iTimesheetService;
	@Autowired
	IEmployeService iEmployeService;
	@Autowired
	IMissionService iMissionService;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	List<Timesheet> timesheets = new ArrayList<Timesheet>();
	Employe employe = new Employe(2, "ines", "ines", "ines@gmail.com", "123456l", true, Role.INGENIEUR);
	Mission mission = new Mission(2, "tetm", "testmm");

	@Test
	public void addTimesheet() throws ParseException {
		Date dateDebut = dateFormat.parse("22/10/2020");
		Date dateFin = dateFormat.parse("31/10/2020");
		iEmployeService.addOrUpdateEmploye(employe);
		iTimesheetService.ajouterTimesheet(1, employe.getId(), dateDebut, dateFin);

	}

	@Test
	public void validateTimesheet() throws ParseException {
		// to do
	}

	@Test
	public List<Timesheet> getTimesheetsByMissionAndDate() throws ParseException {
		Date dateDebut = dateFormat.parse("22/10/2020");
		Date dateFin = dateFormat.parse("31/10/2020");
		timesheets = iTimesheetService.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
		return timesheets;
	}
}