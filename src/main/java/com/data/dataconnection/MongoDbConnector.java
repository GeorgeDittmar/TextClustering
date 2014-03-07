package com.data.dataconnection;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import net.sf.json.JSONObject;

import java.net.UnknownHostException;

/**
 * Created by george on 2/23/14.
 */
public class MongoDbConnector {

    private MongoClient m_mongoClient;
    /**
     *
     * @param server
     * @param user
     * @param pass
     * @throws UnknownHostException is thrown when the code cannot reach a valid mongo server
     */
    public void MongoDbConnector(String server,String db,String user, String pass) throws UnknownHostException {

        // initialized the db and collection if they do not already exist
        m_mongoClient = new MongoClient( "localhost" , 27017 );
        DB database = m_mongoClient.getDB("Documents");
        DBCollection collection = database.getCollection("DocCollection");

    }

    public void addDocuments(JSONObject doc){
        // persist the document by the given json into mongodb

    }

}
