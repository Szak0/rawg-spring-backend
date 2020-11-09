package com.rawg.rawgspringbackend.repository;

import com.rawg.rawgspringbackend.entity.RawGUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<RawGUser, Long> {


    Optional<RawGUser> getRawGUserByEmailOrUserName(String email, String userName);


}
