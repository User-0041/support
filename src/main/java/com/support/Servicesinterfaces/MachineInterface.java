package com.support.Servicesinterfaces;

import java.util.List;
import java.util.Optional;

import com.support.Entitis.Machine;

public interface MachineInterface  {
    void CreateMachine(Machine m);
    public List<Machine> FindAll();
    void DropeMachine(Machine m);
    public Optional<Machine>  FindMachine(Machine m);
}