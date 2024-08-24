package com.vivi.bakery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BakeryRepo extends JpaRepository<Bakery,Long>{
	


}
