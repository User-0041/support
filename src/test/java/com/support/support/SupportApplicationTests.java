package com.support.support;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.support.Entitis.Admin;
import com.support.Entitis.Resever;
import com.support.Entitis.User;
import com.support.Repositories.BreakdownRepositorie;
import com.support.Repositories.MachineFamilyRepositorie;
import com.support.Repositories.MachineRepositorie;
import com.support.Repositories.ReseverRepository;
import com.support.Repositories.TicketRepositrie;
import java.util.Optional;

import com.support.Repositories.UserRepositorie;


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
	
	@Test
	void contextLoads() {
	}
	@Test
	void Repositories(){

		User u1 = new User("User","User");
		User r1 = new Resever("Admin","Admin");
		User a1 = new Admin("Resever","Resever");
		UserRepositorie.save(u1);
		UserRepositorie.save(r1);
		UserRepositorie.save(a1);

		


}

@Test
void Page(){

}
}