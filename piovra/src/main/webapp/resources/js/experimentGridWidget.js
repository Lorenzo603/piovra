var ExperimentGridWidget = {

    init: function() {
        this.restoreCollapsibleState();
        this.bindUIActions();
    },

    bindUIActions: function() {
        $('#expand-all-button').click(
            function() {
                $('.factor-item-levels').collapse('show');
                ExperimentGridWidget.saveAllCollapsibleStates();
            }
        );

        $('#collapse-all-button').click(
            function() {
                $('.factor-item-levels').collapse('hide');
                ExperimentGridWidget.saveAllCollapsibleStates();
            }
        );

        $('.factor-item-levels').on('shown.bs.collapse', ExperimentGridWidget.saveAllCollapsibleStates);
        $('.factor-item-levels').on('hidden.bs.collapse', ExperimentGridWidget.saveAllCollapsibleStates);

        $('.factor-item-name').click(
            function() {
              $(this).addClass("hidden").siblings("form").children(".input-group").removeClass("hidden").children("input").val($(this).text());
            }
        );

        $('.factor-item > form .cancel-action').click(
            function() {
              $(this).parent().addClass("hidden").parent().siblings("span").removeClass("hidden");
            }
        );

        $('.factor-item-actions form a').click(
            function(e) {
                e.preventDefault();
                $('#'+$(this).attr("id").replace("-submit", "")).submit();
            }
        );

        $('.level-item-name').click(
            function() {
              $(this).addClass("hidden").siblings("form").children(".input-group").removeClass("hidden").children("input").val($(this).text());
            }
        );

        $('.level-item form .cancel-action').click(
            function() {
              $(this).parent().addClass("hidden").parent().siblings("span").removeClass("hidden");
            }
        );

        $('.level-item-actions form a').click(
            function(e) {
                e.preventDefault();
                $('#'+$(this).attr("id").replace("-submit", "")).submit();
            }
        );







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

        $('.add-factor-row .add-button').click(ExperimentGridWidget.addFactor);

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

    saveAllCollapsibleStates: function() {
        $('.accordion-toggle').each(function(){
            ExperimentGridWidget.saveCollapsibleState($(this));
        });
    },

    saveCollapsibleState: function(element) {
        var elementId = element.attr('href');
        var collapsed = element.hasClass('collapsed');
        Cookies.set(elementId, collapsed);
    },

    restoreCollapsibleState: function() {
        $('.accordion-toggle').each(
            function() {
                var elementId = $(this).attr('href');
                var collapsed = Cookies.get(elementId);
                if (collapsed == "true") {
                    $(elementId).collapse('hide');
                } else {
                    $(elementId).collapse('show');
                }
            }
        );
    }
    
}