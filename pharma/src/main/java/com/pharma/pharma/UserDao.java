package com.pharma.pharma;


import java.util.List;
import java.util.Optional;

public interface UserDao {
	Optional<User> getUser(String phoneNumber);
}
