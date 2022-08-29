package business;

import java.util.Optional;

import dao.ILivroDAO;
import dao.LivroDAO;
import entity.Livro;
import exceptions.NeededInfoException;
import exceptions.NotFoundException;

public class LivroBusiness {
	
	ILivroDAO dao = new LivroDAO();

	public void save( String titulo, String tituloOriginal, 
			String nomeAutor, String editora, Integer numeroPaginas, Integer numeroEdicao ) {
		if( titulo == null ) {
			new NeededInfoException( "T�tulo � obrigat�rio" );
		}
		if( nomeAutor == null ) {
			new NeededInfoException( "Nome do autor � obrigat�rio" );
		}
		Livro livro = new Livro();
		livro.setTitulo( titulo );
		livro.setTituloOriginal( tituloOriginal );
		livro.setNomeAutor( nomeAutor );
		livro.setEditora( editora );
		livro.setNumeroPaginas( numeroPaginas );
		livro.setNumeroEdicao( numeroEdicao );
		this.dao.save( livro );
	}
	
	public void update(Integer id, String titulo, String tituloOriginal, 
			String nomeAutor, String editora, Integer numeroPaginas, Integer numeroEdicao) throws NotFoundException {
		Livro livro = Optional.ofNullable( this.dao.findById( id ) ).get()
				.orElseThrow( () -> new NotFoundException( "Livro n�o encontrado" ) );
		livro.setTitulo( titulo );
		livro.setTituloOriginal( tituloOriginal );
		livro.setNomeAutor( nomeAutor );
		livro.setEditora( editora );
		livro.setNumeroPaginas( numeroPaginas );
		livro.setNumeroEdicao( numeroEdicao );
		this.dao.update( livro );
	}
	
	public void remove( Integer id ) {
		this.dao.remove( id );
	}
	
	public Livro findById( Integer id ) throws NotFoundException {
		return Optional.ofNullable( this.dao.findById( id ) ).get()
				.orElseThrow( () -> new NotFoundException( "Livro n�o encontrado" ) );
	}
	
	public Livro findByAuthor( String author ) throws NotFoundException {
		return Optional.ofNullable( this.dao.findByAuthor( author ) ).get()
				.orElseThrow( () -> new NotFoundException( "Livro n�o encontrado" ) );
	}
}
