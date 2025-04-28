import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        OrderItemDAO orderItemDAO = new OrderItemDAO();

        try {
            Order newOrder = new Order(0, "Tábi István", "2211. Vasad", new Date(System.currentTimeMillis()), 10000, 1, new Date(System.currentTimeMillis()), "Teszt Ügyfél", new Date(System.currentTimeMillis()), "Teszt Ügyfél");
            orderDAO.insert(newOrder);

            OrderItem newItem = new OrderItem(0, 1, "Laptop", 1, 10000, new Date(System.currentTimeMillis()), "Teszt Ügyfél", new Date(System.currentTimeMillis()), "Teszt Ügyfél");
            orderItemDAO.insert(newItem);

            List<Order> orders = orderDAO.selectAll();
            for (Order o : orders) {
                System.out.println(o.getId() + " " + o.getOrderDate() + " " + o.getCustomerName());
            }

            List<OrderItem> items = orderItemDAO.selectAll();
            for (OrderItem i : items) {
                System.out.println(i.getId() + " " + i.getProductName() + " " + i.getPiece() + " " + i.getUnitPrice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}