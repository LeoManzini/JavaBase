package br.com.leomanzini.users.natives;

import java.util.List;

import br.com.leomanzini.users.natives.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class NativesQueries {

	public static void main(String[] args) {
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("RESOURCE_LOCAL");
		EntityManager entityManager = entityFactory.createEntityManager();
		
//		simpleConsults(entityManager);
//		mapResults(entityManager);
//		mapDtoResults(entityManager);
		usingNamedNativeQuery(entityManager);
		
		entityManager.close();
		entityFactory.close();
	}
	
	public static void simpleConsults(EntityManager entityManager) {
		
        Query query = entityManager.createNativeQuery("select * from users", Users.class);
        List<Users> resultlist = query.getResultList();

        resultlist.stream().forEach(user -> System.out.println(user));
	}
	
	public static void mapResults(EntityManager entityManager) {
		
        Query query = entityManager.createNativeQuery("select * from sis_users", "users-another-field-name");
        List<Users> resultlist = query.getResultList();

        resultlist.stream().forEach(user -> System.out.println(user));
    }
	
	public static void mapDtoResults(EntityManager entityManager) {
		
        Query query = entityManager.createNativeQuery("select user_id, user_login, user_name from sis_users", "users-dto");
        List<Users> resultlist = query.getResultList();

        resultlist.stream().forEach(user -> System.out.println(user));
    }
	
	public static void usingNamedNativeQuery(EntityManager entityManager) {
		
        Query query = entityManager.createNamedQuery("named-query-users");
        List<Users> resultlist = query.getResultList();

        resultlist.stream().forEach(user -> System.out.println(user));
    }
}
