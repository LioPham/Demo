package com.example.demo.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "ROLE")
@Data
public class Role {
	@Id
    @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
	@SequenceGenerator(sequenceName = "ROLE_SEQ", initialValue = 1, allocationSize = 1, name = "ROLE_SEQ")
    private long id;

    @Basic
    @Column(name = "ROLE_NAME")
    @NotEmpty(message = "Nhập thiếu role name")
    @Size(max = 255, message = "Nhập quá số từ cho phép")
    private String role_name;
    
    @Basic
    @Column(name = "ROLE_CODE")
    @NotEmpty(message = "Nhập thiếu role code")
    @Size(max = 255, message = "Nhập quá số từ cho phép")
    private String role_code;
    
    @Basic
    @Column(name = "STATUS")
    private Long status;
    
    @Basic
    @Column(name = "IS_DELETE")
    private long is_delete;
    
    @Basic
    @Column(name = "CREATOR_DATE")
    private String creator_date;

    public Role() {
	}
    
    public Role(String role_name, String role_code, Long status, long is_delete, String creator_date) {
		this.role_name = role_name;
		this.role_code = role_code;
		this.status = status;
		this.is_delete = is_delete;
		this.creator_date = creator_date;
	}

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}	

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}
	
	public long getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(long is_delete) {
		this.is_delete = is_delete;
	}

	public String getCreator_date() {
		return creator_date;
	}

	public void setCreator_date(String creator_date) {
		this.creator_date = creator_date;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + ", role_code=" + role_code + ", status=" + status
				+ ", is_delete=" + is_delete + ", creator_date=" + creator_date + "]";
	}
	
}
