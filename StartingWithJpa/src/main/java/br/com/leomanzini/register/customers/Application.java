package br.com.leomanzini.register.customers;

import br.com.leomanzini.register.customers.model.Clients;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev-local-database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		Consultando uma entidade no banco
//		Clients clientOne = entityManager.find(Clients.class, 1);
//		System.out.println(clientOne);
		
		Clients clientTwo = new Clients();
		clientTwo.setName("Leonardo Henrique");
		clientTwo.setEmail("lg1.10@hotmail.com");
		
		entityManager.getTransaction().begin();
		entityManager.persist(clientTwo);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
