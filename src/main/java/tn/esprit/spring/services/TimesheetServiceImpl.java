package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.repository.missionRepository;

@Service
public class TimesheetServiceImpl implements ITimesheetService {

	@Autowired
	missionRepository mRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;

	private static final Logger logger = Logger.getLogger(TimesheetServiceImpl.class);

	@Override
	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);

		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false);
		timesheetRepository.save(timesheet);
		logger.info("Timesheet added successfully");

	}

	@Override
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		logger.info("In validate Timesheet");
		Employe validateur = employeRepository.findById(validateurId).orElse(null);
		Mission mission = mRepository.findById(missionId).orElse(null);
		if (!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)) {
			logger.error("The employee must be the head of the department to validate a timesheet!+++++++++++++++++++"
					+ validateur.getRole());
		}
		boolean chefDeLaMission = false;
		for (Departement dep : validateur.getDepartements()) {
			if (dep.getId() == mission.getDepartement().getId() || dep.getId() == 0) {
				chefDeLaMission = true;
				break;
			}
		}
		if (!chefDeLaMission) {
			logger.error("the employee must be the head of the department of the mission in question");
		}
		TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
		Timesheet timesheet = timesheetRepository.findBytimesheetPK(timesheetPK);
		timesheet.setValide(true);
		logger.info("Out  validerTimesheet method without errors.");

	}

	public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut,
			Date dateFin) {
		try {
			logger.info("In getTimesheetsByMissionAndDate method");
			timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);
			logger.info("Out  getTimesheetsByMissionAndDate method without errors.");
		} catch (Exception e) {
			logger.error("Error in getTimesheetsByMissionAndDate : " + e);
		}
		return timesheetRepository.getTimesheetsByMissionAndDate(employe, mission, dateDebut, dateFin);

	}
}