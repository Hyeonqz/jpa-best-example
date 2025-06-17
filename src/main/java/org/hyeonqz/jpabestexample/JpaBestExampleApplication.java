package org.hyeonqz.jpabestexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"org.hyeonqz.jpabestexample.onetomany"})
@SpringBootApplication
public class JpaBestExampleApplication {

	public static void main (String[] args) {
		SpringApplication.run(JpaBestExampleApplication.class, args);
	}

}
