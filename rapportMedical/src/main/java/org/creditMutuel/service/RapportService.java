package org.creditMutuel.service;

import java.util.List;

import org.creditMutuel.model.dto.RapportDto;
import org.creditMutuel.model.entity.Rapport;
import org.springframework.cache.annotation.Cacheable;

public interface RapportService {

	/**
	 * Fonction getById : récuperer tout les rapports 
	 * @return : une liste de rapports DTO
	 */
	public List<RapportDto> getAll() ;
	
	/**
	 * Fonction addRapport : ajouter un rapport 
	 * @return : le rapport DTO ajouter 
	 */
	public RapportDto addRapport(RapportDto rapportDetails);
	
	/**
	 * Fonction getByNumRapport : recherche des rapport d'un assuré en 
	 * fonction du numéro  de rapport
	 * @param numRapport : le numéro de rapport
	 * @return : un rapport DTO avec la liste des assurés ainsi que la liste des commentaires
	 */
	@Cacheable(value= "rapportGetbyNumRapport",key="#num")
	public RapportDto getByNumRapport(Integer num);
	
	/**
	 * Fonction getByNumAssureOrNom : recherche des rapport d'un assuré en 
	 * fonction du numéro de l'assuré 
	 * @param numAssure : le numéro de l'assure
	 * @return : une liste de rapports avec la liste des assurés
	 */
	public List<RapportDto> getByNumAssure(int numAssure);
	
	/**
	 * Fonction getByNumAssureOrNom : recherche des rapport d'un assuré en 
	 * fonction du nom de l'assure
	 * @param nomAssure : le nom de l'assure
	 * @return : une liste de rapports avec la liste des assurés
	 */
	public List<RapportDto> getByNomAssure(String nomAssure);
	
	/**
	 * Fonction deleteRapport : supprimer un rapport
	 * @return : 
	 */
	public void deleteRapport(Rapport rapport);
}
