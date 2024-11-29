import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.assertEquals;

public class backendtest { 
    @Test
    void mockData() { 
        String[][] products = backend.mockData();

        assertNotNull(products, "The array should not be null");
        assertEquals(3, products.length, "3 rows required for the products");
        assertEquals("Milk", products[0][0]);
        assertEquals("1.0", products[0][1]);
        assertEquals("Bread", products[1][0]);
        assertEquals("2.0", products[1][1]);
        assertEquals("Chicken", products[2][0]);
        assertEquals("5.0", products[2][1]);
    }
    {
    
    
}