<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Chat</title>
    </head>
    <body>
        <form>
            <table>
                <tr>
                    <td>Message:</td>
                    <td><input type="text" name="msg" id="msg"/></td>
                </tr>
            </table>
            <input type="submit" value="Send" onclick="postMessage();"/>
        </form>
        <div id="message">
            <% if(application.getAttribute("message")!=null){%>
            <%=application.getAttribute("message")%>
            <%}%>
        </div>
        <script src="js/chat-script.js"></script>
    </body>
</html>