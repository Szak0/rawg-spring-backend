package com.rawg.rawgspringbackend.repository;

import com.rawg.rawgspringbackend.entity.RawGUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawGUserRepository extends JpaRepository<RawGUser,Long> {
}
