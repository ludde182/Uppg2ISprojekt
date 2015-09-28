package t3.isprojekt.uppg2.dal;

import java.sql.*;
import java.util.*;

public class DAL {

	private static String connStr = "jdbc:sqlserver://Localhost:1433;databases=CronusDB;user=root;password=root;";

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(connStr);
	}

	// ------ Methods for Employee & related tables ------\\

	// Returns Employee
	public ResultSet getEmployee() throws SQLException {
		String getEmployee = "SELECT [No_], [First Name], [Last Name], [Address], [City] from  [CRONUS Sverige AB$Employee]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmployee);
		return rset;
	}

	// Returns Employee Absence
	public ResultSet getEmployeeAbsence() throws SQLException {
		String getEmpAbsence = "SELECT [timestamp], [Primary Key], [Search Limit], [Back End Public Key], [Back End Private Key] FROM [CRONUS Sverige AB$Employee Portal Setup]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpAbsence);
		return rset;
	}

	// Returns Employee Portal Setup
	public ResultSet getEmployeePortalSetup() throws SQLException {
		String getEmpPortalSetup = "SELECT timestamp, [Config Tool Pane Caption], [Back End Private Key], [Back End Public Key] [Config TP Initial Req_ Caption] FROM [CRONUS Sverige AB$Employee Portal Setup]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpPortalSetup);
		return rset;
	}

	// Returns Employee Qualification
	public ResultSet getEmployeeQualification() throws SQLException {
		String getEmpQual = "SELECT [Qualification Code], [Employee No_], [From Date], [To Date], [Description] from [CRONUS Sverige AB$Employee Qualification]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpQual);
		return rset;
	}

	// Returns Employee Relative
	public ResultSet getEmployeeRelative() throws SQLException {
		String getEmpRel = "SELECT [Relative Code], [First Name], [Last Name], [Birth Date], [Phone No_] from [CRONUS Sverige AB$Employee Relative]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpRel);
		return rset;

	}

	// Returns Employee Statistics Group
	public ResultSet getEmployeeStatisticsGroup() throws SQLException {
		String getEmpStatGroup = "SELECT timestamp, Code, Description from [CRONUS Sverige AB$Employee Statistics Group]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpStatGroup);
		return rset;

	}

	// ------ Methods for MetaData ------ \\

	// Returns All Keys
	public ResultSet getPrimaryKeys() throws SQLException {
		String primaryKeys = "SELECT name, type_desc FROM sys.key_constraints";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(primaryKeys);
		return rset;
	}

	// Returns All Indexes
	public ResultSet getAllIndexes() throws SQLException {
		String indexes = "SELECT name, type_desc FROM sys.key_constraints";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(indexes);
		return rset;
	}

	// Returns All Indexes
	public ResultSet getAllTableConstraints() throws SQLException {
		String constraints = "SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(constraints);
		return rset;
	}

	// Returns All Tables
	public ResultSet getAllTables() throws SQLException {
		String allTables = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
		/*
		 * Annan lösning: "SELECT * FROM sys.tables"
		 */
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(allTables);
		return rset;
	}

	// Returns All Columns in Employee
	public ResultSet getAllColumns() throws SQLException {
		String allColumns = "SELECT * FROM [INFORMATION_SCHEMA].[COLUMNS] WHERE TABLE_NAME = [CRONUS Sverige AB$Employee]";
		/*
		 * Annan lösning: "sp_columns [CRONUS Sverige AB$Employee]"
		 */
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(allColumns);
		return rset;
	}

	// Returns Result with Most Rows
	public ResultSet getMostRows() throws SQLException {
		String getRows = "SELECT * FROM [INFORMATION_SCHEMA].COLUMNS WHERE [TABLE_NAME] = [CRONUS Sverige AB$Employee]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getRows);
		return rset;
	}

	public Vector<Vector<String>> fillTable(ResultSet r) throws SQLException {
		ResultSetMetaData metaData = r.getMetaData();
		int columnCount = metaData.getColumnCount();

		Vector<Vector<String>> fillTable = new Vector<Vector<String>>();
		while (r.next()) {
			Vector<String> temp = new Vector<String>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				temp.add(r.getString(columnIndex));
			}
			fillTable.add(temp);
		}
		return fillTable;
	}

	public Vector<String> colNames(ResultSet r) throws SQLException {
		ResultSetMetaData metaData = r.getMetaData();

		Vector<String> colNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();

		for (int column = 1; column <= columnCount; column++) {
			colNames.add(metaData.getColumnName(column));
		}
		return colNames;
	}

}
