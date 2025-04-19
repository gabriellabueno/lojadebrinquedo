package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.entity.CategoryEntity;
import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.service.CategoryService;
import br.edu.fatecgru.toybox.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    // http://localhost:8080/store/catalog/category?id=1

    @GetMapping("/catalog/category")
    public List<ToyEntity> getByCategory(@RequestParam("id") Integer id) {
        return toyService.findAllByCategoryId(id);
    }

    // APRESENTAÇÃO BRINQUEDO
    // http://localhost:8080/store/catalog/toy/1

    @GetMapping("/catalog/toy/{id}")
    public ToyEntity getById(@PathVariable("id") Integer id) {
        return toyService.findById(id);
    }

    @PostMapping("/new-toy")
    public ToyEntity create(@RequestBody ToyEntity toy) {
        return toyService.create(toy);
    }

}
