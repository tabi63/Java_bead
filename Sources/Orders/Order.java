import java.sql.Date;

//Megrendelések osztálya
public class Order {
    private int id;                     //Egyedi azonosító
    private String customerName;        //Vevő neve
    private String customerAddress;     //Vevő címe
    private Date orderDate;             //Megrendelés ideje
    private int amount;                 //Fizetendő összeg 
    private int orderStateId;           //Megrendelés állapota
    private Date createdOn;             //Létrehozás ideje
    private String createdBy;           //Létrehozó
    private Date lastmodifiedOn;        //Utolsó módosítás ideje
    private String lastModifiedBy;      //Utolső mődosító
    

    public Order() {}

    public Order(int id, String customerName, String customerAddress, Date orderDate, int amount, int orderStateId, Date createdOn, String createdBy,
                    Date lastmodifiedOn, String lastModifiedBy) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.amount = amount;
        this.orderStateId = orderStateId;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
        this.lastmodifiedOn = lastmodifiedOn;
        this.lastModifiedBy =lastModifiedBy;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getOrderStateId() {
        return orderStateId;
    }
    public void setOrderStateId(int orderStateId) {
        this.orderStateId = orderStateId;
    }
    public Date getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public Date getLastModifiedOn() {
        return lastmodifiedOn;
    }
    public void setLastModifiedOn(Date lastmodifiedOn) {
        this.lastmodifiedOn = lastmodifiedOn;
    }
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }
}