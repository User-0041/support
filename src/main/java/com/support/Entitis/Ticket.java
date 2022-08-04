package com.support.Entitis;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.support.Enums.Level;
import com.support.Enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ticket {
@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
String Id;
@ManyToOne
User user;
@ManyToOne
Resever Tecnesstion;
Date IssueDate;
Date closeDate;
@NotNull(message = "Machine not found")
@ManyToOne
Machine machine;
@OneToOne
Breakdown breakdown;
@Enumerated
Level level;
@NotEmpty(message = "Titel empty")
@NotNull(message = "Titel empty")
String Titel;


String Descrption;
String Observetion;
Status status;  

}


  