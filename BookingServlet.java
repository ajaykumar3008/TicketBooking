package booking;

import java.io.IOException;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int newPNR=111111;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String train = request.getParameter("train");
		String date = request.getParameter("date");
		String clas = request.getParameter("clas");
		String passData= request.getParameter("psss"); 
		
			Gson gson=new Gson();
		Passengers passengerList = gson.fromJson(passData, Passengers.class);
		System.out.println(passengerList);
		
		Ticket ticket=new Ticket(from,to,train,date,clas);
		
		Calculation passTicket = new Calculation(ticket,passengerList);
		for(Passenger p:passengerList) {
			System.out.println(p.getName());
			System.out.println(p.age);
			System.out.println(p.name);
			System.out.println(p.getBerth());
			System.out.println(p.getSlno());
		}
		newPNR++;
		System.out.println(newPNR);
		double ticketCost=passTicket.totalCalculation();
		System.out.println(ticketCost);
		
		request.setAttribute("fare",ticketCost);
		request.setAttribute("ticket",ticket);
		request.setAttribute("pnr",newPNR);
		request.setAttribute("passengers",passengerList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Ticket.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
