package com.activos.fijos.persistencia.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.activos.fijos.entity.Persona;

public interface PersonaCrudRepositorio extends CrudRepository <Persona, Integer>{
	
	@Query(value = "SELECT * "
			+ "       FROM PERSONA"
			+ "      WHERE ID_PERSONA = :idpersona", nativeQuery = true)
	Optional<Persona> listarPersonaID(@Param("idpersona") long idPersona);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE "
			+ "       FROM PERSONA "
			+ "      WHERE ID_PERSONA = ?", nativeQuery = true)
	void deleteForId(long idPersona);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE PERSONA "
			+ "        SET TIPO_DOCUMENTO = :tipodocumento"
			+ "           ,NUM_DOCUMENTO = :numdocumento"
			+ "           ,PRIMER_NOMBRE = :primernombre"
			+ "           ,SEGUNDO_NOMBRE = :segundonombre"
			+ "           ,PRIMER_APELLIDO = :primerapellido"
			+ "           ,SEGUNDO_APELLIDO = :segundoapellido"
			+ "           ,TELEFONO_CONTACTO = :telefonocontacto"
			+ "           ,FECHA_MODIFICACION = current_timestamp"
			+ "      WHERE ID_PERSONA = :idpersona", nativeQuery = true)
	void modificarProducto(@Param("tipodocumento") String tipoDocumento,
			               @Param("numdocumento") long numDocumento,
			               @Param("primernombre") String primerNombre,
			               @Param("segundonombre") String segundoNombre,
			               @Param("primerapellido") String primerApellido,
			               @Param("segundoapellido") String segundoApellido,
			               @Param("telefonocontacto") long telefonoContacto,
			               @Param("idpersona") long idPersona);

}
