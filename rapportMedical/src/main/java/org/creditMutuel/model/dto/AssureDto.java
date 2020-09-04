package org.creditMutuel.model.dto;

import java.util.List;

import org.creditMutuel.model.entity.Rapport;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
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
