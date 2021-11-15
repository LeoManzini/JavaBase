package br.com.leomanzini.system.user.procedures;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProceduresApplication {

	public static void main(String[] args) {
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("procedures");
		EntityManager entityManager = entityFactory.createEntityManager();
		
//		queriesWithProcedures(entityManager);
//		researchsWithProcedures(entityManager);
//		updatingWithProcedures(entityManager);
		
		entityManager.close();
		entityFactory.close();
	}
	
	public static void queriesWithProcedures(EntityManager entityManager) {
		
	}
	
	public static void researchsWithProcedures(EntityManager entityManager) {
		
	}
	
	public static void updatingWithProcedures(EntityManager entityManager) {
		
	}
}
