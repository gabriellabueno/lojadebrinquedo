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
        return toyService.listAllToy();
    }

    // TELA ADMIN
    @GetMapping("/adm")
    public List<Toy> listAllAdm() {
        return toyService.listAllToy();
    }

    @GetMapping("/toys/{id}")
    public Toy getToyById(@PathVariable("pk_id_toy") Integer id) {
        return toyService.getToyById(id);
    }

    @PostMapping("/adm/new")
    public void insertToy(@RequestBody Toy toy) {
        toyService.insertToy(toy);
    }

    @PutMapping("/adm/update/{id}")
    public Toy update(@RequestBody Toy toy, @PathVariable Integer id) {
        //Obter toy a ser atualizado:
        Toy toyUpdate = toyService.getToyById(id);

        //Atualizar dados:
        toyUpdate.setName(toy.getName());
        toyUpdate.setPrice(toy.getPrice());
        toyUpdate.setBrand(toy.getBrand());
        toyUpdate.setImage(toy.getImage());
        toyUpdate.setDescription(toy.getDescription());
        toyUpdate.setCategory(toy.getCategory());
        toyService.updateToy(toyUpdate);

        return toyUpdate;
    }

    @DeleteMapping("/adm/delete/{id}")
    public String delete(@PathVariable("pk_id_toy") Integer id) {
        toyService.removeToy(id);
        return "Brinquedo removido com sucesso!";
    }


}
