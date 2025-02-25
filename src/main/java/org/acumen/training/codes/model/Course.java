package org.acumen.training.codes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "queryTotalEnrolledPerCourse", 
				query = "select c.title, count(t.id) "
						+ "from course c left join takes t "
						+ "on c.course_id = t.course_id "
						+ "group by c.title;")
})
@Entity
@Table(catalog = "university")
public class Course {
	private String courseId;
	private String title;
	private String deptName;
	private Integer credits;
	
	private Department department;
	private Prereq prereqCID;
	private Prereq prereqPID;

	@Id
	@Column(name = "course_id", unique = true, length = 8)
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "dept_name", length = 20)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "credits")
	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	
	@ManyToOne
	@JoinColumn(name="dept_name", insertable = false, updatable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@OneToOne(mappedBy = "courseId")
	public Prereq getPrereqCID() {
		return prereqCID;
	}

	public void setPrereqCID(Prereq prereqCID) {
		this.prereqCID = prereqCID;
	}

	@OneToOne(mappedBy = "prereqId")
	public Prereq getPrereqPID() {
		return prereqPID;
	}

	public void setPrereqPID(Prereq prereqPID) {
		this.prereqPID = prereqPID;
	}

	@Override
	public String toString() {
		return "%s %s %s %d".formatted(courseId,title,deptName,credits);
	}
}
