
package org.example.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.JSONObject;
import org.json.XML;

/**
 * ParserServlet.
 *
 * @author ADivaev
 */

@WebServlet(name = "ParserServlet", urlPatterns = {"/parse"})
@MultipartConfig
public class ParserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext selvletContext = getServletContext();
        req.setAttribute("name", "Tom");
        selvletContext.getRequestDispatcher("/parser.jsp").forward(req, resp);
    }

//https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
//https://www.youtube.com/watch?v=zZJl8jZXDPQ


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final String path = req.getParameter("destination");
//        final Part filePart = req.getPart("file");
//        final String fileName = getFileName(filePart);
//        OutputStream out = null;
//        InputStream filecontent = null;
//        final PrintWriter writer = resp.getWriter();
//        try {
//            out = new FileOutputStream(new File(path + File.separator
//                    + fileName));
//            filecontent = filePart.getInputStream();
//
//            int read = 0;
//            final byte[] bytes = new byte[1024];
//
//            while ((read = filecontent.read(bytes)) != -1) {
//                out.write(bytes, 0, read);
//            }
//            writer.println("New file " + fileName + " created at " + path);
//            String fileInput = new String(bytes);
//
//            JSONObject jsonObject = XML.toJSONObject(fileInput);
//            System.out.println(jsonObject.toString());
//
//            //req.setAttribute("shit",jsonObject.toString());
////            req.setAttribute("name","asdfasdfasdf");
////            resp.sendRedirect("parser.jsp");
//
//        } catch (FileNotFoundException fne) {
//            writer.println("You either did not specify a file to upload or are "
//                    + "trying to upload a file to a protected or nonexistent "
//                    + "location.");
//            writer.println("<br/> ERROR: " + fne.getMessage());
//        } finally {
//            if (out != null) {
//                out.close();
//            }
//            if (filecontent != null) {
//                filecontent.close();
//            }
//            if (writer != null) {
//                writer.close();
//            }
//        }
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        session.setAttribute("name", "Tom");
        getServletContext().getRequestDispatcher("/parser.jsp").forward(req,resp);
    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}