package org.creditMutuel.model.mapper;

import java.util.Collection;
import java.util.List;

import org.creditMutuel.model.dto.CommentaireDto;
import org.creditMutuel.model.entity.Commentaire;


/**
 * mapper entre des classes entity et dto
 * @author IRahmani
 *
 */
public interface CommentaireMapperImpl {

	
	public CommentaireDto entityToDto (final Commentaire commentaire) ;
	
	public List<CommentaireDto> entitiesToDto(final Collection<Commentaire> entities);
}
