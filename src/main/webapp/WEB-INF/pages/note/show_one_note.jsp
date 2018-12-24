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
                    ЛОГИСТИКС
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
                        text-align: center;">Описание</h1>
                    <section class="main">


                        <%--<div class="headname">
                            <h1>Ноутбуки</h1>
                        </div>--%>
                            <table width="100%" class="tg">
                                <tr>
                                    <td align="center" width="100%"><img class="normPicture" src="${pageContext.request.contextPath}/resources/images/${notebook.photo}"></td>
                                </tr>
                                <tr>
                                    <td><h1 class="h2 page-header"
                                            style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;">${notebook.price}</h1></td>
                                </tr>

                                <tr>
                                    <td align="center">
                                        <c:url var="addAction" value="/create_order/${notebook.id}"/>

                                        <form:form action="${addAction}" class="form-horizontal">
                                            <div class="form-group">
                                                <div class="col-sm-offset-1 col-sm-10">
                                                    <input type="submit" class="btn btn-success"
                                                           value="<spring:message text="Заказать"/>"/>
                                                </div>
                                            </div>
                                        </form:form>
                                    </td>
                                </tr>

                                <tr>
                                    <td><h1 class="h2 page-header"
                                            style="color:#8d1645; font-family: 'Lobster', cursive; margin-top: -1px;
                        text-align: center;"></h1></td>
                                </tr>



                            </table>


                            <table width="100%" class="tg">
                                <tr>
                                    <th class="pro50">Общая информация</th>
                                    <th class="pro50"></th>
                                </tr>
                                <tr>
                                    <td>Дата выхода на рынок</td>
                                    <td>${common.timeEnter}</td>
                                </tr>

                                <tr>
                                    <td>Тип</td>
                                    <td>${common.type}</td>
                                </tr>

                                <tr>
                                    <td>Трансформер</td>
                                    <c:choose>
                                        <c:when test="${common.transformer eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <th width="50%">Процессор</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Платформа (кодовое название)</td>
                                    <td>${processor.platform}</td>
                                </tr>

                                <tr>
                                    <td>Процессор</td>
                                    <td>${processor.processorName}</td>
                                </tr>

                                <tr>
                                    <td>Модель процессора</td>
                                    <td>${processor.modelProcessor}</td>
                                </tr>

                                <tr>
                                    <td>Количество ядер</td>
                                    <td>${processor.core}</td>
                                </tr>

                                <tr>
                                    <td>Тактовая частота</td>
                                    <td>${processor.frequency}</td>
                                </tr>

                                <tr>
                                    <td>Turbo-частота</td>
                                    <td>${processor.turboFrequency}</td>
                                </tr>

                                <tr>
                                    <td>Энергопотребление процессора (TDP)</td>
                                    <td>${processor.powerUsage}</td>
                                </tr>

                                <tr>
                                    <th width="50%">Конструкция</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Материал корпуса</td>
                                    <td>${construction.materialBody}</td>
                                </tr>

                                <tr>
                                    <td>Цвет корпуса</td>
                                    <td>${construction.colorBody}</td>
                                </tr>

                                <tr>
                                    <td>Материал крышки</td>
                                    <td>${construction.materialCap}</td>
                                </tr>

                                <tr>
                                    <td>Цвет крышки</td>
                                    <td>${construction.colorCar}</td>
                                </tr>

                                <tr>
                                    <td>Подсветка корпуса</td>
                                    <c:choose>
                                        <c:when test="${construction.backlight eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Пыле-, влаго-, ударопрочность</td>
                                    <c:choose>
                                        <c:when test="${construction.impactResistance eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <th width="50%">Размеры и вес</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Ширина</td>
                                    <td>${size.width} мм</td>
                                </tr>

                                <tr>
                                    <td>Глубина</td>
                                    <td>${size.depth} мм</td>
                                </tr>

                                <tr>
                                    <td>Толщина</td>
                                    <td>${size.thickness} мм</td>
                                </tr>

                                <tr>
                                    <td>Вес</td>
                                    <td>${size.weight} г</td>
                                </tr>

                                <tr>
                                    <th width="50%">Экран</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Диагональ экрана</td>
                                    <td>${screen.diagonal}"</td>
                                </tr>

                                <tr>
                                    <td>Разрешение экрана</td>
                                    <td>${screen.resolution}</td>
                                </tr>

                                <tr>
                                    <td>Технология экрана</td>
                                    <td>${screen.technologi}</td>
                                </tr>

                                <tr>
                                    <td>Поверхность экрана</td>
                                    <td>${screen.d3Screen}</td>
                                </tr>

                                <tr>
                                    <td>Сенсорный экран</td>
                                    <c:choose>
                                        <c:when test="${screen.sensonal eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Поддержка ввода пером</td>
                                    <c:choose>
                                        <c:when test="${screen.penInput eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>3D-экран</td>
                                    <c:choose>
                                        <c:when test="${screen.d3Screen eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Ударопрочность</td>
                                    <c:choose>
                                        <c:when test="${screen.impactResistance eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>


                                <tr>
                                    <th width="50%">Оперативная память</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Тип оперативной памяти</td>
                                    <td>${ram.type}</td>
                                </tr>

                                <tr>
                                    <td>Объём памяти</td>
                                    <td>${ram.volume} Г</td>
                                </tr>


                                <tr>
                                    <th width="50%">Хранение данных</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Конфигурация накопителя</td>
                                    <td>${data.configuration}</td>
                                </tr>

                                <tr>
                                    <td>Тип накопителя</td>
                                    <td>${data.type}</td>
                                </tr>

                                <tr>
                                    <td>Ёмкость накопителя</td>
                                    <td>${data.volume} ГБ</td>
                                </tr>


                                <tr>
                                    <td>Оптический привод (ODD)</td>
                                    <c:choose>
                                        <c:when test="${data.optical eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Карты памяти</td>
                                    <c:choose>
                                        <c:when test="${data.memoryCard eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <th width="50%">Графика</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Графический адаптер</td>
                                    <td>${graphics.adapter}</td>
                                </tr>

                                <tr>
                                    <td>Тип графического адаптера</td>
                                    <td>${graphics.type}</td>
                                </tr>

                                <tr>
                                    <td>Объем</td>
                                    <td>${graphics.volume} ГБ</td>
                                </tr>

                                <tr>
                                    <th width="50%">Камера и звук</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Встроенная камера</td>
                                    <c:choose>
                                        <c:when test="${camera.camera eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Встроенный микрофон</td>
                                    <c:choose>
                                        <c:when test="${camera.microphone eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Количество пикселей камеры</td>
                                    <td>${camera.pixel} Мп</td>
                                </tr>

                                <tr>
                                    <td>Встроенные динамики</td>
                                    <td>${camera.dinamics}</td>
                                </tr>

                                <tr>
                                <th width="50%">Клавиатура и тачпад</th>
                                <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Цифровое поле (Numpad)</td>
                                    <c:choose>
                                        <c:when test="${keyboard.numpad eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Подсветка клавиатуры</td>
                                    <c:choose>
                                        <c:when test="${keyboard.backlight eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Заводская «кириллица» на клавишах</td>
                                    <c:choose>
                                        <c:when test="${keyboard.kirilitca eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Управление курсором</td>
                                    <td>${keyboard.touchpad}</td>
                                </tr>

                                <tr>
                                    <td>Мультимедийная сенсорная панель</td>
                                    <c:choose>
                                        <c:when test="${keyboard.multimediaPannel eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <th width="50%">Функции</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Сканер отпечатков пальцев</td>
                                    <c:choose>
                                        <c:when test="${function.scaner eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>


                                <tr>
                                    <th width="50%">Интерфейсы</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>NFC</td>
                                    <c:choose>
                                    <c:when test="${interfac.nfc eq 1}">
                                        <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                    </c:otherwise>
                                </c:choose>
                                </tr>

                                <tr>
                                    <td>Bluetooth</td>
                                    <td>${interfac.bluetooth}</td>
                                </tr>

                                <tr>
                                    <td>LAN</td>
                                    <c:choose>
                                        <c:when test="${interfac.lan eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Wi-Fi</td>
                                    <td>${interfac.wifi}</td>
                                </tr>

                                <tr>
                                    <td>Сотовая связь</td>
                                    <c:choose>
                                        <c:when test="${interfac.mobile eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Всего USB-портов</td>
                                    <td>${interfac.usbPort}</td>
                                </tr>

                                <tr>
                                    <td>USB 2.0</td>
                                    <td>${interfac.usb2}</td>
                                </tr>

                                <tr>
                                    <td>USB 3.0</td>
                                    <td>${interfac.usb3}</td>
                                </tr>

                                <tr>
                                    <td>USB 3.1 Type-A</td>
                                    <td>${interfac.usb31A}</td>
                                </tr>

                                <tr>
                                    <td>USB 3.1 Type-C</td>
                                    <td>${interfac.usb31C}</td>
                                </tr>

                                <tr>
                                    <td>VGA (RGB)</td>
                                    <c:choose>
                                        <c:when test="${interfac.vga eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>HDMI</td>
                                    <c:choose>
                                        <c:when test="${interfac.hdmi eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>DisplayPort</td>
                                    <c:choose>
                                        <c:when test="${interfac.displayPort eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Thunderbolt</td>
                                    <c:choose>
                                        <c:when test="${interfac.thounderbolt eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Аудио выходы (3.5 мм jack)</td>
                                    <c:choose>
                                        <c:when test="${interfac.jack eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <th width="50%">Аккумулятор и время работы</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Количество ячеек аккумулятора</td>
                                    <td>${battery.cell}</td>
                                </tr>

                                <tr>
                                    <td>Запас энергии</td>
                                    <td>${battery.energy} Вт·ч</td>
                                </tr>

                                <tr>
                                    <td>Время работы</td>
                                    <td>${battery.time} ч</td>
                                </tr>


                                <tr>
                                    <th width="50%">Комплектация</th>
                                    <th width="50%"></th>
                                </tr>

                                <tr>
                                    <td>Комплект поставки</td>
                                    <td>${complectation.complect}</td>
                                </tr>

                                <tr>
                                    <td>Вторая батарея</td>
                                    <c:choose>
                                        <c:when test="${complectation.batary2 eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Мышь</td>
                                    <c:choose>
                                        <c:when test="${complectation.mouse eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>

                                <tr>
                                    <td>Сумка или чехол</td>
                                    <c:choose>
                                        <c:when test="${complectation.bagCase eq 1}">
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/checkmark.png"></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><img class="small" src="${pageContext.request.contextPath}/resources/images/no-translate-detected_318-32569.jpg"></td>
                                        </c:otherwise>
                                    </c:choose>
                                </tr>





                            </table>




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
