import java.sql.*;
import java.util.Scanner;

public class FoodOrderingSystem {
    // Port number 3306 nu correct-a mathiyachu
    private static final String URL = "jdbc:mysql://localhost:3306/food_db"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "karthi@123"; // Unga MySQL Password!

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            // Driver-ai explicit-a register panrom
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("--- Connection Success! ---");
            System.out.println("--- Welcome to Online Food Ordering System ---");
            
            // Menu code...
            System.out.println("\n--- TODAY'S MENU ---");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM menu");
            while (rs.next()) {
                System.out.println(rs.getInt("item_id") + ". " + rs.getString("item_name") + " - Rs." + rs.getDouble("price"));
            }
            
            // Take Order...
            System.out.print("\nEnter your Name: ");
            String customerName = scanner.nextLine();
            
            System.out.print("Enter Item ID you want to order: ");
            int itemId = scanner.nextInt();
            
            System.out.print("Enter Quantity: ");
            int quantity = scanner.nextInt();
            
            PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM menu WHERE item_id = ?");
            pstmt1.setInt(1, itemId);
            ResultSet rs2 = pstmt1.executeQuery();
            
            if (rs2.next()) {
                String itemName = rs2.getString("item_name");
                double price = rs2.getDouble("price");
                double total = price * quantity;
                
                PreparedStatement pstmt2 = conn.prepareStatement(
                    "INSERT INTO orders (customer_name, item_name, quantity, total_price) VALUES (?, ?, ?, ?)"
                );
                pstmt2.setString(1, customerName);
                pstmt2.setString(2, itemName);
                pstmt2.setInt(3, quantity);
                pstmt2.setDouble(4, total);
                
                int rows = pstmt2.executeUpdate();
                if (rows > 0) {
                    System.out.println("\n Order Placed Successfully!");
                    System.out.println("Total Amount to Pay: Rs." + total);
                }
            } else {
                System.out.println("Invalid Item ID!");
            }
            
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Class Error: MySQL Connector proper-a add aagala!");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}