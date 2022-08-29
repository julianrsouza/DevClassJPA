package dao;

import java.util.Optional;

import entity.Livro;

public interface ILivroDAO {
	
	public void save( Livro livro );
	
	public void update( Livro livro );
	
	public void remove( Integer id );
	
	public Optional< Livro > findById( Integer id);
	
	public Optional< Livro > findByAuthor( String author );
	
}
