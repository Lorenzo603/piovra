var ExperimentGridWidget = {
    
    init: function() {
        this.bindUIActions();
    },
    
    bindUIActions: function() {
        $('.add-factor-button').click(
            function() {
                $('#factor-list').find('li div.hidden').removeClass('hidden');
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
    }
    
}