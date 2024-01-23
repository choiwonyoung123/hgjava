package com.yedam.interfaces;

public class DataExe {
	public static void main(String[] args) {
		//인터페이스 정의 - 상속과 비슷
		DAO dao = new MysqlDB();
		DAO dao1 = new OracleDB();
		// mysql - oracle
		MysqlDB mysql = new MysqlDB();
		OracleDB oracle = new OracleDB();
		int menu = 0;
		if(menu == 1) {
			mysql.insert();
			oracle.insert();
			dao.insert();
			dao1.insert();
		}
		else if(menu == 2) {
			mysql.update();
			oracle.update();
			dao.update();
			dao1.update();
		}
		else if(menu == 3) {
			mysql.delete();
			oracle.delete();
			dao.delete();
			dao1.delete();
		}
	}
}
