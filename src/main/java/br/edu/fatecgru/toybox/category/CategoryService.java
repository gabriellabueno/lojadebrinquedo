package br.edu.fatecgru.toybox.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<?> findAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();

        if( categories.isEmpty() ) {
            String message = "Não há categorias cadastradas!";
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(message);
        } else
            return ResponseEntity.ok(categories);    }

}
