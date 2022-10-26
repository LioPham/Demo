package com.example.demo.repositories;

import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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
			Query query = em.createNativeQuery(sql,Role.class);
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



}
