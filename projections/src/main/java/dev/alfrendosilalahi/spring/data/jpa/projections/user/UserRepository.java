package dev.alfrendosilalahi.spring.data.jpa.projections.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    List<UserProjections> findAllBy();

}
