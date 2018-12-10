package orz.rlz.servlet.create;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.rlz.dataHandling.AthletDAO;
import org.rlz.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/addAthletEvent" })
public class AddMyAthletEventServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AddMyAthletEventServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String[] paramNames = request.getParameterValues("myAthletId");
System.out.println("Start 3: "+paramNames.toString());

          for (int i = 0; i < paramNames.length; i++) {
                        String id = paramNames[i];   
                        System.out.println("paramValue: "+id);
                    }
          
 
        String errorString = null;
        String successString = "Erfolgreich";
 
 //       try {
 //           AthletDAO.addAthletEvent(conn, Integer.parseInt(idStr),Integer.parseInt(idStr));
 //       } catch (SQLException e) {
 //           e.printStackTrace();
 //           errorString = e.getMessage();
 //       } 
         
        // If has an error, redirecte to the error page.
        if (errorString != null) {
            // Store the information in the request attribute, before forward to views.
            request.setAttribute("errorString", errorString);
            // 
        }
        // If everything nice.
        // Redirect to the product listing page.        
        else {
System.out.println(successString);
RequestDispatcher dispatcher = request.getServletContext()
.getRequestDispatcher("/WEB-INF/views/registerEventView.jsp");
dispatcher.forward(request, response);
        }

 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}