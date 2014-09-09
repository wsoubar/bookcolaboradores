package br.com.mjv.bookcolaboradores.dao;

import java.net.UnknownHostException;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.jongo.marshall.jackson.JacksonMapper;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class Test {
	
	public static void main(String[] args) throws UnknownHostException {
		MongoClient mc = new MongoClient("127.0.0.1");
//		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(mc, "book"));
//		mongoOps.insert(new Person("Wagner", 40));
//		System.out.println(mongoOps.findOne(new Query(Criteria.where("name").is("Joe")), Person.class));

		DB db = mc.getDB("book");
		
		Jongo jongo = new Jongo(db);
		MongoCollection people = jongo.getCollection("people");
		//people.save(new Person("Wagner", 40));
		//Person p = people.findOne("{name: 'Wagner'}").as(Person.class);
		// Person p = people.findOne(new ObjectId("540c19c0dd2858dd2c07637b")).as(Person.class);
		String buscaNome = "Wagner";
		MongoCursor<Person> cursor = people.find("{name: #}", buscaNome).as(Person.class);
		
		for (Person person : cursor) {
			System.out.println( person.toString() );
		}
		// System.out.println( p.toString() );
		
		mc.close();
	}
	

}
