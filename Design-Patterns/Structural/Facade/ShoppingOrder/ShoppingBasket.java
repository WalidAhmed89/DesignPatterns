package Structural.Facade.ShoppingOrder;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private List<BasketItem> items = new ArrayList<BasketItem>();

    public void addItem(BasketItem item){
        items.add(item);
    }

    public void removeOneItem(String itemID){
        BasketItem item = items.stream().filter(x -> x.getItemID() == itemID).findFirst().orElseThrow();
        if(item.getQuantity() > 0 ){
            item.setQuantity(item.getQuantity()-1);
        }
    }

    public List<BasketItem> getItems(){return items;}
}
