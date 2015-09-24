package t3.isprojekt.uppg2.dal;

import java.sql.*;

public class DAL {

	private static String connStr = "jdbc:sqlserver://Localhost;Databases=CronusDB;user=root;password=root;";

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(connStr);
	}
	
	public static ResultSet showCompany() throws SQLException {
		Statement stmt = null; 
		stmt = getConn().createStatement();
		String sqlStr = "SELECT * FROM dbo.Company";
		ResultSet rset = stmt.executeQuery(sqlStr);
		return rset;
	}

	public static ResultSet findEmployeeData() throws SQLException {
		Statement stmt; 
		stmt = getConn().createStatement();
		String sqlStr = "select [No_], [First Name], [Last Name], [Initials], [Job Title] from [CRONUS Sverige AB$Employee];";
		ResultSet rset = stmt.executeQuery(sqlStr);
		return rset;
	}
	
	public static ResultSet getEmployeedata() throws SQLException {
		String getEmployee = "SELECT [No_], [First Name], [Last Name], [Adress], [City]" + "FROM"
				+ "[CRONUS Sverige AB$Employee];";
		PreparedStatement stmt = null;
		stmt = getConn().prepareStatement(getEmployee);
		ResultSet rset = stmt.executeQuery();
		return rset;
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