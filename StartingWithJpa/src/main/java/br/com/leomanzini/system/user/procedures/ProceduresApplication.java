package br.com.leomanzini.system.user.procedures;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

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
		
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("product_name");
		
		procedureQuery.registerStoredProcedureParameter("product_id", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("product_name", String.class, ParameterMode.OUT);
		
		procedureQuery.setParameter("product_id", 1);
		
		procedureQuery.execute();
		
		String productName = (String) procedureQuery.getOutputParameterValue("product_name");
		
		System.out.println(productName);
	}
	
	public static void researchsWithProcedures(EntityManager entityManager) {
		
	}
	
	public static void updatingWithProcedures(EntityManager entityManager) {
		
	}
}
