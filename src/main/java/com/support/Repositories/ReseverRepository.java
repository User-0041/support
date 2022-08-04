package com.support.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.support.Entitis.Resever;
@Repository 
public interface ReseverRepository extends JpaRepository<Resever ,String > {
     
}
