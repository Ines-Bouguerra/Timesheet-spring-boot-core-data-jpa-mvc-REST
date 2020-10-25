package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.repository.missionRepository;

@Service
public class MissionServiceImpl implements IMissionService {

	@Autowired
	missionRepository missionRepository;
	
	@Override
	public int nbrMissions() {
		// TODO Auto-generated method stub
		int nbr = (int) missionRepository.numberMissions();
		return nbr;
	}

}
