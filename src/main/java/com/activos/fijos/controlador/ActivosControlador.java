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

import com.activos.fijos.entity.Activos;
import com.activos.fijos.servicio.ActivosServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/activos")
public class ActivosControlador {
	
	@Autowired
    private ActivosServicio activosServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todas los activos fijos que tiene la empresa")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Activos>> getAll(){
		return new ResponseEntity<> (activosServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{activoId}")
    @ApiOperation("busca un activo fijo de la empresa con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Activo fijo not found")
    })
	public Optional<Activos> getProveedor(@ApiParam(value = "El id de los activos que tiene la empresa", required = true, example ="7") @PathVariable("activoId") long idActivos){
		return activosServicio.getByIdActivos(idActivos);
	}
    
    @PostMapping("/save")
	public ResponseEntity<Activos> save(@RequestBody Activos activos) {
		return new ResponseEntity<> (activosServicio.save(activos), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") long idActivos) {
   		if(activosServicio.delete(idActivos) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<Activos> modify(@RequestBody Activos activos) {
		return new ResponseEntity<> (activosServicio.modify(activos), HttpStatus.OK);
	}

}
