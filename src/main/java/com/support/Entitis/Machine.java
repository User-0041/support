package com.support.Entitis;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Machine {
    @Id
    String Id;
    @ManyToOne
    MachineFamily family;
    @OneToMany
    List<Ticket> Tickets;
}
