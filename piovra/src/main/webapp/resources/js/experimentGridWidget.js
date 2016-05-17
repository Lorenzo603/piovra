var ExperimentGridWidget = {

    init: function() {
        this.bindUIActions();
    },

    bindUIActions: function() {
        $('.add-factor-button').click(function(e) {
            var addedFactor = ExperimentGridWidget.addFactor(e);
            ExperimentGridWidget.addFactorElement($('li list-group-item').length, addedFactor);
        });
        $('.save-factor-button').click(
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
        $('.add-level-button').click(
            function() {
                $('#factor-list li div.level-item').last().removeClass('hidden');
                ExperimentGridWidget.addLevelItem();
            }
        );
    },

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

    addLevelItem: function(factorIndex) {
        $.get("resources/templates/levelTemplate.html", function(template) {
            $('#factor-list li').eq(factorIndex).append(Mustache.render(template));
        });
    }
    
}