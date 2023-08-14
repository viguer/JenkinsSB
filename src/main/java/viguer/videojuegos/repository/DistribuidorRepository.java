package viguer.videojuegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import viguer.videojuegos.domain.Distribuidor;

public interface DistribuidorRepository extends JpaRepository<Distribuidor, Integer> {

}
