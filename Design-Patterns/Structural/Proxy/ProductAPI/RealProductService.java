package Structural.Proxy.ProductAPI;

public class RealProductService implements IProductService{
    @Override
    public String getProduct(int productID) {

        System.out.println("API call for product: "+productID);

        return "product "+productID;
    }
}
