package br.com.pereira.mvc.mudi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pereira.mvc.mudi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
