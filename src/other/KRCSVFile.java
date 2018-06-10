package other;

import java.io.IOException;
import java.io.PrintWriter;

public class KRCSVFile {

	public static void main(String[] args) {
		try{
		    PrintWriter writer = new PrintWriter("C:\\Users\\kwang1\\Desktop\\kr.csv", "UTF-8");
		    int k=50;
		    writer.println("k,r,");
		    for(int i=2;i<=k;i++){
		    	for(int j=1;j<=i-1;j++){
		    		writer.println(i+","+j+",");
		    	}
		    }

		    
		    writer.close();
		} catch (IOException e) {
		   // do something
		}

	}

}
