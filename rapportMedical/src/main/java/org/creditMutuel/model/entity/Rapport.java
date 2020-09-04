package org.creditMutuel.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.creditMutuel.model.enumeration.Domaine;
import org.creditMutuel.model.enumeration.Position;


@Entity
@Table(name ="rapports")
public class Rapport implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="num")
	private Integer num;

	@OneToOne( cascade = CascadeType.ALL ) 
    @JoinColumn( name="assure" )
	private Assure assure;
	
	@Column(name ="date_creation")
	private String dateCreation;
	
	@Column(name ="titre")
	private String titre;

	@Enumerated(EnumType.ORDINAL)
    private Domaine domaine;
	
	@Enumerated(EnumType.ORDINAL)
    private Position position;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="commentaireRapport")
	private List<Commentaire> commentaires;
	
	/*
	private List<String> documents;
	*/


	public Rapport(Assure assure, Integer num , String dateCreation, String titre, Domaine domaine, Position position,
			List<Commentaire> commentaires) {
		super();
		this.assure = assure;
		this.num=num;
		this.dateCreation = dateCreation;
		this.titre = titre;
		this.domaine = domaine;
		this.position = position;
		this.commentaires = commentaires;
	}
	
	public Rapport() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Assure getAssure() {
		return assure;
	}

	public void setAssure(Assure assure) {
		this.assure = assure;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}


}
