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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private DAL dal;
	private Controller ctrl;
	private JTable table;
	private DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {ctrl.getEmployeeData() new Object {{ctrl.getEmpMetaData()});
	private JTable table_1;
	private JButton btnNewButton;
	private JTable table_2;

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
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTable table = new JTable(tableModel);
		table.setBounds(0, 65, 432, 188);
		contentPane.add(table_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 247, 432, -175);
		contentPane.add(scrollPane);

	}
}
