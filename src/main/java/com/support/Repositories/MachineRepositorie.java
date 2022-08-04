package com.support.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.support.Entitis.Machine;
@Repository 
public interface MachineRepositorie extends JpaRepository<Machine, String> {

}