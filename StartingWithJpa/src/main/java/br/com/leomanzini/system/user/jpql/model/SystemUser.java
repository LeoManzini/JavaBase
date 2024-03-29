package br.com.leomanzini.system.user.jpql.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "system_user")
public class SystemUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String login;
	private String password;
	private String name;
	
	@Column(name = "last_acess")
	private LocalDateTime lastAccess;
	
	@ManyToOne
	private Domain domain;
	
	@OneToOne(mappedBy = "user")
	private Configuration configuration;
	
	/**
	 * Gerencia versoes com o lock otimista, caso o registro for atualizado, de uma versao diferente do registro da base atualmente
	 * nao atualiza, pois o dado foi alterado ou deletado durante a sua sessao, pois a cada alteracao esse atributo sera atualizado
	 */
	@Version
	private Integer version;

	public SystemUser() {
	}
	
	public SystemUser(Integer id, String login, String password, String name, LocalDateTime lastAccess, Domain domain,
			Configuration configuration) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
		this.lastAccess = lastAccess;
		this.domain = domain;
		this.configuration = configuration;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(LocalDateTime lastAccess) {
		this.lastAccess = lastAccess;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
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
		SystemUser other = (SystemUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User id: " + id + ", login: " + login + ", name: " + name;
	}
}
