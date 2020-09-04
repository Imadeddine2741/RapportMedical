package org.creditMutuel.model.mapper;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;

import org.creditMutuel.model.dto.RapportDto;
import org.creditMutuel.model.entity.Rapport;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class RapportMapperImpl implements RapportMapper {
	
	public RapportDto entityToDto(final Rapport rapport) {
		return RapportDto.builder().idRapport(rapport.getId())
				.num(rapport.getNum())
				.domaine(rapport.getDomaine())
				.position(rapport.getPosition())
				.titre(rapport.getTitre())
				.assure(rapport.getAssure())
				.commentaires(rapport.getCommentaires())
				.dateCreation(rapport.getDateCreation())
				.build();
	}
	
	public List<RapportDto> entitiesToDtos(final Collection<Rapport> entities){
		return entities.stream()
			      .map(this::entityToDto)
			      .collect(toList());
	}

}
