package calculator.model.database;

import java.sql.SQLException;
import java.util.ArrayList;

public class MYSQLStrategyImpl implements DataBaseStrategy {
	
	// Этот класс создаст взаимодействие калькулятора с БД в MySQL
	// сначала скачайте JDBC-mySQL библиотеку с сайта и подключите библиотеку с помощью IDE
	// или можно подкючить разными способами (maven, gradle)
	// реализуйте каждый метод, которые имплементированы
	// Внимательно усмотрите, что ip-адрес или доменное имя совпадает с теми где поднят сервер mySQL    
	// А порт совпадает? :)
	//
	// Не забудьте!
	// заменить в CalculatorModel.java
	//    db.setDBMS(new SqliteStrategyImpl()); - это означает, что калькулятор работает с СУБД SQLite
	// на db.setDBMS(new MySQLStrategyImpl());  - А вот так установит работу калькулятора с MySQL
	
	
	@Override
	public void connect() throws SQLException {
		
	}

	@Override
	public void close() throws SQLException {
		
	}

	@Override
	public void createDB() throws SQLException {
		
	}

	@Override
	public void write(String s) throws SQLException {
		
	}

	@Override
	public ArrayList<String> read() throws SQLException {
		return null;
	}

}
