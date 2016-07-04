var ExperimentGridWidget = {

    init: function() {
        this.restoreCollapsibleState();
        this.bindUIActions();
    },

    bindUIActions: function() {
        $('.edit-factor-button').click(
            function(e) {
                e.preventDefault();
                $.ajax(
                {
                    type: "POST",
                    url: "save-factor",
                    data: {factorName: $('input[name="factorName"]').val()},
                    success: function(data) {
                        console.log("save-factor call finished with success");
                        $('#debug').html("factor name is " + data.name);
                    },
                    error: function() {
                        console.log("error in save-factor call");
                    }
                }
                );
                return false;
            }
        );

        $('.accordion-toggle').click(
            function() {
                var cookieId = $(this).attr('href');
                var opened = Cookies.get(cookieId);
                if (opened === undefined) {
                    Cookies.set(cookieId, "true");
                } else {
                    if (opened == "true") {
                        Cookies.set(cookieId, "false");
                    } else {
                        Cookies.set(cookieId, "true");
                    }
                }
            }
        );
    },


    // keep them fo reference
    // TODO write article for moustache js partials

    addFactor: function(e) {
        e.preventDefault();
        console.log("add new factor");
        var addedFactor = null;
        $.ajax({
            type: "POST",
            async: false,
            url: "add-factor",
            data: $('#addFactorForm').serializeArray(),
            success: function(data) {
                console.log("add new factor - SUCCESS");
                addedFactor = data;
            }
        });
        return addedFactor;
    },

    addFactorElement: function(factorIndex, factorData) {
        var levelTemplate = "";
        $.get("resources/templates/levelTemplate.html", function(partialTemplate) {
            levelTemplate = partialTemplate;
            $.get("resources/templates/factorTemplate.html", function(template) {
                $('#factor-list').append(Mustache.render(template,{factorIndex: factorIndex, factorName: factorData.name}, {levelTemplate: Mustache.render(levelTemplate,{levelIndex: 0})}));
            });
        });
    },

    restoreCollapsibleState: function() {
        $('.accordion-toggle').each(
            function() {
                var elementId = $(this).attr('href');
                var opened = Cookies.get(elementId);
                if (opened == "true") {
                    $(elementId).collapse();
                }
            }
        );
    }
    
}