package br.com.totemti.livraria.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.totemti.livraria.controllers.dto.AutorDTO;
import br.com.totemti.livraria.models.Autor;
import br.com.totemti.livraria.services.AutorService;
import br.com.totemti.livraria.services.EditoraService;

@RestController
@RequestMapping(value = "/autores")
public class AutorController {
	
	private AutorService autorService;
	private ModelMapper modelMapper;
	
	@Autowired
	public AutorController(AutorService autorService, ModelMapper modelMapper) {
		this.autorService = autorService;
		this.modelMapper = modelMapper;
	}
	
	@GetMapping
	public ResponseEntity<Page<AutorDTO>> index(@PageableDefault(sort = "nome") Pageable pageable) {
		Page autores = autorService
				.listar(pageable)
				.map(autor -> modelMapper.map(autor, AutorDTO.class));
		return ResponseEntity.ok(autores);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutorDTO> show(@PathVariable Long id) {
		Autor autor = autorService.buscar(id);
		
		AutorDTO autorDTO = this.modelMapper.map(autor, AutorDTO.class);
		return ResponseEntity.ok(autorDTO);
	}
	
	

}
