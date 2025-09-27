
package NETLotGUI;



import java.util.Date;

public class CustomerGUI {
    private String id;
    private String name;
    private String phone;
    private Date checkIn;
    private Date checkOut;
    private String pcType; 

    public CustomerGUI(String id, String name, String phone, Date checkIn, String pcType) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.checkIn = checkIn;
        this.pcType = pcType;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public Date getCheckIn() { return checkIn; }
    public Date getCheckOut() { return checkOut; }
    public String getPcType() { return pcType; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCheckOut(Date checkOut) { this.checkOut = checkOut; }
    public void setPcType(String pcType) { this.pcType = pcType; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phone + " | " + pcType;
    }
}
