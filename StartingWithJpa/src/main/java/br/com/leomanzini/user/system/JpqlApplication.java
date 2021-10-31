package br.com.leomanzini.user.system;

import java.util.List;

import br.com.leomanzini.user.system.model.SystemUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpqlApplication {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev-local-database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		selectQuery(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void selectQuery(EntityManager entityManager) {
		
		String consultQuery = "select user from SystemUser user";
		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(consultQuery, SystemUser.class);
		List<SystemUser> resultList = typedQuery.getResultList();
		
		resultList.forEach(user -> System.out.println("User login: " + user.getLogin() + ", last access: " + user.getLastAccess()));
	}
}
