package org.creditMutuel.model.dto;

import java.util.List;

import org.creditMutuel.model.entity.Assure;
import org.creditMutuel.model.entity.Commentaire;
import org.creditMutuel.model.enumeration.Domaine;
import org.creditMutuel.model.enumeration.Position;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class RapportDto {

	private Assure assure;
	private long idRapport;
	private Integer num;
	private String dateCreation;
	private String titre;
    private Domaine domaine;
    private Position position;
	private List<Commentaire> commentaires;

	
}
