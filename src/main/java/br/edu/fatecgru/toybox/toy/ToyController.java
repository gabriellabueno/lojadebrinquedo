package br.edu.fatecgru.toybox.toy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
public class ToyController {

    @Autowired
    private ToyService toyService;

    // TELA HOME
    @GetMapping("/toys")
    public ResponseEntity<?> getAll() {
        return toyService.findAll();
    }


    // TELA CATÁLOGO - BRINQUEDO POR CATEGORIA

    @GetMapping("/category/{id}")
    public ResponseEntity<?> getByCategory(@PathVariable Integer id) {
        return toyService.findAllByCategoryId(id);
    }

    // APRESENTAÇÃO BRINQUEDO
    @GetMapping("/toys/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        return toyService.findById(id);
    }


    // TELA ADMIN

    @GetMapping("/adm")
    public ResponseEntity<?> getAllAdm() {
        return toyService.findAll();
    }

    @PostMapping("/adm")
    public ResponseEntity<?> create(@RequestBody Toy obj) {
        return toyService.create(obj);
    }

    @PutMapping("/adm/{id}")
    public ResponseEntity<?> update(@RequestBody Toy obj, @PathVariable("id") Integer id) {
        return toyService.update(id, obj);
    }

    @DeleteMapping("/adm/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return toyService.delete(id);
    }


}
