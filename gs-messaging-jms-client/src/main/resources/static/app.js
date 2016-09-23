var app = app || {};

$(window).on('load', function () {

    app.order = {
        items: [],
    };
    app.items = [];

    getItems();
    listarOrder();
});

function getItems () {
    $.get("/items", function(data, status){
        app.items = data;
        renderItems(data)
    });
}

function renderItems(items) {
    var templateList = $('#item-list').html();
    var templateItem = $('#item').html();
    Mustache.parse(templateList);
    var viewObject = {
        items: items
    };
    var rendered = Mustache.render(templateList, viewObject, {item: templateItem});
    $('#item-list-container').html(rendered);
}

function findItem(id) {
    var res = {};
    app.items.forEach(function(item) {
        if (item.id === id) {
           res = item;
        }
    });
    return res;
}

function agregarCarrito(prodId) {
    console.log(prodId);

    var cantProd = parseInt($("#cantidad-prod-" + prodId).val())

    var item = findItem(prodId);

    if (!item) {
        alert('item no encontrado')
    } else {
        //No contempla items repetidos (ya agregados)
        item.cantidad = cantProd;
        app.order.items.push(item);
    }

    console.log(app.order);
    listarOrder();
    calcularTotal();
}

function listarOrder() {
    var templateOrderList = $('#order-list').html();
    var templateItemRow = $('#item-table-row').html();
    Mustache.parse(templateOrderList);
    var viewObject = {
        orderItems: app.order.items
    };
    var rendered = Mustache.render(templateOrderList, viewObject, {orderItem: templateItemRow});
    $('#order-list-container').html(rendered);
}

function resetOrder() {
    app.order = {};
}

function calcularTotal() {
    var total = 0;

    app.order.items.forEach(function(item){
        total += item.precio * item.cantidad
    })

    $('#precioTotal').val(total)
    return total;
}

function confirmarOrden() {

    app.order.id = Date.now();
    app.order.fechaCreacion = new Date();
    app.order.idCliente = parseInt($('#user-id').val());
    app.order.formaPago = $("#formaPago").val();
    app.order.facturacion = {
        moneda : parseInt($("#moneda").val()),
        cuotas : parseInt($("#payments").val())
    };


    console.log('SUBMIT ORDER', app.order);

    $.ajax({
        url:'orden',
        type:"POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(app.order),
        async: false,
        cache: false,
        processData:false,
        success: function(resposeJsonObject){
            alert('ORDER CREADA!');
            console.log(resposeJsonObject)
        }
    });
};