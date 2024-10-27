package org.acumen.training.codes.test;

import java.util.Arrays;
import java.util.List;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.DepartmentDao;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDepartmentDao {
	private static Logger LOGGER = 
			Logger.getLogger(TestDepartmentDao.class);
	private UnivConfiguration cfg;

	@BeforeEach()
	public void setup() {
		cfg = new UnivConfiguration();
	}

	@AfterEach()
	public void teardown() {
		cfg = null;
	}
	
	@Test
	public void testQueryTeacherCountAndAvgSalPerDept() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		DepartmentDao dao = new DepartmentDao(sf);
		List<Object[]> data = dao.queryTeacherCountAndAvgSalPerDept();
		data.stream().forEach((rec) -> {
			System.out.println(Arrays.toString(rec));
		});
		LOGGER.info("testQueryTeacherCountAndAvgSalPerDept() executed");
	}
	
	@Test
	public void testQueryTeacherCountPerDept() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		DepartmentDao dao = new DepartmentDao(sf);
		List<Object[]> data = dao.queryTeacherCountPerDept();
		data.stream().forEach((rec) -> {
			System.out.println(Arrays.toString(rec));
		});
		LOGGER.info("testQueryTeacherCountPerDept() executed");
	}
}
