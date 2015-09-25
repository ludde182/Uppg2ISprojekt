package t3.isprojekt.uppg2.controller;

import java.sql.SQLException;

import t3.isprojekt.uppg2.dal.DAL;

public class testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DAL dal = new DAL();
		try {
			DAL.getConn();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
