package de.mongo.test;


import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
 
/**
 * Java + MongoDB Example
 * 
 */
public class MongoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			MongoClient mongo = new MongoClient("localhost", 27017); // mongodb server settings
			DB db = mongo.getDB("mongodbtest"); // connect to mongodb database
			
			DBCollection collection = db.getCollection("testData"); // get collection named "testData" in mongodb database 
			
			
			collection.remove(new BasicDBObject()); // empty collection
			
			// insert record as documents in the testData collection
			
			BasicDBObject document = new BasicDBObject(); // create a document
			document.put("name", "Anil Chaubey");  // insert 1st field in the document
			document.put("age", 29); //insert 2nd field in the document
			collection.insert(document);	// add document in the collection
					
			// display all the documents.
			
			DBCursor cursor = collection.find(); // get all the documents in the collection named "testData"
			while(cursor.hasNext()) {
				 
			    System.out.println(cursor.next());  // display all the documents one by one.
			    
			}
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // to get mongdo db connection setting.
		
		

	}

}
