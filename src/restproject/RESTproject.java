/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restproject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author informatica
 */
public class RESTproject {

    public void get(){
	  try {

		URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) { //ERRORE DEL GET
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

	}
    public void post(){
        	  try {

		URL url = new URL("http://localhost:8080/api/tutorial/1.0/employees");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		String input = "{ \\ \n" +
"   \"employeeId\": 1, \\ \n" +
"   \"firstName\": \"Giorgio\", \\ \n" +
"   \"lastName\": \"Stramaroni\", \\ \n" +
"   \"email\": \"giorgiostramaroni%40gmail.com\", \\ \n" +
"   \"phone\": \"34758569856\" \\ }";

		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();

		                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) { //ERRORE DEL POST (CODICE 201) 
			throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	 }
    }
}

