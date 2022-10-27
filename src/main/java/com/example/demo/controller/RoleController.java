package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pagination;
import com.example.demo.model.Role;
import com.example.demo.service.RoleService;
import com.example.demo.util.ResponseJson;

@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	RoleService roleService;

	@GetMapping("/test")
	public String test() {
		return "hhhhhh";
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseJson> addRole(@RequestBody @Valid Role role) {
		try {
			if (role == null) {
				return createErrorResponse("Not found", HttpStatus.NOT_FOUND);
			}
			Role dataRole = roleService.addRole(role);
			if (dataRole != null) {
				return createSuccessResponse(dataRole, HttpStatus.OK);
			}
		} catch (Exception ex) {
			LOG.error("add" + ex.getMessage(), ex);
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseJson> updateRole(@RequestParam("id") long id, @RequestBody @Valid Role role) {
		try {
			if (role == null) {
				return createErrorResponse("Not found", HttpStatus.NOT_FOUND);
			}
			Role dataRole = roleService.updateRole(id, role);
			if (dataRole != null) {
				return createSuccessResponse(dataRole, HttpStatus.OK);
			}
		} catch (Exception ex) {
			LOG.error("update" + ex.getMessage(), ex);
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@PutMapping("/is_delete")
	public ResponseEntity<ResponseJson> deleteRole(@RequestParam("id") long id) {
		try {
			Role dataRole = roleService.deleteRole(id);
			if (dataRole != null) {
				return createSuccessResponse(dataRole, HttpStatus.OK);
			}
		} catch (Exception ex) {
			LOG.error("delete" + ex.getMessage(), ex);
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<ResponseJson> getAllRole(
			@RequestParam(value="pageSize" , defaultValue = "5") int pageSize,
			@RequestParam(value="pageNumber" , defaultValue = "0") int pageNumber) {
		try {
			Pagination<Role> dataRole = roleService.getAllRole(pageNumber, pageSize);
			if (dataRole != null) {
				return createSuccessResponse(dataRole, HttpStatus.OK);
			}
		} catch (Exception ex) {
			LOG.error("get" + ex.getMessage(), ex);
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
	@GetMapping(value = "/get")
	public ResponseEntity<ResponseJson> getRole(@RequestParam("id") long id, @RequestParam(value = "role_name", required = false) String role_name,
			@RequestParam(value = "role_code", required = false) String role_code, @RequestParam(value = "status", required = false) Long status,
			@RequestParam(value="pageSize" , defaultValue = "5") int pageSize,
			@RequestParam(value="pageNumber" , defaultValue = "0") int pageNumber) {
		try {
			List<Role> dataRole = roleService.getRole(id, role_name, role_code, status, pageNumber, pageSize);
			if (dataRole != null) {
				return createSuccessResponse(dataRole, HttpStatus.OK);
			}
		} catch (Exception ex) {
			LOG.error("get" + ex.getMessage(), ex);
			return createErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
}
