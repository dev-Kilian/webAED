package com.KilianElRincon.webAED.repository;

import com.KilianElRincon.webAED.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}