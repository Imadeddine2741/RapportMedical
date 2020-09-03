package org.creditMutuel.model.dto;

import java.util.List;

import org.creditMutuel.model.entity.Rapport;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssureDto {

	private long id;
    private List<Rapport> rapport ;
	private int num;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String adresse ;
}
