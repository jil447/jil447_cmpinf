package jil447_MenuManager_v2;
/**
 * Class FileManager
 * @author:Jin Li
 * @created:11/03/2022
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileManager {

        static ArrayList<Entree> readEntrees(String fileName) {
            ArrayList<Entree> list = new ArrayList<Entree>();
            try {

                FileReader file = new FileReader(new File(fileName));

                BufferedReader br = new BufferedReader(file);
                String line = "";
                String[] arrs = null;
                while ((line = br.readLine()) != null) {
                    arrs = line.split("@@");
                    list.add(new Entree(arrs[0], arrs[1], Integer.parseInt(arrs[2])));
                }
                br.close();
                file.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
            return list;
        }

        static ArrayList<Side> readSides(String fileName) {
            ArrayList<Side> list = new ArrayList<Side>();
            try {
                FileReader file = new FileReader(new File(fileName));

                BufferedReader br = new BufferedReader(file);
                String line = "";
                String[] arrs = null;
                while ((line = br.readLine()) != null) {
                    arrs = line.split("@@");
                    list.add(new Side(arrs[0], arrs[1], Integer.parseInt(arrs[2])));
                }
                br.close();
                file.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
            return list;
        }

        static ArrayList<Salad> readSalads(String fileName) {
            ArrayList<Salad> list = new ArrayList<Salad>();
            try {
                FileReader file = new FileReader(new File(fileName));

                BufferedReader br = new BufferedReader(file);
                String line = "";
                String[] arrs = null;
                while ((line = br.readLine()) != null) {
                    arrs = line.split("@@");
                    list.add(new Salad(arrs[0], arrs[1], Integer.parseInt(arrs[2])));
                }
                br.close();
                file.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
            return list;
        }

        static ArrayList<Dessert> readDesserts(String fileName) {
            ArrayList<Dessert> list = new ArrayList<Dessert>();
            try {
                FileReader file = new FileReader(new File(fileName));

                BufferedReader br = new BufferedReader(file);
                String line = "";
                String[] arrs = null;
                while ((line = br.readLine()) != null) {
                    arrs = line.split("@@");
                    list.add(new Dessert(arrs[0], arrs[1], Integer.parseInt(arrs[2])));
                }
                br.close();
                file.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
            return list;
        }
    }
