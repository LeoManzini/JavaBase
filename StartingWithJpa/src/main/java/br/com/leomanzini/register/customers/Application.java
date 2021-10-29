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
		
//		Inserindo um novo cliente na base
//		Clients clientTwo = new Clients();
//		clientTwo.setName("Leonardo Henrique");
//		clientTwo.setEmail("lg1.10@hotmail.com");
//		
//		entityManager.getTransaction().begin();
//		entityManager.persist(clientTwo);
//		entityManager.getTransaction().commit();
		
//		Deletando um objeto do banco de dados
//		Clients clientThree = entityManager.find(Clients.class, 3);
//		entityManager.getTransaction().begin();
//		entityManager.remove(clientThree);
//		entityManager.getTransaction().commit();
		
// 		Atualizando os dados de um objeto na base com um objeto existente no codigo
//		Clients clientOne = entityManager.find(Clients.class, 1);
//		entityManager.getTransaction().begin();
//		clientOne.setName(clientOne.getName() + " de Oliveira");
//		entityManager.getTransaction().commit();
		
// 		Atualizando um objeto novo no codigo 
		Clients clientTwo = new Clients();
		clientTwo.setId(2);
		clientTwo.setName("Leonardo Henrique Manzini");
		clientTwo.setEmail("lg1.10@hotmail.com");
		entityManager.getTransaction().begin();
		entityManager.merge(clientTwo);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}
}
