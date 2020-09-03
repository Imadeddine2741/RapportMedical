package org.creditMutuel.repository;



import java.util.List;

import org.creditMutuel.model.entity.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RapportRepository extends JpaRepository<Rapport, Long>{
	
	/*
	 * Permet de chercher un rapport medical à partir d’un numéro de rapport
	 */
	@Query("select r from Rapport r where r.numRapport = ?1 ")
	public Rapport  findByNumRapport(int numRapport);

	@Query("select r from Rapport r inner join Assure assure on r.assure = assure.id where assure.num = ?1")
	public List<Rapport> findByNumAssure(int num);
	
	@Query("select r from Rapport r inner join Assure assure on r.assure = assure.id where assure.nom like ?1")
	public List<Rapport> findByNomAssure(String nom);
		
}
