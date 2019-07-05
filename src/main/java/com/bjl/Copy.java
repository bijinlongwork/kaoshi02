package com.bjl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Copy {
    public static void copyfile(String path,String fileName){

        BufferedReader reader = null;
        String laststr = "";
        ObjectOutputStream oos=null;
        File newfileName = new File(path + fileName + ".json");
        try{
            FileInputStream fileInputStream = new FileInputStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            if(!newfileName.exists()){
                newfileName.createNewFile();
            }
            oos=new ObjectOutputStream(new FileOutputStream(newfileName));

            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
            }

            List<Object> list = new ArrayList<>();
            list.add(laststr);
            oos.writeObject(list);


        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
