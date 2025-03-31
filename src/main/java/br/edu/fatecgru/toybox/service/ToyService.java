package br.edu.fatecgru.toybox.service;

import br.edu.fatecgru.toybox.model.entity.repository.ToyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* SERVICE | Camada de Lógica de Negócio
 * Atua entre Controller e Repository
 * Garante validações e cálculos antes do acesso aos dados
 */

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;
}
