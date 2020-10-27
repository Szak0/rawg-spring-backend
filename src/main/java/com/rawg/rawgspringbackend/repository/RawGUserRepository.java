package com.rawg.rawgspringbackend.repository;

import com.rawg.rawgspringbackend.entity.RawGUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RawGUserRepository extends JpaRepository<RawGUser,Long> {




    List<RawGUser> getRawGUserByEmailOrUserName(String email, String userName);

//    List<String> getRawGUserByEmailAndPassword(String email, String password);
}
