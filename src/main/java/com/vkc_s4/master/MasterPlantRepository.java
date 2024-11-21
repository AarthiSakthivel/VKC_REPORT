package com.vkc_s4.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterPlantRepository extends JpaRepository<MasterPlantEntity, Integer> {

	boolean existsByPlant(String plant);

}