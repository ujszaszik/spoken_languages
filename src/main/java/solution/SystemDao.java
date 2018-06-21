package solution;

public interface SystemDao<T> {
	
	void uploadData();
	
	T obtainField();
	
	Number getRowCount();

}
