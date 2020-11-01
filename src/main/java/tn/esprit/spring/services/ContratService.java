package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContartRepository;

@Service
public class ContratService implements IContratServiceImpl {
	
	@Autowired
	ContartRepository contartRepository ;
	
	public Contrat addContrat(Contrat contrat){
		return contartRepository.save(contrat);
	}
	
	public void deleteContart(Contrat contrat){
	contartRepository.delete(contrat);
	}
	
	public Contrat findcontart(int ref){
		return contartRepository.findById(ref).orElse(null);
	}
	
	public List<Contrat> allContrats(){
		return contartRepository.findAll();
	}

}
