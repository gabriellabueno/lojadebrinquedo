package br.edu.fatecgru.toybox.service;

import br.edu.fatecgru.toybox.entity.ToyEntity;
import br.edu.fatecgru.toybox.repository.CategoryRepository;

import br.edu.fatecgru.toybox.repository.ToyRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;


@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    // @Transacional = reutiliza a mesma conexão do BD para todas as operações do metodo
    // garante Commit se tudo der certo e Rollback e ocorrer exceção

    @Transactional(readOnly = true)
    public List<ToyEntity> findAll() {
        return toyRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ToyEntity>findAllByCategoryId(Integer id) {
        return toyRepository.findAllByCategoryId(id);
    }

    @Transactional(readOnly = true)
    public ToyEntity findById(Long id) {
        return toyRepository.findById(id);
    }

   @Transactional
    public ToyEntity create(ToyEntity toy, MultipartFile imageFile) throws IOException {

        if ( toyRepository.existsById( toy.getId()) ) {
           throw new EntityExistsException(
                   "Brinquedo já cadastrado! ID: " + toy.getId() );
        }

        if ( !categoryRepository.existsById( toy.getCategoryId()) ) {
            throw new EntityNotFoundException(
                    "Categoria não encontrada com ID: " + toy.getCategoryId() );
        }

        if( imageFile.isEmpty() ) {
            throw new IOException(
                    "É necessário selecionar um arquivo de imagem!" );
        }

        toy.setImage(imageFile.getBytes());
        return toyRepository.save(toy);
   }

    @Transactional
    public ToyEntity update(Long id,  ToyEntity obj, MultipartFile imageFile) throws IOException {

        if ( !toyRepository.existsById( id ) ) {
           throw new EntityNotFoundException(
                   "Brinquedo não encontrado com ID: " + id );
        }

        if ( !categoryRepository.existsById( obj.getCategoryId()) ) {
            throw new EntityNotFoundException(
                    "Categoria não encontrada com ID: " + obj.getCategoryId());
        }

        // Se o usuário não inserir uma imagem mantém o brinquedo com a imagem armazenada no BD
        ToyEntity existingToy = toyRepository.findById(id);
        if (imageFile == null || imageFile.isEmpty())
            obj.setImage(existingToy.getImage());
        else
            obj.setImage(imageFile.getBytes());

        obj.setId(id);
        return toyRepository.save(obj);

    }

    @Transactional
    public void delete(Long id) {
        if ( !toyRepository.existsById(id) ) {
            throw new EntityNotFoundException(
                    "Brinquedo não encontrado com ID: " + id);
        }

        ToyEntity toy = toyRepository.findById(id);

        byte[] toyImage = toy.getImage();

        toyRepository.deleteById(id);
    }

    public ResponseEntity<byte[]> getImageResponse(Long id) throws IOException {
        if ( !toyRepository.existsById( id ) ) {
            throw new EntityNotFoundException(
                    "Brinquedo não encontrado com ID: " + id );
        }

        ToyEntity toy = toyRepository.findById(id);

        if( toy.getImage() == null ) {
            throw new IOException(
                    "Imagem não encontrada com ID: " + id );
        }

        String mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(toy.getImage()));
        MediaType mediaType = MediaType.IMAGE_JPEG; // Mantém JPEG como padrão

        // Muda o tipo de mídia para PNG se necessário
        if ("image/png".equals(mimeType))
            mediaType = MediaType.IMAGE_PNG;

        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(toy.getImage());
    }

}
