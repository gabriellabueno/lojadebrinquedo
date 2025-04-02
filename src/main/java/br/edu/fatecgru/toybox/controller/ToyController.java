package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.model.entity.Toy;
import br.edu.fatecgru.toybox.service.ToyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* CONTROLLER | Camada de Apresentação - API
 *   Recebe Requisições HTTP e retorna respostas (JSON, HTML)
 *   Define endpoints da API
 *       GET -> READ
 *       POST -> CREATE
 *       PUT -> UPDATE
 *       DELETE
 */


@RestController
@RequestMapping("store")
public class ToyController {

    @Autowired
    private ToyService toyService;

    // TELA HOME
    @GetMapping("/toys")
    public List<Toy> listAll() {
        return toyService.listAll();
    }

    // APRESENTAÇÃO BRINQUEDO
    @GetMapping("/toys/{id}")
    public Toy getById(@PathVariable("id") Integer id) {
        return toyService.getById(id);
    }

    // TELA ADMIN

    @GetMapping("/adm")
    public List<Toy> listAllAdm() {
        return toyService.listAll();
    }

    @PostMapping("/adm")
    public void insert(@RequestBody Toy toy) {
        toyService.insert(toy);
    }

    @PutMapping("/adm/{id}")
    public void update(@RequestBody Toy toy, @PathVariable("id") Integer id) {
        toyService.update(id, toy);
    }

    @DeleteMapping("/adm/{id}")
    public String remove(@PathVariable("id") Integer id) {
        toyService.remove(id);
        return "Brinquedo removido com sucesso!";
    }

    // TELA CATÁLOGO - BRINQUEDO POR CATEGORIA

    @GetMapping("/category/{id}")
    public List<Toy> listByCategory(@PathVariable Integer id) {
        return toyService.listByCategory(id);
    }


}
