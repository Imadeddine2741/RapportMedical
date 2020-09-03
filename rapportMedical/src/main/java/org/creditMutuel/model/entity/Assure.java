package org.creditMutuel.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Assures")
public class Assure implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="assureRapport")
    private List<Rapport> rapport ;

	@Column(name ="num")
	private int num;

	@Column(name ="nom")
	private String nom;

	@Column(name ="prenom")
	private String prenom;

	@Column(name ="dateNaissance")
	private String dateNaissance;

	@Column(name ="adresse")
	private String adresse ;

	public Assure() {
		super();
	}

	public Assure(int num, String nom, String prenom, String dateNaissance, String adresse) {
		super();
		this.num = num;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Rapport> getRapport() {
		return rapport;
	}

	public void setRapport(List<Rapport> rapport) {
		this.rapport = rapport;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
