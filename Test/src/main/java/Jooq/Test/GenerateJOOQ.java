package Jooq.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.jooq.util.GenerationTool;

/**
 * run this program to generate JOOQ classes from the BDD
 * BE CAREFUL : The AuthorRecord.java in test.generated.tables.records package file can have errors due to @override annotations. Just remove them and you should be fine.
 *
 */
public class GenerateJOOQ {
	public static void main(String[] args) {
		try {

			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new FileReader("library.xml"));

			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			br.close();

			
			
			 GenerationTool.generate(sb.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
