package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.RolesModel;
import com.b.dateroapi.Services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
    @Autowired
    RolesService rolesService;

    @GetMapping
    public ResponseEntity<List<RolesModel>> listarRoles() {
        List<RolesModel> roles = rolesService.ListarRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolesModel> listarRolPorId(@PathVariable("id") Long id) {
        Optional<RolesModel> rol = rolesService.ListarRolId(id);
        if (rol.isPresent()) {
            return new ResponseEntity<>(rol.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<RolesModel> crearRol(@RequestBody RolesModel rolesModel) {
        RolesModel nuevoRol = rolesService.CrearRoles(rolesModel);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolesModel> editarRol(@RequestBody RolesModel rolesModel, @PathVariable("id") Long id) {
        RolesModel rolEditado = rolesService.EditarRoles(rolesModel, id);
        if (rolEditado != null) {
            return new ResponseEntity<>(rolEditado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable("id") Long id) {
        rolesService.EliminarRoles(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
