package br.com.leomanzini.users.natives.model;

import br.com.leomanzini.users.natives.dto.UsersDTO;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.SqlResultSetMappings;

@SqlResultSetMappings({
	@SqlResultSetMapping(name = "users-another-field-name",
            entities = @EntityResult(entityClass = Users.class, 
            fields = {
            		@FieldResult(name = "id", column = "user_id"),
            		@FieldResult(name = "login", column = "user_login"),
            		@FieldResult(name = "password", column = "user_password"),
            		@FieldResult(name = "name", column = "user_name")
            })),
	@SqlResultSetMapping(name = "users-dto", classes = {
			@ConstructorResult(targetClass = UsersDTO.class, columns = {
					@ColumnResult(name = "user_id", type = Integer.class),
                    @ColumnResult(name = "user_login", type = String.class),
                    @ColumnResult(name = "user_name", type = String.class)
			})
	})
})
@NamedNativeQueries({
    @NamedNativeQuery(name = "named-query-users",
            query = "select * from sis_usuario", resultSetMapping = "users-another-field-name"
//            query = "select * from usuario", resultClass = Usuario.class
)})
@Entity
public class Users {
	
	@Id
    private Integer id;

    private String login;
    private String password;
    private String name;

	public Users() {
	}

	public Users(Integer id, String login, String password, String name) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.name = name;
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
		Users other = (Users) obj;
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
