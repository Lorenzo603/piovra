var ExperimentResultWidget = {

    init: function() {
        this.initDataTable();
    },

    initDataTable: function() {

        $.ajax(
            {
                url: window.location + "Ajax",
                dataType: "json",
                success: function(response) {
                    var tableData = response.cases;

                    $('#casesTable').DataTable( {
                        data: tableData,
                        paging: false
                    } );

                    // select rows
                    $('#casesTable tbody').on( 'click', 'tr', function () {
                        $(this).toggleClass('active');
                    } );

                }
            }
        );


    }

}