package br.edu.fatecgru.toybox.toy;

import br.edu.fatecgru.toybox.category.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public ResponseEntity<?> findAllByCategoryId(Integer id) {
        List<Toy> toys = toyRepository.findAllByCategoryId(id);

        if( toys.isEmpty() ) {
            String message = "Não há brinquedos cadastrados para a categoria de ID " + id;
            return errorTextResponse(HttpStatus.NOT_FOUND, message);
        } else
            return ResponseEntity.ok(toys);

    }

    public ResponseEntity<?> findAll() {
        List<Toy> toys = toyRepository.findAll();

        if( toys.isEmpty() ) {
            String message = "Não há brinquedos cadastrados!";
            return errorTextResponse(HttpStatus.NOT_FOUND, message);
        } else
            return ResponseEntity.ok(toys);
    }

    public ResponseEntity<?> findById(Integer id) {
        Toy toy = toyRepository.findById(id).orElse(null);

        if (toy != null) {
            return ResponseEntity.ok(toy);
        } else {
            String message = "Brinquedo de ID " + id + " não encontrado!";
            return errorTextResponse(HttpStatus.NOT_FOUND, message);
        }
    }

    public ResponseEntity<?> create(Toy obj) {
        Toy toySearch = toyRepository.findByName(obj.getName());
        Integer categoryId = obj.getCategoryId();
        String message = "";

        if (toySearch != null) {
            message = "Brinquedo já cadastrado! ID: " + toySearch.getId();
            return errorTextResponse(HttpStatus.CONFLICT, message);

        } else if (!categoryRepository.existsById(categoryId)) {
            message = "Categoria de ID " + categoryId + " não encontrada!";
            return errorTextResponse(HttpStatus.NOT_FOUND, message);

        } else {
            toyRepository.save(obj);
            message = "Brinquedo cadastrado com sucesso!";
            return okTextResponse(message);
        }

    }

    public ResponseEntity<?> update(Integer id, Toy obj) {
        Integer categoryId = obj.getCategoryId();
        String message = "";

        if( !toyRepository.existsById(id) ) {
            message = "Brinquedo de ID " + id + " não encontrado!";
            return errorTextResponse(HttpStatus.NOT_FOUND, message);

        } else if ( !categoryRepository.existsById(categoryId) ) {
            message = "Categoria de ID " + categoryId + " não encontrada!";
            return errorTextResponse(HttpStatus.NOT_FOUND, message);

        } else {
            Toy toy = toyRepository.findById(id).get();

            toy.setName(        obj.getName() );
            toy.setPrice(       obj.getPrice() );
            toy.setBrand(       obj.getBrand() );
            toy.setImageUrl(    obj.getImageUrl() );
            toy.setDescription( obj.getDescription() );
            toy.setCategoryId(  obj.getCategoryId() );

            toyRepository.save(toy);

            message = "Brinquedo de ID " + id + " atualizado com sucesso!";
            return okTextResponse(message);
        }

    }

    public ResponseEntity<?> delete(Integer id) {
        String message = "";

        if ( toyRepository.existsById(id) ) {
            toyRepository.deleteById(id);
            message = "Brinquedo de ID " + id + " removido com sucesso!";
            return okTextResponse(message);
        } else
            message = "Brinquedo de ID " + id + " não encontrado!";
            return errorTextResponse(HttpStatus.NOT_FOUND, message);
    }


    // RESPOSTAS HTTP
    public static ResponseEntity<String> okTextResponse(String message) {
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(message);
    }

    public static ResponseEntity<String> errorTextResponse(HttpStatus status, String message) {
        return ResponseEntity.status(status)
                .contentType(MediaType.TEXT_PLAIN)
                .body(message);
    }

}
