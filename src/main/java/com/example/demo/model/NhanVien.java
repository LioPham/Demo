package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Dell on 10/12/2022
 */
@Entity
@Table(name = "NHAN_VIEN")
@Data
public class NhanVien {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NHAN_VIEN_SEQ")
    @SequenceGenerator(sequenceName = "NHAN_VIEN_SEQ", initialValue = 1, allocationSize = 1, name = "NHAN_VIEN_SEQ")
    private long id;

    @Basic
    @Column(name = "TEN")
    private String ten;

    @Basic
    @Column(name = "ROLE_NAME")
    private String role_name;
    
    @Basic
    @Column(name = "ROLE_CODE")
    private String role_code;
    
    @Basic
    @Column(name = "STATUS")
    private String status;
    
    @Basic
    @Column(name = "IS_DELETE")
    private String is_delete;
    
    @Basic
    @Column(name = "CREATOR_DATE")
    private String creator_date;

    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}

	public String getCreator_date() {
		return creator_date;
	}

	public void setCreator_date(String creator_date) {
		this.creator_date = creator_date;
	}

	@Transient
    private Long type;

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
    
    

}
