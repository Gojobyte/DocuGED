package com.ged.docuged;

import com.ged.docuged.domain.RequestContext;
import com.ged.docuged.entity.RoleEntity;
import com.ged.docuged.enumeration.Authority;
import com.ged.docuged.repository.RoleRepository;
import com.ged.docuged.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DocuGedApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocuGedApplication.class, args);

	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
		return args -> {
			RequestContext.setUserId(0L);
			var userRole = new RoleEntity();
			userRole.setName(Authority.USER.name());
		 	userRole.setAuthorities(Authority.USER);
			 roleRepository.save(userRole);

			 var adminRole = new RoleEntity();
			 adminRole.setName(Authority.ADMIN.name());
			 adminRole.setAuthorities(Authority.USER);
			 roleRepository.save(adminRole);
			 RequestContext.start();
		};
	}

}
