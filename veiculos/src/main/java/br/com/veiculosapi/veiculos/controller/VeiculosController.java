package br.com.veiculosapi.veiculos.controller;

import br.com.veiculosapi.veiculos.model.VeiculosModel;
import br.com.veiculosapi.veiculos.service.VeiculosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VeiculosController {

    private VeiculosService veiculosService;

    public VeiculosController(VeiculosService veiculosService) {
        this.veiculosService = veiculosService;
    }

    @GetMapping("")
    public String texto () {
        return "API está de pé! Confia!";
    }

    @GetMapping("/veiculos")
    public ResponseEntity <List<VeiculosModel>> listaVeiculos () {
        return ResponseEntity.status(200).body(veiculosService.listarVeiculos());
    }

    @PostMapping("/veiculos")
    public ResponseEntity<VeiculosModel> criaVeiculo (@RequestBody VeiculosModel veiculo) {
        return ResponseEntity.status(201).body(veiculosService.criarVeiculos(veiculo));
    }

    @PutMapping("/veiculos")
    public ResponseEntity<VeiculosModel> editaVeiculo (@RequestBody VeiculosModel veiculo) {
        return ResponseEntity.status(201).body(veiculosService.editarVeiculos(veiculo));
    }

    @DeleteMapping("/veiculos/{id}")
    public ResponseEntity<?> ExcluiVeiculo (@PathVariable Integer id) {
        veiculosService.excluirVeiculos(id);
        return ResponseEntity.status(204).build();
    }
}

