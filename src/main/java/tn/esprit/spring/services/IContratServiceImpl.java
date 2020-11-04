package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratServiceImpl {
	public Contrat addContart(Contrat contrat);
	public int addOrUpdateContart(Contrat contrat);
	public void deleteContart(Contrat contrat);
	public Contrat findcontart(int ref);
	public List<Contrat> allContrats();
	
	

}
