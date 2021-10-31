package br.com.leomanzini.user.system;

import java.util.List;

import br.com.leomanzini.user.system.dto.SystemUserDTO;
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

		passParameters(entityManager);
		
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
		 * Como temos o tipo desse objeto SystemUserDTO mapeado com os atributos que queremos utilizar na query, 
		 * instanciamos um novo objeto a cada chamada da query com o retorno desses atributos. Precisamos chamar o nome do pacote
		 * para o JPQL nao se perder durante a execucao, mas o retorno da execao e uma lista da nossa classe DTO instanciada na query
		 * 
		 * A CLASSE DTO PRECISA TER UM CONSTRUTOR COM OS ATRIBUTOS QUE QUEREMOS UTILIZAR PARA PODERMOS INSTANCIAR A MESMA
		 */
		String query = "select new br.com.leomanzini.user.system.dto.SystemUserDTO(id, name, login) from SystemUser";
		
		TypedQuery<SystemUserDTO> specificReturn = entityManager.createQuery(query, SystemUserDTO.class);
		List<SystemUserDTO> listSpecifcReturn = specificReturn.getResultList();
		
		listSpecifcReturn.forEach(listItem -> System.out.println(listItem));
	}
	
	public static void choosingMoreThenOneReturnAbstraction(EntityManager entityManager) {
		
		String query = "select id, name, login from SystemUser";
		
		/**
		 * Como nao tenho um tipo de objeto definido para esse retorno especificado na string da query, abstraimos e usamos
		 * um array de objetos criado em tempo de execucao, sendo as propriedades desse objeto, as propriedades selecionadas como retorno da query
		 * tendo essas variaveis, os mesmos tipos de retorno da nossa classe entidade, como essa abstracao nao cria uma classe como precisamos, mantemos
		 * o codigo abstrato, usando o tipo Object []
		 */
		TypedQuery<Object []> arrayOfObjects = entityManager.createQuery(query, Object [].class);
		List<Object []> arrayListOfObjects = arrayOfObjects.getResultList();
		
		arrayListOfObjects.forEach(arrayItem -> System.out.println(String.format("%s, %s, %s", arrayItem)));
	}
	
	public static void passParameters(EntityManager entityManager) {
		
		/**
		 * Colocamos o identificador de parametros ":" e o nome da var de parametros apos ele ":userId", por convencao usamos sempre o mesmo nome da 
		 * propriedade comparada, nesse caso ficando: "select user from SystemUser user where user.id = :id", após criada a query, setamos o valor 
		 * do parametro nela, passando a var que vamos substituir e o valor, por se tratar de uma classe, podemos emendar tudo
		 */
		String query = "select user from SystemUser user where user.id = :userId";
		
		// Criando query e depois setando o valor do parametro na mesma
		TypedQuery<SystemUser> typedQuery = entityManager.createQuery(query, SystemUser.class);
		typedQuery.setParameter("userId", 1);
		
		// Criando query e já setando o valor do parametro
		// TypedQuery<SystemUser> typedQuery = entityManager.createQuery(query, SystemUser.class).setParameter("userId", 1);
		
		SystemUser user = typedQuery.getSingleResult();
		
		System.out.println(user);
	}
}
