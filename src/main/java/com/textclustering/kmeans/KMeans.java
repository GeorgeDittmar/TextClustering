package com.textclustering.kmeans;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Implements the kmeans algorithm.
 * User: george
 * Date: 11/17/13
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class KMeans {
    final int m_numClusters;

    public KMeans(int m_numClusters) {
        this.m_numClusters = m_numClusters;
    }

    /**
     * Generate a random cluster center given the dimensionality of the data.
     */
    public Vector<Double> generate_clusters(long dim){

       return null;
    }


    // calculates the euclidian distance of a document to the cluster centers
    public int calc_dist(Vector<Double> doc, List<Vector<Double>> centroids){

        List<Double> distanceToCentroids = new LinkedList<Double>();
        for(Vector<Double> centroid: centroids){
            if(doc.size() != centroid.size()){
                throw new RuntimeException("Document and centroid vectors are not the same size. Some issue has happened" +
                        "during creation of the vectors.");
            }
            double distance = 0.0;
            for(int i=0; i<doc.size(); i++){

               distance += Math.pow((doc.get(i)-centroid.get(i)),2);


            }

            distance = Math.sqrt(distance);
            distanceToCentroids.add(distance);
        }

        Collections.sort(distanceToCentroids);

        // grab the closest centroid and return its id.


       return -1;
    }
}
