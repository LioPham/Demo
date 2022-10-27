package com.example.demo.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Role;


/**
 * Interface phan repository cua vai tro
 * @author PHUONG
 * @version 1.0
 */
@Repository
@Primary
public interface RoleRepository extends JpaRepository<Role, Long>, RoleRepositoryCustom{
	
//	@Query(value = "select * from Role where id = :id", nativeQuery = true)
//	List<Role> fillRole(@RequestParam("id") long id);
	
//	@Query(value = "select * from Role where id = :id", nativeQuery = true)
//	List<Role> fillRoleById(@RequestParam("id") long id);
//	
//	@Query(value = "select * from Role where role_name = :role_name", nativeQuery = true)
//	List<Role> fillRoleByRoleName(@RequestParam("role_name") String role_name);
//	
//	@Query(value = "select * from Role where role_code = :role_code", nativeQuery = true)
//	List<Role> fillRoleByRoleCode(@RequestParam("role_code") String role_code);
//	
//	@Query(value = "select * from Role where status = :status", nativeQuery = true)
//	List<Role> fillRoleByStatus(@RequestParam("status") long status);
}
