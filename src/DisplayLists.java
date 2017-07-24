/**
 * Created by zuoanqh on 7/24/2017.
 */

import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayLists {

    public static void main(String[] args) {
        List<Stock> l = new ArrayList<Stock>();
        Stock s = new Stock();
        Drink d = new Drink();
        d.setBrand("asdasda");
        d.setNum(123123);
        s. setStock(d);
        l.add(s);
        Ticket t = new Ticket();
        t.setDrink(d);
        t.setNumber(144);
        Customer c = new Customer();
        c.setName("cat ajsdoas");
        t.setCustomer(c);
        TicketList tl = new TicketList();
        tl.ticket.add(t);
        DisplayTicketList(tl);

    }

    public static void DisplayStock(List<Stock> l)
    {
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        String[] columnNames = {"Brand", "Num"};

        Object[][] data = new String[l.size()][2];
        for(int i=0;i<l.size();i++)
        {
            data[i][0]=l.get(i).getStock().getBrand();
            data[i][1]=l.get(i).getStock().getNum()+"";

        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);

    }

    public static void DisplayTicketList(TicketList l)
    {
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        List<Ticket>ls = l.ticket;
        String[] columnNames = {"Ticket Number", "Customer Name", "Brand", "Num"};

        Object[][] data = new String[ls.size()][4];
        for(int i=0;i<ls.size();i++)
        {
            data[i][0]=ls.get(i).getNumber()+"";
            data[i][1]=ls.get(i).getCustomer().getName();
            data[i][2]=ls.get(i).getDrink().getBrand();
            data[i][3]=ls.get(i).getDrink().getNum()+"";

        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);

    }
}
