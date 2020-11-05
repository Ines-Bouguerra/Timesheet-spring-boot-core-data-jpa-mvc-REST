package tn.esprit.spring.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;

import tn.esprit.spring.repository.ContartRepository;

@Service
public class ContratService implements IContratServiceImpl {
	
	private static final Logger logger = Logger.getLogger(ContratService.class);
	
	@Autowired
	ContartRepository contartRepository ;
	

	@Override
	public int addOrUpdateContart(Contrat contrat) {
		contartRepository.save(contrat);
		logger.info("add Or Update Contart  " +contrat);
	return contrat.getReference();
	}
	
	@Override
	public void deleteContart(Contrat contrat){
	contartRepository.delete(contrat);
	logger.info("delete Contart  " +contrat);
	}
	
	@Override
	public Contrat findcontart(int ref){
		Contrat contart = contartRepository.findById(ref).orElse(null);
		logger.info("find contart by ref" +contart);
		return contart ;
	}
	
	@Override
	public List<Contrat> allContrats(){
		
		List<Contrat> liste =	(List<Contrat>) contartRepository.findAll();
		logger.info("liste all Contrats " +liste);
		return liste;
	}

	@Override
	public Contrat addContart(Contrat contrat) {		
		contartRepository.save(contrat);
		logger.info("Add Contrat " +contrat);
		return contrat ;
	}

}
