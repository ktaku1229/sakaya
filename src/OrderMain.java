import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
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

import javax.swing.Action;

public class OrderMain extends JDialog {
	private JTextField textField;
	private JTextField textField2;

	static OrderList list = new OrderList();

	private static String name;
	private static ArrayList<String> brand = new ArrayList<String>();
	private static ArrayList<Integer> num = new ArrayList<Integer>();
	private static Stock s = new Stock();

	static OrderMain dialog = new OrderMain(0);
	static OrderMain dialog1 = new OrderMain(1);
	static OrderMain dialog2 = new OrderMain(2);
	static OrderMain error = new OrderMain(3);
	static OrderMain dialog3 = new OrderMain(4);
	static OrderMain dialog7 = new OrderMain(7);

	static File orderFile = new File("src/order.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		try{
		      BufferedReader br = new BufferedReader( new FileReader("src/zaiko.txt") );
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
	public OrderMain(int id) {
		if (id == 0) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 450, 42);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				getContentPane().add(panel);
				{
					JLabel lblNewLabel = new JLabel("<html>酒屋在庫管理システムへようこそ.<br>お名前を入力してください.</html>");

					panel.add(lblNewLabel);
				}
			}

			JLabel lblNewLabel_1 = new JLabel("[お名前]:");
			lblNewLabel_1.setBounds(10, 60, 61, 16);
			getContentPane().add(lblNewLabel_1);

			textField = new JTextField();
			textField.setBounds(62, 55, 130, 26);
			getContentPane().add(textField);
			textField.setColumns(10);

			JButton btnNewButton = new JButton("次へ");
			btnNewButton.setBounds(0, 93, 68, 26);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.getText().equals("")) {
						dialog.setVisible(false);
						dialog1.setVisible(true);
					} else {
						name = textField.getText();
						dialog.setVisible(false);
						dialog2.setVisible(true);
					}
				}
			});
		}
		if (id == 1) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 450, 42);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				getContentPane().add(panel);
				{
					JLabel lblNewLabel = new JLabel("お名前を入力してください");
					panel.add(lblNewLabel);
				}
			}
			JButton btnNewButton = new JButton("戻る");
			btnNewButton.setBounds(0, 93, 68, 26);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dialog1.setVisible(false);
					dialog.setVisible(true);
				}
			});
		}
		if (id == 2) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 450, 42);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				getContentPane().add(panel);
				{
					JLabel lblNewLabel = new JLabel("注文したい酒の銘柄とその本数を入力してください.");
					panel.add(lblNewLabel);
				}
			}

			JLabel lblNewLabel_1 = new JLabel("[酒の銘柄]:");
			lblNewLabel_1.setBounds(10, 60, 100, 16);
			getContentPane().add(lblNewLabel_1);

			textField = new JTextField();
			textField.setBounds(80, 55, 130, 26);
			getContentPane().add(textField);
			textField.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("[本数]:");
			lblNewLabel_2.setBounds(10, 100, 61, 16);
			getContentPane().add(lblNewLabel_2);

			textField2 = new JTextField();
			textField2.setBounds(80, 100, 130, 26);
			getContentPane().add(textField2);
			textField2.setColumns(10);

			JButton btnNewButton = new JButton("次へ");
			btnNewButton.setBounds(0, 150, 68, 26);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textField.getText().equals("")) {
						dialog2.setVisible(false);
						error.setVisible(true);
					} else {
						try {
							num.add(Integer.parseInt(textField2.getText()));
							brand.add(textField.getText());
							dialog2.setVisible(false);
							dialog3.setVisible(true);
						} catch (Exception exc) {
							dialog2.setVisible(false);
							error.setVisible(true);
						}
					}
				}
			});
		}
		if (id == 3) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 450, 42);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				getContentPane().add(panel);
				{
					JLabel lblNewLabel = new JLabel("正しく入力してください");
					panel.add(lblNewLabel);
				}
			}
			JButton btnNewButton = new JButton("戻る");
			btnNewButton.setBounds(0, 93, 68, 26);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					error.setVisible(false);
					dialog2.setVisible(true);
				}
			});
		}
		if (id == 4) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 450, 42);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				getContentPane().add(panel);
				{
					JLabel lblNewLabel = new JLabel("注文を続けますか？注文を確定する場合は[次へ]を選択してください.");

					panel.add(lblNewLabel);
				}
			}

			JButton btnNewButton = new JButton("注文を続ける");
			btnNewButton.setBounds(16, 45, 117, 29);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dialog3.setVisible(false);
					dialog2.setVisible(true);
				}
			});
			JButton btn2 = new JButton("次へ");
			btn2.setBounds(145, 45, 68, 29);
			getContentPane().add(btn2);
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dialog3.setVisible(false);
					createPanel(5);
				}
			});
		}
		if (id == 7) {
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			{
				JPanel panel = new JPanel();
				panel.setBounds(0, 0, 450, 42);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT));
				getContentPane().add(panel);
				{
					JLabel lblNewLabel = new JLabel("<html>在庫がありませんでした.<br>申し訳ありませんが,時間をおいて再度注文をしてください.");
					panel.add(lblNewLabel);
				}
			}
			JButton btnNewButton = new JButton("トップへ戻る");
			btnNewButton.setBounds(0, 93, 150, 26);
			getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					brand.clear();
					num.clear();
					dialog7.setVisible(false);
					dialog.setVisible(true);
				}
			});
		}
	}

	public void createPanel(int id) {
		if (id == 5) {
			final JDialog contentPanel = new JDialog();
			contentPanel.setBounds(100, 100, 450, 300);
			contentPanel.setLayout(null);
			{
				JLabel label = new JLabel("注文は以上で以上でよろしいですか？");
				label.setBounds(6, 6, 438, 16);
				contentPanel.add(label);
			}
			{
				JLabel label = new JLabel("[お名前]:" + name);
				label.setBounds(6, 33, 438, 16);
				contentPanel.add(label);
			}
			{
				for(int i=0; i<brand.size(); i++){
					String a = brand.get(i);
					int b = num.get(i);
				JLabel lblNewLabel = new JLabel(a +  "-" + b);
				lblNewLabel.setBounds(6, 61+i*20, 438, 16);
				contentPanel.add(lblNewLabel);
				}
			}
			JButton btnNewButton = new JButton("はい");
			btnNewButton.setBounds(6, 200, 80, 29);
			contentPanel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int flag=0;
					for(int i=0; i<brand.size(); i++){
						flag=0;
						for(int j=0; j<s.getStock().size(); j++){
							if(s.getStock().get(j).getBrand().equals(brand.get(i))){
								if(s.getStock().get(j).getNum()>=num.get(i)){
									flag = 1;
								}
							}
						}
						if(flag == 0){
							break;
						}
					}
					if(flag==0){
						contentPanel.setVisible(false);
						dialog7.setVisible(true);
					}else{
						int number=0;
						if(list.order.size()==0){
							number=1;
						}else{
							number=(list.order.get(list.order.size()-1).getNumber())+1;
						}
						for(int i=0; i<brand.size(); i++){
							Drink drink = new Drink();
							Order order = new Order();
							Customer customer = new Customer();
							customer.setName(name);
							drink.setBrand(brand.get(i));
							drink.setNum(num.get(i));
							order.setDrink(drink);
							order.setCustomer(customer);
							order.setNumber(number);
							list.order.add(order);
						}
						writeOrderList();
						contentPanel.setVisible(false);
						createPanel(6);
					}
				}
			});
			JButton btn2 = new JButton("注文をし直す");
			btn2.setBounds(100, 200, 117, 29);
			contentPanel.add(btn2);
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPanel.setVisible(false);
					dialog2.setVisible(true);
				}
			});
			contentPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			contentPanel.setVisible(true);
		}
		if (id == 6) {
			final JDialog contentPanel = new JDialog();
			contentPanel.setBounds(100, 100, 450, 300);
			contentPanel.setLayout(null);
			{
				JLabel label = new JLabel("ご注文ありがとうございました.");
				label.setBounds(6, 6, 438, 16);
				contentPanel.add(label);
			}
			{
				JLabel naiyou = new JLabel("[ご注文内容]:");
				naiyou.setBounds(6, 33, 438, 16);
				contentPanel.add(naiyou);
			}
			{
				JLabel label = new JLabel("[お名前]:" + name);
				label.setBounds(6, 63, 438, 16);
				contentPanel.add(label);
			}
			{
				for(int i=0; i<brand.size(); i++){
					String a = brand.get(i);
					int b = num.get(i);
				JLabel lblNewLabel = new JLabel(a +  "-" + b);

				lblNewLabel.setBounds(6, 80+i*20, 438, 16);
				contentPanel.add(lblNewLabel);
				}
			}
			JButton btnNewButton = new JButton("トップへ戻る");
			btnNewButton.setBounds(6, 200, 117, 29);
			contentPanel.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					brand.clear();
					num.clear();
					contentPanel.setVisible(false);
					dialog.setVisible(true);
				}
			});
			contentPanel.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			contentPanel.setVisible(true);
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
