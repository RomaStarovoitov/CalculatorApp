package calculator.model.database;

import java.sql.SQLException;
import java.util.ArrayList;

public class DataBase {
	DataBaseStrategy db;

	public void setDBMS(DataBaseStrategy db) {
		this.db = db;
		initDB();
	}

	public void initDB() {
		try {
			db.connect();
			db.createDB();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void writeBD(String record) {
		try {
			db.connect();
			db.write(record);
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> readDB() {
		ArrayList<String> resReadDB = new ArrayList<String>();
		try {
			db.connect();
			resReadDB = db.read();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
			resReadDB.add("Ошибка получения");
			return resReadDB;
		}

		if(resReadDB.size()==0)resReadDB.add("Вычислений не было");
		return resReadDB;
	}

}
