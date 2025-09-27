
package NETLotGUI;


import java.util.ArrayList;
import java.util.List;

public class NetGUI1 {
    private List<CustomerGUI> customers;

    public NetGUI1() {
        customers = new ArrayList<>();
    }

    public void addCustomer(CustomerGUI c) {
        customers.add(c);
    }

    public void removeCustomer(String id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

    public CustomerGUI findCustomer(String id) {
        for (CustomerGUI c : customers) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    public List<CustomerGUI> getCustomers() {
        return customers;
    }

    public double totalFee() {
        double total = 0;
        for (CustomerGUI c : customers) {
            total += ServiceGUI.calculateFee(c);
        }
        return total;
    }
} 

