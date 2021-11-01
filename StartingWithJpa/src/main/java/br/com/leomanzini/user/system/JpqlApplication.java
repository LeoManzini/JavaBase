package br.com.leomanzini.user.system;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import br.com.leomanzini.user.system.dto.SystemUserDTO;
import br.com.leomanzini.user.system.model.Configuration;
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

//		choosingReturn(entityManager);

//		choosingMoreThenOneReturnAbstraction(entityManager);

//		choosingMoreThenOneReturn(entityManager);

//		passParameters(entityManager);

//		joiningTables(entityManager);

//		leftJoiningTables(entityManager);

//		joinFetchTables(entityManager);

//		likeFilter(entityManager);

//		betweenFilter(entityManager);

//		logicalOperators(entityManager);

//		order(entityManager);
		
		pagination(entityManager);
		
		entityManager.close();
		entityManagerFactory.close();
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

	public static void choosingMoreThenOneReturn(EntityManager entityManager) {

		/**
		 * Como temos o tipo desse objeto SystemUserDTO mapeado com os atributos que
		 * queremos utilizar na query, instanciamos um novo objeto a cada chamada da
		 * query com o retorno desses atributos. Precisamos chamar o nome do pacote para
		 * o JPQL nao se perder durante a execucao, mas o retorno da execao e uma lista
		 * da nossa classe DTO instanciada na query
		 * 
		 * A CLASSE DTO PRECISA TER UM CONSTRUTOR COM OS ATRIBUTOS QUE QUEREMOS UTILIZAR
		 * PARA PODERMOS INSTANCIAR A MESMA
		 */
		String query = "select new br.com.leomanzini.user.system.dto.SystemUserDTO(id, name, login) from SystemUser";

		TypedQuery<SystemUserDTO> specificReturn = entityManager.createQuery(query, SystemUserDTO.class);
		List<SystemUserDTO> listSpecifcReturn = specificReturn.getResultList();

		listSpecifcReturn.forEach(listItem -> System.out.println(listItem));
	}

	public static void choosingMoreThenOneReturnAbstraction(EntityManager entityManager) {

		String query = "select id, name, login from SystemUser";

		/**
		 * Como nao tenho um tipo de objeto definido para esse retorno especificado na
		 * string da query, abstraimos e usamos um array de objetos criado em tempo de
		 * execucao, sendo as propriedades desse objeto, as propriedades selecionadas
		 * como retorno da query tendo essas variaveis, os mesmos tipos de retorno da
		 * nossa classe entidade, como essa abstracao nao cria uma classe como
		 * precisamos, mantemos o codigo abstrato, usando o tipo Object []
		 */
		TypedQuery<Object[]> arrayOfObjects = entityManager.createQuery(query, Object[].class);
		List<Object[]> arrayListOfObjects = arrayOfObjects.getResultList();

		arrayListOfObjects.forEach(arrayItem -> System.out.println(String.format("%s, %s, %s", arrayItem)));
	}

	public static void passParameters(EntityManager entityManager) {

		/**
		 * Colocamos o identificador de parametros ":" e o nome da var de parametros
		 * apos ele ":userId", por convencao usamos sempre o mesmo nome da propriedade
		 * comparada, nesse caso ficando: "select user from SystemUser user where
		 * user.id = :id", após criada a query, setamos o valor do parametro nela,
		 * passando a var que vamos substituir e o valor, por se tratar de uma classe,
		 * podemos emendar tudo
		 */
		String query = "select user from SystemUser user where user.id = :userId";

		// Criando query e depois setando o valor do parametro na mesma
		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(query, SystemUser.class);
		typedQuery.setParameter("userId", 1);

		// Criando query e já setando o valor do parametro
		// TypedQuery<SystemUser> typedQuery = entityManager.createQuery(query,
		// SystemUser.class).setParameter("userId", 1);

		SystemUser user = typedQuery.getSingleResult();

		System.out.println(user);
	}

	public static void joiningTables(EntityManager entityManager) {

		String jpql = "select user from SystemUser user join user.domain domain where domain.id = 1";

		TypedQuery<SystemUser> query = entityManager.createQuery(jpql, SystemUser.class);
		List<SystemUser> resultList = query.getResultList();

		resultList.forEach(listItem -> System.out.println(listItem));
	}

	public static void leftJoiningTables(EntityManager entityManager) {

		String jpql = "select user, configuration from SystemUser user left join user.configuration configuration";

		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> resultList = query.getResultList();

		resultList.forEach(arrayItem -> {
			// arrayItem[0] == SystemUser
			// arrayItem[1] == Configuration
			// Isso acima acontece devido a ser uma composicao de Objects retornada na query
			// JPQL, sempre que usarmos um array de objetos
			// para trazer o resultado da query teremos isso, a posição 0 equivalendo ao
			// primeiro campo trazido, e assim por diante.
			// Por isso dentro do forEach deu certo usar assim, pois para cada item do nosso
			// array de objetos, a posicao 0 vai ser user, e a
			// posicao 1 vai ser configuracao, desse modo percorrendo todos os itens
			// retornados na consulta.

			String output = ((SystemUser) arrayItem[0]).getName();

			if (arrayItem[1] == null) {
				output += ", NULL";
			} else {
				output += ", " + ((Configuration) arrayItem[1]).getUser().getDomain().getName();
			}

			System.out.println(output);
		});
	}

	public static void joinFetchTables(EntityManager entityManager) {

		String jpql = "select user from SystemUser user join fetch user.configuration join fetch user.domain";

		TypedQuery<SystemUser> query = entityManager.createQuery(jpql, SystemUser.class);
		List<SystemUser> listResult = query.getResultList();

		listResult.forEach(listItem -> System.out.println(listItem));
	}

	public static void likeFilter(EntityManager entityManager) {

		// is null = "select user from SystemUser user where user.name is null" tras
		// todos users com o valor definido na query sendo null
		// is empty = "select domain from Domain domain where domain.users is empty"
		// tras todos os dominios onde a lista de usuarios esta null

		// Exemplo com like e parameters
		// String jpql = "select user from SystemUser user where user.name like
		// :userName";
		// No caso acima, precisamos passar o % como parametro na query
		// TypedQuery<SystemUser> query = entityManager.createQuery(jpql,
		// SystemUser.class)
		// .setParameter("userName", "Cal%");
		// Como exemplificado abaixo, nao, pois ja estamos concatenando o valor recebido
		// como parametro na propria query jpql
		String jpql = "select user from SystemUser user where user.name like concat(:userName, '%')";

		TypedQuery<SystemUser> query = entityManager.createQuery(jpql, SystemUser.class).setParameter("userName",
				"Cal");
		List<SystemUser> listResult = query.getResultList();

		listResult.forEach(listItem -> System.out.println(listItem));
	}

	public static void betweenFilter(EntityManager entityManager) {

		String jpql = "select user from SystemUser user where user.lastAccess between :yesterday and :today";

		TypedQuery<SystemUser> query = entityManager.createQuery(jpql, SystemUser.class)
				.setParameter("yesterday", LocalDateTime.now().minusDays(1)).setParameter("today", LocalDateTime.now());
		List<SystemUser> listResult = query.getResultList();

		listResult.forEach(listItem -> System.out.println(listItem));
	}

	public static void logicalOperators(EntityManager entityManager) {

		// AND
		String jpql = "select user from SystemUser user where user.lastAccess > :yesterday and user.lastAccess < :today";

		TypedQuery<SystemUser> query = entityManager.createQuery(jpql, SystemUser.class)
				.setParameter("yesterday", LocalDateTime.now().minusDays(1)).setParameter("today", LocalDateTime.now());

		List<SystemUser> listResult = query.getResultList();
		listResult.forEach(listItem -> System.out.println(listItem));

		// OR
		jpql = "select user from SystemUser user where user.id = 1 or user.id = 2";

		query = entityManager.createQuery(jpql, SystemUser.class);

		listResult = query.getResultList();
		listResult.forEach(listItem -> System.out.println(listItem));

		// IN
		jpql = "select user from SystemUser user where user.id in (:ids)";

		query = entityManager.createQuery(jpql, SystemUser.class).setParameter("ids", Arrays.asList(3, 5));

		listResult = query.getResultList();
		listResult.forEach(listItem -> System.out.println(listItem));
	}

	public static void order(EntityManager entityManager) {

		String jpql = "select user from SystemUser user where user.id in (:ids) order by user.id";

		TypedQuery<SystemUser> query = entityManager.createQuery(jpql, SystemUser.class)
				.setParameter("ids", Arrays.asList(2, 5, 3, 4));
		List<SystemUser> listResult = query.getResultList();

		listResult.forEach(listItem -> System.out.println(listItem));
	}
	
	public static void pagination(EntityManager entityManager) {

		String jpql = "select user from SystemUser user";

		TypedQuery<SystemUser> query = entityManager.createQuery(jpql, SystemUser.class)
				.setFirstResult(0)
				.setMaxResults(2);
		List<SystemUser> listResult = query.getResultList();

		listResult.forEach(listItem -> System.out.println(listItem));
	}
}
