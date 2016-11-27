package Jooq.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Random;


import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import static test.generated.Tables.*;

public class App {
	
	private static void showAuthors(Result<Record> result){
		for (Record r : result) {
			Integer id = r.getValue(AUTHOR.ID);
			String firstName = r.getValue(AUTHOR.FIRST_NAME);
			String lastName = r.getValue(AUTHOR.LAST_NAME);

			System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName +"\n");
		}
	}
	
	public static void main(String[] args) {
		try {


			//Create the SQL context
			
			String userName = "jooqtest";
			String password = "IDMj00q2016";
			String url = "jdbc:mysql://triton.fr.nf:3306/library";
			Connection conn = DriverManager.getConnection(url, userName, password);
				
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			
			//Get all the authors from the library database
			Result<Record> result = create.select().from(AUTHOR).fetch();

			//show the list of authors
			showAuthors(result);
			
			//Will be used to generate a random ID
			Random rand = new Random();
			
			//Foo inserted values, change it at will
			String fName = "Ella";
			String lName = "Dupot";
			String duplicateIDLName="Doe";
			String duplicateIDFName="John";
			
			
			create.insertInto(AUTHOR, AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
					.values(rand.nextInt()%10000, fName, lName) //Inserts the fName and lName values with a random ID
					.onDuplicateKeyUpdate().set(AUTHOR.LAST_NAME, duplicateIDLName ).set(AUTHOR.FIRST_NAME, duplicateIDFName) //it means that if the id that we insert already exists, then the row will be updated new names 
					.execute();
			
			//get all the rows again
			result = create.select().from(AUTHOR).fetch();

			//print it
			showAuthors(result);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
