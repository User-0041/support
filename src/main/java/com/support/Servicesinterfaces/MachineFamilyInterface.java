package com.support.Servicesinterfaces;

import java.util.List;
import java.util.Optional;

import com.support.Entitis.MachineFamily;

public interface MachineFamilyInterface {
    void CreateMachineFamily(MachineFamily f);
    Optional<MachineFamily> findByid(String id);
    List<MachineFamily> findAll();
}
