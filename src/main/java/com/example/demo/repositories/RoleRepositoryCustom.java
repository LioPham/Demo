package com.example.demo.repositories;

import java.util.List;

import com.example.demo.model.Pagination;
import com.example.demo.model.Role;


public interface RoleRepositoryCustom {
	Pagination<Role> fillAllRole(int pageNumber, int pageSize);
	List<Role> fillRole(long id, String role_name, String role_code, Long status, int pageNumber, int pageSize);
}
