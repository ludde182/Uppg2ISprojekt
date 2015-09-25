import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import t3.isprojekt.uppg2.controller.Controller;
import t3.isprojekt.uppg2.dal.DAL;

public class View extends JFrame {

	private JPanel contentPane;
	private DAL dal;
	private Controller ctrl;
	private JTable table;
	private DefaultTableModel tableModel;
	private JTable table_1;
	private String[][] headerModel = DAL.getEmployeeMetaData();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public View() throws SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		TableModel model = new DefaultTableModel();

		model = new DefaultTableModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 420, 155);

		contentPane.add(scrollPane);

		table_1 = new JTable(model);
		scrollPane.setViewportView(table_1);
	}

}
