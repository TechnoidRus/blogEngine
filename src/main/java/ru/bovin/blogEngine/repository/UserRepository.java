package ru.bovin.blogEngine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.bovin.blogEngine.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
