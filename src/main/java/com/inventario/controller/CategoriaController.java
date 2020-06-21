package com.inventario.controller;

import com.inventario.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.inventario.entity.Categoria;
import com.inventario.entity.request.AddCategoriaRequest;

import java.util.List;

@RestController()
@RequestMapping("categoria")
public class CategoriaController {

    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

    @RequestMapping(value = "/{categoriaId}", method = RequestMethod.GET)
    public Categoria findCategoriaById(@PathVariable Long categoriaId) {
        return categoriaRepository.findOne(categoriaId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Categoria addNewCategoria(@RequestBody AddCategoriaRequest addUserRequest) {
        Categoria user = new Categoria();
        user.setNombre(addUserRequest.getNombre());
        return categoriaRepository.save(user);
    }

    @RequestMapping(value = "/{categoriaId}", method = RequestMethod.DELETE)
    public void deleteCategoria(@PathVariable Long categoriaId) {
        categoriaRepository.delete(categoriaId);
    }

    @RequestMapping(value = "/{categoriaId}", method = RequestMethod.PUT)
    public Categoria updateCategoria(@PathVariable Long categoriaId, @RequestBody AddCategoriaRequest addUserRequest) {
        Categoria categoria = categoriaRepository.getOne(categoriaId);
        categoria.setNombre(addUserRequest.getNombre());
        return categoriaRepository.save(categoria);
    }


}
