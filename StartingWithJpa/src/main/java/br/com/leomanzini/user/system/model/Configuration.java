package br.com.leomanzini.user.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Configuration {
	
	@Id
	private Integer id;
	
	@MapsId
	@OneToOne
	private User user;
	
	private boolean receiveNotifications;
	private boolean finishSession;
	
	public Configuration() {
	}

	public Configuration(Integer id, User user, boolean receiveNotifications, boolean finishSession) {
		this.id = id;
		this.user = user;
		this.receiveNotifications = receiveNotifications;
		this.finishSession = finishSession;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isReceiveNotifications() {
		return receiveNotifications;
	}

	public void setReceiveNotifications(boolean receiveNotifications) {
		this.receiveNotifications = receiveNotifications;
	}

	public boolean isFinishSession() {
		return finishSession;
	}

	public void setFinishSession(boolean finishSession) {
		this.finishSession = finishSession;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Configuration other = (Configuration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
