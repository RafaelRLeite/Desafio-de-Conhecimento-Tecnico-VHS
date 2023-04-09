
package br.com.seloDigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.seloDigital.model")
public class SeloDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeloDigitalApplication.class, args);
	}
}