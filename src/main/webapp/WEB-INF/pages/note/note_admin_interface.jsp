<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Пункт прибытия/назначения</title>
    <%--<script src="../../resources/js/modernizr.custom.63321.js"></script>
   <script src="../../resources/js/jquery-1.11.1.min.js"></script>
   <script src="../../resources/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css" />
 <link rel="stylesheet" href="../../resources/css/font-awesome.min.css" />
 <link rel="stylesheet" href="../../resources/css/menu_style.css" />
 <link rel="stylesheet" href="../../resources/css/table.css" />
 <link rel="stylesheet" href="../../resources/css/dopstyle.css" />
 <link rel="stylesheet" href="../../resources/css/autor_style.css" />--%>
    <!-- Раскомментировать для jsp -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/autor_style.css" />"/>
    <script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.63321.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/download.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/menu_style.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/table.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/modal.css" />"/>
    <link rel="shortcut icon" href="<c:url value="/resources/images/fon1.jpg"/>" type="image/png">
    <%--<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/client.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/modal.css" />"/>--%>

</head>
<body>

<!-- ///////////////////////////////////////////////// -->
<div class="container">
    <div class="header">
        <div class="row">
            <div class="col-md-8">
                <div class="name">
                    TECHNOLAND
                </div>
            </div>

            <div class="col-md-4">
                <form class="navbar-form navbar-left" role="search">
                    <input type="text" id="text-to-find" value="" class="form-control" placeholder="Найти">
                    <button type="submit" class="btn btn-default"
                            onclick="javascript: FindOnPage('text-to-find'); return false;">
                        <i class="fa fa-search" aria-hidden="true"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- ///////////////////////////////////////////////// -->
<nav class="navbar navbar-default ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="sr-only"></span>
            </button>

        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="">
                    <a href="<c:url value="/order_client"/>" target="_self">Заявки</a>
                </li>
                <%-- <li class="">
                    <a href="<c:url value="/flowers_admin"/>" target="_self">Цветы</a>
                </li>
                <li class="">
                    <a href="<c:url value="/bouquets_admin"/>" target="_self">Букеты</a>
                </li>
                <li class="">
                    <a href="<c:url value="/compositions_admin"/>" target="_self">Копмозиции</a>
                </li>
                <li class="">
                    <a href="<c:url value="/packs_admin"/>" target="_self">Упаковки</a>
                </li>
                <li class="">
                    <a href="<c:url value="/decorations_admin"/>" target="_self">Украшения</a>
                </li> --%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="<c:url value="/users/currentUser"/>" class="dropdown-toggle" data-toggle="dropdown"
                       role="button" aria-expanded="false">
                        <c:choose>
                            <c:when test="${user.login ne null}">
                                ${user.login}
                            </c:when>
                            <c:otherwise>
                                Мой профиль
                            </c:otherwise>
                        </c:choose>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li class="divider"></li>
                        <c:choose>
                            <c:when test="${user.login ne null}">
                                <li><a href="<c:url value="/exit"/>" target="_self">Выход</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="<c:url value="/autorization"/>" target="_self">Вход</a></li>
                            </c:otherwise>
                        </c:choose>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/users"/>" target="_self">Регистрация</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<br>
<div class="mybody">
    <div class="container">
        <div class="article container">
            <div class="row otstup">
                <div class="col-md-12">
                    <h1 class="h2 page-header"
                        style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">Пункт прибытия/назначения</h1>
                    <section class="main">


                        <div class="headname">
                            <h1>Форма для оформления доставки товара</h1>
                        </div>

                        <c:url var="addAction" value="/note_admin_interface/add"/>

                        <form:form action="${addAction}" modelAttribute="interface" class="form-horizontal">


                        <div class="form-group">
                            <form:label path="nfc" class="col-sm-2 control-label">
                                <spring:message text="NFC"/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="nfc" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="lan" class="col-sm-2 control-label">
                                <spring:message text="LAN "/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="lan" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="wifi" class="col-sm-2 control-label">
                                <spring:message text="Wi-Fi"/>
                            </form:label>
                            <div class="col-sm-4">
                                <form:input path="wifi" pattern="(.[0-9]*)"
                                            title="Используйте цифры." class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="mobile" class="col-sm-2 control-label">
                                <spring:message text="Сотовая связь"/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="mobile" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="usbPort" class="col-sm-2 control-label">
                                <spring:message text="Всего USB-портов"/>
                            </form:label>
                            <div class="col-sm-4">
                                <form:input path="usbPort" pattern="(.[0-9]*)"
                                            title="Используйте цифры." class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="usb2" class="col-sm-2 control-label">
                                <spring:message text="USB 2.0"/>
                            </form:label>
                            <div class="col-sm-4">
                                <form:input path="usb2" pattern="(.[0-9]*)"
                                            title="Используйте цифры." class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="usb3" class="col-sm-2 control-label">
                                <spring:message text="USB 3.0"/>
                            </form:label>
                            <div class="col-sm-4">
                                <form:input path="usb3" pattern="(.[0-9]*)"
                                            title="Используйте цифры" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="usb31A" class="col-sm-2 control-label">
                                <spring:message text="USB 3.1 Type-A"/>
                            </form:label>
                            <div class="col-sm-4">
                                <form:input path="usb31A" pattern="(.[0-9]*)"
                                            title="Используйте цифры." class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="usb31C" class="col-sm-2 control-label">
                                <spring:message text="USB 3.1 Type-C"/>
                            </form:label>
                            <div class="col-sm-4">
                                <form:input path="usb31C" pattern="(.[0-9]*)"
                                            title="Используйте цифры." class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="vga" class="col-sm-2 control-label">
                                <spring:message text="VGA (RGB)"/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="vga" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="hdmi" class="col-sm-2 control-label">
                                <spring:message text="HDMI"/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="hdmi" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="displayPort" class="col-sm-2 control-label">
                                <spring:message text="DisplayPort"/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="displayPort" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="thounderbolt" class="col-sm-2 control-label">
                                <spring:message text="Thunderbolt"/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="thounderbolt" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="jack" class="col-sm-2 control-label">
                                <spring:message text="Аудио выходы (3.5 мм jack)"/>
                            </form:label>
                            <div class="col-sm-2 control-label">
                                <div class="double">
                                    <form:checkbox path="jack" checked="true" value="1"/>
                                </div>
                            </div>
                        </div>




                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" class="btn btn-success"
                                       value="<spring:message text="Продолжить"/>"/>
                            </div>
                        </div>
                    </form:form>
                        </div>
                    </section>

                </div>
            </div>
        </div>
    </div>

    <footer>
        <div class="container">
            <div style="padding: 10px 0pt 0pt 30px; clear: both; color: #8d1645; font-size: 15px;">Все права защищены
                &copy; <?=date ('Y')?></div>
        </div>
    </footer>
</div>
<<!-- Раскомментировать для jsp -->
<script src="${pageContext.request.contextPath}/resources/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("resources/images/fon1.jpg");
</script>
</body>
</html>
