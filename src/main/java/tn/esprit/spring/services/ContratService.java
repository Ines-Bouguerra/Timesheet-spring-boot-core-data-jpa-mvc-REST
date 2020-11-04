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
	

	@Override
	public int addOrUpdateContart(Contrat contrat) {
		contartRepository.save(contrat);
	return contrat.getReference();
	}
	
	@Override
	public void deleteContart(Contrat contrat){
	contartRepository.delete(contrat);
	}
	
	@Override
	public Contrat findcontart(int ref){
		return contartRepository.findById(ref).orElse(null);
	}
	
	@Override
	public List<Contrat> allContrats(){
		return (List<Contrat>) contartRepository.findAll();
	}

	@Override
	public Contrat addContart(Contrat contrat) {		
		return contartRepository.save(contrat);
	}

}
