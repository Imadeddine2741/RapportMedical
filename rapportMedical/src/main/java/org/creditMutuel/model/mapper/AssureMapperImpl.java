package org.creditMutuel.model.mapper;


import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.List;

import org.creditMutuel.model.dto.AssureDto;
import org.creditMutuel.model.entity.Assure;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AssureMapperImpl implements AssureMapper {
	
	public AssureDto entityToDto(final Assure assure) {
		return AssureDto.builder().id(assure.getId())
				.dateNaissance(assure.getDateNaissance())
				.adresse(assure.getAdresse())
				.nom(assure.getNom())
				.prenom(assure.getPrenom())
				.rapport(assure.getRapport())
				.num(assure.getNum())
				.build();
	}
	
	public List<AssureDto> entitiesToDto(final Collection<Assure> entities){
		return entities.stream()
				.map(this::entityToDto)
				.collect(toList());
	}

}
