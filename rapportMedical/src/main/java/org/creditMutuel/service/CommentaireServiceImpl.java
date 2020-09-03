package org.creditMutuel.service;


import java.util.List;

import org.creditMutuel.model.dto.CommentaireDto;
import org.creditMutuel.model.entity.Commentaire;
import org.creditMutuel.model.mapper.CommentaireMapperImpl;
import org.creditMutuel.repository.CommentaireRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class CommentaireServiceImpl implements CommentaireService{
	
	private final CommentaireRepository commentaireRepository;
	
	private final CommentaireMapperImpl commentaireMapper;
	
	public List<CommentaireDto> getAll(){
		List<Commentaire> commentaires = commentaireRepository.findAll();
		return commentaireMapper.entitiesToDto(commentaires);
 	}
	

}
