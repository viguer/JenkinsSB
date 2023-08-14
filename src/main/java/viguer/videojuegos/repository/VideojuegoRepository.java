package viguer.videojuegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import viguer.videojuegos.domain.Videojuego;

public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer> {

@Query("from Videojuego v order by v.nombre")
List<Videojuego> buscarTodos();

@Query(value = "select * from videojuego order by descripcion", nativeQuery=true)
List<Videojuego> buscarTodos2();

@Query("from Videojuego v where v.distribuidor.id = ?1 order by v.nombre")
List<Videojuego> buscarPorDistribuidor(int distribuidor);

@Query("from Videojuego v where v.nombre like %?1%")
List<Videojuego> buscarPorNombre(String nombre);

List<Videojuego> findByNombreContaining(String nombre);
}
