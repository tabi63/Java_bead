import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Megrendelés tételek kezelés az adatbázisban
public class OrderItemDAO {

    //Megrendelés tétel felvitele
    public void insert(OrderItem item) throws SQLException {
        String sql = "INSERT INTO orderitem (orderid, productname, piece, unitprice, createdon, createdby, lastmodifiedon, lastmodifiedby) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getOrderId());
            stmt.setString(2, item.getProductName());
            stmt.setInt(3, item.getPiece());
            stmt.setInt(4, item.getUnitPrice());
            stmt.setDate(5, item.getCreatedOn());
            stmt.setString(6, item.getCreatedBy());
            stmt.setDate(7, item.getLastModifiedOn());
            stmt.setString(8, item.getLastModifiedBy());
            stmt.executeUpdate();
        }
    }

    //Megrendelés tétel módosítása
    public void update(OrderItem item) throws SQLException {
        String sql = "UPDATE orderitem SET orderid = ?, productname = ?, quantity = ?, unitprice = ?, createdon = ?, createdby = ?, lastmodifiedon = ?, lastmodifiedby = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, item.getOrderId());
            stmt.setString(2, item.getProductName());
            stmt.setInt(3, item.getPiece());
            stmt.setInt(4, item.getUnitPrice());
            stmt.setDate(5, item.getCreatedOn());
            stmt.setString(6, item.getCreatedBy());
            stmt.setDate(7, item.getLastModifiedOn());
            stmt.setString(8, item.getLastModifiedBy());
            stmt.setInt(9, item.getId());
            stmt.executeUpdate();
        }
    }

    //Megrendelés tétel törlése
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM orderitem WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    //Összes megrendelés tétel lekérdezése
    public List<OrderItem> selectAll() throws SQLException {
        List<OrderItem> items = new ArrayList<>();
        String sql = "SELECT * FROM orderitem";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                OrderItem item = new OrderItem(
                        rs.getInt("id"),
                        rs.getInt("orderid"),
                        rs.getString("productname"),
                        rs.getInt("piece"),
                        rs.getInt("unitprice"),
                        rs.getDate("createdon"),
                        rs.getString("createdby"),
                        rs.getDate("lastmodifiedon"),
                        rs.getString("lastmodifiedby")
                );
                items.add(item);
            }
        }
        return items;
    }

    //Egy megrendeléshez tartozó tételek lekérdezése
        public List<OrderItem> selectByOrderId(int orderId) throws SQLException {
        List<OrderItem> items = new ArrayList<>();
        String sql = "SELECT * FROM orderitem WHERE orderid = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    OrderItem item = new OrderItem(
                        rs.getInt("id"),
                        rs.getInt("orderid"),
                        rs.getString("productname"),
                        rs.getInt("piece"),
                        rs.getInt("unitprice"),
                        rs.getDate("createdon"),
                        rs.getString("createdby"),
                        rs.getDate("lastmodifiedon"),
                        rs.getString("lastmodifiedby")
                    );
                    items.add(item);
                }
            }
        }
        return items;
    }

    //Megrendelés tétel lekérdezése id alapján
    public OrderItem selectById(int id) throws SQLException {
        String sql = "SELECT * FROM orderitem WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new OrderItem(
                        rs.getInt("id"),
                        rs.getInt("orderid"),
                        rs.getString("productname"),
                        rs.getInt("piece"),
                        rs.getInt("unitprice"),
                        rs.getDate("createdon"),
                        rs.getString("createdby"),
                        rs.getDate("lastmodifiedon"),
                        rs.getString("lastmodifiedby")
                    );
                }
            }
        }
        return null;
    }
}
