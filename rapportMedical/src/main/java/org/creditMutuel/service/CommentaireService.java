package org.creditMutuel.service;

import java.util.List;

import org.creditMutuel.model.dto.CommentaireDto;

public interface CommentaireService {
	
	
	/**
	 * Fonction getAll : récuperer tout les commentaires 
	 * @return : une liste des commentaires DTO
	 */
	public List<CommentaireDto> getAll();
}
