package com.inventario.repository;

import com.inventario.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
//    Page<Producto> findByCategory(Long categoriaId, Pageable pageable);
//    Optional<Producto> findByIdAndCategoriaId(Long id, Long categoriaId);
}
