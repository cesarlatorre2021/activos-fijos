package com.activos.fijos.controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	public Optional<Activos> getAcitovoId(@ApiParam(value = "El id de los activos que tiene la empresa", required = true, example ="1") @PathVariable("activoId") long idActivos){
		return activosServicio.getByIdActivos(idActivos);
	}
    
    @GetMapping("/All/tipo/{activoTipo}")
    @ApiOperation("busca un activo fijo de la empresa por el tipo")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Activo fijo not found")
    })
	public Optional<Activos> getAcitovoByTipo(@ApiParam(value = "El Tipo del activo que tiene la empresa", required = true, example ="1") @PathVariable("activoTipo") String tipoActivo){
		return activosServicio.getByTipo(tipoActivo);
	}
    
    @GetMapping("/All/serial/{activoSerial}")
    @ApiOperation("busca un activo fijo de la empresa por el serial")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Activo fijo not found")
    })
	public Optional<Activos> getAcitovoBySerial(@ApiParam(value = "El serial del activo que tiene la empresa", required = true, example ="1") @PathVariable("activoSerial") String tipoActivo){
		return activosServicio.getBySerial(tipoActivo);
	}
    
    @GetMapping("/All/fecha/{activoFechaCompra}")
    @ApiOperation("busca un activo fijo de la empresa por la fecha de compra")
    @ApiResponses({
    	@ApiResponse(code = 200, message = "OK"),
    	@ApiResponse(code = 404, message = "Activo fijo not found")
    })
	public Optional<List<Activos>> getAcitovoByFecha(@ApiParam(value = "La fecha de compra del activo que tiene la empresa", required = true, example ="2021-03-26") @PathVariable("activoFechaCompra") String fechaCompra){
    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    	LocalDateTime fecha = LocalDate.parse(fechaCompra, formato).atStartOfDay();
		return activosServicio.getByFecha(fecha);
	}
    
    @PostMapping("/save")
    @ApiOperation("Permite guardar en la BD un nuevo activo")
    @ApiResponse(code = 200, message = "OK")
   	public ResponseEntity<List<Activos>> save(@RequestBody List<Activos> activos) {
   		return new ResponseEntity<> (activosServicio.save(activos), HttpStatus.CREATED);
   	}
    
    @SuppressWarnings("rawtypes")
   	@DeleteMapping("/delete/{id}")
    @ApiOperation("Permite eliminar un activo de la empresa con un ID")
    @ApiResponse(code = 200, message = "OK")
   	public ResponseEntity delete (@PathVariable("id") long idActivos) {
   		if(activosServicio.delete(idActivos) == true){
   			return new ResponseEntity<>(HttpStatus.OK);
   		}else {
   			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   		}
   	}
    
    @PutMapping("/modify")
    @ApiOperation("Permite modificar el registro de un activo de la empresa")
	public ResponseEntity<Activos> modify(@RequestBody Activos activos) {
		return new ResponseEntity<> (activosServicio.modify(activos), HttpStatus.OK);
	}

}
