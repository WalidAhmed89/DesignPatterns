package Creational.Builder.ProductBuilder;

public interface IBuilder {
    void StartUpOperations();
    void BuildBody();
    void InsertWheels();
    void AddHeadLights();
    void EndOperations();
    Product GetVehicle();
}
