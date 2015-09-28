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

	public ResultSet getEmployee() throws SQLException {
		return dal.getEmployee();
	}

	public ResultSet getEmployeeAbsence() throws SQLException {
		return dal.getEmployeeAbsence();
	}

	public ResultSet getEmployeePortalSetup() throws SQLException {
		return dal.getEmployeePortalSetup();
	}

	public ResultSet getEmployeeQualification() throws SQLException {
		return dal.getEmployeeQualification();
	}

	public ResultSet getEmployeeRelative() throws SQLException {
		return dal.getEmployeeRelative();
	}

	public ResultSet getEmployeeStatisticsGroup() throws SQLException {
		return dal.getEmployeeStatisticsGroup();
	}

	public ResultSet getPrimaryKeys() throws SQLException {
		return dal.getPrimaryKeys();
	}

	public ResultSet getAllIndexes() throws SQLException {
		return dal.getAllIndexes();
	}

	public ResultSet getAllTableConstraints() throws SQLException {
		return dal.getAllTableConstraints();
	}

	public ResultSet getAllTables() throws SQLException {
		return dal.getAllTables();
	}

	public ResultSet getAllColumns() throws SQLException {
		return dal.getAllColumns();
	}

	public ResultSet getMostRows() throws SQLException {
		return dal.getMostRows();
	}

}
