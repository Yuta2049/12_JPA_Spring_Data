$('.buttonProductEdit').on('click', function() {

    $('#newProductSave').hide();
    $('#editProductSave').show();

    var productId = this.dataset.productId;

        $.ajax({
            url : '/products/'+productId+'/edit',
            success : function(data) {
                /*$('#result').html(data);*/
                /*$("#ProductWindow").load("/fragments/createOrUpdateProductForm");*/
                $("#editProductId").val(data.id);
                $("#editProductName").val(data.name);
                //$("#editProductCategory").val(data.category);
                $("#editProductCategoryId").val(data.category.id);
                $("#editProductCategoryName").val(data.category.name);
                $("#editProductPrice").val(data.price);
                $("#editProductImage").val(data.image);
            }
        });

    })

$('#editProductSave').on('click', function() {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    var productId = $("#editProductId").val();
    var productName = $("#editProductName").val();
//    var productCategory = $("#editProductCategory").val();
    var productCategoryId = $("#editProductCategoryId").val();
    var productCategoryName = $("#editProductCategoryName").val();
    var productPrice = $("#editProductPrice").val();
    var productImage = $("#editProductImage").val();

    var productCategory = {id : productCategoryId,
                    name : productCategoryName}

    var product = {id : productId,
                  name : productName,
                  category : productCategory,
                  price : productPrice,
                  image : productImage};

    var url = '/products/'+productId+'/edit';

        $.ajax({
            contentType: 'application/json',
            url : url,
            type : 'put',
            dataType: 'json',
            data : JSON.stringify(product),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success : function(data) {
                /*console.log(data);
                $("#searchItems").load(url);*/
                location.reload();
            },
            error : function() {
                console.log("There was an error");
            }
        });
    })


$('#buttonProductNew').on('click', function() {
    $('#newProductSave').show();
    $('#editProductSave').hide();
    })

$('#newProductSave').on('click', function() {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    var productId = $("#editProductId").val();
    var productName = $("#editProductName").val();
    var productCategory = $("#editProductCategory").val();
    var productPrice = $("#editProductPrice").val();
    var productImage = $("#editProductImage").val();

    var product = {id : productId,
                  name : productName,
                  category : productCategory,
                  price : productPrice,
                  image : productImage};

    var url = '/products/new';

        $.ajax({
            contentType: 'application/json',
            url : url,
            type : 'post',
            dataType: 'json',
            data : JSON.stringify(product),
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success : function(data) {
                location.reload();
            },
            error : function() {
                alert('create product not successful');
            }
        });
    })


$('.buttonProductDelete').on('click', function() {

    var token = $('#_csrf').attr('content');
    var header = $('#_csrf_header').attr('content');

    var productId = this.dataset.productId;

    url = '/products/'+productId+'/delete';

        $.ajax({
            contentType: 'application/json',
            url : url,
            type : "delete",
            dataType: 'json',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success : function(data) {
                location.reload();
            },
            error : function() {
                alert('delete not successful');
            }
        });
})

//function showHiddenTab() {
$('.visibleSection').on('click', function() {
    var i, x;
    var productId = this.dataset.productId;

    var visibleSection = document.getElementById('b'+productId);

    $('#'+'b'+productId).hide();

    var hiddenSection = document.getElementById('c'+productId);
    hiddenSection.style.display = "flex";

    var productSection = document.getElementById('a'+productId);
    productSection.style.width = '100%';

    // Закрываем другие скрытые секции
    x = document.getElementsByClassName("visibleSection");
    for (i = 0; i < x.length; i++) {
        if (x[i] != visibleSection) {
            x[i].removeAttribute('style');
        }
    }

    x = document.getElementsByClassName("hiddenSection");
    for (i = 0; i < x.length; i++) {
        if (x[i] != hiddenSection) {
            x[i].removeAttribute('style');
        }
    }

    var x2 = document.getElementsByClassName("product");
    for (i = 0; i < x2.length; i++) {
        if (x2[i] != productSection) {
            //x2[i].style.flexBasis = '';
            x2[i].removeAttribute('style');
        }
    }
})

//function hideHiddenTab(productSectionName, tabName, tabName2) {
$('.hiddenSection').on('click', function() {
    var productId = this.dataset.productId;

    $('#'+'b'+productId).show();

    var hiddenSection = document.getElementById('c'+productId);
    hiddenSection.removeAttribute('style');

    var productSection = document.getElementById('a'+productId);
    productSection.removeAttribute('style');
})


