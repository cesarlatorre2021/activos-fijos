package com.activos.fijos.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.activos.fijos.entity.Ubicacion;

public interface UbicacionCrudRepositorio extends CrudRepository <Ubicacion, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM UBICACION"
			+ "      WHERE ID_UBICACION = :idubicacion", nativeQuery = true)
	Optional<Ubicacion> listarAreaID(@Param("idubicacion") long idUbicacion);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM UBICACION "
			+ "      WHERE ID_UBICACION = ?", nativeQuery = true)
	void deleteForId(long idUbicacion);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE UBICACION "
			+ "        SET NOMBRE_CIUDAD = :nombreciudad"
			+ "           ,NOMBRE_PAIS = :nombrepais"
			+ "           ,DIRECCION = :direccion"
			+ "           ,TELEFONO_CONTACTO = :telefonocontacto"
			+ "           ,FECHA_MODIFICACION = current_timestamp"
			+ "      WHERE ID_UBICACION = :idubicacion", nativeQuery = true)
	void modificarProducto(@Param("nombreciudad") String nombreCiudad,
			               @Param("nombrepais") String nombrePais,
			               @Param("direccion") String direccion,
			               @Param("telefonocontacto") long telefonoContacto,
			               @Param("idubicacion") long idUbicacion);

}
