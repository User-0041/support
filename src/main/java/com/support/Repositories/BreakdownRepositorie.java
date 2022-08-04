package com.support.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.support.Entitis.Breakdown;
@Repository 
public interface  BreakdownRepositorie extends JpaRepository<Breakdown,String>{
    
}