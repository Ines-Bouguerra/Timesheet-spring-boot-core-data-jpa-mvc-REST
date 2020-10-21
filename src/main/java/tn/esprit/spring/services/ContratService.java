package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContartRepository;

@Service
public class ContratService {
	
	@Autowired
	ContartRepository contartRepository ;
	
	public void addContrat(Contrat contrat){
		contartRepository.save(contrat);
	}
	
	public void deleteContart(int ref){
	contartRepository.delete(contartRepository.findById(ref).orElse(null));
	}
	
	public Contrat findcontart(int ref){
		return contartRepository.findById(ref).orElse(null);
	}
	
	public List<Contrat> allContrats(){
		return contartRepository.findAll();
	}

}
