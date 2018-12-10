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
import org.rlz.dataHandling.AthletDAO;
import org.rlz.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/athletList" })
public class AthletListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AthletListServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String errorString = null;
        List<Athlet> list = null;
        try {
            list = AthletDAO.selectAthlet(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        request.setAttribute("athletList", list);
        
        List<Athlet> listMy = null;
        try {
            listMy = AthletDAO.selectMyAthlet(conn,"Thomas");
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("athletMyList", listMy);
     
        // Forward to /WEB-INF/views/eventListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/athletListView.jsp");
        dispatcher.forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}

