package org.acumen.training.codes.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Student {
	private String id;
	private String name;
	private String deptName;
	private Integer totCred;
	
	private Department department;
	private Set<Takes> takes;
	private Advisor advisor;

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

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Column(name = "tot_cred")
	public Integer getTotCred() {
		return totCred;
	}

	public void setTotCred(Integer totCred) {
		this.totCred = totCred;
	}
	
	@ManyToOne
	@JoinColumn(name = "dept_name", insertable = false, updatable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@OneToMany(mappedBy = "student")
	public Set<Takes> getTakes() {
		return takes;
	}

	public void setTakes(Set<Takes> takes) {
		this.takes = takes;
	}
	
	@OneToOne(mappedBy = "student")
	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}
	
	@Override
	public String toString() {
		return "%s %s %s %d".formatted(id, name, deptName, totCred);
	}
}
