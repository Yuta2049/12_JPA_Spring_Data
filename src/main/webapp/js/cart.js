var itemCount = 0;
var priceTotal = 0;

$('.openCloseCart').on('click', function() {
    $('#shoppingCart').toggle();

//        if (findText != '') {

            var token = $('#_csrf').attr('content');
            var header = $('#_csrf_header').attr('content');

                $.ajax({
                    url : "/cart",
                    type : "get",
                    //data : {
                    //    "productName" : findText
                    //},
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader(header, token);
                    },
                    success : function(data) {
                        showProductsInTheCart(data);
                    },
                    error : function() {
                        alert("There was an error");
                    }
                });
//            }


})


    function showProductsInTheCart(filteredProducts) {

        var searchItemsDiv = document.getElementById('cartItems');
        $("#cartItems").empty();
        //var textCat = '<ul class="products">';
        //searchItemsDiv.insertAdjacentHTML('beforeEnd', textCat);

        for(var i = 0; i < filteredProducts.length; i++) {

            //var text = '<li class="product">';
            var text = '<div class="hiddenSection" data-roduct-id="'+filteredProducts[i].product.id+'">';
            text += '<div class="image">';
            text += '<img src="images/' + filteredProducts[i].product.image + '">';
            text += '</div>';
            text += '<div class="productName">';
            text += filteredProducts[i].product.name;
            text += '</div>';

            text += '<div class="price">';
            text += filteredProducts[i].product.price;
            text += '</div>';

            text += '<button class="removeItem">X</button>';

            //text += '</li>';
            text += '</div>';

            searchItemsDiv.insertAdjacentHTML('beforeEnd', text);
        }

        //textCat = '</ul>';

        //searchItemsDiv.insertAdjacentHTML('beforeEnd', textCat);
    }


// Добавляем товары в корзину
$('.add').click(function () {

//  itemCount++;
//
//  $('#itemCount').text(itemCount).css('display', 'block');
//  $(this).parent().clone().removeAttr('onclick').appendTo('#cartItems').append('<button class="removeItem">X</button>');
//
//  $('#cartItems').find('.add').remove();
//  $('#cartItems').find('*').removeAttr("id style");
//
//  $('#cartItems').find('.hiddenSection').show();
//
//  calcAmount();

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    var productId = this.dataset.productId;

    url = '/cart/add/'+productId;

        $.ajax({
            contentType: 'application/json',
            url : url,
            type : "PUT",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success : function(data) {
                //location.reload();
            },
            error : function() {
                alert('add to cart not successful');
            }
        });
});


// Пересчитываем сумму заказа
function calcAmount() {

  var prices = document.getElementById("cartItemsContainer").getElementsByClassName("price");
  console.log(prices);

  var productsAmount = 0;
  for (let i = 0; i < prices.length; i++) {
    productsAmount += parseInt(prices[i].textContent);
  }

  $('#productsAmount').text(productsAmount + " галактических кредитов");
  var discountSize = parseInt($('#discountSize').text());

  if (isNaN(discountSize)) {
    discountSize = Math.random() * 20;
  }

  $('#discountSize').text(discountSize);
  var discountAmount = productsAmount * discountSize / 100;
  $('#discountAmount').text(discountAmount + " галактических кредитов");
  var productsTotal = productsAmount + discountAmount;
  $('#productsTotal').text(productsTotal + " галактических кредитов");
}

//// Hide and Show Cart Items
//$('.openCloseCart').click(function () {
//  $('#shoppingCart').toggle();
//});


// Очистить корзину (оформить заказ)
//$('#emptyCart').click(function () {
$('#registerOrder').click(function () {
//  itemCount = 0;
//  $('#itemCount').css('display', 'none');
//  $('#cartItems').text('');
//
//  calcAmount();


      var token = $('#_csrf').attr('content');
      var header = $('#_csrf_header').attr('content');

      var productId = this.dataset.productId;

      url = '/orders/add';

          $.ajax({
              contentType: 'application/json',
              url : url,
              type : "PUT",
              dataType: 'json',
              beforeSend: function (xhr) {
                  xhr.setRequestHeader(header, token);
              },
              success : function(data) {
                  //location.reload();
              },
              error : function() {
                  alert('add order not successful');
              }
          });




});


// Удаляем товары из корзины
$('#shoppingCart').on('click', '.removeItem', function () {

  $(this).parent().remove();

  itemCount--;

  $('#itemCount').text(itemCount);

  calcAmount();

  if (itemCount == 0) {
    $('#itemCount').css('display', 'none');
  }
});