package be.vdab.servlets;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.*;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns="/index.htm", name="indexservlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	LocalDate vandaag = LocalDate.now();
	DayOfWeek weekdag = vandaag.getDayOfWeek();
	request.setAttribute("telefoonNummerHelpDesk",
			this.getInitParameter("telefoonNummerHelpDesk"));
	request.setAttribute("frituurFrida", new Adres("Frituurweg", "17A", new Gemeente("Genk", 3600)));
	
	
	request.setAttribute("openGesloten",
	weekdag == DayOfWeek.MONDAY || weekdag == DayOfWeek.THURSDAY ?
	"gesloten" :
	"open");
	RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW);
	dispatcher.forward(request, response);
	}
	}
