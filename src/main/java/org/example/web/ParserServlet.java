
package org.example.web;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ParserServlet.
 *
 * @author ADivaev
 */

@WebServlet(name = "ParserServlet", urlPatterns = {"/parse"})
@MultipartConfig
public class ParserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ParserServlet.class);

    //https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
//https://www.youtube.com/watch?v=zZJl8jZXDPQ
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Part filePart = req.getPart("file");
        JSONObject jsonObject = new JSONObject();
        try (InputStream filecontent = filePart.getInputStream()) {
            final byte[] bytes = new byte[1024];
            filecontent.read(bytes);
            String fileInput = new String(bytes);
            jsonObject = XML.toJSONObject(fileInput);
            log.info("result log {}", jsonObject);
        } catch (FileNotFoundException fne) {
        }
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        session.setAttribute("text", formatter(jsonObject.toString(1)));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }


    private String formatter(String text) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object jsonObject = mapper.readValue(text, Object.class);
            String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
            return prettyJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}