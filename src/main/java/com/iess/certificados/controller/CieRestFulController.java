package com.iess.certificados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iess.certificados.repository.model.Cie10;
import com.iess.certificados.service.ICieService;

@RestController
@RequestMapping("/cie10")
@CrossOrigin("http://localhost:8080")
public class CieRestFulController {

    @Autowired
    private ICieService cieService;

    @PostMapping
    public String crear(@RequestBody Cie10 cie10){
        String msg = "Se ha ingresado correctamente";
        try{

        
        this.cieService.crear(cie10);
    }catch(Exception e){
        msg = "Error" + e;
    }
    return msg;    
    }

    @GetMapping(path = "/{codigo}")
    public ResponseEntity<Cie10> buscarCie10PorCodigo(@PathVariable("codigo") String codigo){
        
        return ResponseEntity.ok(this.cieService.buscarPorCodigo(codigo));
    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<Cie10>> listarCie(){
        return ResponseEntity.ok(this.cieService.listaCie());
    }

    @GetMapping(path = "/descripcion/{descripcion}")
    public ResponseEntity<List<Cie10>> buscarCiePorDescripcion(@PathVariable("descripcion") String descripcion){
        return ResponseEntity.ok(this.cieService.buscarPorDescripcion(descripcion));
    }

}   
