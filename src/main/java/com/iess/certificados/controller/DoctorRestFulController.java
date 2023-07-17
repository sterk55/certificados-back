package com.iess.certificados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.iess.certificados.repository.model.Doctor;
import com.iess.certificados.repository.model.Paciente;
import com.iess.certificados.service.IDoctorService;

@RestController
@RequestMapping("/doctores")
@CrossOrigin("http://localhost:8080")
public class DoctorRestFulController {
    
    @Autowired
    private IDoctorService doctorService;

    @PostMapping
    public String crear(@RequestBody Doctor doctor){
       String msj = "Se ha ingresado correctamente";
       try{
        this.doctorService.crear(doctor);

       }catch(Exception e){
        msj = "Error al ingresar" + e;

       }
       return msj;

    }

    @GetMapping(path = "/todos")
    public ResponseEntity<List<Doctor>> listarDoctores(){
        return ResponseEntity.ok(this.doctorService.listarDoctores());

    }
    
    @DeleteMapping(path = "/{cedula}")
    public void eliminarPorCedula(@PathVariable("cedula") String cedula){
        this.doctorService.eliminarPorCedula(cedula);
    }

    @GetMapping(path = "/login/{cedula}/{contraseña}")
    public ResponseEntity<Doctor> loginResultado(@PathVariable("cedula") String cedula, @PathVariable("contraseña") String contraseña){
        return ResponseEntity.ok(this.doctorService.loginAprobado(cedula, contraseña));

    }

    @GetMapping(path = "/cedula/{cedula}")
    public ResponseEntity<List<Doctor>> buscarDoctorPorCedula(@PathVariable("cedula") String cedula){

        return ResponseEntity.ok(this.doctorService.buscarPorCedula(cedula));
    }

    @PutMapping(path = "/{id}")
    public void actualizar(@PathVariable("id") Integer id, @RequestBody Doctor doctor){
        doctor.setId(id);
        this.doctorService.actualizar(doctor);
        
    }
}
