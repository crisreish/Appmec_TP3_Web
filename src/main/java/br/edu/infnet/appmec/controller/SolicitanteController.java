package br.edu.infnet.appmec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appmec.model.domain.Solicitante;
import br.edu.infnet.appmec.model.domain.Usuario;
import br.edu.infnet.appmec.model.service.SolicitanteService;

@Controller
public class SolicitanteController {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@GetMapping(value = "/solicitante")
	public String tela() {
		return "solicitante/cadastro";
	}	
	
	@GetMapping(value = "/solicitante/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", solicitanteService.obterLista(usuario));

		return "solicitante/lista";
	}

	@PostMapping(value = "/solicitante/incluir")
	public String incluir(Model model, Solicitante solicitante, @SessionAttribute("user") Usuario usuario) {

		solicitante.setUsuario(usuario);
		
		solicitanteService.incluir(solicitante);
		
		String mensagem = "O solicitante "+ solicitante.getNome() +" foi cadastrado com sucesso!!!";
		
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}	
	
	@GetMapping(value = "/solicitante/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Solicitante solicitante = solicitanteService.obterPorId(id);
		
		solicitanteService.excluir(id);
		
		String mensagem = "O solicitante "+ solicitante.getNome() +" foi removido com sucesso!!!";
		
		model.addAttribute("msg", mensagem);

		return telaLista(model, usuario);
	}
}