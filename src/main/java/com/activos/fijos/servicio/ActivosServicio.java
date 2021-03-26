package com.activos.fijos.servicio;

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
	
	public Optional<Activos> getByIdActivos(long idActivos) {
        return activosRepositorio.getByIdActivos(idActivos);
    }
	
	public Activos save(Activos activos) {
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
        return activosRepositorio.save(activos);
    }

}
