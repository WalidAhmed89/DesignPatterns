package Creational.Builder.ProductBuilder;

public class MotorCycle implements IBuilder {

    private String brandName;

    private Product product;

    public MotorCycle(String brand){
        product = new Product();
        this.brandName = brand;
    }

    @Override
    public void StartUpOperations() {
        product.Add("MotorCycle Model name: "+this.brandName);
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
