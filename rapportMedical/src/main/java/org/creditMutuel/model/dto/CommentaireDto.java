package org.creditMutuel.model.dto;

import org.creditMutuel.model.entity.Rapport;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentaireDto {

	private long id;
    private Rapport rapport;
	private String dateCreation;
	private String dateModification;
	private String textLong;
}
