package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.NhanVien;
import com.example.demo.model.Pagination;
import com.example.demo.model.Role;


/**
 * Interface phan service xu ly chuc nang cua vai tro
 * @author PHUONG
 * @version 1.0
 */
public interface RoleService {

	/**
	 * Tao moi vai tro
	 * @param role
	 * @return role
	 */
	public Role addRole(Role role);

	/**
	 * Cap nhat vai tro
	 * @param id
	 * @param role
	 * @return role
	 */
	public Role updateRole(long id, Role role);

	/**
	 * Xoa trang thai vai tro
	 * @param id
	 * @return role
	 */
	public Role deleteRole(long id);

	/**
	 * Lay toan bo danh sach vai tro
	 * @param pageNumber
	 * @param pageSize
	 * @return roleRepository
	 */
	public Pagination<Role> getAllRole(int pageNumber, int pageSize);

	/**
	 * Lay danh sach vai tro thoa man tham so truyen vao
	 * @param id
	 * @param role_name
	 * @param role_code
	 * @param status
	 * @param pageNumber
	 * @param pageSize
	 * @return roleRepository
	 */
	public List<Role> getRole(long id, String role_name, String role_code, Long status, int pageNumber, int pageSize);
}
