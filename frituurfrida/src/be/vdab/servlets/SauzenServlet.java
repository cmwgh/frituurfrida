package be.vdab.servlets;

import java.util.List;
import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.entities.Saus;
import be.vdab.repositories.SausRepository;

/**
 * Servlet implementation class SauzenServlet
 */
@WebServlet("/sauzen.htm")
public class SauzenServlet extends HttpServlet {
	@Resource(name = SausRepository.JNDI_NAME)
	public void setDataSource(DataSource dataSource) {
	sausRepository.setDataSource(dataSource);
	} // en transient bij de declaratie van de variabele sausRepository
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/sauzen.jsp";
	private final transient SausRepository sausRepository = new SausRepository();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("sauzen", sausRepository.findAll());
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}