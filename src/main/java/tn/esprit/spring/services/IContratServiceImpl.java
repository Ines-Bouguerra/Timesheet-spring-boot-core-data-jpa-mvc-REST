package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratServiceImpl {
	
	public Contrat addContrat(Contrat contrat);
	public void deleteContart(Contrat contrat);
	public Contrat findcontart(int ref);
	public List<Contrat> allContrats();
	
	

}
