var app = app || {};

$(window).on('load', function () {
    getItems();
});

function getItems () {
    $.get("/items", function(data, status){
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


