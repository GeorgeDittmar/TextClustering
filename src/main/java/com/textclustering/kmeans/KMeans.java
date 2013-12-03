package com.textclustering.kmeans;

import com.data.Document.TextDocument;
import com.textclustering.IClusterAlg;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Implements the KMeans clustering algorithm for use with text documents.
 * User: george
 * Date: 11/17/13
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class KMeans implements IClusterAlg {
    final int m_numClusters;

    public KMeans(int m_numClusters) {
        this.m_numClusters = m_numClusters;
    }

    /**
     * This method performs the k-means clustering algorithm on the set of vectorized documents.
     */
    public void classifyData(List<Vector<Double>> data) {

    }

    /**
     * Generate a random cluster center given the dimensionality of the data as a parameter. Each randomly generated cluster center
     * wll be derived by looking at the overall statistics of the documents loaded into the corpus so as to not create a random center that is not actually withing
     * the document space.
     */
    public Vector<Double> generateClusters(long dim) {

        return null;
    }


    /**
     * Calculates the distance a centroid is from a given document. This measure uses euclidian distance to calculate the distance
     * metric.
     *
     * @param doc       the document that needs to be assigned to a cluster.
     * @param centroids list of vectors that we associated the document with.
     * @return
     * @throws Exception
     */
    public int calc_dist(Vector<Double> doc, List<Vector<Double>> centroids) throws Exception {

        List<Double> distanceToCentroids = new LinkedList<Double>();
        for (Vector<Double> centroid : centroids) {
            if (doc.size() != centroid.size()) {
                throw new RuntimeException("TextDocument and centroid vectors are not the same size. Some issue has happened" +
                        "during creation of the vectors.");
            }
            double distance = 0.0;
            for (int i = 0; i < doc.size(); i++) {

                distance += Math.pow((doc.get(i) - centroid.get(i)), 2);


            }

            distance = Math.sqrt(distance);
            distanceToCentroids.add(distance);
        }

        Collections.sort(distanceToCentroids);

        // grab the closest centroid and return its id.


        return -1;
    }

    @Override
    public int classify(TextDocument document) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getNumberOfDocs() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadDocumentVectors(List<Vector<Double>> documentSpace) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
