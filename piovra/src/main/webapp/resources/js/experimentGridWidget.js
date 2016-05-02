var ExperimentGridWidget = {
    
    init: function() {
        this.bindUIActions();
        this.addFactorItem();
    },

    bindUIActions: function() {
        $('.add-factor-button').click(
            function() {
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
                $('#factor-list').find('li div.level-item').removeClass('hidden');
                ExperimentGridWidget.addLevelItem();
            }
        );
    },

    addFactorItem: function() {
        $.get("resources/templates/factorTemplate.html", function(template) {
            $('#factor-list').append(Mustache.render(template));
        });
    },

    addLevelItem: function(factorIndex) {
        $.get("resources/templates/levelTemplate.html", function(template) {
            $('#factor-list li').eq(factorIndex).append(Mustache.render(template));
        });
    }
    
}