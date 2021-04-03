<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Super parser!</h2>
<hr>
    <form action="parse" method="post" enctype="multipart/form-data">
        File:
        <br/>
        <input type="file" name="file" id="file" /> <br/>
        </br>
        <input type="submit" value="Upload" name="upload" id="upload" />
    </form>
<hr>
<pre><%=session.getAttribute("text") %></pre>
</body>
</html>
