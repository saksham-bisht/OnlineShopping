import java.sql.*;

public class Product {
    public static void viewProducts() {
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            System.out.println("ID | Name | Price | Quantity");
            while (rs.next()) {
                System.out.printf("%d | %s | %.2f | %d\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addProduct(String name, double price, int quantity) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO products(name, price, quantity) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);
            ps.executeUpdate();
            System.out.println("Product added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

