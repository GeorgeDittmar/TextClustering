package com.textclustering;

import com.data.Corpus;
import com.textclustering.kmeans.KMeans;
import com.textclustering.knn.Knn;

/**
 * Created with IntelliJ IDEA.
 * User: george
 * Date: 12/7/13
 * Time: 11:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClusterFactory {
    /**
     *
     * @param cluterClass
     * @return an IClusterAlg object or null if the desired class does not exist
     */
    public static IClusterAlg createClusterAlg(Class cluterClass){

        if(cluterClass.isInstance(KMeans.class)){
            return new KMeans(0,new Corpus());
        }else if(cluterClass.isInstance(Knn.class)){
            return new Knn();
        }

        return null;
    }
}
