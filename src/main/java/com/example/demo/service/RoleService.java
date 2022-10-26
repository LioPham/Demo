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

	// Get role
	public Pagination<Role> getAllRole(int pageNumber, int pageSize);
	
//	public List<Role> getDetailRole(long id, Optional<String> role_name, Optional<String> role_code, Optional<Long> status);

	public List<Role> getDetailRole(long id, String role_name, String role_code, long status);
}
