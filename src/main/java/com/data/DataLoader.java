package com.data;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The DataLoader object's job is to take a directory and read in documents from sub folders, where the subfolders are
 * used to denote document class. Example if you point the DataLoader to a folder named documents and there are 2 subfolders in it
 * called fiction and non-fiction; these two sub folders will denote the number of clusters / classes we will try to learn.
 * User: george
 * Date: 11/17/13
 * Time: 8:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataLoader {

    public static Map<String,List<File>> loadDataSet(File dir){
        File[] fList = dir.listFiles();
        Map<String,List<File>> dataset = new HashMap<String,List<File>>();

        // generate the cluster classes from the directory structure
        for(File file : fList){
            if(file.isDirectory()){
                dataset.put(file.getName(),new LinkedList<File>());
            }
        }

        // next open each sub directory and add the files to the map

        for(String classKey :dataset.keySet()){

            File subdir = new File(dir.getAbsolutePath()+"/"+classKey);
            File[] subdirList = subdir.listFiles();

            for(File file: subdirList){
                dataset.get(classKey).add(file);
            }

        }
        return dataset;
    }
}
