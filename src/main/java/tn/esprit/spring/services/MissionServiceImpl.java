package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionService {

	private static final Logger logger = Logger.getLogger(MissionServiceImpl.class);
	
	@Autowired
	MissionRepository MissionRepository;
	@Autowired
	DepartementRepository departementRepository;
	
	@Override
	public int nbrMissions() {
		int nbr = (int) MissionRepository.numberMissions();
		logger.info("The total number of Missions is: " +nbr);
		return nbr;
	}

	@Override
	public List<Mission> getAllMissions() {
		List<Mission> missions= (List<Mission>) MissionRepository.findAll();
		logger.info("This is the list of missions" + missions);
		return missions;
	}

	@Override
	public void addMission(Mission mission) {
		MissionRepository.save(mission);
		logger.info("add succeded");
	}

	@Override
	public List<Mission> getMissionsByDepartement(int departementId) {
		Departement dep = departementRepository.findById(departementId).orElse(null);
		List<Mission> missions = new ArrayList<>();
		for(Mission mis : MissionRepository.findAll()){
			if (mis.getDepartement() == dep){
				missions.add(mis);			
			}
		}	
		logger.info("This is the list of missions By departement" + missions);
		
		return missions;			
		
	}
	
	@Override
	public void deleteAllMissions() {
		departementRepository.deleteAll();
	}


}
