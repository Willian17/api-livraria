package br.com.totemti.livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.totemti.livraria.exceptions.RegistroNaoEncontradoException;
import br.com.totemti.livraria.models.Livro;
import br.com.totemti.livraria.repositories.LivroRepository;

@Service
public class LivroService {
	private LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public Page<Livro> listar (Pageable pageable) {
		return this.livroRepository.findAll(pageable);
	}
	
	public Livro buscar(Long id) {
		return this.livroRepository
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontradoException("livro.naoEncontrado"));
	}

	public Livro salvar(Livro livro) {
		return this.livroRepository.save(livro);
	}

	public void excluir(Long id) {
		Livro livro = this.buscar(id);
		this.livroRepository.delete(livro);
		
	}
	
}
