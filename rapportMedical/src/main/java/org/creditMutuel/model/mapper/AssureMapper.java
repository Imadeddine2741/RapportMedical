package org.creditMutuel.model.mapper;

import java.util.Collection;
import java.util.List;

import org.creditMutuel.model.dto.AssureDto;
import org.creditMutuel.model.entity.Assure;

/**
 * mapper entre des classes entity et dto
 * @author IRahmani
 *
 */
public interface AssureMapper {
	
	public AssureDto entityToDto(final Assure assure) ;
	public List<AssureDto> entitiesToDto(final Collection<Assure> entities);

}
