package com.support.Services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.Entitis.Machine;
import com.support.Repositories.MachineRepositorie;
import com.support.Servicesinterfaces.MachineInterface;
@Service
public class MachineService implements MachineInterface {
    @Autowired
    MachineRepositorie MachineRepositorie;
    @Override
    public void CreateMachine(Machine m) {
       MachineRepositorie.save(m);
    }

    @Override
    public void DropeMachine(Machine m) {
        MachineRepositorie.delete(m);
    }
     
    public Optional<Machine>  FindMachine(Machine m){
       return  MachineRepositorie.findById(m.getId());
    }
}
