package org.creditMutuel.service;

import java.util.List;

import org.creditMutuel.model.dto.AssureDto;
import org.creditMutuel.model.entity.Assure;

public interface AssureServiceImpl {

	/**
	 * Fonction getAll : récuperer tout les rapports
	 * @return : une liste de rapports
	 */
	public List<AssureDto> getAll();
	
	/**
	 * Fonction getById : recherche d'un assuré en fonction de son id
	 * @param assureId : l'id de l'assuré
	 * @return : Assure DTO 
	 */
	public AssureDto getByIdToDto(Long assureId);
	
	/**
	 * Fonction getById : recherche d'un assuré en fonction de son id
	 * @param assureId
	 * @return : l'assure si trouvé
	 */
	
	public Assure getById(Long assureId);
	
	/**
	 * Fonction ajouterAssure : ajouter un assuré
	 * @param assure
	 * @return :  Assure DTO 
	 */
	public AssureDto ajouterAssure(Assure assure); 
}
