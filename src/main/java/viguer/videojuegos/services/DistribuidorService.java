package viguer.videojuegos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import viguer.videojuegos.domain.Distribuidor;
import viguer.videojuegos.repository.DistribuidorRepository;


@Service
public class DistribuidorService {
	
	private final DistribuidorRepository distribuidorRepository;
	
	public DistribuidorService(DistribuidorRepository distribuidorRepository){
		this.distribuidorRepository = distribuidorRepository;
	}
	
	public List<Distribuidor> buscarTodos(){
		return distribuidorRepository.findAll();
	}

}
