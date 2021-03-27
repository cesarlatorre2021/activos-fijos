package com.activos.fijos.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activos.fijos.entity.Area;
import com.activos.fijos.servicio.AreaServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/area")
public class AreaControlador {
	
	@Autowired
    private AreaServicio areaServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todas las areas que conforman la empresa")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Area>> getAll(){
		return new ResponseEntity<> (areaServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{areaId}")
    @ApiOperation("busca un area de la empresa con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Area not found")
    })
	public Optional<Area> getProveedor(@ApiParam(value = "El id de las areas que tiene la empresa", required = true, example ="1") @PathVariable("areaId") long idArea){
		return areaServicio.getByIdArea(idArea);
	}
    
    @PostMapping("/save")
    @ApiOperation("Guarda en la BD una nueva area de la empresa")
	public ResponseEntity<List<Area>> save(@RequestBody List<Area> area) {
		return new ResponseEntity<> (areaServicio.save(area), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
    @ApiOperation("Permite eliminar de la BD una area de la empresa")
   	public ResponseEntity delete (@PathVariable("id") long idArea) {
   		if(areaServicio.delete(idArea) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
    @ApiOperation("Permite modificar de la BD el registro de alguna area de la empresa")
	public ResponseEntity<Area> modify(@RequestBody Area area) {
		return new ResponseEntity<> (areaServicio.modify(area), HttpStatus.OK);
	}

}
