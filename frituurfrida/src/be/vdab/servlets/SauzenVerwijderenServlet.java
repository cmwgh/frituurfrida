package be.vdab.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.SausRepository;


@WebServlet("/sauzen/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REDIRECT_URL = "%s/sauzen.htm";
	private final SausRepository sausRepository = new SausRepository();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] idsAlsString = request.getParameterValues("id");
		if (idsAlsString != null){
			sausRepository.delete(Arrays.stream(idsAlsString)
					.map(id -> Long.parseLong(id))
					.collect(Collectors.toSet()));
		}
		response.sendRedirect(
				String.format(REDIRECT_URL, request.getContextPath()));
	}

}