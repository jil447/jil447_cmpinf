package jil447_MenuManager_v3;
/**
 * Class FileManager
 * @author:Jin Li
 * @created:11/20/2022
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	public static ArrayList<MenuItem> readItems(String fileName){
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
        try {
            FileReader file = new FileReader(new File(fileName));

            BufferedReader br = new BufferedReader(file);
            String line = "";
            String[] arrs = null;
            while ((line = br.readLine()) != null) {
                arrs = line.split("@@");
                if("entree".equals(arrs[1])) {
                	list.add(new Entree(arrs[0], arrs[2], Integer.parseInt(arrs[3]), Double.parseDouble(arrs[4])));
                }
                if("side".equals(arrs[1])) {
                	list.add(new Side(arrs[0], arrs[2], Integer.parseInt(arrs[3]), Double.parseDouble(arrs[4])));
                }
                if("salad".equals(arrs[1])) {
                	list.add(new Salad(arrs[0], arrs[2], Integer.parseInt(arrs[3]), Double.parseDouble(arrs[4])));
                }
                if("dessert".equals(arrs[1])) {
                	list.add(new Dessert(arrs[0], arrs[2], Integer.parseInt(arrs[3]), Double.parseDouble(arrs[4])));
                }
            }
            br.close();
            file.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public static void writeItems(String fileName, ArrayList<Menu> menus){
    	try {
			FileWriter file = new FileWriter(new File(fileName));
			BufferedWriter bw = new BufferedWriter(file);
			for (int i = 0; i < menus.size(); i++) {
				bw.write(menus.get(i).desc());
				bw.newLine();
				bw.write("total calories "+ menus.get(i).totalCalories());
				bw.newLine();
				bw.write("total prices "+ menus.get(i).totalPrice());
				bw.newLine();
			}
			bw.flush();
            bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}

