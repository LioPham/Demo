package com.example.demo.repositories;

import java.util.List;

import com.example.demo.model.Pagination;
import com.example.demo.model.Role;

/**
 * Interface phan repository custom xu ly cac chuc nang lay danh sach cua vai tro
 * @author PHUONG
 * @version 1.0
 */
public interface RoleRepositoryCustom {
	/**
	 * Xu ly hien thi tat ca danh sach vai tro
	 * @param pageNumber
	 * @param pageSize
	 * @return result voi list vai tro
	 */
	Pagination<Role> fillAllRole(int pageNumber, int pageSize);
	
	/**
	 * Xu ly hien danh sach vai tro thoa man cac tham so truyen vao
	 * @param id
	 * @param role_name
	 * @param role_code
	 * @param status
	 * @param pageNumber
	 * @param pageSize
	 * @return result voi list vai tro
	 */
	List<Role> fillRole(long id, String role_name, String role_code, Long status, int pageNumber, int pageSize);
}
