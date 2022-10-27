package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.Pagination;
import com.example.demo.model.Role;

public class RoleRepositoryImpl implements RoleRepositoryCustom {

	private static final Logger LOG = LoggerFactory.getLogger(RoleRepositoryImpl.class);

	@PersistenceContext
	private EntityManager em;

//	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

//	@Override
//	public List<Role> fillByRole() {
//		List<Role> result = new ArrayList<>();
//		try {
////			Session session = sessionFactory.openSession();
////			Query query = session.createQuery("select * FROM Role");
////			query.setFirstResult(0);
////			query.setMaxResults(10);
////			result = query.list();
////			return result;
//			
//			int pageNumber = 1;
//			int pageSize = 10;
//			
//			
//			String sql = "select * from Role";
//			Query query = em.createNativeQuery(sql,Role.class);
//			query.setFirstResult(pageNumber - 1);// phan trang, lay tu phan tu thu 0 trong list, max lay 10 phan tu
//			query.setMaxResults(pageSize);
//			
//			pageNumber += pageSize;
//			result = query.getResultList();
//		} catch (Exception ex) {
//			LOG.error("fillByRole: " + ex.getMessage());
//		}
//		
//		return result;
//	}

	@Override
	public Pagination<Role> fillAllRole(int pageNumber, int pageSize) {
		int lastPageNumber = 0;
		Long totalRecords = new Long(100);
		List<Role> roleList = new ArrayList<>();

		try {
			String countSql = "select count(id) from Role";
			Query countQuery = em.createQuery(countSql);
			totalRecords = (Long) countQuery.getSingleResult();

			if (totalRecords % pageSize == 0) {
				lastPageNumber = (int) (totalRecords / pageSize);
			} else {
				lastPageNumber = (int) (totalRecords / pageSize) + 1;
			}
		} catch (Exception ex) {
			LOG.error("totalRecords, lastPageNumber: " + ex.getMessage());
		}

		try {
			String sql = "select * from Role";
			Query query = em.createNativeQuery(sql, Role.class);
			query.setFirstResult((pageNumber - 1) * pageSize);
			query.setMaxResults(pageSize);
			roleList = query.getResultList();
		} catch (Exception ex) {
			LOG.error("fillByRole: " + ex.getMessage());
		}
		Pagination<Role> result = new Pagination<>();
		result.setCurrentPageNumber(pageNumber);
		result.setPageSize(pageSize);
		result.setLastPageNumber(lastPageNumber);
		result.setTotalRecords(totalRecords);
		result.setRecords(roleList);
		return result;

	}

	@Override
	public List<Role> fillRole(long id, String role_name, String role_code, Long status, int pageNumber, int pageSize) {

		List<Role> result = new ArrayList<>();
		String sql = "select r from Role r where r.id = :id "
				+ "and (:role_name is null or r.role_name like :role_name) "
				+ "and (:role_code is null or r.role_code like :role_code) "
				+ "and (:status is null or r.status = :status) ";
		Query query = em.createQuery(sql, Role.class);

		query.setParameter("id", id);
		query.setParameter("role_name", role_name);
		query.setParameter("role_code", role_code);

		query.setParameter("status", status);

		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		result = query.getResultList();

		return result;

	}

}
