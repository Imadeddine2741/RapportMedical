package org.creditMutuel.model.mapper;

import java.util.Collection;
import java.util.List;

import org.creditMutuel.model.dto.RapportDto;
import org.creditMutuel.model.entity.Rapport;

/**
 * mapper entre des classes entity et dto
 * @author IRahmani
 *
 */
public interface RapportMapperImpl {

	public RapportDto entityToDto(final Rapport rapport);
	public List<RapportDto> entitiesToDtos(final Collection<Rapport> entities);
}
