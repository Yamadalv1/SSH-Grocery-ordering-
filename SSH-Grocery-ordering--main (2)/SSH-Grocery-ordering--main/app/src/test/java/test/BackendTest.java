package test; 

import com.grocery.dat.OrderItem;
import com.grocery.dat.Product;
import com.grocery.dat.User;
import com.grocery.dat.Backend;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class BackendTest {
    private Backend backend;

    @BeforeEach
    public void setUp() {
        backend = new Backend();
    } 

    @Test
    public void testUserList() {
        backend.userList();
        List<User> users = backend.getMockData().getUsers();
        assertEquals(2, users.size());

        User user1 = users.get(0);
        assertEquals("Max", user1.getName());
        assertEquals(1, user1.getId());
        assertEquals("max@example.com", user1.getEmail());
        assertEquals("Tennis Court", user1.getAddress());

        User user2 = users.get(1);
        assertEquals("Oscar", user2.getName()); 
        assertEquals(2, user2.getId());
        assertEquals("oscar@example.com", user2.getEmail());
        assertEquals("Tennis Court", user2.getAddress()); 
    }    

    @Test
public void testEmptyUserList() {
    List<User> users = backend.mockData.getUsers();
    assertTrue(users.isEmpty());
}

@Test
public void testEmptyProductCatalog() {
    List<Product> products = backend.mockData.getProductCatalog();
    assertTrue(products.isEmpty());
} 

@Test
public void testAddToCartWithZeroQuantity() {
    OrderItem orderItem = backend.addToCart(1, "Orange", 0, 1.7);
    assertEquals(0, orderItem.getTotalProductPrice());
}

@Test
public void testAddToCartWithNegativeQuantity() {
    OrderItem orderItem = backend.addToCart(1, "Orange", -1, 1.7);
    assertEquals(-1.7, orderItem.getTotalProductPrice());
}
   } 