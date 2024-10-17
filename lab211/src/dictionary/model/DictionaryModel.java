package dictionary.model;

import java.io.*;
import java.util.HashMap;

public class DictionaryModel {
    private HashMap<String,String> dictionary;

    public DictionaryModel() {
        dictionary = new HashMap<>();
        loadData();
    }
    public void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    dictionary.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("No existing dictionary data found.");
        }
    }
    public void updateDatabase(){
        try(PrintWriter pw = new PrintWriter(new FileWriter("dictionary.txt"))) {
            for(String eng : dictionary.keySet()){// tập hợp chưa key
                pw.println(eng+"="+dictionary.get(eng));
            }
        } catch (IOException e) {
            System.out.println("error update");
        }
    }
    public boolean addWord(String eng, String vi){
        if(dictionary.containsKey(eng)){
            return false;
        }
        dictionary.put(eng,vi);
        updateDatabase(); // cập nhật lại file
        return true;
    }
    public boolean removeWord(String eng){
        if(dictionary.containsKey(eng)){
            dictionary.remove(eng);
            updateDatabase();
            return true;
        }
        return false;
    }
    public String translate(String eng){
        return dictionary.getOrDefault(eng,"Word not found");
    }

}
