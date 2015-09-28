import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javafx.scene.control.ComboBox;
import t3.isprojekt.uppg2.controller.Controller;
import t3.isprojekt.uppg2.dal.DAL;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;

public class View extends JFrame {
	// private JFrame frame;
	private JPanel contentPane;
	private Controller ctrl = new Controller();
	private DAL dal = new DAL();
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private JComboBox comboBox;
	private String[] labels = { "Employee Data", "Employee Absence Data", "Employee Portal Setup Data",
			"Employee Qualification Data", "Employee Relative Data", "Employee Stat Group Data",
			"Show all primary keys", "Show all indexes", "Show all table constraints", "Show all tables",
			"Show all columns in Employee", "Show table with most rows" };

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
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>(labels);
		comboBox.setBounds(12, 13, 317, 23);
		contentPane.add(comboBox);

		JButton btnShowData = new JButton("Show Data");
		btnShowData.setBounds(341, 13, 129, 23);
		btnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String selectedItem = (String) comboBox.getSelectedItem();
				if (selectedItem.equals("Employee Data"))
					try {
						CreateTable(ctrl.getEmployee());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (selectedItem.equals("Employee Absence Data"))
					try {
						CreateTable(ctrl.getEmployeeAbsence());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Employee Portal Setup Data"))
					try {
						CreateTable(ctrl.getEmployeePortalSetup());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Employee Qualification Data"))
					try {
						CreateTable(ctrl.getEmployeeQualification());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Employee Relative Data"))
					try {
						CreateTable(ctrl.getEmployeeRelative());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Employee Stat Group Data"))
					try {
						CreateTable(ctrl.getEmployeeStatisticsGroup());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Show all primary keys"))
					try {
						CreateTable(ctrl.getPrimaryKeys());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Show all indexes"))
					try {
						CreateTable(ctrl.getAllIndexes());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Show all table constraints"))
					try {
						CreateTable(ctrl.getAllTableConstraints());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Show all tables"))
					try {
						CreateTable(ctrl.getAllTables());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Show all columns in Employee"))
					try {
						CreateTable(ctrl.getAllColumns());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals("Show table with most rows"))
					try {
						CreateTable(ctrl.getMostRows());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

		});

		contentPane.add(btnShowData);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 49, 458, 466);
		contentPane.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

	}

	private void CreateTable(ResultSet r) throws SQLException {
		dtm = new DefaultTableModel(dal.fillTable(r), dal.colNames(r));
		table.removeAll();
		table.setModel(dtm);
	}
}
