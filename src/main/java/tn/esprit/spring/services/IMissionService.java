package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	List <Mission> getAllMissions();
	void addMission(Mission mission);
	int nbrMissions();
	List <Mission> getMissionsByDepartementName(int departementId);

}
