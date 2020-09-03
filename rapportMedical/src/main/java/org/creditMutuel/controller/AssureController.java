package org.creditMutuel.controller;

import java.util.List;

import javax.validation.Valid;

import org.creditMutuel.exception.ResourceNotFoundException;
import org.creditMutuel.model.dto.AssureDto;
import org.creditMutuel.model.entity.Assure;
import org.creditMutuel.service.AssureService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AssureController {
	

	private final AssureService assureService;
	
	@GetMapping("/assures")
	public ResponseEntity<List<AssureDto>> getAllAssures(Model model){
		List<AssureDto> ListAssures = assureService.getAll();
       
		return ResponseEntity.ok().body(ListAssures);
	}

	@GetMapping("/assuree/{id}")
	public ResponseEntity<AssureDto> getAssureeById(@PathVariable(value = "id") Long assureId)
			throws ResourceNotFoundException {
		AssureDto assureDtO = assureService.getByIdToDto(assureId);
		
		if(assureDtO == null) {
			throw new ResourceNotFoundException("Assuree not found for this id :: " + assureId);
		}
		return ResponseEntity.ok().body(assureDtO);
		
		
	}
	
	@PostMapping("/assuree")
	public AssureDto createAssuree(@Valid @RequestBody Assure assure) {
		return assureService.ajouterAssure(assure);
	}
	
	@PutMapping("/assuree/{id}")
	public ResponseEntity<AssureDto> updateAssuree(@PathVariable(value = "id") Long assureId,
			@Valid @RequestBody AssureDto assureeDetails) throws ResourceNotFoundException {
		Assure assure = assureService.getById(assureId);
		if(assure == null) {
			throw new ResourceNotFoundException("Assuree not found for this id :: " + assureId);
		}

		assure.setNom(assureeDetails.getNom());
		assure.setPrenom(assureeDetails.getPrenom());
		assure.setAdresse(assureeDetails.getAdresse());
		assure.setDateNaissance(assureeDetails.getDateNaissance());
		assure.setNum(assureeDetails.getNum());
		
		final AssureDto updatedAssuree = assureService.ajouterAssure(assure);
		return ResponseEntity.ok(updatedAssuree);
	}
	
}
