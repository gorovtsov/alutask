<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<fmt:setLocale value="${sessionScope.local}" />

<link rel="stylesheet" type="text/css" href="css/mainstyle.css"/>

<title>Alutask | Welcome</title>
</head>


<body>
<div id="allcontent">
    <div id="header">
      <img src="src/img/mainHeader.gif" alt="Alutask. Just try to use" />
    </div>

    <div id="main">
        <form action="developers" method="get">
            <input type="submit" name="toDevs" value="ShowDevelopers" />
        </form>
    </div>

    <div id="sidebar">
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
</html>