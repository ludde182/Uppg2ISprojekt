package t3.isprojekt.uppg2.controller;

import java.sql.*;

import t3.isprojekt.uppg2.dal.DAL;

public class Controller {
	private DAL dal;

	public Controller() throws SQLException {
		dal = new DAL();
	}

	public ResultSet getEmpData() throws SQLException {
		return dal.getEmpData();
	}

	public ResultSet getEmpAbscenceData() throws SQLException {
		return dal.getEmpAbsenceData();
	}

	public ResultSet getEmpPortalSetupData() throws SQLException {
		return dal.getEmpPortalSetupData();
	}

	public ResultSet getEmpQualification() throws SQLException {
		return dal.getEmpQualification();
	}

	public ResultSet getEmpRelative() throws SQLException {
		return dal.getEmpRelative();
	}

	public ResultSet getEmpStatGroup() throws SQLException {
		return dal.getEmpStatGroup();
	}
}