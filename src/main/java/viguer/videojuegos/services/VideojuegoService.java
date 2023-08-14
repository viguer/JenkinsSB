package viguer.videojuegos.services;
import java.util.List;

import org.springframework.stereotype.Service;

import viguer.videojuegos.domain.Videojuego;
import viguer.videojuegos.repository.VideojuegoRepository;

@Service
public class VideojuegoService {
	
	private final VideojuegoRepository videojuegoRepository;
	
	public VideojuegoService(VideojuegoRepository videojuegoRepository){
		this.videojuegoRepository = videojuegoRepository;
	}

	public List<Videojuego> buscarDestacados() {
		return videojuegoRepository.buscarTodos();
	}
	
	public List<Videojuego> buscarPorDistribuidor(int distribuidor){
		return videojuegoRepository.buscarPorDistribuidor(distribuidor);
	}
	
	public List<Videojuego> buscarPorNombre(String nombre){
		return videojuegoRepository.findByNombreContaining(nombre);
	}
	
	public Videojuego crearVideojuego(Videojuego videojuego) {
		return videojuegoRepository.save(videojuego);
	}

}
