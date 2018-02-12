<%--
  Created by IntelliJ IDEA.
  User: Alexander
  Date: 11.02.2018
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alutask | Welcome</title>

    <link rel="stylesheet" type="text/css" href="../css/mainstyle.css"/>
</head>
<body>
<div id="allcontent">
    <div id="header">
        <img src="src/img/mainHeader.gif" alt="Alutask. Just try to use" />
    </div>

    <div id="main">

        <table>
            <tr>
                <th>
                    <form action="developers" method="get">
                        <select name="elementsToShow">
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="15">15</option>
                        </select>
                        <input type="submit" value="Refresh list">
                    </form>
                </th>
                <c:forEach var="pageNum" items="${requestScope.pageNums}">
                    <th>
                    <form action="developers" method="get">
                        <input type="hidden" name="pageToShow" value="${pageNum}">
                        <input type="submit" value="${pageNum}">
                    </form>
                    </th>
        </c:forEach>
            </tr>
        </table>
        <table>
            <tr>
                <th>Login</th>
                <th>Name</th>
                <th>e-Mail</th>
                <th>Programming Language</th>
                <th>Level</th>
            </tr>

            <c:forEach var="developer" items="${requestScope.developers}">
                <tr>
                    <td align="center"><c:out value="${developer.login}"/></td>
                    <td align="center"><c:out value="${developer.name}"/></td>
                    <td align="center"><c:out value="${developer.email}"/></td>
                    <td align="center"><c:out value="${developer.language}"/></td>
                    <td align="center"><c:out value="${developer.level}"/></td>
                </tr>
            </c:forEach>

        </table>
    </div>

    <div id="sidebar">
        <form action="developers" method="get">
            <select name="elementsToShow">
                <option value="5">5</option>
                <option value="10">10</option>
                <option value="15">15</option>
            </select>

            <select name="programmingLanguageFilter">
                <c:forEach items="${requestScope.programmingLanguages}" var="programmingLanguage">
                    <option value="${programmingLanguage}">${programmingLanguage}</option>
                </c:forEach>
            </select>

            <select name="developerLevelFilter">
                <c:forEach items="${requestScope.developerLevels}" var="developerLevel">
                    <option value="${developerLevel}">${developerLevel}</option>
                </c:forEach>
            </select>

            <input type="submit" value="Refresh list">
        </form>

        <form action="developers" method="get">
            <select name="programmingLanguageFilter">
                <c:forEach items="${requestScope.programmingLanguages}" var="programmingLanguage">
                    <option value="${programmingLanguage}">${programmingLanguage}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Refresh list">
        </form>
        <p class="beanheading">
            <img src="src/img/sidebarBooks.gif" alt="Alutask" /> <br />
            <span class="slogan">
            JUST <br />
            TRY <br />
            IT <br />
        </span>
        </p>
        <p>
            Hello. Alutask is still implementing, but we really trying to do everything
            to release our great project. Hope you'll enjoy it.... later)
        </p>
    </div>

    <div id="footer">
        &copy; 2018, Alexander Gorovtsov
        <br />
        Web project made specially for JD02 ITAcademy.by.
    </div>
</div>
</body>
</body>
</html>
