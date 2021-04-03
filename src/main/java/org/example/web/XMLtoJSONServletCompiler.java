
package org.example.web;

import org.example.parse.XmlToJsonParser;
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
public class XMLtoJSONServletCompiler extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(XMLtoJSONServletCompiler.class);
    private final XmlToJsonParser xmlToJsonParserUtil = new XmlToJsonParser();

    //https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Part filePart = req.getPart("file");
        String jsonString = String.valueOf("");
        try (InputStream filecontent = filePart.getInputStream()) {
            final byte[] bytes = new byte[1024];
            filecontent.read(bytes);
            jsonString = xmlToJsonParserUtil.parseWithFormatting(bytes);
            log.info("result log {}", jsonString);
        } catch (FileNotFoundException fne) {
            log.error(fne.getMessage());
        }
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        session.setAttribute("text", jsonString);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}