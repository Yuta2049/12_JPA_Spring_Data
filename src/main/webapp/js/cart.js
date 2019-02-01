var itemCount = 0;
var priceTotal = 0;

$('.openCloseCart').on('click', function() {
    $('#shoppingCart').toggle();
})


// Добавляем товары в корзину
$('.add').click(function () {

  itemCount++;

  $('#itemCount').text(itemCount).css('display', 'block');
  $(this).parent().clone().removeAttr('onclick').appendTo('#cartItems').append('<button class="removeItem">X</button>');

  $('#cartItems').find('.add').remove();
  $('#cartItems').find('*').removeAttr("id style");

  $('#cartItems').find('.hiddenSection').show();

  calcAmount();

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
  itemCount = 0;
  //priceTotal = 0;
  $('#itemCount').css('display', 'none');
  $('#cartItems').text('');
  //$('#cartTotal').text("Total: €" + priceTotal);

  calcAmount();

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