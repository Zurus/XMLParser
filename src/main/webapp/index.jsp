<html>
<body>
<h2>Super parser!</h2>
<%--enctype="multipart/form-data"--%>
    <form action="parse" method="post" enctype="multipart/form-data">
        File:
        <input type="file" name="file" id="file" /> <br/>
        Destination:
        <input type="text" value="/tmp" name="destination"/>
        </br>
        <input type="submit" value="Upload" name="upload" id="upload" />
    </form>
<hr>
</body>
</html>
