import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class test extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			test dialog = new test();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public test() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("注文は以上で以上でよろしいですか？");
			label.setBounds(6, 6, 438, 16);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("[お名前]:");
			label.setBounds(6, 33, 438, 16);
			contentPanel.add(label);
		}
		{
			JLabel lblNewLabel = new JLabel("酒の銘柄 - 本数");
			lblNewLabel.setBounds(6, 61, 438, 16);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(6, 89, 117, 29);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("New button");
			btnNewButton_1.setBounds(140, 89, 117, 29);
			contentPanel.add(btnNewButton_1);
		}
	}

}
