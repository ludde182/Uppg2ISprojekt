package t3.isprojekt.uppg2.GUI;

import java.awt.BorderLayout;
import java.sql.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import t3.isprojekt.uppg2.dal.DAL;

import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import java.awt.Color;
import javax.swing.JTable;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con = null;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 623);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 529, 567);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);

		JButton btnNewButton = new JButton("Magic Button");
		btnNewButton.setBounds(201, 5, 123, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel.setLayout(null);

				table = new JTable();
				table.setBounds(196, 19, 0, 0);
				panel.add(table);
				panel.add(btnNewButton);

				JTextArea textArea = new JTextArea();
				textArea.setBounds(15, 220, 494, 313);
				panel.add(textArea);
			}
		});
	}
}
