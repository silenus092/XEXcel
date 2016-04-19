import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Processing {
	private boolean finish = false;
	ArrayList<People> arraylist_people = new ArrayList<People>();
	String dad_file, mom_file, son_file, save_to_file;
	private String dad_filter, mom_filter, son_filter;
	private int init_son_index = 0;
	private Map<String, Object[]> data;
	public String ErrorMsg = "";

	public Processing(String dad_file, String mom_file, String son_file, String dad_filter, String mom_filter,
			String son_filter, String save_to_file) {
		try {
			this.save_to_file = save_to_file;
			this.dad_file = dad_file;
			this.mom_file = mom_file;
			this.son_file = son_file;
			this.dad_filter = dad_filter;
			this.mom_filter = mom_filter;
			this.son_filter = son_filter;
			finish = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int Start() {
		if (!dad_file.equals("") || !dad_file.isEmpty()) {

			Read_data_Dad();
			init_son_index++;
		} else {
			System.out.println("Skip read dad");
		}
		if (!mom_file.equals("") || !mom_file.isEmpty()) {

			Read_data_Mom();
			init_son_index++;
		} else {
			System.out.println("Skip read mom");
		}
		Read_data_Son();
		if(ErrorMsg.isEmpty()){
			return 0;
		}else{
			return 1;
		}
	}

	public void Read_data_Dad() {
		try {
			System.out.println("Read dad");
			File temp_dad = new File(dad_file);
			XEXcelFileReader reader = new XEXcelFileReader(dad_file);
			arraylist_people.add(new People(temp_dad.getName(), "dad", reader.readRows()));

			arraylist_people.get(0).getTemp_list().remove(0);
			// List<String[]> dad_list = arraylist_people.get(0).getTemp_list();
			for (int j = 0; j < 10; j++) {
				for (int i = 0; i < arraylist_people.get(0).getTemp_list().size(); i++) {
					String[] value = arraylist_people.get(0).getTemp_list().get(i);
					if (value[8].equalsIgnoreCase(dad_filter)) {
						arraylist_people.get(0).getTemp_list().remove(i);
					}

				}

				System.out.println("Finish File: " + arraylist_people.get(0).getID() + " Status :"
						+ arraylist_people.get(0).getStatus() + " Size: "
						+ arraylist_people.get(0).getTemp_list().size());
			}
			temp_dad = null;
			reader.finalize();
			System.out.println("Read dad finish");
		} catch (Throwable e) {
			e.printStackTrace();
			ErrorMsg = e.toString();
		}

	}

	public void Read_data_Mom() {
		try {
			System.out.println("Read mom");
			File temp_mom = new File(mom_file);
			XEXcelFileReader reader = new XEXcelFileReader(mom_file);
			arraylist_people.add(new People(temp_mom.getName(), "mom", reader.readRows()));
			int init_mom_index = arraylist_people.size() - 1;
			arraylist_people.get(init_mom_index).getTemp_list().remove(0);
			// List<String[]> mom_list = arraylist_people.get(1).getTemp_list();
			for (int j = 0; j < 10; j++) {
				for (int i = 0; i < arraylist_people.get(init_son_index).getTemp_list().size(); i++) {
					String[] value = arraylist_people.get(init_son_index).getTemp_list().get(i);
					if (value[8].equalsIgnoreCase(mom_filter)) {
						arraylist_people.get(init_mom_index).getTemp_list().remove(i);
					}

				}

				System.out.println("Finish File: " + arraylist_people.get(init_son_index).getID() + " Status :"
						+ arraylist_people.get(init_mom_index).getStatus() + " Size: "
						+ arraylist_people.get(init_son_index).getTemp_list().size());
			}
			temp_mom = null;
			reader.finalize();
			System.out.println("Read mom finish");
		} catch (Throwable e) {
			e.printStackTrace();
			ErrorMsg = e.toString();
		}
	}

	public void Read_data_Son() {
		try {
			System.out.println("Read son");
			File temp_son = new File(son_file);
			XEXcelFileReader reader = new XEXcelFileReader(son_file);
			arraylist_people.add(new People(temp_son.getName(), "son", reader.readRows()));
			/*
			 * List<String[]> son_list = arraylist_people.get(2).getTemp_list();
			 * for (int i = 0; i < son_list.size(); i++) { String[] value =
			 * son_list.get(i);
			 * 
			 * System.out.println(i+" : "+value[1] + " "+value[2]+" "+value[3]+
			 * " "+value[4]+" "+value[5]+" "+value[6]+" "+value[7]+" "
			 * +value[8]); }
			 */
			arraylist_people.get(init_son_index).getTemp_list().remove(0);
			// List<String[]> son_list = arraylist_people.get(2).getTemp_list();
			for (int j = 0; j < 10; j++) {
				for (int i = 0; i < arraylist_people.get(init_son_index).getTemp_list().size(); i++) {
					String[] value = arraylist_people.get(init_son_index).getTemp_list().get(i);

					if (value[8].equalsIgnoreCase(son_filter)) {

						arraylist_people.get(init_son_index).getTemp_list().remove(i);
					}

				}
				System.out.println("Finish File: " + arraylist_people.get(init_son_index).getID() + " Status :"
						+ arraylist_people.get(init_son_index).getStatus() + " Size: "
						+ arraylist_people.get(init_son_index).getTemp_list().size());
			}

			/*
			 * List<String[]> son_list = arraylist_people.get(2).getTemp_list();
			 * for (int i = 0; i < son_list.size(); i++) { String[] value =
			 * son_list.get(i);
			 * 
			 * System.out.println(i+" : "+value[1] + " "+value[2]+" "+value[3]+
			 * " "+value[4]+" "+value[5]+" "+value[6]+" "+value[7]+" "
			 * +value[8]); }
			 */

			temp_son = null;
			reader.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorMsg = e.toString();
		}
	}

	public int Match()  {
		try{
		// This data needs to be written (Object[])
		data = new TreeMap<String, Object[]>();
		data.put("0",
				new Object[] { "CHROM", "Gene Name", "POS", "DP", "QUAL", "Effect", "Feature_ID", "HGVS.c", "HGVS.p",
						"dbsmp_142_ID", "1000GP3_AF", "1000Gp3_AFR_AF", "1000Gp3_AMR_AF", "1000Gp3_EAS_AF",
						"1000Gp3_EUR_AF", "1000Gp3_SAS_AF", "SIFT_score", "Polyphen2_HDIV_score",
						"Polyphen2_HVAR_score", "Polyphen2_HVAR_pred", "CLINVAR_CLNSIG", "REF", "ALT", "DAD_ALT",
						"MOM_ALT" });

		int son_total = 0;
		for (int i = 0; i < arraylist_people.size(); i++) {
			if (arraylist_people.get(i).getStatus().equals("son")) {
				son_total++;
			}
		}
		System.out.println("son_total :" + son_total);
		int son_index = 0;
		boolean match = true;
		int parsed_value = 0;
		String mom_ALT = "#N/A";
		String dad_ALT = "#N/A";
		// son by son
		NumberFormat ukFormat = NumberFormat.getNumberInstance(Locale.UK);	
		long start = System.currentTimeMillis();
		System.out.println("Start Matching " );
		for (int j = 0; j < son_total; j++) {
			son_index = j + init_son_index;
			// each son have row size
			List<String[]> son_list = arraylist_people.get(son_index).getTemp_list();
			List<String[]> dad_list = arraylist_people.get(0).getTemp_list();
			List<String[]> mom_list = arraylist_people.get(1).getTemp_list();
			
			for (int i = 0; i < son_list.size(); i++) {
				String[] son_value = son_list.get(i);

				// search against dad
				if (!dad_file.equals("") || !dad_file.isEmpty()) {
					int z = 0;
					for (z = 0; z < dad_list.size(); z++) {
						String[] dad_value = dad_list.get(z);
						if (son_value[1].equals(dad_value[1])) {
							dad_ALT = dad_value[3];
							dad_list.remove(z);
							break;
						}
					}
					
				}

				// search against mom
				if (!mom_file.equals("") || !mom_file.isEmpty()) {
					int y = 0;
					for (y = 0; y < mom_list.size(); y++) {
						String[] mom_value = mom_list.get(y);
						if (son_value[1].equals(mom_value[1])) {
							mom_ALT = mom_value[3];
							mom_list.remove(y);
							break;
						}
					}
					
				}

			
					parsed_value = ukFormat.parse(son_value[1]).intValue();

			
				data.put("" + i + 1,
						new Object[] { son_value[0], son_value[12], parsed_value, son_value[4], son_value[6],
								son_value[10], son_value[14], son_value[17], son_value[18], son_value[28],
								son_value[29], son_value[30], son_value[31], son_value[32], son_value[33],
								son_value[34], son_value[38], son_value[40], son_value[42], son_value[43],
								son_value[44], son_value[2], son_value[3], dad_ALT, mom_ALT });
			}

		}
		long time = System.currentTimeMillis() - start;
		arraylist_people.clear();
		System.out.println("Finish Matching : time (sec) = " + (time/1000));
	  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		ErrorMsg = e.toString();
		return 1;
	 }
		return 0;
	}

	/*public  void WriteFile(){
		try {
		while(data.size() >0){
			for(int j = 0  ;j <10 ; j++){
				File file = new File(this.save_to_file);
				// Write the workbook in file system
			
				int rownum = 0;
				if (!file.exists()) {
					FileOutputStream out = new FileOutputStream(new File(this.save_to_file));
					// Blank workbook	
					XSSFWorkbook workbook = new XSSFWorkbook(); 
					// Create a blank sheet
					XSSFSheet sheet  = workbook.createSheet("Merge_Data");
					rownum = 0;

					Row row = sheet.createRow(rownum++);
					Object[] objArr = data.get(""+j);
					int cellnum = 0;
					for (Object obj : objArr) {
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Integer)
							cell.setCellValue((Integer) obj);
					}
					objArr = null;
					workbook.write(out);
					workbook.close();
					out.close();
				}else{
					FileOutputStream out = new FileOutputStream(this.save_to_file);
					FileInputStream myxls = new FileInputStream(this.save_to_file);
					XSSFWorkbook workbook =  (XSSFWorkbook)WorkbookFactory.create(myxls);
					XSSFSheet sheet  = workbook.getSheet("Merge_Data");
					rownum = sheet.getPhysicalNumberOfRows();
							Row row = sheet.createRow(rownum++);
							Object[] objArr = data.get(""+j);
							int cellnum = 0;
							for (Object obj : objArr) {
								Cell cell = row.createCell(cellnum++);
								if (obj instanceof String)
									cell.setCellValue((String) obj);
								else if (obj instanceof Integer)
									cell.setCellValue((Integer) obj);
							}
							objArr = null;; 
							workbook.write(out);
							workbook.close();
							out.close();
				}
		
		
				// Iterate over data and write to sheet

			
			
			}
		}

			
			System.out.println("Written successfully on disk.");
			finish =true;
		
		
		} catch (Exception e) {
			ErrorMsg = e.getMessage();
			e.printStackTrace();
		}
		
	}*/
	
	public void WriteFile() { 
		System.out.println("Start Writing File ");
		// Blank workbook http://poi.apache.org/spreadsheet/how-to.html#xssf_sax_api
		// keep 1 row in memory, exceeding rows will be flushed to dis
		SXSSFWorkbook workbook= new SXSSFWorkbook(1); // Create a blank sheet 
		SXSSFSheet sheet = workbook.createSheet("Merge_Data");

		// Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}

		}
		keyset = null;
		try { // Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(this.save_to_file));
			workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("Written successfully on disk.");
			finish = true;
			workbook = null;
			out = null;

		} catch (Exception e) {
			ErrorMsg = e.toString();
			e.printStackTrace();
		}
	  }
	 

	public boolean finish() {
		return this.finish;
	}

	public void destroy() {
		try {

			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // this is only for demonstrate my idea
	}
}
