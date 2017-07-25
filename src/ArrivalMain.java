import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ArrivalMain extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	static OrderList list = new OrderList();
	static TicketList ticketList = new TicketList();

	static ArrivalMain dialog = new ArrivalMain(0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		drink2.setBrand("super dry");
		drink2.setNum(5);
		order2.setDrink(drink2);
		order2.setCustomer(customer);
		order2.setNumber(1);
		list.order.add(order2);
		Drink drink3 = new Drink();
		Order order3 = new Order();
		drink3.setBrand("super dry");
		drink3.setNum(10);
		order3.setDrink(drink3);
		order3.setCustomer(customer);
		order3.setNumber(2);
		list.order.add(order3);
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
							Ticket ticket = new Ticket();
							ticket.setCustomer(list.order.get(i).getCustomer());
							ticket.setDrink(list.order.get(i).getDrink());
							ticket.setNumber(list.order.get(i).getNumber());
							ticketList.ticket.add(ticket);
							list.order.remove(i);
							i--;
						}
					}
					System.out.println(list.order.size());
					
					contentPanel.setVisible(false);
					createPanel(3);
				}
			});
			JButton btn2 = new JButton("cancel");
			btn2.setBounds(80, 250, 68, 29);
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
			btnNewButton.setBounds(16, 100, 50, 29);
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

}
