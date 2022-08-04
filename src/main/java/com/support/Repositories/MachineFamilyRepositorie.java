package com.support.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.support.Entitis.MachineFamily;
@Repository 
public interface MachineFamilyRepositorie extends JpaRepository<MachineFamily,String> {
    
}
