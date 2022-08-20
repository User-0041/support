package com.support.Entitis;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty
    String id;
    @NotEmpty
    String name;
    @OneToMany(mappedBy="family")
    List<Machine> machines;

    public MachineFamily(String Id, String Name){
        this.id=Id;
        this.name=Name;
    }
}
