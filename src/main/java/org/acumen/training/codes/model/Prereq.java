package org.acumen.training.codes.model;

import org.acumen.training.codes.model.compositekeys.PrereqId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Prereq {
	private PrereqId ids;
	private Course courseId;
	private Course prereqId;

	@EmbeddedId
	public PrereqId getIds() {
		return ids;
	}

	public void setIds(PrereqId ids) {
		this.ids = ids;
	}

	@OneToOne
    @JoinColumn(name = "course_id",referencedColumnName = "course_id", insertable = false, updatable = false)
	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	@OneToOne
    @JoinColumn(name = "prereq_id",referencedColumnName = "course_id", insertable = false, updatable = false)
	public Course getPrereqId() {
		return prereqId;
	}

	public void setPrereqId(Course prereqId) {
		this.prereqId = prereqId;
	}

	@Override
	public String toString() {
		return "%s %s".formatted(ids.getCourseId(), ids.getPrereqId());
	}
}
