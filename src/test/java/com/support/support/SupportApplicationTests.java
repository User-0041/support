
package com.support.support;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.support.Entitis.Admin;

import com.support.Entitis.Resever;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;

import com.support.ReposetryPorxy.TicketRepositrieProxySort;
import com.support.Repositories.BreakdownRepositorie;
import com.support.Repositories.MachineFamilyRepositorie;
import com.support.Repositories.MachineRepositorie;
import com.support.Repositories.ReseverRepository;
import com.support.Repositories.TicketRepositrie;


import com.support.Repositories.UserRepositorie;
import com.support.Services.TicketService;


@SpringBootTest
class SupportApplicationTests {
	@Autowired
	MachineFamilyRepositorie MachineFamilyRepositorie;
	@Autowired
	MachineRepositorie MachineRepositorie; 
	@Autowired
	ReseverRepository ReseverRepository;
	@Autowired
	 UserRepositorie UserRepositorie ;
	@Autowired
	BreakdownRepositorie BreakdownRepositorie; 
	@Autowired
	TicketRepositrie TicketRepositrie; 
	@Autowired
	TicketService TicketService;
	@Autowired
	TicketRepositrieProxySort TicketRepositrieProxySort; 
	
	@Test
	void contextLoads() {
	}	

}