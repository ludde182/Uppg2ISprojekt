package t3.isprojekt.uppg2.dal;

import java.sql.*;
import java.util.*;

public class DAL {

	private static String connStr = "jdbc:sqlserver://Localhost:1433;databases=CronusDB;user=root;password=root;";

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(connStr);
	}

	// -------------------- UPPGIFT 1 A + B ------------------------------//

	public static ArrayList<String> getEmployeeData() throws SQLException {
		ArrayList<String> empList = new ArrayList();
		String getEmp = "SELECT [No_], [First Name], [Last Name], [Address], [City]" + "FROM"
				+ "[CRONUS Sverige AB$Employee];";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmp);
		ResultSetMetaData rsmd = rset.getMetaData();

		while (rset.next()) {
			empList.add(rsmd.getColumnLabel(1) + rsmd.getColumnLabel(2) + rsmd.getColumnLabel(3)
					+ rsmd.getColumnLabel(4) + rsmd.getColumnLabel(5));
			empList.add(
					rset.getString(1) + rset.getString(2) + rset.getString(3) + rset.getString(4) + rset.getString(5));
		}
		stmt.close();
		return empList;
	}

	public static ArrayList<String> getEmployeeMetaData() throws SQLException {
		String empMetaData = "SELECT TABLE_CATALOG, TABLE_NAME, COLUMN_NAME, DATA_TYPE FROM [CronusDB].[INFORMATION_SCHEMA].[COLUMNS] WHERE TABLE_NAME = [CRONUS SVERIGE AB$Rating]";

		ArrayList<String> empMetaLista = new ArrayList<String>();
		Statement stmt = null;
		stmt = getConn().createStatement();

		ResultSet rset = stmt.executeQuery(empMetaData);
		ResultSetMetaData rsmd = rset.getMetaData();

		while (rset.next()) {
			empMetaLista.add(rset.getString(1) + " " + rset.getString(2) + " " + rset.getString(3) + " "
					+ rset.getString(4) + " ");
		}

		return empMetaLista;
	}

	public static ResultSet getEmpAbsenceData() throws SQLException {
		String getEmpAbsence = "SELECT [timestamp], [Primary Key], [Search Limit], [Back End Public Key], [Back End Private Key] FROM [CRONUS Sverige AB$Employee Portal Setup]";
		PreparedStatement stmt = null;
		stmt = getConn().prepareStatement(getEmpAbsence);
		ResultSet rset = stmt.executeQuery();
		ResultSetMetaData rsmd = rset.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnLabel(i) + "--");
		}
		return rset;
	}

	public static ResultSet getEmpStatGroup() throws SQLException {
		String getEmpStat = "SELECT timestamp, Code, Description FROM [CRONUS Sverige AB$Employee Statistics Group];";
		Connection conn = null;
		PreparedStatement stmt = null;
		stmt = conn.prepareStatement(null);
		ResultSet rset = stmt.executeQuery(getEmpStat);
		ResultSetMetaData rsmd = rset.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnLabel(i) + "--");
		}
		return rset;
	}

}