import com.aspose.cells.CellArea;
import com.aspose.cells.Cells;
import com.aspose.cells.DataSorter;
import com.aspose.cells.SortOrder;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class SortXExcel {
	private String FileName ;
	private boolean IsFinish;
	public SortXExcel(String dir ,int StartRow ,int StartColumn ,int EndRow ,int EndColumn) {
		super();
		FileName = dir;
		IsFinish = false;
		sort(dir , StartRow , StartColumn ,EndRow ,EndColumn);
	}
	
	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public boolean isIsFinish() {
		return IsFinish;
	}

	public void setIsFinish(boolean isFinish) {
		IsFinish = isFinish;
	}

	public void sort(String filename ,int StartRow ,int StartColumn ,int EndRow ,int EndColumn){
		String dataPath = filename;

		// Instantiating a Workbook object
		Workbook workbook;
		try {
			workbook = new Workbook(dataPath);

			// Accessing the first worksheet in the Excel file
			Worksheet worksheet = workbook.getWorksheets().get(0);

			// Get the cells collection in the sheet
			Cells cells = worksheet.getCells();

			// Obtain the DataSorter object in the workbook
			DataSorter sorter = workbook.getDataSorter();

			// Set the first order
			sorter.setOrder1(SortOrder.ASCENDING);

			// Define the first key.
			sorter.setKey1(2);

			// Set the second order
			//sorter.setOrder2(SortOrder.ASCENDING);

			// Define the second key
			//sorter.setKey2(1);

			// Create a cells area (range).
			CellArea ca = new CellArea();

			// Specify the start row index.
			ca.StartRow = StartRow;
			// Specify the start column index.
			ca.StartColumn = StartColumn;
			// Specify the last row index.
			ca.EndRow = EndRow;
			// Specify the last column index.
			ca.EndColumn = EndColumn;

			// Sort data in the specified data range (A2:C10)
			sorter.sort(cells, ca);

			// Saving the excel file
			workbook.save(dataPath);
			System.out.println("Sort Done.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
