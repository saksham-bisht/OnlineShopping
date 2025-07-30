import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductManager {
    public static void addProduct(String name, double price) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO products (name, price) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.executeUpdate();

            System.out.println("✅ Product added successfully: " + name);
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        addProduct("Laptop", 55000);
        addProduct("Smartphone", 22000);
        addProduct("Wireless Mouse", 900);
        addProduct("Headphones", 1500);
        addProduct("Smartwatch", 4000);
          addProduct("Lenovo Laptop", 85000);
        addProduct("Apple Smartphone", 44000);
        addProduct("Logitech Mouse", 2800);
        addProduct("BOAT Headphones", 3500);
    }
}
