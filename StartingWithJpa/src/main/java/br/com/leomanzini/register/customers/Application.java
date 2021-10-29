package br.com.leomanzini.register.customers;

import br.com.leomanzini.register.customers.model.Clients;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev-local-database");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Clients clientOne = entityManager.find(Clients.class, 1);

		System.out.println(clientOne);

		entityManager.close();
		entityManagerFactory.close();
	}
}
