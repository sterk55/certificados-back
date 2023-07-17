package com.iess.certificados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iess.certificados.repository.model.Paciente;
import com.iess.certificados.service.IPacienteService;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("http://localhost:8080")
public class PacienteRestFulController {
    

    @Autowired
    private IPacienteService pacienteService;

    @PostMapping
    public String crear(@RequestBody Paciente paciente){
        String msj = "Se ha ingresado correctamente";
        try{
            this.pacienteService.crear(paciente);

        }catch(Exception e){
            msj = "Error sl ingresar" + e;
        }
        return msj;
    }

    @GetMapping(path = "/cedula/{cedula}")
    public ResponseEntity<List<Paciente>> buscarPacientePorCedula(@PathVariable("cedula") String cedula){
        return ResponseEntity.ok(this.pacienteService.buscarPorCedula(cedula));
    }

    @GetMapping(path = "/apellido/{apellido}")
    public ResponseEntity<List<Paciente>> buscarPacientePorApellido(@PathVariable("apellido") String apellido){
        return ResponseEntity.ok(this.pacienteService.buscarPorApellido(apellido));
    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<Paciente>> listarPaciente(){
        return ResponseEntity.ok(this.pacienteService.listarPacientes());
    }

    @GetMapping(path = "/eliminar/{cedula}")
    public void eliminarPorCedula(@PathVariable("cedula") String cedula){
        this.pacienteService.eliminarPorCedula(cedula);
    }

    @PutMapping(path = "/{id}")
    public void actualizar(@PathVariable("id") Integer id, @RequestBody Paciente paciente ){
        paciente.setId(id);
        this.pacienteService.actualizar(paciente);
    }
    
}
