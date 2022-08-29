package dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Livro;

public class LivroDAO implements ILivroDAO{  
	
	public void save( Livro livro ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "ExercicioJPA" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( livro );
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void update( Livro livro ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "ExercicioJPA" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge( livro );
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public void remove( Integer id ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "ExercicioJPA" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Livro livro = entityManager.find( Livro.class, id );
		entityManager.remove( livro );
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public Optional< Livro > findById( Integer id ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "ExercicioJPA" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Optional< Livro > livro = Optional.ofNullable( entityManager.find( Livro.class, id ) );
		entityManager.close();
		entityManagerFactory.close();
		return livro;
	}
	
	public Optional< Livro > findByAuthor( String author ) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "ExercicioJPA" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Optional< Livro > livro = Optional.ofNullable( entityManager.find( Livro.class, author ) );
		entityManager.close();
		entityManagerFactory.close();
		return livro;
	}
	
}
