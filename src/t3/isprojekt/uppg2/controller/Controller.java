package t3.isprojekt.uppg2.controller;

import java.sql.*;

import t3.isprojekt.uppg2.dal.DAL;

public class Controller {
	private DAL dal;

	public Controller() throws SQLException {
		dal = new DAL();
	}

	//////////////////////////////////////// UPPgift2 A, META
	//////////////////////////////////////// controller//////////

	public String[][] getEmployeeData() throws SQLException {
		return dal.getEmpData();
	}

	public String[][] getEmpMetaData() throws SQLException {
		return dal.getEmployeeMetaData();
	}

	public String[][] getEmAbsMetaData() throws SQLException {
		return dal.getEmployeeMetaData();
	}

	public String[][] getEmpPSMetaData() throws SQLException {
		return dal.getEmpAbsenceData();
	}

	public String[][] getEmpQualData() throws SQLException {
		return dal.getEmpAbsenceData();
	}

	public String[][] getEmpRelMetaData() throws SQLException {
		return dal.getEmployeeRelMetaData();
	}

	public String[][] getEmpSGMetaData() throws SQLException {
		return dal.getEmpAbsenceData();
	}

	/////////////////////////// uppgift 2 B controller ////////////////////
	public String[][] getPrimaryKeys() throws SQLException {
		return dal.getPrimaryKeys();
	}

	public String[][] getIndexes() throws SQLException {
		return dal.getIndexes();
	}

	public String[][] getTableConstraints() throws SQLException {
		return dal.getTableConstraints();
	}

	public String[][] getAllColumnsM1() throws SQLException {
		return dal.getAllColumnsM1();
	}

	public String[][] getAllColumnsM2() throws SQLException {
		return dal.getAllColumnsM2();
	}

	public String[][] getColumnsEmpM1() throws SQLException {
		return dal.getColumnsEmpM1();
	}

	public String[][] getColumnsM2() throws SQLException {
		return dal.getColumnsEmpM2();
	}

public ResultSet getTableMostRows() throws SQLException {
return dal.getTableMostRows();
}
