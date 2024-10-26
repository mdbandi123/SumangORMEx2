package org.acumen.training.codes.test;

import java.util.Arrays;
import java.util.List;

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
	
	@Disabled
	@Test
	public void testUpdateBiologySalaryAddFiveK() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);
		dao.updateBiologySalaryAddFiveK();
		LOGGER.info("updateBiologySalaryAddFiveK() executed");
	}
	
	@Disabled
	@Test
	public void testUpdateSalaryNonBiology() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);
		dao.updateSalaryNonBiology();
		LOGGER.info("testUpdateSalaryNonBiology() executed");
	}
	
	@Test
	public void testQueryMaxSalaryPerDept() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		TeacherDao dao = new TeacherDao(sf);
		List<Object[]> data =dao.queryMaxSalaryPerDept();
		data.stream().forEach((rec) -> {
			System.out.println(Arrays.toString(rec));
		});
		LOGGER.info("testQueryMaxSalaryPerDept() executed");
	}
}
