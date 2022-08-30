package business;

import java.util.List;
import java.util.Optional;

import dao.ILivroDAO;
import dao.LivroDAO;
import entity.Livro;
import exceptions.NotFoundException;
import exceptions.RequiredInfoException;

public class LivroBusiness {
	
	ILivroDAO dao = new LivroDAO();

	public void save( String titulo, String tituloOriginal, 
			String nomeAutor, String editora, Integer numeroPaginas, Integer numeroEdicao ) {
		if( titulo == null ) {
			new RequiredInfoException( "Título é obrigatório" );
		}
		if( nomeAutor == null ) {
			new RequiredInfoException( "Nome do autor é obrigatório" );
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
				.orElseThrow( () -> new NotFoundException( "Livro não encontrado" ) );
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
				.orElseThrow( () -> new NotFoundException( "Livro não encontrado" ) );
	}
	
	public List< Livro > findByAuthor( String author ) throws NotFoundException {
		List< Livro > livrosDoAutor = this.dao.findByAuthor( author );
		if( livrosDoAutor.isEmpty() ) {
			throw new NotFoundException( "Nenhum livro encontrado para este autor");
		}
		return livrosDoAutor;
	}
}
