package main.java.facade;

import main.java.dao.ProductoDao;
import main.java.dao.ProductoImpl;
import main.java.dto.ProductosDto;

import java.util.List;

public class ProductoFacade {
private ProductoImpl productoImpl;

public ProductoFacade(){this.productoImpl=new ProductoDao();}
    public void registerProducto(ProductosDto producto){productoImpl.registerProducto(producto);}
    public ProductosDto getProducto(int ProductoId){return productoImpl.getProducto(ProductoId);}
    public void updateProducto(ProductosDto producto){productoImpl.updateProducto(producto);}
    public void deleteProducto(int producto){productoImpl.deleteProducto(producto);}
    public List<ProductosDto> getAllProducto(){return productoImpl.getAllProducto();}

}
