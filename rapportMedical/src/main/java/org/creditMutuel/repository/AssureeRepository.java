package org.creditMutuel.repository;


import org.creditMutuel.model.entity.Assure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssureeRepository extends JpaRepository<Assure, Long>{
	
}

