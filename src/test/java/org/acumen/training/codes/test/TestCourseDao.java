package org.acumen.training.codes.test;

import java.util.Arrays;
import java.util.List;

import org.acumen.training.codes.UnivConfiguration;
import org.acumen.training.codes.dao.CourseDao;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCourseDao {
	private static Logger LOGGER = Logger.getLogger(TestCourseDao.class);
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
	public void testGetTotalEnrolledPerCourse() {
		cfg.createConfiguration();
		SessionFactory sf = cfg.getSessionFactory();
		CourseDao dao = new CourseDao(sf);
		List<Object[]> data = dao.getTotalEnrolledPerCourse();
		data.stream().forEach((rec) -> {
			System.out.println(Arrays.toString(rec));
		});
		LOGGER.info("testGetTotalEnrolledPerCours() executed");
	}
}
