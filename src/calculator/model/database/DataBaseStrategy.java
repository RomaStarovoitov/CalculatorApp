package calculator.model.database;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DataBaseStrategy {

	public abstract void  connect() throws SQLException;
	public abstract void close() throws SQLException;
	public abstract void createDB() throws SQLException;
	public abstract void write(String s) throws SQLException;
	public abstract ArrayList<String> read() throws SQLException;
	
}
