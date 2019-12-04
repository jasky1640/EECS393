package entity;

import java.io.Serializable;

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int course_id;
	private String course_code;
	private String name;
	private String time_slots;
	private String prerequisite_courses;
	private String type;
	private int depth;
	private long credit_hour;
	
	public Course() {
		
		
	}
	
	public Course(int course_id, String course_code, String name, String time_slots, String prerequisite_courses, String type, int depth, long credit_hour)
	{
		this.course_id=course_id;
		this.course_code=course_code;
		this.name=name;
		this.time_slots=time_slots;
		this.prerequisite_courses=prerequisite_courses;
		this.type=type;
		this.depth=depth;
		this.credit_hour=credit_hour;
	}
	
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime_slots() {
		return time_slots;
	}
	public void setTime_slots(String time_slots) {
		this.time_slots = time_slots;
	}
	public String getPrerequisite_courses() {
		return prerequisite_courses;
	}
	public void setPrerequisite_courses(String prerequisite_courses) {
		this.prerequisite_courses = prerequisite_courses;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public long getCredit_hour() {
		return credit_hour;
	}
	public void setCredit_hour(long credit_hour) {
		this.credit_hour = credit_hour;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course_code == null) ? 0 : course_code.hashCode());
		result = prime * result + course_id;
		result = prime * result + (int) (credit_hour ^ (credit_hour >>> 32));
		result = prime * result + depth;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prerequisite_courses == null) ? 0 : prerequisite_courses.hashCode());
		result = prime * result + ((time_slots == null) ? 0 : time_slots.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (course_code == null) {
			if (other.course_code != null)
				return false;
		} else if (!course_code.equals(other.course_code))
			return false;
		if (course_id != other.course_id)
			return false;
		if (credit_hour != other.credit_hour)
			return false;
		if (depth != other.depth)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prerequisite_courses == null) {
			if (other.prerequisite_courses != null)
				return false;
		} else if (!prerequisite_courses.equals(other.prerequisite_courses))
			return false;
		if (time_slots == null) {
			if (other.time_slots != null)
				return false;
		} else if (!time_slots.equals(other.time_slots))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_code=" + course_code + ", name=" + name + ", time_slots="
				+ time_slots + ", prerequisite_courses=" + prerequisite_courses + ", type=" + type + ", depth=" + depth
				+ ", credit_hour=" + credit_hour + "]";
	}
}
