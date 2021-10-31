package br.com.leomanzini.user.system;

import java.util.List;

import br.com.leomanzini.user.system.model.Domain;
import br.com.leomanzini.user.system.model.SystemUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class JpqlApplication {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev-local-database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		selectQuery(entityManager);
//		selectFilteredQuery(entityManager);
//		selectNoTypedQuery(entityManager);

		choosingReturn(entityManager);

		entityManager.close();
		entityManagerFactory.close();
	}

	public static void choosingReturn(EntityManager entityManager) {
		String consultQuery = "select user.domain from SystemUser user where user.id = 1";

		TypedQuery<Domain> typedQuery = entityManager.createQuery(consultQuery, Domain.class);
		Domain domain = typedQuery.getSingleResult();

		System.out.println(domain);
		
		// Query JPQL sempre retorna o tipo do campo buscado na consulta
		consultQuery = "select user.name from SystemUser user where user.id = 1";
		TypedQuery<String> stringTypedQuery = entityManager.createQuery(consultQuery, String.class);
		String userName = stringTypedQuery.getSingleResult();
		
		System.out.println(userName);
	}

	public static void selectQuery(EntityManager entityManager) {

		String consultQuery = "select user from SystemUser user";

		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(consultQuery, SystemUser.class);
		List<SystemUser> resultList = typedQuery.getResultList();

		resultList.forEach(user -> System.out.println(user));
	}

	public static void selectFilteredQuery(EntityManager entityManager) {

		String filteredQuery = "select user from SystemUser user where user.id = 1";

		TypedQuery<SystemUser> typedFilteredQuery = entityManager.createQuery(filteredQuery, SystemUser.class);
		SystemUser user = typedFilteredQuery.getSingleResult();

		System.out.println(user);
	}

	public static void selectNoTypedQuery(EntityManager entityManager) {

		String query = "select user from SystemUser user where user.di = 2";

		Query noTypedQuery = entityManager.createQuery(query);
		SystemUser user = (SystemUser) noTypedQuery.getSingleResult();

		System.out.println(user);
	}
}
