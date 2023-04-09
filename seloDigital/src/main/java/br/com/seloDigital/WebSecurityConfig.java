package br.com.seloDigital;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authz -> authz
					.requestMatchers("/home").permitAll()
					.anyRequest().authenticated()
				)
			.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl("/usuario/pedido", true)
					.failureUrl("/login?error")
					.permitAll()
				)
			.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/home")
				)
			.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	public UserDetailsManager users(DataSource dataSource) {
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
		
//		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		
//		UserDetails user = User.builder()
//				.username("rafael")
//				.password(passwordEncoder.encode("123456789"))
//				.roles("USER")
//				.build();
//		UserDetails admin = User.builder()
//				.username("#rafael")
//				.password(passwordEncoder.encode("123456789"))
//				.roles("USER", "ADMIN")
//				.build();
//		
//		users.createUser(user);
//		users.createUser(admin);
		
		return users;
	}
}