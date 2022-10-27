package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pagination;
import com.example.demo.model.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.RoleRepositoryCustom;

/**
 * Ke thua interface phan service xu ly cac chuc nang cua vai tro
 * @author PHUONG
 * @version 1.0
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	RoleRepositoryCustom roleRepositoryCustom;

	@Override
	public Role addRole(Role role) {
		try {
			if (role != null) {
				return roleRepository.save(role);
			}
		} catch (Exception ex) {
			LOG.error("addRole: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Role updateRole(long id, Role role) {
		try {
			if (role != null) {
				Role dataRole = roleRepository.findById(id).get();
				if (dataRole != null) {
					dataRole.setRole_name(role.getRole_name());
					dataRole.setRole_code(role.getRole_code());
					dataRole.setStatus(role.getStatus());
					dataRole.setIs_delete(role.getIs_delete());
					dataRole.setCreator_date(role.getCreator_date());
					return roleRepository.save(dataRole);
				}
			}
		} catch (Exception ex) {
			LOG.error("updateRole: " + ex.getMessage());
		}
		return null;

	}

	@Override
	public Role deleteRole(long id) {
		try {
			Role role = roleRepository.findById(id).get();
			if (id >= 1) {
				role.setIs_delete(1);
				return roleRepository.save(role);
			}
		} catch (Exception ex) {
			LOG.error("deleteRole: " + ex.getMessage());
		}
		return null;
	}

	@Override
	public Pagination<Role> getAllRole(int pageNumber, int pageSize) {
		return roleRepository.fillAllRole(pageNumber, pageSize);
	}

	@Override
	public List<Role> getRole(long id, String role_name, String role_code, Long status, int pageNumber, int pageSize) {
		return roleRepository.fillRole(id, role_name, role_code, status, pageNumber, pageSize);
	}

//	@Override
//	public List<Role> getRole(long id, String role_name, String role_code, long status) {
//		List<Role> dataRole = new ArrayList<>();
//		if (id >= 0) {
//			dataRole.addAll(roleRepository.fillDetailRoleById(id));
//		}
//		if (role_name != null) {
//			for (Role role: dataRole) {
//				if (!role.getRole_name().equals(role_name)) {
//					dataRole.addAll(roleRepository.fillDetailRoleByRoleName(role_name));
//				}
//			}			
//		}
//		if (role_code != null) {
//			for (Role role: dataRole) {
//				if (!role.getRole_code().equals(role_code)) {
//					dataRole.addAll(roleRepository.fillDetailRoleByRoleCode(role_code));
//				}
//			}	
//		}
//		if (status >= 0) {
//			for (Role role: dataRole) {
//				if (!(role.getStatus() == status)) {
//					dataRole.addAll(roleRepository.fillDetailRoleByStatus(status));
//				} 						
//			}
//		}
//		return dataRole;
//	}
}
