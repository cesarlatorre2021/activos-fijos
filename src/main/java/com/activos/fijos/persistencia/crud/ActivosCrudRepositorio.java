package com.activos.fijos.persistencia.crud;

import java.time.LocalDateTime;
import java.util.List;
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
	Optional<List<Activos>> listarActivosID(@Param("idactivo") long idActivo);
	
	@Query(value = "SELECT * "
			+ "       FROM ACTIVOS"
			+ "      WHERE TIPO = :tipoactivo", nativeQuery = true)
	Optional<List<Activos>> listarActivosTipo(@Param("tipoactivo") String tipoActivo);
	
	@Query(value = "SELECT * "
			+ "       FROM ACTIVOS"
			+ "      WHERE SERIAL = :serialactivo", nativeQuery = true)
	Optional<List<Activos>> listarActivosSerial(@Param("serialactivo") String serialActivo);
	
	@Query(value = "SELECT * "
			+ "       FROM ACTIVOS"
			+ "      WHERE DATE(TO_CHAR(FECHA_COMPRA,'YYYY-MM-DD')) = :fechaactivo", nativeQuery = true)
	Optional<List<Activos>> listarActivosFecha(@Param("fechaactivo") LocalDateTime fechaActivo);
	
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
