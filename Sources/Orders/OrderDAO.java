import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public void insert(Order order) throws SQLException {
        String sql = "INSERT INTO \"order\" (customername, costumeraddress, orderdate, amount, orderstateid, createdon, createdby, lastmodifiedon, lastmodifiedby) VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, order.getCustomerName());
            stmt.setString(2, order.getCustomerAddress());
            stmt.setDate(3, order.getOrderDate());
            stmt.setInt(4, order.getAmount());
            stmt.setInt(5, order.getOrderStateId());
            stmt.setDate(6, order.getCreatedOn());
            stmt.setString(7, order.getCreatedBy());
            stmt.setDate(8, order.getLastModifiedOn());
            stmt.setString(9, order.getLastModifiedBy());
            stmt.executeUpdate();
        }
    }

    public void update(Order order) throws SQLException {
        String sql = "UPDATE \"order\" SET customername = ?, costumeraddress = ?, orderdate = ?, amount = ?, orderstateid = ?, createdon = ?, createdby = ?, lastmodifiedon = ?, lastmodifiedby = ?  WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, order.getCustomerName());
            stmt.setString(2, order.getCustomerAddress());
            stmt.setDate(3, order.getOrderDate());
            stmt.setInt(4, order.getAmount());
            stmt.setInt(5, order.getOrderStateId());
            stmt.setDate(6, order.getCreatedOn());
            stmt.setString(7, order.getCreatedBy());
            stmt.setDate(8, order.getLastModifiedOn());
            stmt.setString(9, order.getLastModifiedBy());
            stmt.setInt(10, order.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM \"order\" WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Order> selectAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM \"order\"";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("id"),
                        rs.getString("costumername"),
                        rs.getString("costumeraddress"),
                        rs.getDate("orderdate"),
                        rs.getInt("amount"),
                        rs.getInt("orderstateid"),
                        rs.getDate("createdon"),
                        rs.getString("createdby"),
                        rs.getDate("lastmodifiedon"),
                        rs.getString("lastmodifiedby")
                );
                orders.add(order);
            }
        }
        return orders;
    }

    public Order selectById(int id) throws SQLException {
        String sql = "SELECT * FROM \"order\" WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Order(
                        rs.getInt("id"),
                        rs.getString("costumername"),
                        rs.getString("costumeraddress"),
                        rs.getDate("orderdate"),
                        rs.getInt("amount"),
                        rs.getInt("orderstateid"),
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