package com.data;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by george on 3/9/14.
 */
public class LSHTCDataLoader {
    public static Iterator loadData(String filename) throws IOException {
        Iterator lineIter = FileUtils.lineIterator(new File(filename),"utf-8");
        return lineIter;
    }

    public static void main(String[] args){
        try {
            LineIterator iter = (LineIterator) LSHTCDataLoader.loadData("C:\\train.csv");
            while(iter.hasNext()){
                System.out.println(iter.next());
                System.out.println(iter.next());
                System.out.println(iter.next());
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
