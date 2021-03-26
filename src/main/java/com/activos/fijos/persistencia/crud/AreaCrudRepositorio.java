package com.activos.fijos.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.activos.fijos.entity.Area;

public interface AreaCrudRepositorio extends CrudRepository <Area, Integer> {
	
	@Query(value = "SELECT * "
			+ "       FROM AREA "
			+ "      WHERE ID_AREA = :idarea", nativeQuery = true)
	Optional<Area> listarAreaID(@Param("idarea") long idArea);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM AREA "
			+ "      WHERE ID_AREA = ?", nativeQuery = true)
	void deleteForId(long idArea);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE AREA "
			+ "        SET NOMBRE_AREA = :nombrearea"
			+ "           ,TELEFONO_CONTACTO = :telefonocontacto"
			+ "           ,FECHA_MODIFICACION = current_timestamp"
			+ "      WHERE ID_AREA = :idarea", nativeQuery = true)
	void modificarProducto(@Param("nombrearea") String nombreArea,
			               @Param("telefonocontacto") long telefonoContacto,
			               @Param("idarea") long idArea);

}
