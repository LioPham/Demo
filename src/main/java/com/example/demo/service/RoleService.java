package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.NhanVien;
import com.example.demo.model.Pagination;
import com.example.demo.model.Role;

public interface RoleService {

	// Create new role
	public Role addRole(Role role);

	// Update role
	public Role updateRole(long id, Role role);

	// Delete role
	public Role deleteRole(long id);

	// Get all role
	public Pagination<Role> getAllRole(int pageNumber, int pageSize);
	
	// Get role
	public List<Role> getRole(long id, String role_name, String role_code, Long status, int pageNumber, int pageSize);
}
