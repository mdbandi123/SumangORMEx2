package org.acumen.training.codes.model;

import java.util.Set;

import org.acumen.training.codes.model.compositekeys.SectionId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(catalog = "university")
public class Section {
	private SectionId ids;

	private String building;
	private String roomNumber;
	private String timeSlotId;

	private Set<Classroom> classrooms;
	
	private Takes take;

	@EmbeddedId
	public SectionId getIds() {
		return ids;
	}

	public void setIds(SectionId ids) {
		this.ids = ids;
	}

	@Column(name = "building", length = 15)
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	@Column(name = "room_number", length = 7)
	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Column(name = "time_slot_id", length = 4)
	public String getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(String timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	@ManyToMany
	@JoinTable(joinColumns = { 
			@JoinColumn(name = "building", referencedColumnName = "building", insertable = false, updatable = false),
			@JoinColumn(name = "room_number", referencedColumnName = "room_number", insertable = false, updatable = false)
			}
	)
	public Set<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(Set<Classroom> classrooms) {
		this.classrooms = classrooms;
	}
	
	@OneToOne(mappedBy = "section")
	public Takes getTake() {
		return take;
	}

	public void setTake(Takes take) {
		this.take = take;
	}

	@Override
	public String toString() {
		return "%s %s %s %d %s %s %s".formatted(ids.getCourseId(), ids.getSecId(), ids.getSemester(), ids.getYear(),
				building, roomNumber, timeSlotId);
	}
}
