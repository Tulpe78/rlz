package orz.rlz.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.rlz.dataModel.Event;
import org.rlz.dataHandling.EventDAO;
import org.rlz.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createEvent" })
public class CreateEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateEventServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createEventView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String strSaison = (String) request.getParameter("saison");
        String execDate = (String) request.getParameter("execDate");
        String name = (String) request.getParameter("name");
        String descn = (String) request.getParameter("descn");

        Event event = new Event(Integer.parseInt(strSaison), execDate, name, descn);
 
        String errorString = null;
 
        if (errorString == null) {
            try {
                EventDAO.insertEvent(conn, event);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Store information to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("event", event);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createEventView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/eventList");
        }
    }
 
}