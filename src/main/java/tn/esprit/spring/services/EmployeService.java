package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeService {
	
	@Autowired
	EmployeRepository employeRepository ;
	
	public void addEmploye(Employe employe){
	employeRepository.save(employe);
}
	public Employe findEmploye(int id){
		return employeRepository.findById(id).orElse(null);
	}

	
}
