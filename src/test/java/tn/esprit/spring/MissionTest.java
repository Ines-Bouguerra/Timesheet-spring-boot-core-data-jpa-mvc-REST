package tn.esprit.spring;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.MissionExterne;
import tn.esprit.spring.services.IMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionTest {
	@Autowired
	IMissionService iMissionService;

	
	@Test
	public void addMissionExterne() throws ParseException{
		MissionExterne mission = new MissionExterne("name","description","emailFacturation",11);
		iMissionService.addMission(mission);
	}

	@Test
	public void showMissions() throws ParseException{
		iMissionService.getAllMissions();
	}
	
//	@Test
//	public void showMissionsByDepartement(int id) throws ParseException{
//		iMissionService.getMissionsByDepartement(id);
//	}
	
	@Test
	public void addMission() throws ParseException{
		Mission mission = new Mission("name","description");
		iMissionService.addMission(mission);
	}
	
	@Test
	public void countMissions() throws ParseException{
		iMissionService.nbrMissions();
	}
	
}
