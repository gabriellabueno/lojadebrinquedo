package br.edu.fatecgru.toybox.controller;

import br.edu.fatecgru.toybox.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
