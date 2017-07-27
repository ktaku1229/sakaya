/**
 * Created by zuoanqh on 7/24/2017.
 */

//import javafx.application.Application;
//import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayLists {
    static{
        FileTest.main(null);
    }

    public static void main(String[] args) {
        DisplayStock();
    }

    public static void DisplayStock()
    {
        JOptionPane.showMessageDialog(null, "");
        Stock l = FileTest.s;
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        String[] columnNames = {"Brand", "Num"};

        Object[][] data = new String[l.getStock().size()][2];
        for(int i=0;i<l.getStock().size();i++)
        {
            data[i][0]=l.getStock().get(i).getBrand();
            data[i][1]=l.getStock().get(i).getNum()+"";

        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);

    }

    public static void DisplayTicketList()
    {
        String name = JOptionPane.showInputDialog("Input Customer Name");

        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        List<Ticket>ls = FileTest.tl.ticket.stream().filter(ticket->ticket.getCustomer().getName().equals(name)).collect(Collectors.toList());
        String[] columnNames = {"Ticket Number", "Customer Name", "Brand", "Num"};

        Object[][] data = new String[ls.size()][4];
        for(int i=0;i<ls.size();i++)
        {
                data[i][0] = ls.get(i).getNumber() + "";
                data[i][1] = ls.get(i).getCustomer().getName();
                data[i][2] = ls.get(i).getDrink().getBrand();
                data[i][3] = ls.get(i).getDrink().getNum() + "";
        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);

    }
}
