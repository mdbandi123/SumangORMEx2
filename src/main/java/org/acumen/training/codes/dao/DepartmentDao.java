package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;
import org.jboss.logging.Logger;

public class DepartmentDao {
	private static final Logger LOGGER = Logger.getLogger(DepartmentDao.class);
	private SessionFactory sf;

	public DepartmentDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	public List<Object[]> getTeacherCountAndAvgSalPerDept(){
		LOGGER.info("executing getTeacherCountAndAvgSalPerDept()...");
		List<Object[]> recs = new ArrayList<>();
		
		try (Session sess = sf.openSession();){
			SelectionQuery<Object[]> query = sess.createNamedQuery("getTeacherCountAndAvgSalPerDept", Object[].class);
			recs = query.getResultList();
			
			LOGGER.info("executed getTeacherCountAndAvgSalPerDept() successfully");
			return recs;
		} catch (Exception e) {
			LOGGER.error("encountered exception: %s".formatted(e));
			e.printStackTrace();
		}
		
		return recs;
	}
	
	public List<Object[]> getTeacherCountPerDept(){
		LOGGER.info("executing getTeacherCountPerDept()...");
		List<Object[]> recs = new ArrayList<>();
		
		try (Session sess = sf.openSession();){
			SelectionQuery<Object[]> query = sess.createNamedQuery("getTeacherCountPerDept", Object[].class);
			recs = query.getResultList();
			
			LOGGER.info("executed getTeacherCountPerDept() successfully");
			return recs;
		} catch (Exception e) {
			LOGGER.error("encountered exception: %s".formatted(e));
			e.printStackTrace();
		}
		
		return recs;
	}
}
