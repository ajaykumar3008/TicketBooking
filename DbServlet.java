package booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class DbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashMap<String,ArrayList<String>> list=new HashMap<>();
		ArrayList<String> places = new ArrayList<>();
		ArrayList<String> trains = new ArrayList<>();
		try {

			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ajay",
					"postgres", "Maddineni@123");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();

			ResultSet rs1 = st1.executeQuery("select * from places");
			ResultSet rs2 = st2.executeQuery("select * from Trains");

			while (rs1.next()) {
				places.add(rs1.getString(1));
			}
			
			while (rs2.next()) {
				trains.add(rs2.getString(1));
			}

			con.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

		list.put("train", trains);
		list.put("place", places);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String json = new Gson().toJson(list);
		response.getWriter().write(json);

	}

}
