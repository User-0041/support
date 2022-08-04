package com.support.support;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import com.support.Repositories.BreakdownRepositorie;
import com.support.Repositories.MachineFamilyRepositorie;
import com.support.Repositories.MachineRepositorie;
import com.support.Repositories.ReseverRepository;
import com.support.Repositories.TicketRepositrie;
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
		//MachineFamily f1 = new MachineFamily("F1","Fammly");
		//MachineFamilyRepositorie.save(f1);
		//Machine m1 = new Machine("M",f1);
		//MachineRepositorie.save(m1);
		//User i1= new User("U1","U1");
		//Resever r1 = new Resever("R1","U1");
		//UserRepositorie.save(i1);		
		//ReseverRepository.save(r1);
		//Breakdown b1 = new Breakdown("1","Mecanical");
		//BreakdownRepositorie.save(b1);
		//Ticket t1 = new Ticket("t1", i1, r1,Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())   ,Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())  , m1, b1, Level.Normal, "Probalme","It is all fuked");
		//TicketRepositrie.save(t1);

}

@Test
void Page(){

}
}