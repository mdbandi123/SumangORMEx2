package org.acumen.training.codes.model;

import org.acumen.training.codes.model.compositekeys.TakesId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Takes {
	private TakesId ids;
	private String grade;
	
	private Section section;
	private Student student;

	@EmbeddedId
	public TakesId getIds() {
		return ids;
	}

	public void setIds(TakesId ids) {
		this.ids = ids;
	}

	@Column(name = "grade", length = 2)
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@OneToOne
	@JoinColumns({
	    @JoinColumn(name = "course_id", insertable = false, updatable = false),
	    @JoinColumn(name = "sec_id", insertable = false, updatable = false),
	    @JoinColumn(name = "semester", insertable = false, updatable = false),
	    @JoinColumn(name = "year", insertable = false, updatable = false)
	})
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "%s %s %s %s %d %s".formatted(ids.getCourseId(), ids.getId(), ids.getSecId(), ids.getSemester(),
				ids.getYear(), grade);
	}

}
