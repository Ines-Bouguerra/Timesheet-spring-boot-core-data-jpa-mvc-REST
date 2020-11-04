package tn.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Contrat;

public interface ContartRepository extends CrudRepository<Contrat, Integer> {

}
