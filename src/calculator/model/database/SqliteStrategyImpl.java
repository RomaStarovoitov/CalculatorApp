package calculator.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.JDBC;

public class SqliteStrategyImpl implements DataBaseStrategy {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	private String nameDB = "./DBCalculator.db";

	@Override
	public void connect() throws SQLException {
		DriverManager.registerDriver(new JDBC());
		connection = DriverManager.getConnection("jdbc:sqlite:" + nameDB);
		statement = connection.createStatement();
	}

	@Override
	public void close() throws SQLException {
		connection.close();
		if (statement != null)
			statement.close();
		if (resultSet != null)
			resultSet.close();
	}

	@Override
	public void createDB() throws SQLException {
		statement.execute("CREATE TABLE " + "if not exists "
				+ "'History' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'hystory' text);");

	}

	@Override
	public void write(String record) throws SQLException {
		statement.execute("INSERT INTO 'History' ('hystory') VALUES ('" + record + "');");
	}

	@Override
	public ArrayList<String> read() throws SQLException {

		resultSet = statement.executeQuery(
				"SELECT hystory FROM (SELECT * FROM History ORDER BY id DESC LIMIT 10) ORDER BY id");
		ArrayList<String> readList = new ArrayList<String>();

		while (resultSet.next()) {
			readList.add(resultSet.getString("hystory"));
		}
		return readList;
	}

}
