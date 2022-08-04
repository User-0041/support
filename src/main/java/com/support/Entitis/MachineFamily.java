package com.support.Entitis;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MachineFamily {
    @Id
    String id;
    String Name;
    @OneToMany(mappedBy="family")
    List<Machine> Machines;

    public MachineFamily(String Id, String Name){
        this.id=Id;
        this.Name=Name;
    }
}