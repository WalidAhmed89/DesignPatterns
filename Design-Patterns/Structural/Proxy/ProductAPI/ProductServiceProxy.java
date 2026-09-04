package Structural.Proxy.ProductAPI;

import Creational.Builder.ProductBuilder.Product;

import java.util.HashMap;

public class ProductServiceProxy implements IProductService{
    private IProductService _productService;
    private HashMap<Integer,String> cache;

    public ProductServiceProxy(){
        _productService = new RealProductService();
        cache = new HashMap<>();
    }

    @Override
    public String getProduct(int productID) {

        if(cache.containsKey(productID)){
            System.out.println("Getting product "+productID+" from cache");

            return cache.get(productID);
        }
        String product = _productService.getProduct(productID);
        cache.put(productID,product);

        return product;
    }
}
