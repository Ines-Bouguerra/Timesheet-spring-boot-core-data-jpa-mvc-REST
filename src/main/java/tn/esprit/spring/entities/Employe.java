
package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

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
import tn.esprit.spring.entities.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employe implements Serializable {
	private static final long serialVersionUID = -1396669830860400871L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String prenom;

	private String nom;

	// @Column(unique=true)
	private String email;

	private boolean actif;
	private String password;	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@JsonIgnore
	//@JsonBackReference
	@OneToOne(mappedBy="employe")
	private Contrat contrat;
	
	
	//@JsonBackReference  
	@JsonIgnore
	@ManyToMany(mappedBy="employes",fetch=FetchType.EAGER )
	//@NotNull
	private List<Departement> departements;
	
	
	public Employe() {
		super();
	}
	
	
	
	
	
	public List<Departement> getDepartements() {
		return departements;
	}





	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}




	public Employe(String prenom, String nom, String password, String email, boolean actif) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.actif = actif;
	}

	public Employe(int id, String prenom, String nom, String email, boolean actif, String password, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.password = password;
		this.email = email;
		this.actif = actif;
		this.contrat = contrat;
	}
	
	

	public Employe(String prenom, String nom, String email, boolean actif, String password) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.actif = actif;
		this.password = password;
	}

	public Employe(int id, String prenom, String nom, String email, boolean actif, String password) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.actif = actif;
		this.password = password;
	}

	public Employe(String prenom, String nom, String email, boolean actif, Role role) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.actif = actif;
		this.role = role;
	}

	public Employe(int id, String prenom, String nom, String email, boolean actif, Role role) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.actif = actif;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@JsonIgnore
	// @JsonBackReference
	@OneToMany(mappedBy = "employe")
	private List<Timesheet> timesheets;

	public List<Timesheet> getTimesheets() {
		return timesheets;
	}

	public void setTimesheets(List<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
}

