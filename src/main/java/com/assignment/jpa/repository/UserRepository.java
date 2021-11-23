package com.assignment.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.jpa.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findBynameLike(String name);

	public List<User> findBynameStartingWith(String name);

	@Query("select u from User u where u.balance=?1")
	public List<User> findWithBalance(int balance);

	@Query(value = "select * from User where balance=(select max(balance) from User)", nativeQuery = true)
	public User findMax();

	@Query("select u from User u")
	public List<User> findInSort(Sort sort);

	@Query(value = "select * from User where name=:name or balance=:balance", nativeQuery = true)
	public List<User> findNameAndBal(@Param("name") String name, @Param("balance") Integer bal);

	@Modifying
	@Transactional
	@Query("update User u set u.balance=?2 where u.name=?1")
	public void updateByName(String name, int balance);

	@Query(value = "select * from User where name=?1", nativeQuery = true)
	public Page<User> findByName(String name, Pageable page);

}
