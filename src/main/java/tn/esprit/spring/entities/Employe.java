package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class Employe implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String prenom;
	
	private String nom;
	
	private String password;
	
	//@Column(unique=true)
	private String email;

	private boolean actif;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToOne(mappedBy="employe")
	private Contrat contrat;
	
	public Employe() {
		super();
	}
	
	

	public Employe(String prenom, String nom, String password, String email, boolean actif) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.actif = actif;
	}



	public Employe(String prenom, String nom, String password, String email, boolean actif, Contrat contrat) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.actif = actif;
		this.contrat = contrat;
	}

	public Employe(int id, String prenom, String nom, String password, String email, boolean actif, Contrat contrat) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.actif = actif;
		this.contrat = contrat;
	}






	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	
	
	
}
