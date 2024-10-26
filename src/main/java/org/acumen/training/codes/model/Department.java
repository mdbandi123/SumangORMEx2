package org.acumen.training.codes.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "getTeacherCountAndAvgSalPerDept",query = "select a.dept_name, count(b.name), coalesce(avg(b.salary),0.0) from department a left join instructor b on a.dept_name = b.dept_name group by a.dept_name;"),
		@NamedNativeQuery(name = "getTeacherCountPerDept",query = "select a.dept_name, count(b.name) from department a left join instructor b on a.dept_name = b.dept_name group by a.dept_name;")
})
@Entity
@Table(catalog = "university")
public class Department {
	private String deptName;
	private String building;
	private Double budget;
	
	private Set<Course> courses;
	private Set<Instructor> instructors;
	private Set<Student> students;

	@Id
	@Column(name = "dept_name", unique = true, length = 20)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "building", length = 15)
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Column(name = "budget")
	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	@OneToMany(mappedBy = "department")
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	@OneToMany(mappedBy = "department")
	public Set<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(Set<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	@OneToMany(mappedBy = "department")
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "%s %s %f".formatted(deptName, building, budget);
	}

}
