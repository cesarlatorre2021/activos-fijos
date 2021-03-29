package com.activos.fijos.servicio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.fijos.entity.Activos;
import com.activos.fijos.repositorio.ActivosRepositorio;

@Service
public class ActivosServicio {
	
	@Autowired
	private ActivosRepositorio activosRepositorio;
	
	public List<Activos> getAll() {
        return activosRepositorio.getAll();
    }
	
	public Optional<List<Activos>> getByIdActivos(long idActivos) {
        return activosRepositorio.getByIdActivos(idActivos);
    }
	
	public Optional<List<Activos>> getByTipo(String tipoActivo) {
        return activosRepositorio.getByTipoActivo(tipoActivo);
    }
	
	public Optional<List<Activos>> getBySerial(String serialActivo) {
        return activosRepositorio.getBySerialActivo(serialActivo);
    }
	
	public Optional<List<Activos>> getByFecha(LocalDateTime serialFecha) {
        return activosRepositorio.getByFechaActivo(serialFecha);
    }
	
	public List<Activos> save(List<Activos> activos) {
        return activosRepositorio.save(activos);
    }

    public boolean delete(long idActivos) {
    	if (getByIdActivos(idActivos).isPresent() == true) {
    		activosRepositorio.delete(idActivos);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Activos modify(Activos activos) {
        return activosRepositorio.modify(activos);
    }

}
