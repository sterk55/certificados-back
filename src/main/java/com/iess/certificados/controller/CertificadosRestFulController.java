package com.iess.certificados.controller;

import java.time.LocalDate;
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

import com.iess.certificados.repository.model.Certificados;
import com.iess.certificados.service.ICertificadosService;

@RestController
@RequestMapping("/certificados")
@CrossOrigin("http://localhost:8080")
public class CertificadosRestFulController {
    
    @Autowired
    private ICertificadosService certificados;
 
    @PostMapping
    public String crear(@RequestBody Certificados certificados){
        String msj = "Se ha ingresado correctamente";
        try{

            this.certificados.crear(certificados);

        }catch(Exception e){
            msj = "Error" + e;
        }

        return msj;
    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<Certificados>> listarCertificados(){
        return ResponseEntity.ok(this.certificados.listarCertificados());
    }

    @GetMapping(path = "/cedulaPaciente/{cedulaPaciente}")
    public ResponseEntity<List<Certificados>> buscarCertificadoPorCedula(@PathVariable("cedulaPaciente") String cedulaPaciente){
        return ResponseEntity.ok(this.certificados.buscarPorCedula(cedulaPaciente));
    }

    @GetMapping(path = "/cedulaDoctor/{cedulaDoctor}")
    public ResponseEntity<List<Certificados>> buscarCertificadoPorCedulaD(@PathVariable("cedulaDoctor") String cedulaDoctor){
        return ResponseEntity.ok(this.certificados.buscarPorCedulaD(cedulaDoctor));
    }

    @GetMapping(path = "/fecha/{fechaGeneracion}")
    public ResponseEntity<List<Certificados>> buscarCertificadosPorFecha(@PathVariable("fechaGeneracion") LocalDate fechaGeneracion){
        return ResponseEntity.ok(this.certificados.buscarPorFecha(fechaGeneracion));
    }
}
