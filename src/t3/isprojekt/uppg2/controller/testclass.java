package t3.isprojekt.uppg2.controller;

import java.sql.SQLException;
import java.util.Arrays;

import t3.isprojekt.uppg2.dal.DAL;

public class testclass {
	private DAL dal;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DAL dal = new DAL();
		try {
			DAL.getConn();
			System.out.println(dal.getEmpData());
			for (int i = 0; i < dal.getEmpData().length; i++) {
				System.out.println(Arrays.deepToString(dal.getEmployeeMetaData()));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
