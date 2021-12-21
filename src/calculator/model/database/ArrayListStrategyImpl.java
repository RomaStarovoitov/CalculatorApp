package calculator.model.database;

import java.util.ArrayList;

// этот класс был создан для того чтобы протестировать добавление и 
// просмотр последних 10 вычислений
// Поэтому, он служит для имитации записи и чтении данных
// Чтобы не испортить данные в реальных БД


public class ArrayListStrategyImpl implements DataBaseStrategy{

	private ArrayList<String> db;
	@Override
	public void connect() {
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public void createDB() {
		if(db==null) {
			db=new ArrayList<String>();
		}
	}

	@Override
	public void write(String record) {
		if(db.size()==10) {db.remove(0);}
		db.add(record);
	}

	@Override
	public ArrayList<String> read() {
		if(db.size()==0) return new ArrayList<String>();
		return db;
	}

}
