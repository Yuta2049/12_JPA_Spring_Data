<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">

    <title>Интернет-магазин "АВРОРА". Самый большой выбор звездолетов и планетарных станций в 9 вселенных. В наличии и под заказ</title>

    <link rel="stylesheet" href="css/style.css" type="text/css">

    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript" src="js/products.js"></script>

    <script type="text/javascript" src="js/users.js"></script>

    <link rel="shortcut icon" href="images/favicon.ico" />

</head>

<body>

    <div id="header">
    </div>

    <div id="main" class="main">

        <div id="shoppingCart">
            <div id="cartItemsContainer">
                <h1>Корзина</h1>
                <b class="openCloseCart" aria-hidden="true">x</b>
                <div id="cartItems"></div>
                <div>Сумма товаров:
                    <span id="productsAmount"></span>
                </div>
                <div>Скидка:
                    <span id="discountSize"></span>%
                    <span id="discountAmount"></span>
                </div>
                <div>Итого:
                    <span id="productsTotal"></span>
                </div>
                <button id="registerOrder">Оформить заказ</button>
            </div>
        </div>

        <div id="searchWindow">
            <div id="searchItemsContainer">
                <h1>Поиск</h1>
                <b class="openCloseSearch" aria-hidden="true">x</b>
                Найти:
                <input id="findText">
                <button id="findProducts" onclick="findProducts()">Найти</button>
                <div id="searchItems"></div>
            </div>
        </div>

            <c:forEach items="${categories}" var="category">

                <div class="category">
                    <H2>${category.name}</H2>
                    <hr>
                </div>


                <ul class="products">

                <c:forEach items="${products}" var="product">

                    <c:if test="${category.id==product.category}">

                        <li class="product" id="a${category.id}${product.id}">

                            <div class="visibleSection" id="b${category.id}${product.id}" onclick="showHiddenTab('a${category.id}${product.id}', 'b${category.id}${product.id}', 'c${category.id}${product.id}');">

                                <div class="image">
                                    <img src="images/${product.image}">
                                </div>


                                <div class="productName">
                                    ${product.name}
                                </div>
                            </div>

                            <div class="hiddenSection" id="c${category.id}${product.id}" onclick="hideHiddenTab('a${category.id}${product.id}', 'b${category.id}${product.id}', 'c${category.id}${product.id}');">

                                <div class="image">
                                    <img src="images/${product.image}">
                                </div>


                                <div class="price">
                                    ${product.price}
                                </div>

                                <button class="add">Да, я хочу этот корабль!</button>

                            </div>

                        </li>
                    </c:if>

                </c:forEach>
                </ul>
            </c:forEach>

    </div>

	<div id="footer">
	</div>

    <script>

        function openClose() {
            $('#shoppingCart').toggle();
        }

    </script>

    <script type="text/javascript" src="js/cart.js"></script>

    <script type="text/javascript" src="js/search.js"></script>

</body>

</html>