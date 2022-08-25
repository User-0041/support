package com.support;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.support.Repositories.TicketRepositrie;
@SpringBootApplication
public class SupportApplication {
@Autowired
TicketRepositrie TicketRepositrie;
@Bean
public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.ENGLISH);
    return slr;
}
	public static void main(String[] args) {
		SpringApplication.run(SupportApplication.class, args);
	}
}
