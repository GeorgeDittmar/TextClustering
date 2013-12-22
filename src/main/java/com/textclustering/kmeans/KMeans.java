package com.textclustering.kmeans;

import com.data.Corpus;
import com.data.Document.TextDocument;
import com.sun.istack.internal.NotNull;
import com.textclustering.IClusterAlg;

import java.util.*;

/**
 * Implements the KMeans clustering algorithm for use with text documents. The Kmeans class will store
 * User: george
 * Date: 11/17/13
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class KMeans implements IClusterAlg {

    int m_numClusters;
    private Map<Integer, List<TextDocument>> clusters;
    private Map<Integer, Vector<Double>> clusterCenters;
    private Corpus corpus;


    public KMeans(int m_numClusters, @NotNull Corpus corpus) {
        this.m_numClusters = m_numClusters;
        this.clusters = new HashMap<Integer, List<TextDocument>>();
        this.clusterCenters = new HashMap<Integer, Vector<Double>>();
        this.corpus = corpus;
    }

    public void setNumberClusters(int num) {
        this.m_numClusters = num;
    }

    /**
     * This method performs the k-means clustering algorithm on the set of vectorized documents.
     */
    public void classifyData(List<TextDocument> data) throws Exception {

        for (TextDocument document : data) {
            Vector<Double> documentVector = document.getVectorRepresentation();
            calc_dist(documentVector, clusterCenters);
        }
    }

    /**
     * This function runs the kmeans algorithm to learn the cluster centers. This is an iterative algorithm that will
     * learn the best fit cluster centers for a given corpus of documents.
     */
    public void learn(Corpus corpus) {

        // generate the random clusters once we get the corpus.
        LinkedList<Double> minMaxList = new LinkedList<Double>();
        for (String classLabel : corpus.getCorpus().keySet()) {
            for (TextDocument tmp : corpus.getCorpus().get(classLabel)) {
                // grab the min and max feature value from each document.
                minMaxList.add(Collections.max(tmp.getVectorRepresentation()));
                minMaxList.add(Collections.min(tmp.getVectorRepresentation()));
            }
        }

        double min = Collections.min(minMaxList);
        double max = Collections.max(minMaxList);

        // generate the random cluster centers that will start the learning process.
        for(int i=0; i< m_numClusters; i++){

        }

    }

    /**
     * Generate a random cluster center given the dimensionality of the data as a parameter. Each randomly generated cluster center
     * wll be derived by looking at the overall statistics of the documents loaded into the corpus so as to not create a random center that is not actually withing
     * the document space. Simple case can just look at the value of the largest feature and the smallest feature so as to generates an n-dimensional vector with each
     * feature x_i is min_att <= x_i <= max_att.
     */
    public void generateClusters(long dim, double min, double max) {

        Random r = new Random();

        for (int i = 0; i < m_numClusters; i++) {

            Vector<Double> generatedCluster = new Vector<Double>();

            for (int j = 0; j < dim; j++) {
                double randFeatureVal = min + (max - min) * r.nextDouble();
                generatedCluster.add(randFeatureVal);
            }

            clusterCenters.put(i, generatedCluster);
        }

    }


    /**
     * Calculates the distance a centroid is from a given document. This measure uses euclidian distance to calculate the distance
     * metric.
     *
     * @param doc       the document that needs to be assigned to a cluster.
     * @param centroids list of vectors that we associated the document with.
     * @return centroid closest to a given document
     * @throws Exception
     */
    public int calc_dist(Vector<Double> doc, Map<Integer, Vector<Double>> centroids) throws Exception {

        int closestCentroid = -1;
        double lastDistance = 0.0;

        for (int centroid : centroids.keySet()) {
            if (doc.size() != centroids.get(centroid).size()) {
                throw new RuntimeException("TextDocument and centroid vectors are not the same size. Some issue has happened" +
                        "during creation of the vectors.");
            }


            double distance = 0.0;

            Vector<Double> centroidVec = centroids.get(centroid);
            for (int i = 0; i < doc.size(); i++) {

                distance += Math.pow((doc.get(i) - centroidVec.get(i)), 2);
            }

            distance = Math.sqrt(distance);
            // calculate as we go the closest centroid to our document.
            if (closestCentroid == -1) {
                closestCentroid = centroid;
                lastDistance = distance;
            } else if (distance < lastDistance) {
                closestCentroid = centroid;
                lastDistance = distance;
            }

        }

        // grab the closest centroid and return its id.
        return closestCentroid;
    }


    @Override
    public int classify(TextDocument document) {

        // given a single document to classify against our document corpus
        return 0;
    }

    @Override
    public int getNumberOfDocs() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadDocumentVectors(List<Vector<Double>> documentSpace) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadDocuments(List<TextDocument> documents) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
