package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.missionRepository;

@Service
public class MissionServiceImpl implements IMissionService {

	@Autowired
	missionRepository missionRepository;
	
	@Override
	public int nbrMissions() {
		int nbr = (int) missionRepository.numberMissions();
		return nbr;
	}

	@Override
	public List<Mission> getAllMissions() {
		List<Mission> missions= (List<Mission>) missionRepository.findAll();
		return missions;
	}

	@Override
	public void addMission(Mission mission) {
		// TODO Auto-generated method stub
		missionRepository.save(mission);
	}


}
