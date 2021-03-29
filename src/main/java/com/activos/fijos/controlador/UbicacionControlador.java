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

import com.activos.fijos.entity.Ubicacion;
import com.activos.fijos.servicio.UbicacionServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionControlador {
	
	@Autowired
    private UbicacionServicio ubicacionServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todas las ciudades donde tiene presencia la empresa")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Ubicacion>> getAll(){
		return new ResponseEntity<> (ubicacionServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{ubicacionId}")
    @ApiOperation("busca una ciudad con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Ubicacion not found")
    })
	public Optional<Ubicacion> getProveedor(
			@ApiParam(value = "El id de las ciudades donde tiene presencia la empresa", required = true, example ="1") 
			@PathVariable("ubicacionId") long idUbicacion){
		return ubicacionServicio.getByIdUbicacion(idUbicacion);
	}
    
    @PostMapping("/save")
    @ApiOperation("Permite crear el registro de una nueva ciudad, donde se tiene presencia la empresa")
	public ResponseEntity<List<Ubicacion>> save(@RequestBody List<Ubicacion> ubicacion) {
		return new ResponseEntity<> (ubicacionServicio.save(ubicacion), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
    @ApiOperation("Permite elminiar el registro de una ciudad, donde ya no se tiene presencia la empresa")
   	public ResponseEntity delete (@PathVariable("id") long idUbicacion) {
   		if(ubicacionServicio.delete(idUbicacion) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<Ubicacion> modify(@RequestBody Ubicacion ubicacion) {
		return new ResponseEntity<> (ubicacionServicio.modify(ubicacion), HttpStatus.OK);
	}

}
