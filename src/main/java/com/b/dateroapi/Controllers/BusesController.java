package com.b.dateroapi.Controllers;

import com.b.dateroapi.Models.BusesModel;
import com.b.dateroapi.Services.BusesService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/buses")
public class BusesController {
    @Autowired
    BusesService busesService;

    @GetMapping
    public List<BusesModel> GetAll(){
        return busesService.ListarBuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusesModel> GetAllId(@PathVariable Long id){
        Optional<BusesModel> buses = busesService.ListarBusId(id);
        if (buses.isPresent()){
            return new ResponseEntity<>(buses.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<BusesModel> CrearB(@RequestBody BusesModel busesModel){
        BusesModel cbus = busesService.CrearBus(busesModel);
        return new ResponseEntity<>(cbus,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusesModel> EditarB(@RequestBody BusesModel busesModel, @PathVariable Long id){
        BusesModel ebus = busesService.EditarBus(busesModel, id);
        if (ebus!=null){
            return new ResponseEntity<>(ebus, HttpStatus.OK);
        }
        return null;
    }

    @PutMapping("pos/{id}")
    public ResponseEntity<BusesModel> EditarPos(@RequestBody BusesModel busesModel, @PathVariable Long id){
        BusesModel ebus = busesService.EditarPosicionamiento(busesModel, id);
        if (ebus!=null){
            return new ResponseEntity<>(ebus, HttpStatus.OK);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BusesModel> EliminarB(@PathVariable Long id){
        busesService.EliminarBus(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vista")
    public List<BusesModel> getListBusesD(){
        return busesService.ListarBD();
    }

    @GetMapping("/busxempT/{emp}")
    public List<BusesModel> BusesxEmp(@PathVariable("emp") Long emp){
        return busesService.ListarBusesxET(emp);
    }

    @GetMapping("/busxempH/{est}/{emp}")
    public List<BusesModel> BusesxEmpH(@PathVariable("est") Boolean est,@PathVariable("emp") Long emp){
        return busesService.ListarBusesxEH(est, emp);
    }

    @GetMapping("/busxempD/{emp}")
    public List<BusesModel> BusesxEmpD(@PathVariable("emp") Long emp){
        return busesService.ListarBusesxED(emp);
    }

    @GetMapping("/saludo")
    public String Saludos(){
        return "Hola mundo";
    }
}
