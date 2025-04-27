//Megrendelés állapotának az osztálya
public class OrderState
{
    private int id;             //egyedi azonosítő
    private String description; //megrendelés állapota

    public OrderState() { }

    public OrderState(int id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }    
}
