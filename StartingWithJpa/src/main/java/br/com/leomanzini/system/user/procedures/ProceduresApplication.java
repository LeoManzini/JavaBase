package br.com.leomanzini.system.user.procedures;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

import br.com.leomanzini.system.user.procedures.model.Product;

public class ProceduresApplication {

	public static void main(String[] args) {

		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("procedures");
		EntityManager entityManager = entityFactory.createEntityManager();

//		queriesWithProcedures(entityManager);
//		researchsWithProcedures(entityManager);
		updatingWithProcedures(entityManager);

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

	@SuppressWarnings("unchecked")
	public static void researchsWithProcedures(EntityManager entityManager) {

		// Ao contrario da chamada acima, precisa passar o tipo do retorno, pois a
		// procedure nao especifica nenhum
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("search_products",
				Product.class);

		procedureQuery.registerStoredProcedureParameter("termo", String.class, ParameterMode.IN);

		procedureQuery.setParameter("termo", "S");

		procedureQuery.execute();
		
		List<Product> resultList = procedureQuery.getResultList();
		
		resultList.forEach(product -> System.out.println(product));
	}

	public static void updatingWithProcedures(EntityManager entityManager) {
		
		StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("modify_product_price");

		procedureQuery.registerStoredProcedureParameter("product_id", Integer.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("amount", BigDecimal.class, ParameterMode.IN);
		procedureQuery.registerStoredProcedureParameter("new_price", BigDecimal.class, ParameterMode.OUT);

		procedureQuery.setParameter("product_id", 1);
		procedureQuery.setParameter("amount", 1.1);

		procedureQuery.execute();

		BigDecimal productPrice = (BigDecimal) procedureQuery.getOutputParameterValue("new_price");

		System.out.println(productPrice);
	}
}
