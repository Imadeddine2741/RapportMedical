package org.creditMutuel.service;

import java.util.List;

import org.creditMutuel.model.dto.AssureDto;
import org.creditMutuel.model.entity.Assure;
import org.creditMutuel.model.mapper.AssureMapper;
import org.creditMutuel.repository.AssureeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssureServiceImpl implements AssureService{
	
	@Autowired
	private AssureeRepository assureeRepository;

	@Autowired
	private AssureMapper assureMapper;
	
	public List<AssureDto> getAll(){
	
		List<Assure> assures = assureeRepository.findAll();
		if(!assures.isEmpty()) {
			return assureMapper.entitiesToDto(assures);
		}
		return null;
 	}

	public AssureDto getByIdToDto(Long assureId) {	
		Assure assure = assureeRepository.findById(assureId).orElse(null);
		return assureMapper.entityToDto(assure);	
	}
	
	public Assure getById(Long assureId) {
		Assure assure = assureeRepository.findById(assureId).orElse(null);
		return assure;	
	}

	public AssureDto ajouterAssure(Assure assure) {
		Assure assureSave =  assureeRepository.save(assure);
		return assureMapper.entityToDto(assureSave);
				
	}

}
