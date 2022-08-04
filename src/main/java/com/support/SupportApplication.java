package com.support;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.support.Repositories.TicketRepositrie;
@SpringBootApplication
public class SupportApplication {
@Autowired
TicketRepositrie TicketRepositrie;
	public static void main(String[] args) {
		SpringApplication.run(SupportApplication.class, args);
	}
}
