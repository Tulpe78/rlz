package orz.rlz.servlet.create;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.rlz.dataModel.Athlet;
import org.rlz.dataHandling.AthletDAO;
import org.rlz.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/createAthlet" })
public class CreateAthletServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public CreateAthletServlet() {
        super();
    }
 
    // Show product creation page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createAthletView.jsp");
        dispatcher.forward(request, response);
    }
 
    // When the user enters the product information, and click Submit.
    // This method will be called.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String yearStr = (String) request.getParameter("year");
        String contactStr = (String) request.getParameter("contact");
        String clubStr = (String) request.getParameter("club");

        Athlet athlet = new Athlet((String) request.getParameter("lastName")
        		                  ,(String) request.getParameter("firstName")
        		                  ,Integer.parseInt(yearStr)
        		                  ,(String) request.getParameter("gender")
        		                  ,Integer.parseInt(contactStr)
        		                  ,Integer.parseInt(clubStr));
 
        String errorString = null;
 
        if (errorString == null) {
            try {
                AthletDAO.insertAthlet(conn, athlet);
            } catch (SQLException e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
        }
 
        // Store information to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("athlet", athlet);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/createAthletView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/athletList");
        }
    }
 
}