package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.CategoryEntity;
import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.CategoryService;
import br.edu.fatecgru.toybox.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("api")
public class TESTController {

    @Autowired
    private ToyService toyService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all-toys")
    public List<ToyEntity> getAllTest() {
        List<ToyEntity> toys = toyService.findAll();
        return toys;
    }


    @GetMapping("/catalog")
    public List<CategoryEntity> getCategories() {
        return categoryService.findAll();
    }

    // BRINQUEDO POR CATEGORIA
    // http://localhost:8080/api/category?id=1

    @GetMapping("/category")
    public List<ToyEntity> getByCategory(@RequestParam("id") Integer id) {
        return toyService.findAllByCategoryId(id);
    }

    // APRESENTAÇÃO BRINQUEDO
    // http://localhost:8080/store/catalog/toy/1

    @GetMapping("/toy/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        ToyEntity toy = toyService.findById(id);
        if (toy == null)
            return ResponseEntity.notFound().build();
        else {
            return ResponseEntity.ok(toy);
        }
    }

    @PostMapping("/new-toy")
    public ToyEntity create(@RequestBody ToyEntity toy) {
        return toyService.create(toy);
    }

    @PutMapping("/update-toy/{id}")
    public ToyEntity update(@PathVariable("id") Long id, @RequestBody ToyEntity toy) {
       return toyService.update(id, toy);
    }


    @DeleteMapping("/delete-toy/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {


        ToyEntity toy = toyService.findById(id);
        if (toy == null)
           return ResponseEntity.notFound().build();
        else {
            toyService.delete(id);
            return ResponseEntity.ok("Brinquedo deletado com sucesso");
        }
    }



}
