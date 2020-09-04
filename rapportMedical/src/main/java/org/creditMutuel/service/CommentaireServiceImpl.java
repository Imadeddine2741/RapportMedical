package org.creditMutuel.service;


import java.util.List;

import org.creditMutuel.model.dto.CommentaireDto;
import org.creditMutuel.model.entity.Commentaire;
import org.creditMutuel.model.mapper.CommentaireMapper;
import org.creditMutuel.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class CommentaireServiceImpl implements CommentaireService{
	
	@Autowired
	private CommentaireRepository commentaireRepository;
	
	@Autowired
	private CommentaireMapper commentaireMapper;
	
	public List<CommentaireDto> getAll(){
		List<Commentaire> commentaires = commentaireRepository.findAll();
		return commentaireMapper.entitiesToDto(commentaires);
 	}
	

}
