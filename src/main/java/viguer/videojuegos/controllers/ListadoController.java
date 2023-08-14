package viguer.videojuegos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import viguer.videojuegos.domain.Videojuego;
import viguer.videojuegos.services.VideojuegoService;


@Controller	
public class ListadoController {
	
	private final VideojuegoService videojuegoService;

    ListadoController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }
	
	@RequestMapping("/") 
	public String listaVideoJuegos(Model model) {
		List<Videojuego> destacados = videojuegoService.buscarDestacados();
        System.out.println("pruebass: " + destacados.get(0).getDistribuidor().getNombre());
		model.addAttribute("videojuegos", destacados);
		return "Listado";
		
	}
	
	@RequestMapping("/videojuegosPorDistribuidor")
	public String ListarVideojuegosPorDistribuidor(int distribuidorId, Model model) {
		List<Videojuego> juegos = videojuegoService.buscarPorDistribuidor(distribuidorId);
		model.addAttribute("videojuegos", juegos);
		return "Listado";
	}
	
	@RequestMapping("/buscar")
	public String ListarVideojuegoPorNombre(@RequestParam ("q") String nombre, Model model) {
		List<Videojuego> juego = videojuegoService.buscarPorNombre(nombre);
		model.addAttribute("videojuegos", juego);
		return "Listado";
	}

}
