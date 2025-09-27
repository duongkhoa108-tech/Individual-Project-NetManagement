
package NETLotGUI;

import javax.swing.*;
import java.util.Date;

public class ServiceGUI {

    
    public static long getHours(Date checkIn, Date checkOut) {
        if (checkIn == null || checkOut == null) return 0;
        long diff = checkOut.getTime() - checkIn.getTime();
        long hours = diff / (1000 * 60 * 60);
        return (hours < 1) ? 1 : hours; 
    }

  
    public static double calculateFee(CustomerGUI c) {
        if (c == null) return 0;
        if (c.getCheckIn() == null || c.getCheckOut() == null) return 0;

        long hours = getHours(c.getCheckIn(), c.getCheckOut());
        String type = (c.getPcType() == null) ? "Normal" : c.getPcType();

        double rate = type.equalsIgnoreCase("VIP") ? 10000 : 5000;
        double total = hours * rate;

        
        JOptionPane.showMessageDialog(null,
                "Khach: " + c.getName() +
                "\nLoai may: " + type +
                "\nSo gio: " + hours +
                "\nTien phai tra: " + total + " VND",
                "Thanh toan",
                JOptionPane.INFORMATION_MESSAGE);

        return total;
    }
}


