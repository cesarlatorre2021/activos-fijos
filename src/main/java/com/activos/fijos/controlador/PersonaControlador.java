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

import com.activos.fijos.entity.Persona;
import com.activos.fijos.servicio.PersonaServicio;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/persona")
public class PersonaControlador {
	
	@Autowired
    private PersonaServicio personaServicio;
	
    @GetMapping("/All")
    @ApiOperation("Enlista todas las personas vinculadas a la empresa")
    @ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Persona>> getAll(){
		return new ResponseEntity<> (personaServicio.getAll(), HttpStatus.OK);
    } 
    
    @GetMapping("/All/{personaId}")
    @ApiOperation("busca una persona vinculada a la empresa con un ID")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "persona not found")
    })
	public Optional<Persona> getProveedor(@ApiParam(value = "El id de las personas vinculadas a la empresa", required = true, example ="7") @PathVariable("personaId") long idPersona){
		return personaServicio.getByIdPersona(idPersona);
	}
    
    @PostMapping("/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		return new ResponseEntity<> (personaServicio.save(persona), HttpStatus.CREATED);
	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
   	public ResponseEntity delete (@PathVariable("id") long idPersona) {
   		if(personaServicio.delete(idPersona) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
	public ResponseEntity<Persona> modify(@RequestBody Persona persona) {
		return new ResponseEntity<> (personaServicio.modify(persona), HttpStatus.OK);
	}

}
