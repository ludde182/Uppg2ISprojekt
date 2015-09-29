package t3.isprojekt.uppg2.GUI;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import t3.isprojekt.uppg2.controller.Controller;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller ctrl = new Controller();
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private String[] labels = { "Employee Data", "Employee Absence Data", "Employee Portal Setup Data",
			"Employee Qualification Data", "Employee Relative Data", "Employee Stat Group Data",
			"Show all primary keys", "Show all indexes", "Show all table constraints", "Show all tables",
			"Show all columns in Employee", "Show table with most rows" };

	private String[] documents = new String[] { "All Customers", "All Employees" };
	private String[] docType = new String[] { "Microsoft Word", "Microsoft Excel", "Microsoft Access" };

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
		setBounds(100, 100, 500, 646);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 494, 606);
		contentPane.add(tabbedPane);

		JPanel panelUppg2 = new JPanel();
		tabbedPane.addTab("Uppgift 2", null, panelUppg2, null);
		panelUppg2.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 83, 459, 473);
		panelUppg2.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JLabel lblSelectYourData = new JLabel("Select data");
		lblSelectYourData.setBounds(15, 16, 62, 15);
		panelUppg2.add(lblSelectYourData);
		lblSelectYourData.setFont(new Font("Tahoma", Font.PLAIN, 12));

		// ------ Create the "Get Data" button & add ActionListener ------//
		JButton btnShowData = new JButton("Show Data");
		btnShowData.setBounds(313, 39, 161, 29);
		panelUppg2.add(btnShowData);

		// ------ Create the combo box & add String[] ------//
		JComboBox<String> comboBox = new JComboBox<String>(labels);
		comboBox.setBounds(15, 40, 283, 26);
		panelUppg2.add(comboBox);

		JPanel panelUppg3 = new JPanel();
		tabbedPane.addTab("Uppgift 3", null, panelUppg3, null);
		panelUppg3.setLayout(null);

		// --- Create combo box for format type & documents & add String[] //
		JComboBox<String> formatBox = new JComboBox<String>(docType);
		formatBox.setBounds(15, 131, 172, 26);
		panelUppg3.add(formatBox);

		JComboBox<String> documentBox = new JComboBox<String>(documents);
		documentBox.setBounds(15, 47, 172, 26);
		panelUppg3.add(documentBox);

		JLabel lblSelectDocument = new JLabel("Select Document");
		lblSelectDocument.setBounds(15, 16, 138, 15);
		lblSelectDocument.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelUppg3.add(lblSelectDocument);

		JButton btnOpenDoc = new JButton("Open Document");
		btnOpenDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) documentBox.getSelectedItem();
				String selectedFormat = (String) formatBox.getSelectedItem();

				if (selectedItem.equals(documents[0]) && selectedFormat.equals(docType[0])) {
					ctrl.openDocument("C:\\Uppgift3\\Uppgift2.1AllaKunder.docx");
				}

				if (selectedItem.equals(documents[0]) && selectedFormat.equals(docType[1])) {
					ctrl.openDocument("C:\\Uppgift3\\uppg2.1AllaKunder.xlsx");
				}

				if (selectedItem.equals(documents[0]) && selectedFormat.equals(docType[2])) {
					ctrl.openDocument("C:\\Uppgift3\\Access\\Uac2.1AllaKunder.accdb");
				}

				if (selectedItem.equals(documents[1]) && selectedFormat.equals(docType[0])) {
					ctrl.openDocument("C:\\Uppgift3\\Uppgift2.2AllaAnstellda.docx");
				}

				if (selectedItem.equals(documents[1]) && selectedFormat.equals(docType[1])) {
					ctrl.openDocument("C:\\Uppgift3\\uppg2.2AllaAnstellda.xlsx");
				}

				if (selectedItem.equals(documents[1]) && selectedFormat.equals(docType[2])) {
					ctrl.openDocument("C:\\Uppgift3\\Access\\Uac2.2AllaAnstellda.accdb");
				}
			}
		});
		btnOpenDoc.setBounds(15, 194, 172, 29);
		panelUppg3.add(btnOpenDoc);

		JLabel lblSelectDocumentType = new JLabel("Select Document Type");
		lblSelectDocumentType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectDocumentType.setBounds(15, 100, 138, 15);
		panelUppg3.add(lblSelectDocumentType);

		btnShowData.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				long starttime = System.nanoTime();
				String selectedItem = (String) comboBox.getSelectedItem();
				if (selectedItem.equals(labels[0]))
					try {
						CreateTable(ctrl.getEmployee());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (selectedItem.equals(labels[1]))
					try {
						CreateTable(ctrl.getEmployeeAbsence());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[2]))
					try {
						CreateTable(ctrl.getEmployeePortalSetup());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[3]))
					try {
						CreateTable(ctrl.getEmployeeQualification());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[4]))
					try {
						CreateTable(ctrl.getEmployeeRelative());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[5]))
					try {
						CreateTable(ctrl.getEmployeeStatisticsGroup());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[6]))
					try {
						CreateTable(ctrl.getPrimaryKeys());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[7]))
					try {
						CreateTable(ctrl.getAllIndexes());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[8]))
					try {
						CreateTable(ctrl.getAllTableConstraints());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[9]))
					try {
						CreateTable(ctrl.getAllTables());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[10]))
					try {
						CreateTable(ctrl.getAllColumns());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				if (selectedItem.equals(labels[11]))
					try {
						CreateTable(ctrl.getMostRows());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				// --- Printing response times in console --- //
				long endtime = System.nanoTime();
				long duration = (endtime - starttime / 1000000);
				// DIVISIONEN gör resultatet till millisekunder
				System.out.println(duration);
			}

		});

	}

	// ------ Method for populating JTable ------//
	private void CreateTable(ResultSet r) throws SQLException {
		dtm = new DefaultTableModel(ctrl.tableData(r), ctrl.colNames(r));
		table.removeAll();
		table.setModel(dtm);
	}
}
