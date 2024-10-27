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
	
	public List<Object[]> queryTeacherCountAndAvgSalPerDept(){
		LOGGER.info("executing queryTeacherCountAndAvgSalPerDept()...");
		List<Object[]> recs = new ArrayList<>();
		
		try (Session sess = sf.openSession();){
			SelectionQuery<Object[]> query = 
					sess.createNamedQuery("queryTeacherCountAndAvgSalPerDept", 
										Object[].class);
			recs = query.getResultList();
			
			LOGGER.info("executed queryTeacherCountAndAvgSalPerDept() "
					+ "successfully");
			return recs;
		} catch (Exception e) {
			LOGGER.error("encountered exception: %s".formatted(e));
			e.printStackTrace();
		}
		
		return recs;
	}
	
	public List<Object[]> queryTeacherCountPerDept(){
		LOGGER.info("executing queryTeacherCountPerDept()...");
		List<Object[]> recs = new ArrayList<>();
		
		try (Session sess = sf.openSession();){
			SelectionQuery<Object[]> query = 
					sess.createNamedQuery("queryTeacherCountPerDept", 
										Object[].class);
			recs = query.getResultList();
			
			LOGGER.info("executed queryTeacherCountPerDept() successfully");
			return recs;
		} catch (Exception e) {
			LOGGER.error("encountered exception: %s".formatted(e));
			e.printStackTrace();
		}
		
		return recs;
	}
}
