package com.support.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.Entitis.MachineFamily;
import com.support.Repositories.MachineFamilyRepositorie;
import com.support.Servicesinterfaces.MachineFamilyInterface;
@Service
public class MachineFamilyService implements MachineFamilyInterface {
@Autowired
MachineFamilyRepositorie MachineFamilyRepositorie;

    @Override
    public void CreateMachineFamily(MachineFamily f) {
        MachineFamilyRepositorie.save(f);
        
    }

    @Override
    public Optional<MachineFamily> findByid(String id) {
        return MachineFamilyRepositorie.findById(id);
    }

    @Override
    public List<MachineFamily> findAll() {
      return MachineFamilyRepositorie.findAll();
    }
    
}
