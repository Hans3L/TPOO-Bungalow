package main.java.dao;

import main.java.dto.ProductosDto;

import java.util.List;

public interface ProductoImpl {
    void registerProducto(ProductosDto producto);
    ProductosDto getProducto(int id);
    void updateProducto(ProductosDto producto);
    void deleteProducto(int id);
    List<ProductosDto> getAllProducto();
}
