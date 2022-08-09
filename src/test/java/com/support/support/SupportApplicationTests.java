
package com.support.support;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.support.Entitis.Admin;
import com.support.Entitis.Machine;
import com.support.Entitis.MachineFamily;
import com.support.Entitis.Resever;
import com.support.Entitis.Ticket;
import com.support.Entitis.User;
import com.support.Enums.Status;
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
		Admin admin= new Admin();
		User u= (User) admin;
		Resever r =(Resever) u;
		System.out.println(r.getClass());

	}	


	@Test
	void FindByTest() {
		List<Ticket> t =  TicketRepositrieProxySort.getList("Status","M7");
		System.out.println(t);
	}


	@Test
	void Repositories(){
		User u1 = new User("User","$2a$12$s.nKYeuQIb/Jh3WHSsA.7OYDASy0HUAvJxKNU4go08hQ3NsqoUj2K");
		User r1 = new Admin("Admin","$2a$12$jdaOZlcKmpF1nbI.u0Sb1eHrhsdhQJ3wAa2.vYCAd.9PNuq7ZE7wy");
		User a1 = new Resever("Resever","$2a$12$YZfY8uQBsUsA2GcPbzrZCe4xK/3oTBgxYkir0TK/6E1xfxVOSv1eG");
		User a2 = new Resever("Resever-2","$2a$12$YZfY8uQBsUsA2GcPbzrZCe4xK/3oTBgxYkir0TK/6E1xfxVOSv1eG");

		UserRepositorie.save(u1);
		UserRepositorie.save(r1);
		UserRepositorie.save(a1);
}

@Test
void Page(){

}
}