import java.sql.Date;
//Megrendelés tételeinek az osztálya
public class OrderItem {
    private int id;                 //megrendelés tételének egyedi azonosítója
    private int orderId;            //megrendelés egyedi azonosítója
    private String productName;     //termék neve
    private int piece;              //darabszám
    private int unitPrice;          //egység ár
    private Date createdOn;         //Létrehozás ideje
    private String createdBy;       //Létrehozó
    private Date lastmodifiedOn;    //Utolsó módosítás ideje
    private String lastModifiedBy;  //Utolső mődosító

    public OrderItem() {}

    public OrderItem(int id, int orderId, String productName, int piece, int unitPrice, Date createdOn, String createdBy, Date lastmodifiedOn, String lastModifiedBy) {
        this.id = id;
        this.orderId = orderId;
        this.productName = productName;
        this.piece = piece;
        this.unitPrice = unitPrice;
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
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getPiece() {
        return piece;
    }
    public void setPiece(int piece) {
        this.piece = piece;
    }
    public int getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
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