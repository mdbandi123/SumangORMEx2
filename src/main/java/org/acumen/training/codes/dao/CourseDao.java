package org.acumen.training.codes.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;
import org.jboss.logging.Logger;

public class CourseDao {
	private static Logger LOGGER = Logger.getLogger(CourseDao.class);
	private SessionFactory sf;
	
	public CourseDao(SessionFactory sf) {
		this.sf = sf;
	}
	
	public List<Object[]> getTotalEnrolledPerCourse(){
		LOGGER.info("executing getTotalEnrolledPerCourse()...");
		List<Object[]> recs = new ArrayList<>();
		
		try (Session sess = sf.openSession();){
			SelectionQuery<Object[]> query = sess.createNamedQuery("getTotalEnrolledPerCourse", Object[].class);
			recs = query.getResultList();
			
			LOGGER.info("executed getTotalEnrolledPerCourse() successfully");
			return recs;
		} catch (Exception e) {
			LOGGER.error("encountered exception: %s".formatted(e));
			e.printStackTrace();
		}
		
		return recs;
	}
	
}
