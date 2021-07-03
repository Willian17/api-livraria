package br.com.totemti.livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.totemti.livraria.exceptions.RegistroNaoEncontradoException;
import br.com.totemti.livraria.models.Usuario;
import br.com.totemti.livraria.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public Usuario buscarPorId(Long id) {
		return this.usuarioRepository
				.findById(id)
				.orElseThrow(() -> new RegistroNaoEncontradoException("usuario.naoEncontrado"));
	}
	
	public Usuario buscarPorEmail(String email) {
		return this.usuarioRepository
				.findByEmail(email)
				.orElseThrow(() -> new RegistroNaoEncontradoException("usuario.naoEncontrado"));
	}
	
	
	
	

}
