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
 
import org.rlz.dataHandling.EventDAO;
import org.rlz.dataModel.Event;
import org.rlz.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/editEvent" })
public class EditEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditEventServlet() {
        super();
    }
 
    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
 
        Event event = null;
 
        String errorString = null;
 
        try {
            event = EventDAO.findEvent(conn, Integer.parseInt(idStr));
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && event == null) {
            response.sendRedirect(request.getServletPath() + "/eventList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("event", event);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/editEventView.jsp");
        dispatcher.forward(request, response);
 
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String idStr = (String) request.getParameter("id");
        String execDateStr = (String) request.getParameter("exec_date");
        String saisonStr = (String) request.getParameter("saison");
        String name = (String) request.getParameter("name");
        String descn = (String) request.getParameter("descn");
        
        Event event = new Event(Integer.parseInt(idStr), Integer.parseInt(saisonStr),execDateStr, name, descn);
 
        String errorString = null;
 
        try {
            EventDAO.updateEvent(conn, event);;
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("event", event);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/editEventView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/eventList");
        }
    }
 
}