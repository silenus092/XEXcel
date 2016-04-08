import java.util.List;

public interface IDataFileReader {
	public int rowNum(); // current row number!
	 public List<String[]> readRows(int batchSize) throws Exception;
}
