package org.creditMutuel.model.mapper;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;

import org.creditMutuel.model.dto.CommentaireDto;
import org.creditMutuel.model.entity.Commentaire;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CommentaireMapper implements CommentaireMapperImpl{
	
	
	public CommentaireDto entityToDto (final Commentaire commentaire) {
		return CommentaireDto.builder().id(commentaire.getId())
				.dateCreation(commentaire.getDateCreation())
				.dateModification(commentaire.getDateModification())
				.textLong(commentaire.getTextLong())
				.build();
	
	}
		
	public List<CommentaireDto> entitiesToDto(final Collection<Commentaire> entities){
		return entities.stream()
				.map(this::entityToDto)
				.collect(toList());
	}

}
