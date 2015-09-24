package t3.isprojekt.uppg2.controller;

import java.sql.*;

import t3.isprojekt.uppg2.dal.DAL;

public class Controller {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		DAL.getConn();
		System.out.println("Conn lyckades!");
		System.out.println(DAL.findEmployeeData());

	}

}