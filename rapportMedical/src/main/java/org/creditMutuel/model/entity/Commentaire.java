package org.creditMutuel.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Commentaires")
public class Commentaire implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idRapport", nullable=true)
    private Rapport rapport;
	
	@Column(name ="dateCreation")
	private String dateCreation;
	
	@Column(name ="dateModification")
	private String dateModification;
	
	@Column(name="texte_Long")
	private String textLong;

	public Commentaire() {
		super();
	}
	
	public Commentaire(String dateCreation, String dateModification, String textLong) {
		super();
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.textLong = textLong;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getDateModification() {
		return dateModification;
	}

	public void setDateModification(String dateModification) {
		this.dateModification = dateModification;
	}

	public String getTextLong() {
		return textLong;
	}

	public void setTextLong(String textLong) {
		this.textLong = textLong;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
