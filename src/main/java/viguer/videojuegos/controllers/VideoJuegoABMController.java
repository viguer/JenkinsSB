package viguer.videojuegos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import viguer.videojuegos.domain.Videojuego;
import viguer.videojuegos.services.DistribuidorService;
import viguer.videojuegos.services.VideojuegoService;

@Controller
public class VideoJuegoABMController {
	
	public final DistribuidorService distribuidorService;
	public final VideojuegoService videojuegoService;
	
	public VideoJuegoABMController(DistribuidorService distribuidorService, VideojuegoService videojuegoService) {
	this.distribuidorService = distribuidorService;	
	this.videojuegoService = videojuegoService;
	}
	
	
	@RequestMapping("/videojuego/crear")
	public String mostrarForm(Model model){
		model.addAttribute("distribuidores", distribuidorService.buscarTodos());
		model.addAttribute("videojuego", new Videojuego());
		return "formVideoJuego";
		
	}
	
	@PostMapping("/videojuego/guardar")
	public String guardar(Videojuego videojuego){
		videojuegoService.crearVideojuego(videojuego);
		return "redirect:/";
	}
	
	

}
