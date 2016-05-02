var factor-index-prefix = "li-factor-";
var level-index-prefix = "div-level-";

var ExperimentGridWidget = {

    init: function() {
        this.bindUIActions();
        this.addFactorItem(0);
    },

    bindUIActions: function() {
        $('.add-factor-button').click(
            function() {
                this.
                $('#factor-list li div.factor-item').last().removeClass('hidden');
                ExperimentGridWidget.addFactorItem();
            }
        );
        $('.save-factor-button').click(
            function(e) {
                e.preventDefault();
                $.ajax(
                {
                    type: "POST",
                    url: "save-factor",
                    data: {factorName: $('input[name="factorName"]').val()},
                    success: function(data) {
                        console.log("save-factor call finished with succecss");
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

    addFactorItem: function(factorIndex) {
        var levelTemplate = "";
        $.get("resources/templates/levelTemplate.html", function(partialTemplate) {
            levelTemplate = partialTemplate;
            $.get("resources/templates/factorTemplate.html", function(template) {
                $('#factor-list').append(Mustache.render(template,{factorIndex: factorIndex}, {levelTemplate: Mustache.render(levelTemplate,{levelIndex: 0})}));
            });
        });
    },

    addLevelItem: function(factorIndex) {
        $.get("resources/templates/levelTemplate.html", function(template) {
            $('#factor-list li').eq(factorIndex).append(Mustache.render(template));
        });
    }
    
}