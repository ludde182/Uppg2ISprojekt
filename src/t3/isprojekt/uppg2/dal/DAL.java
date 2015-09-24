package t3.isprojekt.uppg2.dal;

import java.sql.*;
import java.util.*;

public class DAL {

	private static String connStr = "jdbc:sqlserver://Localhost:1433;databases=CronusDB;user=root;password=root;";

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(connStr);
	}

	// ------ Methods for Employee & related tables ------\\

	public ResultSet getEmpData() throws SQLException {
		String getEmp = "SELECT [No_], [First Name], [Last Name], [Address], [City] FROM [CRONUS Sverige AB$Employee];";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmp);
		return rset;
	}

	/*
	 * public static ResultSet getEmployeeMetaData() throws SQLException {
	 * String empMetaData =
	 * "SELECT TABLE_CATALOG, TABLE_NAME, COLUMN_NAME, DATA_TYPE FROM [CronusDB].[INFORMATION_SCHEMA].[COLUMNS] WHERE TABLE_NAME = [CRONUS SVERIGE AB$Rating]"
	 * ; Statement stmt = null; stmt = getConn().createStatement(); ResultSet
	 * rset = stmt.executeQuery(empMetaData); return rset; }
	 */

	public ResultSet getEmpAbsenceData() throws SQLException {
		String getEmpAbsence = "SELECT [timestamp], [Primary Key], [Search Limit], [Back End Public Key], [Back End Private Key] FROM [CRONUS Sverige AB$Employee Portal Setup]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpAbsence);
		return rset;
	}

	public ResultSet getEmpPortalSetupData() throws SQLException {
		String getEmpPortalSetup = "SELECT [Entry No_], [Employee No_], [From Date], [To Date], [Description] from [CRONUS Sverige AB$Employee Portal Setup]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpPortalSetup);
		return rset;
	}

	public ResultSet getEmpQualification() throws SQLException {
		String getEmpQual = "SELECT [Employee No_], [Qualification Code], [Cost], [Course Grade], [Employee Status] from [CRONUS Sverige AB$Employee Qualification]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpQual);
		return rset;
	}

	public ResultSet getEmpRelative() throws SQLException {
		String getEmpRel = "SELECT [Relative Code], [First Name], [Last Name], [Birth Date], [Phone No_] from [CRONUS Sverige AB$Employee Relative]";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpRel);
		return rset;

	}

	public ResultSet getEmpStatGroup() throws SQLException {
		String getEmpStat = "SELECT timestamp, Code, Description FROM [CRONUS Sverige AB$Employee Statistics Group];";
		Statement stmt = null;
		stmt = getConn().createStatement();
		ResultSet rset = stmt.executeQuery(getEmpStat);
		return rset;
	}

}