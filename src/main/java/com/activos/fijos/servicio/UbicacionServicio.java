package com.activos.fijos.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.fijos.entity.Ubicacion;
import com.activos.fijos.repositorio.UbicacionRepositorio;

@Service
public class UbicacionServicio {
	
	@Autowired
	private UbicacionRepositorio ubicacionRepositorio;
	
	public List<Ubicacion> getAll() {
        return ubicacionRepositorio.getAll();
    }
	
	public Optional<Ubicacion> getByIdUbicacion(long idUbicacion) {
        return ubicacionRepositorio.getByIdUbicacion(idUbicacion);
    }
	
	public List<Ubicacion> save(List<Ubicacion> ubicacion) {
        return ubicacionRepositorio.save(ubicacion);
    }

    public boolean delete(long idUbicacion) {
    	if (getByIdUbicacion(idUbicacion).isPresent() == true) {
    		ubicacionRepositorio.delete(idUbicacion);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Ubicacion modify(Ubicacion save) {
        return ubicacionRepositorio.modify(save);
    }

}
