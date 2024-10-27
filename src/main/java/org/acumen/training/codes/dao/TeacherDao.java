package org.acumen.training.codes.dao;

import java.util.List;

import org.acumen.training.codes.model.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.hibernate.query.SelectionQuery;
import org.jboss.logging.Logger;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class TeacherDao {
	private static Logger LOGGER = Logger.getLogger(TeacherDao.class);
	private SessionFactory sf;

	public TeacherDao(SessionFactory sf) {
		this.sf = sf;
	}

	public boolean updateSalarySetToFortyFiveK() {
		LOGGER.info("executing updateSalarySetToFortyFiveK()...");
		Double newSalary = 45000.00;
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		
		try {
			MutationQuery query = 
					sess.createNamedMutationQuery("updateSalarySetToFortyFiveK");
			query.setParameter("nsalary", newSalary);
			int rows = query.executeUpdate();
			
			txn.commit();
			
			LOGGER.info("executed updateSalarySetToFortyFiveK() successfully");
			LOGGER.info("Updated %d records".formatted(rows));
			return true;
		} catch (Exception e) {
			try {
				LOGGER.error("encountered exception: %s".formatted(e));
				LOGGER.info("rollback executing...");
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("encountered exception: %s".formatted(ee));
				ee.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("session closing...");
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("encountered exception: %s".formatted(eee));
				eee.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean updateBiologySalaryAddFiveK() {
		LOGGER.info("executing updateBiologySalaryAddFiveK()...");
		Double addAmt = 5000.00;
		String deptName = "Biology";
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		
		try {
			MutationQuery query = 
					sess.createNamedMutationQuery("updateBiologySalaryAddFiveK");
			query.setParameter("addamt", addAmt);
			query.setParameter("deptname", deptName);
			int rows = query.executeUpdate();
			
			txn.commit();
			
			LOGGER.info("executed updateBiologySalaryAddFiveK() successfully");
			LOGGER.info("Updated %d records".formatted(rows));
			return true;
		} catch (Exception e) {
			try {
				LOGGER.error("encountered exception: %s".formatted(e));
				LOGGER.info("rollback executing...");
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("encountered exception: %s".formatted(ee));
				ee.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("session closing...");
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("encountered exception: %s".formatted(eee));
				eee.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean updateSalaryNonBiology() {
		LOGGER.info("executing updateSalaryNonBiology()...");
		Double incPerc = 0.10;
		String deptName = "Biology";
		Session sess = sf.openSession();
		Transaction txn = sess.beginTransaction();
		
		try {
			MutationQuery query = 
					sess.createNamedMutationQuery("updateSalaryNonBiology");
			query.setParameter("incperc", incPerc);
			query.setParameter("deptname", deptName);
			int rows = query.executeUpdate();
			
			txn.commit();
			
			LOGGER.info("executed updateSalaryNonBiology() successfully");
			LOGGER.info("Updated %d records".formatted(rows));
			return true;
		} catch (Exception e) {
			try {
				LOGGER.error("encountered exception: %s".formatted(e));
				LOGGER.info("rollback executing...");
				txn.rollback();
			} catch (Exception ee) {
				LOGGER.error("encountered exception: %s".formatted(ee));
				ee.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("session closing...");
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("encountered exception: %s".formatted(eee));
				eee.printStackTrace();
			}
		}
		
		return false;
	}
	
	public List<Object[]> queryMaxSalaryPerDept() {
		LOGGER.info("executing queryMaxSalaryPerDept()...");
		List<Object[]> recs;
		Session sess = sf.openSession();
		try {
			CriteriaBuilder builder = sess.getCriteriaBuilder();
			CriteriaQuery<Object[]> sql = builder.createQuery(Object[].class);
			Root<Instructor> from = sql.from(Instructor.class);
			sql.multiselect(
					from.get("deptName"), builder.max(from.get("salary")))
			.where(builder.greaterThanOrEqualTo(from.get("salary"), 9000))
			.groupBy(from.get("deptName"));

			Query<Object[]> query = sess.createQuery(sql);
			recs = query.getResultList();
			
			LOGGER.info("executed queryMaxSalaryPerDept() successfully");
			return recs;
		} catch (Exception e) {
			try {
				LOGGER.error("encountered exception: %s".formatted(e));
				LOGGER.info("rollback executing...");
			} catch (Exception ee) {
				LOGGER.error("encountered exception: %s".formatted(ee));
				ee.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("session closing...");
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("encountered exception: %s".formatted(eee));
				eee.printStackTrace();
			}
		}
		return null;
	}
		
	public List<Object[]> queryTotalStudsPerInstructor() {
		LOGGER.info("executing queryTotalStudsPerInstructor()...");
		List<Object[]> recs;
		Session sess = sf.openSession();
		try {
			SelectionQuery<Object[]> query = sess.createNamedQuery("queryTotalStudsPerInstructor", Object[].class);
			recs = query.getResultList();
			
			LOGGER.info("executed queryTotalStudsPerInstructor() successfully");
			return recs;
		} catch (Exception e) {
			try {
				LOGGER.error("encountered exception: %s".formatted(e));
				LOGGER.info("rollback executing...");
			} catch (Exception ee) {
				LOGGER.error("encountered exception: %s".formatted(ee));
				ee.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				LOGGER.info("session closing...");
				sess.close();
			} catch (Exception eee) {
				LOGGER.error("encountered exception: %s".formatted(eee));
				eee.printStackTrace();
			}
		}
		return null;
	}
}
