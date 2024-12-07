package test;

import org.junit.jupiter.api.Test;
import com.grocery.dat.OrderItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderItemTest {

    @Test
    public void testOrderItemget() {
        OrderItem orderItem = new OrderItem();

        orderItem.setProductId(2);
        assertEquals(2, orderItem.getProductId(), "Product ID should be 2");

        orderItem.setQuantity(5);
        assertEquals(5, orderItem.getQuantity(), "Quantity should be 5");
    }

    @Test
    public void testDefaultValues() {
        OrderItem orderItem = new OrderItem();
        assertEquals(0, orderItem.getProductId(), "product ID should be 0");
        assertEquals(0, orderItem.getQuantity(), "quantity should be 0");
    }
} 
