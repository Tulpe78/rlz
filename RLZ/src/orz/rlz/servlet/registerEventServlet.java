package orz.rlz.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rlz.dataModel.Athlet;
import org.rlz.dataModel.Event;
import org.rlz.dataHandling.AthletDAO;
import org.rlz.dataHandling.EventDAO;
import org.rlz.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/registerEvent" })
public class registerEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public registerEventServlet() {
        super();
    }
 
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
        
        List<Athlet> listMy = null;
        try {
            listMy = AthletDAO.selectMyAthlet(conn,"Thomas");
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }

        request.setAttribute("athletMyList", listMy);
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("eventList", event);
     
        // Forward to /WEB-INF/views/eventListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/registerEventView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}

