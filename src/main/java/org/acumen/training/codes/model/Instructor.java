package org.acumen.training.codes.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@NamedQueries(value = {
		@NamedQuery(name = "updateSalarySetToFortyFiveK", query = "update Instructor i set i.salary = :nsalary"),
		@NamedQuery(name = "updateBiologySalaryAddFiveK", query = "update Instructor i set i.salary = i.salary + :addamt where i.deptName = :deptname") })
@Entity
@Table(catalog = "university")
public class Instructor {
	private String id;
	private String name;
	private String deptName;
	private Double salary;

	private Set<Teaches> teaches;
	private Set<Advisor> advisors;

	private Department department;

	@Id
	@Column(name = "id", unique = true, length = 5)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "dept_name", length = 20)
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String dept_name) {
		this.deptName = dept_name;
	}

	@Column(name = "salary")
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@OneToMany(mappedBy = "instructor", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	public Set<Teaches> getTeaches() {
		return teaches;
	}

	public void setTeaches(Set<Teaches> teaches) {
		this.teaches = teaches;
	}

	@ManyToOne
	@JoinColumn(name = "dept_name", insertable = false, updatable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@OneToMany(mappedBy = "instructor")
	public Set<Advisor> getAdvisors() {
		return advisors;
	}

	public void setAdvisors(Set<Advisor> advisors) {
		this.advisors = advisors;
	}

	@Override
	public String toString() {
		return "%s %s %s %f".formatted(id, name, deptName, salary);
	}

}
