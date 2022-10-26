package com.example.demo.repositories;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Role;


@Repository
@Primary
public interface RoleRepository extends JpaRepository<Role, Long>, PagingAndSortingRepository<Role, Long>, RoleRepositoryCustom{
	
//	@Query(value = "select * from Role where id = :id", nativeQuery = true)
//	List<Role> fillDetailRole(@RequestParam("id") long id);
	
	@Query(value = "select * from Role where id = :id", nativeQuery = true)
	List<Role> fillDetailRoleById(@RequestParam("id") long id);
	
	@Query(value = "select * from Role where role_name = :role_name", nativeQuery = true)
	List<Role> fillDetailRoleByRoleName(@RequestParam("role_name") String role_name);
	
	@Query(value = "select * from Role where role_code = :role_code", nativeQuery = true)
	List<Role> fillDetailRoleByRoleCode(@RequestParam("role_code") String role_code);
	
	@Query(value = "select * from Role where status = :status", nativeQuery = true)
	List<Role> fillDetailRoleByStatus(@RequestParam("status") long status);
}
