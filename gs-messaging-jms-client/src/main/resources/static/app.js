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
        item.cantidad = cantProd;
        app.order.items.push(item);
        alert('item ' + prodId + ' agregado al carrito con cantidad ' + cantProd);
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