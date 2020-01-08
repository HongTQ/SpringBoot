package read_write_file.com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ManangerFile {
	private final String URL_FILE = "D:\\read_wirte_import.txt";
	
	public ArrayList<Person> readPersonFromFile(ArrayList<Person> listPerson){
		try {
			InputStreamReader inReader = new InputStreamReader(new FileInputStream(URL_FILE), "UTF-8");
			BufferedReader reader = new BufferedReader(inReader);
			String line = reader.readLine();
			while (line != null) {
				String[] obj = line.split(",");
				int id = Integer.parseInt(obj[0]);
				String name = obj[1];
				boolean sex;
				if(obj[2].equals("true")) 
					sex = true; 
				else 
					sex = false;
				String birthday = obj[3];
				String phone = obj[4];
				listPerson.add(new Person(id,name,sex,birthday,phone));
				line = reader.readLine();
			}
            System.out.println("Done read file");
            reader.close();
            return listPerson;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void writePersonInFile(ArrayList<Person> listPerson) {
		try {
			OutputStreamWriter outpWriter = new OutputStreamWriter(new FileOutputStream(URL_FILE), "UTF-8");
			BufferedWriter writer = new BufferedWriter(outpWriter);
			String str = "";
			for (Person person : listPerson) {
				 str += ""+person.getId()+","+person.getName()+","+person.getSex()+","+person.getBirthday()+","+person.getPhone()+"\n";
			}
			writer.write(str);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
