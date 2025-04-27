import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Megrendelés állapotának a kezelése az adatbázisban
public class OrderStateDAO
{
    //Megrendelés állapot felvitele
    public void insert(OrderState state) throws SQLException {
        String sql = "INSERT INTO orderstate (description) VALUES (?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, state.getDescription());
            stmt.executeUpdate();
        }
    }

    //Megrendelés állapot módosítása
    public void update(OrderState state) throws SQLException {
        String sql = "UPDATE orderstate SET description = ? WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, state.getDescription());
            stmt.setInt(2, state.getId());
            stmt.executeUpdate();
        }
    }

    //Megrendelés állapot törlése
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM orderstate WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    //Összes megrendelés állapot lekérdezése
    public List<OrderState> selectAll() throws SQLException {
        List<OrderState> states = new ArrayList<>();
        String sql = "SELECT * FROM orderstate";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                OrderState state = new OrderState(
                        rs.getInt("id"),
                        rs.getString("description")
                );
                states.add(state);
            }
        }
        return states;
    }

    //Megrendelés állapot lekérdezése id alapján
    public OrderState selectById(int id) throws SQLException {
        String sql = "SELECT * FROM orderstate WHERE id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new OrderState(
                        rs.getInt("id"),
                        rs.getString("description")
                    );
                }
            }
        }
        return null;
    }
}
