package com.src.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.Booking;
import com.src.model.Passenger;
import com.src.model.PermDriver;
import com.src.model.Request;
import com.src.model.TempDriver;
import com.src.objs.ObjectGenerator;
import com.src.security.SecurityServices;
import com.src.security.SecurityServicesInterface;
import com.src.services.RequestBooking;
import com.src.services.RequestBookingInterface;

/**
 * Servlet implementation class BookingControl
 */
public class BookingControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SecurityServicesInterface ssi = new SecurityServices();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectGenerator objgetter = new ObjectGenerator();
		HttpSession session = request.getSession();
		String mode = (String)session.getAttribute("mode");
		System.out.println(mode);
		session.setAttribute("msglog", "");
		session.setAttribute("msgreg", "");
		PrintWriter out = response.getWriter();
		RequestBookingInterface rb = new RequestBooking();
		if(mode!=null) {
			if(mode.equals("tdriver")) {
				RequestBookingInterface rbi = objgetter.getRequestDriverServices();
				
				TempDriver t = (TempDriver) session.getAttribute("user");
				Request setreq = rbi.isBooked(t.getUsername());
				System.out.println(t.getUsername());
				System.out.println(setreq);
				if(setreq!=null){
					System.out.println("in tab");
					session.setAttribute("setrequest", setreq);
					RequestDispatcher rbd = request.getRequestDispatcher("displayrequests.jsp");
					StringBuilder tablebuilder = new StringBuilder();
					tablebuilder.append("<div><table class='containersingle' cellspacing = 30px><tr><th class = 'Named'>From</th><th class = 'Named'>To</th><th class = 'Named'>Driver_Username</th><th class = 'Named'>Charge</th><th class = 'Named'>Trip Distance</th><th class = 'Named'>Allowed Number of Passengers</th></tr>");
					Request rqst = setreq;
					tablebuilder.append("<tr><td class = 'Named'>"+rqst.getFromplace()+"</td>"
							+ "<td class = 'Named'>"+rqst.getToPlace()+"</td>"
							+ "<td class = 'Named'>"+ssi.decrypt(rqst.getDriv_username())+"</td>"
							+ "<td class = 'Named'>"+rqst.getBookingfare()+"</td>"
							+ "<td class = 'Named'>"+rqst.getRoutedistance()+"</td>"
							+ "<td class = 'Named'>"+rqst.getMax_people()+"</td>"
							+ "<td class = 'Named'><a href = 'val.jsp?op=book&mode=tdriver&from="+rqst.getFromplace()+"&to="+rqst.getToPlace()+"&drivuname="+rqst.getdriv_username()+"&bookfare="+rqst.getBookingfare()+"&routedistance="+rqst.getRoutedistance()+"'>Accept</a></td>"
							+ "</tr>"
							);
					request.setAttribute("reqs", tablebuilder);
					rbd.include(request, response);
				}
				else if(rbi.isRequested(t.getUsername())!=null){
					RequestDispatcher rbd = request.getRequestDispatcher("home.jsp?msg=Requests Already Exists Wait for Confirmation");
					rbd.forward(request, response);
				}
				else {
					
					Request req = new Request(request.getParameter("From"),request.getParameter("To"),t.getUsername(),Integer.parseInt(request.getParameter("max_people")),t);
					if(rb.addRequest(req)) {
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp?msg=Succesfully Uploaded");
						rd.include(request, response);
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp?msg=Same Request Already Exists");
						rd.include(request, response);
					}
					
				}
			}
			else if(mode.equals("pdriver")) {
				RequestBookingInterface rbi = new RequestBooking();
				PermDriver t = (PermDriver) session.getAttribute("user");
				System.out.println(t.getUsername()+" "+rbi.isBooked(t.getUsername()));
				Request setreq = rbi.isBooked(t.getUsername());
				if(setreq!=null){
					System.out.println("in tab");
					session.setAttribute("setrequest", setreq);
					RequestDispatcher rbd = request.getRequestDispatcher("displayrequests.jsp");
					StringBuilder tablebuilder = new StringBuilder();
					tablebuilder.append("<div><table class='containersingle' cellspacing = 30px><tr><th class = 'Named'>From</th><th class = 'Named'>To</th><th class = 'Named'>Driver_Username</th><th class = 'Named'>Charge</th><th class = 'Named'>Trip Distance</th><th class = 'Named'>Allowed Number of Passengers</th></tr>");
					Request rqst = setreq;
					tablebuilder.append("<tr><td class = 'Named'>"+rqst.getFromplace()+"</td>"
							+ "<td class = 'Named'>"+rqst.getToPlace()+"</td>"
							+ "<td class = 'Named'>"+ssi.decrypt(rqst.getDriv_username())+"</td>"
							+ "<td class = 'Named'>"+rqst.getBookingfare()+"</td>"
							+ "<td class = 'Named'>"+rqst.getRoutedistance()+"</td>"
							+ "<td class = 'Named'>"+rqst.getMax_people()+"</td>"
							+ "<td class = 'Named'><a href = 'val.jsp?op=book&mode=pdriver&from="+rqst.getFromplace()+"&to="+rqst.getToPlace()+"&drivuname="+rqst.getdriv_username()+"&bookfare="+rqst.getBookingfare()+"&routedistance="+rqst.getRoutedistance()+"'>Accept</a></td>"
							+ "</tr>"
							);
					request.setAttribute("reqs", tablebuilder);
					rbd.include(request, response);
				}
				else if(rbi.isRequested(t.getUsername())!=null){
					RequestDispatcher rbd = request.getRequestDispatcher("home.jsp?msg=Requests Already Exists Wait for Confirmation");
					rbd.forward(request, response);
				}
				else {
					Request req = new Request(request.getParameter("From"),request.getParameter("To"),t.getUsername(),Integer.parseInt(request.getParameter("max_people")),t);
					if(rb.addRequest(req)) {
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp?msg=Succesfully Uploaded");
						rd.include(request, response);
					}
					else {
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp?msg=Same Request Already Exists");
						rd.include(request, response);
					}
				}
			}
			else if(mode.equals("passenger")) {
				
				Passenger t = (Passenger) session.getAttribute("user");
				Booking isbook = objgetter.getBookingServices().getBooking(t.getUsername());
				if(isbook != null) {
					session.setAttribute("setbooking", isbook);
					RequestDispatcher rbd = request.getRequestDispatcher("booked.jsp");
					rbd.forward(request, response);
				}
				else {
					ArrayList<Request> requests = (ArrayList<Request>) rb.getRequests(request.getParameter("From"),request.getParameter("To"));
					StringBuilder tablebuilder = new StringBuilder();
					tablebuilder.append("<div><table class='containersingle' cellspacing = 30px><tr><th class = 'Named'>From</th><th class = 'Named'>To</th><th class = 'Named'>Driver_Username</th><th class = 'Named'>Charge</th><th class = 'Named'>Trip Distance</th><th class = 'Named'>Allowed Number of Passengers</th></tr>");
					int c=0;
					for(Request rqst:requests) {
						c=1;
						tablebuilder.append("<tr><td class = 'Named'>"+rqst.getFromplace()+"</td>"
								+ "<td class = 'Named'>"+rqst.getToPlace()+"</td>"
								+ "<td class = 'Named'>"+ssi.decrypt(rqst.getDriv_username())+"</td>"
								+ "<td class = 'Named'>"+rqst.getBookingfare()+"</td>"
								+ "<td class = 'Named'>"+rqst.getRoutedistance()+"</td>"
								+ "<td class = 'Named'>"+rqst.getMax_people()+"</td>"
								+ "<td class = 'Named'><a href = 'val.jsp?op=bookpass&mode=passenger&from="+rqst.getFromplace()+"&to="+rqst.getToPlace()+"&drivuname="+rqst.getdriv_username()+"&bookfare="+rqst.getBookingfare()+"&routedistance="+rqst.getRoutedistance()+"'>Book</a></td>"
								+ "</tr>"
								);
					}
					if(c==1) {
						tablebuilder.append("</table></div>");
						request.setAttribute("reqs", tablebuilder);
					}
					else {
						request.setAttribute("reqs", null);
					}
					
					
					RequestDispatcher rtd = request.getRequestDispatcher("displayrequests.jsp");
					rtd.include(request, response);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

