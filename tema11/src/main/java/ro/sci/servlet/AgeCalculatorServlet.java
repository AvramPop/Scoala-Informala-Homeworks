package ro.sci.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.sci.classes.AgeCalculator;

public class AgeCalculatorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AgeCalculator ageCalculator = new AgeCalculator();

		Date today = java.sql.Date.valueOf(LocalDate.now());
		Date birthDay = java.sql.Date.valueOf(LocalDate.of(1999, 12, 22));

		if (birthDay == null) {
			resp.getWriter().println("<b>Not a birthday inserted</b>");

		} else {
			resp.getWriter().println("<b>Your age in days is " + ageCalculator.daysBetweenDates(birthDay, today) + "!</b>");

		}

		req.setAttribute("age", ageCalculator.daysBetweenDates(birthDay, today));

	}

}
