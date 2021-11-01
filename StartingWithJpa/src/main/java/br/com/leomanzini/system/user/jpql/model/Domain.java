package br.com.leomanzini.system.user.jpql.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "domain")
public class Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "domain")
	private List<SystemUser> users;

	/**
	 * Gerencia versoes com o lock otimista, caso o registro for atualizado, de uma versao diferente do registro da base atualmente
	 * nao atualiza, pois o dado foi alterado ou deletado durante a sua sessao, pois a cada alteracao esse atributo sera atualizado
	 */
	@Version
	private Integer version;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SystemUser> getUsers() {
		return users;
	}

	public void setUsers(List<SystemUser> users) {
		this.users = users;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Domain dominio = (Domain) o;

		return id.equals(dominio.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Domain id: " + id + ", name: " + name + ", users: " + users;
	}
}