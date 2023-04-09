package br.com.seloDigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.seloDigital.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>  {
	
	User findByUsername(String username);
}
