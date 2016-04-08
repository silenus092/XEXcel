import java.util.ArrayList;
import java.util.List;

public class People {
	private String ID;
	public String getID() {
		return ID;
	}

	public People(String iD, String status, List<String[]> temp_list) {
		super();
		ID = iD;
		this.setStatus(status);
		this.temp_list = temp_list;
	}

	public void setID(String iD) {
		ID = iD;
	}
	private String status;
	
	public People() {
		super();

	}

	List<String[]> temp_list;
	public List<String[]> getTemp_list() {
		return temp_list;
	}

	public void setTemp_list(List<String[]> temp_list) {
		this.temp_list = temp_list;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
