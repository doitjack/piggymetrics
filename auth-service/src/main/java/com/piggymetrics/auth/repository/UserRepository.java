package com.piggymetrics.auth.repository;

import com.piggymetrics.auth.domain.User;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> , QueryByExampleExecutor<User>  {
	
	 Optional<User> findByUsername(String username);
	 Optional<User> findByEmail(String email);
}
