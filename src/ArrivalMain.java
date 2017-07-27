import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ArrivalMain extends JDialog {

	static File file = new File("src/zaiko.txt");
	static File tlFile = new File("src/ticket.txt");
	static File orderFile = new File("src/order.txt");
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	static OrderList list = new OrderList();
	static TicketList ticketList = new TicketList();

	private static Stock s = new Stock();

	static ArrivalMain dialog = new ArrivalMain(0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try{
		      BufferedReader br = new BufferedReader( new FileReader(file) );
		      String str;

		      String zaiko[];
		      ArrayList<Drink> stock = new ArrayList<Drink>();

		      while( (str = br.readLine()) != null ) {
		    	  zaiko = str.split(",");
		    	  Drink d = new Drink();
		    	  d.setBrand(zaiko[0]);
		    	  d.setNum(Integer.parseInt(zaiko[1]));
		    	  stock.add(d);
		      }
		      s.setStock(stock);

		      br.close();
		    }catch(FileNotFoundException e){
		      System.out.println("ファイルが存在しません.");
		    }catch(IOException e){
		      System.out.println("ファイルを読み込めませんでした.");
		    }catch(NumberFormatException e){
		    	System.out.println("ファイルの形式が正しくありません.");
		    }

		try{
	        BufferedReader br2 = new BufferedReader( new FileReader(tlFile) );
	        String str2;

	        String ticket[];

	        while( (str2 = br2.readLine()) != null ) {
	      	  ticket = str2.split(",");
	      	  Ticket t = new Ticket();
	      	  t.setNumber(Integer.parseInt(ticket[0]));
	      	  Customer customer = new Customer();
	      	  customer.setName(ticket[1]);
	      	  t.setCustomer(customer);
	      	  Drink d = new Drink();
	      	  d.setBrand(ticket[2]);
	      	  d.setNum(Integer.parseInt(ticket[3]));
	      	  t.setDrink(d);
	      	  ticketList.ticket.add(t);
	        }

	        br2.close();
	      }catch(FileNotFoundException e){
	        System.out.println("ファイルが存在しません.");
	      }catch(IOException e){
	        System.out.println("ファイルを読み込めませんでした.");
	      }catch(NumberFormatException e){
	      	System.out.println("ファイルの形式が正しくありません.");
	      }

		try{
	        BufferedReader br = new BufferedReader( new FileReader(orderFile) );
	        String str;

	        String tmp[];

	        while( (str = br.readLine()) != null ) {
	      	  tmp = str.split(",");
	      	  Order order = new Order();
	      	  order.setNumber(Integer.parseInt(tmp[0]));
	      	  Customer customer = new Customer();
	      	  customer.setName(tmp[1]);
	      	  order.setCustomer(customer);
	      	  Drink d = new Drink();
	      	  d.setBrand(tmp[2]);
	      	  d.setNum(Integer.parseInt(tmp[3]));
	      	  order.setDrink(d);
	      	  list.order.add(order);
	        }

	        br.close();
	      }catch(FileNotFoundException e){
	        System.out.println("ファイルが存在しません.");
	      }catch(IOException e){
	        System.out.println("ファイルを読み込めませんでした.");
	      }catch(NumberFormatException e){
	      	System.out.println("ファイルの形式が正しくありません.");
	      }
/*
		Drink drink = new Drink();
		Order order = new Order();
		Customer customer = new Customer();
		customer.setName("aaa");
		drink.setBrand("mio");
		drink.setNum(10);
		order.setDrink(drink);
		order.setCustomer(customer);
		order.setNumber(1);
		list.order.add(order);
		Drink drink2 = new Drink();
		Order order2 = new Order();
		drink2.setBrand("asahi");
		drink2.setNum(5);
		order2.setDrink(drink2);
		order2.setCustomer(customer);
		order2.setNumber(1);
		list.order.add(order2);
		Drink drink3 = new Drink();
		Order order3 = new Order();
		drink3.setBrand("asahi");
		drink3.setNum(10);
		order3.setDrink(drink3);
		order3.setCustomer(customer);
		order3.setNumber(2);
		list.order.add(order3);

		*/
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ArrivalMain(int id) {
		if (id == 0) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 450, 42);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				getContentPane().add(panel);
				{
					JLabel lblNewLabel = new JLabel("出荷管理画面へようこそ 出荷が完了した注文番号を入力してください");

					panel.add(lblNewLabel);
				}
			}

			JLabel lblNewLabel_1 = new JLabel("注文番号:");
			lblNewLabel_1.setBounds(10, 60, 61, 16);
			getContentPane().add(lblNewLabel_1);

			textField = new JTextField();
			textField.setBounds(62, 55, 130, 26);
			getContentPane().add(textField);
			textField.setColumns(10);

			JButton btnNewButton = new JButton("OK");
			btnNewButton.setBounds(0, 93, 68, 26);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int flag = 0;
					try{
					for (int i = 0; i < list.order.size(); i++) {
						if (list.order.get(i).getNumber() == (Integer.parseInt(textField.getText()))) {
							flag = 1;
						}
					}
					if (flag == 0) {
						dialog.setVisible(false);
						createPanel(4);
					} else {
						dialog.setVisible(false);
						createPanel(2);
					}
					}catch(Exception exc){
						dialog.setVisible(false);
						createPanel(4);
					}
				}
			});
		}
	}

	public void createPanel(int id) {
		if (id == 2) {
			final JDialog contentPanel = new JDialog();
			contentPanel.setBounds(100, 100, 450, 300);
			contentPanel.setLayout(null);
			{
				{
					JLabel lblNewLabel = new JLabel("以下の注文でよろしいでしょうか？");
					lblNewLabel.setBounds(10, 20, 450, 16);
					contentPanel.add(lblNewLabel);
				}
			}
			JLabel lblNewLabel_1 = new JLabel("注文番号:" + textField.getText());
			lblNewLabel_1.setBounds(10, 60, 450, 16);
			contentPanel.add(lblNewLabel_1);

			int count=0;
			for(int i=0; i<list.order.size(); i++){
				if(list.order.get(i).getNumber() == (Integer.parseInt(textField.getText()))){
					JLabel lbl1 = new JLabel("顧客名:" + list.order.get(i).getCustomer().getName());
					lbl1.setBounds(10, 80+60*count, 450, 16);
					contentPanel.add(lbl1);
					JLabel lbl2 = new JLabel("酒の銘柄:" + list.order.get(i).getDrink().getBrand());
					lbl2.setBounds(10, 100+60*count, 450, 16);
					contentPanel.add(lbl2);
					JLabel lbl3 = new JLabel("本数:" + list.order.get(i).getDrink().getNum());
					lbl3.setBounds(10, 120+60*count, 450, 16);
					contentPanel.add(lbl3);
					count++;
				}
			}

			JButton btnNewButton = new JButton("OK");
			btnNewButton.setBounds(16, 250, 68, 29);
			contentPanel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0; i<list.order.size(); i++){
						if(list.order.get(i).getNumber() == (Integer.parseInt(textField.getText()))){
							int number = list.order.get(i).getNumber();
							Customer customer = list.order.get(i).getCustomer();
							Drink drink = list.order.get(i).getDrink();
							list.order.remove(i);
							Ticket ticket = createTicket(number ,customer, drink);
							decreaseStock(drink);
							ticketList.ticket.add(ticket);
							i--;
						}
					}
					writeStock();
					writeTicketList();
					writeOrderList();

					contentPanel.setVisible(false);
					createPanel(3);
				}
			});
			JButton btn2 = new JButton("cancel");
			btn2.setBounds(100, 250, 100, 29);
			contentPanel.add(btn2);
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPanel.setVisible(false);
					dialog.setVisible(true);
				}
			});

			contentPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			contentPanel.setVisible(true);
		}
		if(id==3){
			final JDialog contentPanel = new JDialog();
			contentPanel.setBounds(100, 100, 450, 300);
			contentPanel.setLayout(null);
			{
				{
					JLabel lblNewLabel = new JLabel("以下の注文の出荷を完了しました.");
					lblNewLabel.setBounds(10, 20, 450, 16);
					contentPanel.add(lblNewLabel);
				}
			}
			JLabel lblNewLabel_1 = new JLabel("注文番号:" + textField.getText());
			lblNewLabel_1.setBounds(10, 60, 450, 16);
			contentPanel.add(lblNewLabel_1);

			int count=0;
			for(int i=0; i<list.order.size(); i++){
				if(list.order.get(i).getNumber() == (Integer.parseInt(textField.getText()))){
					JLabel lbl1 = new JLabel("顧客名:" + list.order.get(i).getCustomer().getName());
					lbl1.setBounds(10, 80+60*count, 450, 16);
					contentPanel.add(lbl1);
					JLabel lbl2 = new JLabel("酒の銘柄:" + list.order.get(i).getDrink().getBrand());
					lbl2.setBounds(10, 100+60*count, 450, 16);
					contentPanel.add(lbl2);
					JLabel lbl3 = new JLabel("本数:" + list.order.get(i).getDrink().getNum());
					lbl3.setBounds(10, 120+60*count, 450, 16);
					contentPanel.add(lbl3);
					count++;
				}
			}

			JButton btnNewButton = new JButton("OK");
			btnNewButton.setBounds(16, 250, 68, 29);
			contentPanel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPanel.setVisible(false);
					dialog.setVisible(true);
				}
			});

			contentPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			contentPanel.setVisible(true);
		}
		if (id == 4) {
			final JDialog contentPanel = new JDialog();
			contentPanel.setBounds(100, 100, 450, 300);
			contentPanel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("以下の注文番号は存在しません.");
				lblNewLabel.setBounds(10, 20, 450, 16);
				contentPanel.add(lblNewLabel);
			}

			JLabel lblNewLabel_1 = new JLabel("注文番号:" + textField.getText());
			lblNewLabel_1.setBounds(10, 60, 450, 16);
			contentPanel.add(lblNewLabel_1);

			JButton btnNewButton = new JButton("OK");
			btnNewButton.setBounds(16, 100, 68, 29);
			contentPanel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPanel.setVisible(false);
					dialog.setVisible(true);
				}
			});

			contentPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			contentPanel.setVisible(true);
		}
	}

	public Ticket createTicket(int number, Customer customer, Drink drink){
		Ticket ticket = new Ticket();
		ticket.setNumber(number);
		ticket.setCustomer(customer);
		ticket.setDrink(drink);

		return ticket;
	}

	public void decreaseStock(Drink drink){
		ArrayList<Drink> list = s.getStock();
		for(int i=0; i<list.size(); i++){
			if(drink.getBrand().equals(list.get(i).getBrand())){
				Drink newDrink = new Drink();
				newDrink.setBrand(drink.getBrand());
				newDrink.setNum(list.get(i).getNum() - drink.getNum());
				list.remove(i);
				list.add(i, newDrink);
				s.setStock(list);
			}
		}
	}

	public void writeStock(){
		try{
	    	if(!file.exists()){
	    		file.createNewFile();
	    	}

	    	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    	ArrayList<Drink> list = s.getStock();

	    	for(int i=0; i<list.size(); i++){
	    		String tmp;
	    		tmp = list.get(i).getBrand() + "," + list.get(i).getNum() + "\n";
	    		bw.write(tmp);
	    		//bw.newLine();
	    	}

	    	bw.close();

	    }catch(FileNotFoundException e){
	        System.out.println("ファイルが存在しません.");
	      }catch(IOException e){
	        System.out.println("ファイルに書き込めませんでした.");
	      }
	}

	public void writeTicketList(){
		 try{
		    	if(!tlFile.exists()){
		    		tlFile.createNewFile();
		    	}

		    	BufferedWriter bw2 = new BufferedWriter(new FileWriter(tlFile));
		    	List<Ticket> tl = ticketList.ticket;

		    	for(int i=0; i<tl.size(); i++){
		    		String tmp;
		    		tmp = tl.get(i).getNumber() + "," + tl.get(i).getCustomer().getName() + "," + tl.get(i).getDrink().getBrand() + "," + tl.get(i).getDrink().getNum();
		    		bw2.write(tmp);
		    		bw2.newLine();
		    	}

		    	bw2.close();


		    }catch(FileNotFoundException e){
		        System.out.println("ファイルが存在しません.");
		      }catch(IOException e){
		        System.out.println("ファイルに書き込めませんでした.");
		      }

	}

	public void writeOrderList(){
		try{
	    	if(!orderFile.exists()){
	    		orderFile.createNewFile();
	    	}

	    	BufferedWriter bw2 = new BufferedWriter(new FileWriter(orderFile));
	    	List<Order> orderList = list.order;

	    	for(int i=0; i<orderList.size(); i++){
	    		String tmp;
	    		tmp = orderList.get(i).getNumber() + "," + orderList.get(i).getCustomer().getName() + "," + orderList.get(i).getDrink().getBrand() + "," + orderList.get(i).getDrink().getNum();
	    		bw2.write(tmp);
	    		bw2.newLine();
	    	}

	    	bw2.close();

	    }catch(FileNotFoundException e){
	        System.out.println("ファイルが存在しません.");
	      }catch(IOException e){
	        System.out.println("ファイルに書き込めませんでした.");
	      }
	}
}
