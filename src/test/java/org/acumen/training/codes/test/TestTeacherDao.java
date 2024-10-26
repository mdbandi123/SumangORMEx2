package org.acumen.training.codes.test;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.TeacherDao;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestTeacherDao {
	private static Logger LOGGER = Logger.getLogger(TestTeacherDao.class);
	private UnivConfiguration cfg;
	
	@BeforeEach()
	public void setup() {
		cfg = new UnivConfiguration();
	}
	
	@AfterEach()
	public void teardown() {
		cfg = null;
	}
	
	@Disabled
	@Test
	public void testUnivConfiguration() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);
		dao.updateSalarySetToFortyFiveK();
		LOGGER.info("updateSalarySetToFortyFiveK() executed");
	}
	
	@Test
	public void updateBiologySalaryAddFiveK() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);
		dao.updateBiologySalaryAddFiveK();
		LOGGER.info("updateBiologySalaryAddFiveK() executed");
	}
}
