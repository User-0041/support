package com.support.Entitis;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
    @NotBlank
    String id;
    @ManyToOne
    @NotNull
    MachineFamily family;
    @OneToMany
    List<Ticket> tickets;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date start;


    
    public Machine(String Id){
        this.id = Id;
    }
}
