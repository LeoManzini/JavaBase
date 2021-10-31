package br.com.leomanzini.user.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Configuration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@MapsId
	@OneToOne
	private SystemUser user;

	private boolean receiveNotifications;

	private boolean logoutAutomatically;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SystemUser getUser() {
		return user;
	}

	public void setUser(SystemUser user) {
		this.user = user;
	}

	public boolean isReceiveNotifications() {
		return receiveNotifications;
	}

	public void setReceiveNotifications(boolean receiveNotifications) {
		this.receiveNotifications = receiveNotifications;
	}

	public boolean isLogoutAutomatically() {
		return logoutAutomatically;
	}

	public void setLogoutAutomatically(boolean logoutAutomatically) {
		this.logoutAutomatically = logoutAutomatically;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Configuration that = (Configuration) o;

		return id.equals(that.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}