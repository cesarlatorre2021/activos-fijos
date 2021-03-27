package com.activos.fijos.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.activos.fijos.entity.Activos;

public interface ActivosCrudRepositorio extends CrudRepository <Activos, Integer>{

	@Query(value = "SELECT * "
			+ "       FROM ACTIVOS"
			+ "      WHERE ID_ACTIVO = :idactivo", nativeQuery = true)
	Optional<Activos> listarActivosID(@Param("idactivo") long idActivo);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM ACTIVOS "
			+ "      WHERE ID_ACTIVO = ?", nativeQuery = true)
	void deleteForId(long idActivo);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE ACTIVOS "
			+ "        SET NOMBRE = :nombre"
			+ "           ,DESCRIPCION = :descripcion"
			+ "           ,TIPO = :tipo"
			+ "           ,SERIAL = :serial"
			+ "           ,NUM_INVENTARIO = :numinventario"
			+ "           ,PESO = :peso"
			+ "           ,ALTO = :alto"
			+ "           ,ANCHO = :ancho"
			+ "           ,LARGO = :largo"
			+ "           ,VALOR_COMPRA = :valorcompra"
			+ "      WHERE ID_ACTIVO = :idubicacion", nativeQuery = true)
	void modificarProducto(@Param("nombre") String nombre,
			               @Param("descripcion") String descripcion,
			               @Param("tipo") String tipo,
			               @Param("serial") String serial,
			               @Param("numinventario") long numInventario,
			               @Param("peso") long peso,
			               @Param("alto") long alto,
			               @Param("ancho") long ancho,
			               @Param("largo") long largo,
			               @Param("valorcompra") long valorCompra,
			               @Param("idubicacion") long idUbicacion);
	
}
