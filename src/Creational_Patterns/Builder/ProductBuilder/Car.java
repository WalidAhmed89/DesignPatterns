package Creational_Patterns.Builder.ProductBuilder;

public class Car implements IBuilder {

    private String brandName;
    private Product product;

    public Car(String brand){
        product = new Product();
        this.brandName = brand;
    }

    @Override
    public void StartUpOperations() {
        product.Add("Car Model name: "+this.brandName);
    }

    @Override
    public void BuildBody() {
        product.Add(" Body was added ");
    }

    @Override
    public void InsertWheels() {
        product.Add(" Wheels was added ");
    }

    @Override
    public void AddHeadLights() {
        product.Add(" Lights was added ");
    }

    @Override
    public void EndOperations() {
        product.Add(" Operation was ended ");
    }

    @Override
    public Product GetVehicle() {
        return product;
    }
}
