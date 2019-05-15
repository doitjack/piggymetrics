package com.piggymetrics.auth.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.piggymetrics.auth.domain.User;
import com.piggymetrics.auth.dto.QueryUser;




public interface UserService<S extends User> {

	void create(User user);
	 Optional<S> findByUsername(String username);

	    Optional<S> findByEmail(String email);

	    Page<S> findAll(Pageable pageable);

	    Page<S> findAll(QueryUser query, Pageable pageable);

	    S save(S entity);

	    Optional<S> findById(String id);

	    long count();

	    void delete(S entity);

	    void deleteAll();

	    S initNewInstance();
}
