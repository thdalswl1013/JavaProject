package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class DataBase {
	public static ArrayList<InputDataSet> DB_mon = new ArrayList<InputDataSet>();
	public static ArrayList<InputDataSet> DB_tus = new ArrayList<InputDataSet>();
	public static ArrayList<InputDataSet> DB_wed = new ArrayList<InputDataSet>();
	public static ArrayList<InputDataSet> DB_thu = new ArrayList<InputDataSet>();
	public static ArrayList<InputDataSet> DB_fri = new ArrayList<InputDataSet>();
	public static ArrayList<InputDataSet> DB_sat = new ArrayList<InputDataSet>();
	public static ArrayList<InputDataSet> DB_sun = new ArrayList<InputDataSet>();
	
	public static void inputData(InputDataSet i, int day) {
		switch(day) {
		case 0:
			DB_mon.add(i);
			break;
		case 1:
			DB_tus.add(i);
			break;
		case 2:
			DB_wed.add(i);
			break;
		case 3:
			DB_thu.add(i);
			break;
		case 4:
			DB_fri.add(i);
			break;
		case 5:
			DB_sat.add(i);
			break;
		case 6:
			DB_sun.add(i);
		}
	}
	public static void readPlanFromFile() {
		try {
			File f_mon = new File("out_mon.txt");
			FileReader fR_mon = new FileReader(f_mon);
			BufferedReader bR_mon = new BufferedReader(fR_mon);
			String line = "";
			while((line = bR_mon.readLine()) != null) {
				String[] strary = line.split("/");
				InputDataSet i = new InputDataSet(strary[0], strary[1], Integer.parseInt(strary[2]), Integer.parseInt(strary[3]), Integer.parseInt(strary[4]), Integer.parseInt(strary[5]));
				DB_mon.add(i);
			}
			
			File f_tus = new File("out_tus.txt");
			FileReader fR_tus = new FileReader(f_tus);
			BufferedReader bR_tus = new BufferedReader(fR_tus);
			line = "";
			while((line = bR_tus.readLine()) != null) {
				String[] strary = line.split("/");
				InputDataSet i = new InputDataSet(strary[0], strary[1], Integer.parseInt(strary[2]), Integer.parseInt(strary[3]), Integer.parseInt(strary[4]), Integer.parseInt(strary[5]));
				DB_tus.add(i);
			}
			
			File f_wed = new File("out_wed.txt");
			FileReader fR_wed = new FileReader(f_wed);
			BufferedReader bR_wed = new BufferedReader(fR_wed);
			line = "";
			while((line = bR_wed.readLine()) != null) {
				String[] strary = line.split("/");
				InputDataSet i = new InputDataSet(strary[0], strary[1], Integer.parseInt(strary[2]), Integer.parseInt(strary[3]), Integer.parseInt(strary[4]), Integer.parseInt(strary[5]));
				DB_wed.add(i);
			}
			
			File f_thu = new File("out_thu.txt");
			FileReader fR_thu = new FileReader(f_thu);
			BufferedReader bR_thu = new BufferedReader(fR_thu);
			line = "";
			while((line = bR_thu.readLine()) != null) {
				String[] strary = line.split("/");
				InputDataSet i = new InputDataSet(strary[0], strary[1], Integer.parseInt(strary[2]), Integer.parseInt(strary[3]), Integer.parseInt(strary[4]), Integer.parseInt(strary[5]));
				DB_thu.add(i);
			}
			
			File f_fri = new File("out_fri.txt");
			FileReader fR_fri = new FileReader(f_fri);
			BufferedReader bR_fri = new BufferedReader(fR_fri);
			line = "";
			while((line = bR_fri.readLine()) != null) {
				String[] strary = line.split("/");
				InputDataSet i = new InputDataSet(strary[0], strary[1], Integer.parseInt(strary[2]), Integer.parseInt(strary[3]), Integer.parseInt(strary[4]), Integer.parseInt(strary[5]));
				DB_fri.add(i);
			}
			
			File f_sat = new File("out_sat.txt");
			FileReader fR_sat = new FileReader(f_sat);
			BufferedReader bR_sat = new BufferedReader(fR_sat);
			line = "";
			while((line = bR_sat.readLine()) != null) {
				String[] strary = line.split("/");
				InputDataSet i = new InputDataSet(strary[0], strary[1], Integer.parseInt(strary[2]), Integer.parseInt(strary[3]), Integer.parseInt(strary[4]), Integer.parseInt(strary[5]));
				DB_sat.add(i);
			}
			
			File f_sun = new File("out_sun.txt");
			FileReader fR_sun = new FileReader(f_sun);
			BufferedReader bR_sun = new BufferedReader(fR_sun);
			line = "";
			while((line = bR_sun.readLine()) != null) {
				String[] strary = line.split("/");
				InputDataSet i = new InputDataSet(strary[0], strary[1], Integer.parseInt(strary[2]), Integer.parseInt(strary[3]), Integer.parseInt(strary[4]), Integer.parseInt(strary[5]));
				DB_sun.add(i);
			}
			fR_mon.close();
			fR_tus.close();
			fR_wed.close();
			fR_thu.close();
			fR_fri.close();
			fR_sat.close();
			fR_sun.close();
		}
		catch (FileNotFoundException nfe) {
			nfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	public static void writeToFile() throws IOException {
		FileOutputStream out_mon = new FileOutputStream("out_mon.txt");
		FileOutputStream out_tus = new FileOutputStream("out_tus.txt");
		FileOutputStream out_wed = new FileOutputStream("out_wed.txt");
		FileOutputStream out_thu = new FileOutputStream("out_thu.txt");
		FileOutputStream out_fri = new FileOutputStream("out_fri.txt");
		FileOutputStream out_sat = new FileOutputStream("out_sat.txt");
		FileOutputStream out_sun = new FileOutputStream("out_sun.txt");
		for(InputDataSet i : DB_mon) {
			out_mon.write(i.toStringToFile(i).getBytes());
		}
		for(InputDataSet i : DB_tus) {
			out_tus.write(i.toStringToFile(i).getBytes());
		}
		for(InputDataSet i : DB_wed) {
			out_wed.write(i.toStringToFile(i).getBytes());
		}
		for(InputDataSet i : DB_thu) {
			out_thu.write(i.toStringToFile(i).getBytes());
		}
		for(InputDataSet i : DB_fri) {
			out_fri.write(i.toStringToFile(i).getBytes());
		}
		for(InputDataSet i : DB_sat) {
			out_sat.write(i.toStringToFile(i).getBytes());
		}
		for(InputDataSet i : DB_sun) {
			out_sun.write(i.toStringToFile(i).getBytes());
		}
		out_mon.close();
		out_tus.close();
		out_wed.close();
		out_thu.close();
		out_fri.close();
		out_sat.close();
		out_sun.close();
	}
	public static void resetDB() {
		DB_mon.clear();
		DB_tus.clear();
		DB_wed.clear();
		DB_thu.clear();
		DB_fri.clear();
		DB_sat.clear();
		DB_sun.clear();
	}
	public static void sortData() {
		Collections.sort(DB_mon, new Ascending());
		Collections.sort(DB_tus, new Ascending());
		Collections.sort(DB_wed, new Ascending());
		Collections.sort(DB_thu, new Ascending());
		Collections.sort(DB_fri, new Ascending());
		Collections.sort(DB_sat, new Ascending());
		Collections.sort(DB_sun, new Ascending());
	}
}
class Ascending implements Comparator<InputDataSet>{
	public int compare(InputDataSet a, InputDataSet b) {
		if (a.hour<b.hour) {
			return -1;
		}
		else if (a.hour == b.hour) {
			return 0;
		}
		else {
			return 1;
		}
	}
}
