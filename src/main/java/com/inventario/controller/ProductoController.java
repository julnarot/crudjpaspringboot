package com.inventario.controller;

import com.inventario.entity.Categoria;
import com.inventario.entity.Producto;
import com.inventario.entity.request.AddCategoriaRequest;
import com.inventario.entity.request.AddProductoRequest;
import com.inventario.repository.CategoriaRepository;
import com.inventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
        System.out.println(this.productoRepository.findAll());
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Producto> findAllproductos() {
        return productoRepository.findAll();
    }

    @RequestMapping(value = "/{productoId}", method = RequestMethod.GET)
    public Producto findProductoById(@PathVariable Long productoId) {
        return productoRepository.findOne(productoId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Producto addNewProducto(@RequestBody AddProductoRequest addProductoRequest) {
        Producto product = new Producto();
        Categoria categoria = categoriaRepository.getOne(addProductoRequest.getCategoria_id());
        product.setNombre(addProductoRequest.getNombre());
        product.setPrecio(addProductoRequest.getPrecio());
        product.setCantidad(addProductoRequest.getCantidad());
        product.setCategoriaId(categoria.getId());
        return productoRepository.save(product);
    }

    @RequestMapping(value = "/{productoId}", method = RequestMethod.DELETE)
    public void deleteProducto(@PathVariable Long productoId) {
        productoRepository.delete(productoId);
    }

    @RequestMapping(value = "/{productoId}", method = RequestMethod.PUT)
    public Producto updateProducto(@PathVariable Long productoId, @RequestBody AddProductoRequest addProductoRequest) {
        Producto producto = productoRepository.getOne(productoId);
        producto.setNombre(addProductoRequest.getNombre());
        producto.setCantidad(addProductoRequest.getCantidad());
        producto.setPrecio(addProductoRequest.getPrecio());
        producto.setCategoriaId(addProductoRequest.getCategoria_id());
        return productoRepository.save(producto);
    }


}
