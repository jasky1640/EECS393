package entity;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int user_id;
	private String user_name;
	private String user_password;
	private int user_type;
	private String core;
	private String breadth;
	private String depth;
	private String general;
	private String technical_elective;
	private int track;
	
	public User(int user_id, String user_name, String user_password, int user_type, String core, String breadth, String depth, String general, String technical_elective, int track)
	{
		this.user_id=user_id;
		this.user_name=user_name;
		this.user_password=user_password;
		this.user_type=user_type;
		this.core=core;
		this.breadth=breadth;
		this.depth=depth;
		this.general=general;
		this.technical_elective=technical_elective;
		this.track=track;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public String getCore() {
		return core;
	}
	public void setCore(String core) {
		this.core = core;
	}
	public String getBreadth() {
		return breadth;
	}
	public void setBreadth(String breadth) {
		this.breadth = breadth;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getGeneral() {
		return general;
	}
	public void setGeneral(String general) {
		this.general = general;
	}
	public String getTechnical_elective() {
		return technical_elective;
	}
	public void setTechnical_elective(String technical_elective) {
		this.technical_elective = technical_elective;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breadth == null) ? 0 : breadth.hashCode());
		result = prime * result + ((core == null) ? 0 : core.hashCode());
		result = prime * result + ((depth == null) ? 0 : depth.hashCode());
		result = prime * result + ((general == null) ? 0 : general.hashCode());
		result = prime * result + ((technical_elective == null) ? 0 : technical_elective.hashCode());
		result = prime * result + track;
		result = prime * result + user_id;
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + user_type;
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
		User other = (User) obj;
		if (breadth == null) {
			if (other.breadth != null)
				return false;
		} else if (!breadth.equals(other.breadth))
			return false;
		if (core == null) {
			if (other.core != null)
				return false;
		} else if (!core.equals(other.core))
			return false;
		if (depth == null) {
			if (other.depth != null)
				return false;
		} else if (!depth.equals(other.depth))
			return false;
		if (general == null) {
			if (other.general != null)
				return false;
		} else if (!general.equals(other.general))
			return false;
		if (technical_elective == null) {
			if (other.technical_elective != null)
				return false;
		} else if (!technical_elective.equals(other.technical_elective))
			return false;
		if (track != other.track)
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_type != other.user_type)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_type=" + user_type + ", core=" + core + ", breadth=" + breadth + ", depth=" + depth
				+ ", general=" + general + ", technical_elective=" + technical_elective + ", track=" + track + "]";
	}
}
