import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Processing {
	private boolean finish = false;
	ArrayList<People> arraylist_people = new ArrayList<People>();
	String dad_file,  mom_file ,son_file, save_to_file;
	private String dad_filter , mom_filter ,son_filter;
	public Processing(String dad_file, String mom_file, String son_file,String dad_filter , String mom_filter,String son_filter, String save_to_file) {
		try {
			this.save_to_file = save_to_file;
			this.dad_file = dad_file;
			this.mom_file =mom_file ;
			this.son_file =son_file;
			this.dad_filter = dad_filter;
			this.mom_filter = mom_filter;
			this.son_filter = son_filter;
			finish = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void Start(){
		 Read_data_Dad();
		 Read_data_Mom();
		 Read_data_Son();
		 try {
			Match();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Read_data_Dad() {
		try {
			File temp_dad = new File(dad_file);
			XEXcelFileReader reader = new XEXcelFileReader(dad_file);
			arraylist_people.add(new People(temp_dad.getName(), "dad", reader.readRows()));

			arraylist_people.get(0).getTemp_list().remove(0);
			 //List<String[]> dad_list = arraylist_people.get(0).getTemp_list();
			for(int j = 0; j< 10; j++){
			  for (int i = 0; i < arraylist_people.get(0).getTemp_list().size(); i++) { 
				  String[] value = arraylist_people.get(0).getTemp_list().get(i);
				  if(value[8].equalsIgnoreCase(dad_filter)){
					  arraylist_people.get(0).getTemp_list().remove(i);
				  }
				
			  }
			 
			
			System.out.println("Finish File: " + arraylist_people.get(0).getID() + " Status :"
					+ arraylist_people.get(0).getStatus() + " Size: " + arraylist_people.get(0).getTemp_list().size());
			}
			temp_dad = null;
			reader.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	public void Read_data_Mom() {
		try {
			File temp_mom = new File(mom_file);
			XEXcelFileReader reader = new XEXcelFileReader(mom_file);
			arraylist_people.add(new People(temp_mom.getName(), "mom", reader.readRows()));
			arraylist_people.get(1).getTemp_list().remove(0);
			// List<String[]> mom_list = arraylist_people.get(1).getTemp_list();
			for(int j = 0; j< 10; j++){
			  for (int i = 0; i < arraylist_people.get(1).getTemp_list().size(); i++) { 
				  String[] value = arraylist_people.get(1).getTemp_list().get(i);
				  if(value[8].equalsIgnoreCase(mom_filter)){
					  arraylist_people.get(1).getTemp_list().remove(i);
				  }
				  
			  }
			
			System.out.println("Finish File: " + arraylist_people.get(1).getID() + " Status :"
					+ arraylist_people.get(1).getStatus() + " Size: " + arraylist_people.get(1).getTemp_list().size());
			}
			temp_mom = null;
			reader.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void Read_data_Son() {
		try {
			File temp_son = new File(son_file);
			XEXcelFileReader reader = new XEXcelFileReader(son_file);
			arraylist_people.add(new People(temp_son.getName(), "son", reader.readRows()));
			/* List<String[]> son_list = arraylist_people.get(2).getTemp_list();
			  for (int i = 0; i < son_list.size(); i++) { 
				  String[] value = son_list.get(i);

					System.out.println(i+" : "+value[1] + " "+value[2]+" "+value[3]+
							" "+value[4]+" "+value[5]+" "+value[6]+" "+value[7]+" "+value[8]);
			  }*/
			arraylist_people.get(2).getTemp_list().remove(0);
			 //List<String[]> son_list = arraylist_people.get(2).getTemp_list();
			for(int j = 0; j< 10; j++){
				for (int i = 0; i < arraylist_people.get(2).getTemp_list().size(); i++) { 
					  String[] value = arraylist_people.get(2).getTemp_list().get(i);
					 
					  if(value[8].equalsIgnoreCase(son_filter)){
							
						  arraylist_people.get(2).getTemp_list().remove(i);
					  }
					  
					 
				  }
				System.out.println("Finish File: " + arraylist_people.get(2).getID() + " Status :"
						+ arraylist_people.get(2).getStatus() + " Size: " + arraylist_people.get(2).getTemp_list().size());
			}
			  
			/* List<String[]> son_list = arraylist_people.get(2).getTemp_list();
			  for (int i = 0; i < son_list.size(); i++) { 
				  String[] value = son_list.get(i);

					System.out.println(i+" : "+value[1] + " "+value[2]+" "+value[3]+
							" "+value[4]+" "+value[5]+" "+value[6]+" "+value[7]+" "+value[8]);
			  }*/																																																																																																																	
		
		
						temp_son = null;				
									reader.finalize();
		} catch (Throwable e) {																
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Match() throws IOException {
		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook(); 

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Merge_Data");
		// This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("0", new Object[] { "CHROM", "Gene Name", "POS","Effect","HGVS.c","HGVS.p","dbsmp_142_ID","1000GP3_AF", "REF", "ALT", "DAD_ALT", "MOM_ALT" });

		int son_total = 0;
		for (int i = 0; i < arraylist_people.size(); i++) {
			if (arraylist_people.get(i).getStatus().equals("son")) {
				son_total++;
			}
		}
		System.out.println("son_total :" + son_total);
		int son_index = 0;
		boolean match = true;
		// son by son
		for (int j = 0; j < son_total; j++) {
			son_index = j + 2;
			// each son have row size
			List<String[]> son_list = arraylist_people.get(son_index).getTemp_list();
			for (int i = 0; i < son_list.size(); i++) {
				String[] son_value = son_list.get(i);

				// search against dad
				List<String[]> dad_list = arraylist_people.get(0).getTemp_list();
				String dad_ALT = "#N/A";
				for (int z = 0; z < dad_list.size(); z++) {
					String[] dad_value = dad_list.get(z);
					if (son_value[1].equals(dad_value[1])) {
						dad_ALT = dad_value[3];
						break;
					}
				}
				
				// search against mom
				List<String[]> mom_list = arraylist_people.get(1).getTemp_list();
				String mom_ALT = "#N/A";
				for (int z = 0; z < mom_list.size(); z++) {
					String[] mom_value = mom_list.get(z);
					if (son_value[1].equals(mom_value[1])) {
						mom_ALT = mom_value[3];
						break;
					}
				}
				
				data.put("" + i + 1, new Object[] { son_value[0], son_value[12], Integer.parseInt(son_value[1]),son_value[10]
						,son_value[17],son_value[18],son_value[28],son_value[29], son_value[2],
						son_value[3], dad_ALT, mom_ALT });
			}
	
		}
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

		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(this.save_to_file));
			workbook.write(out);
			out.close();
			System.out.println("written successfully on disk.");
			finish =true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	

	}
	public boolean finish(){
		return this.finish;
	}

}
