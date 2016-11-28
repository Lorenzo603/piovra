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



                    $('input[type="checkbox"]').change(
                    function() {
                            var caseIndex = $(this).attr('id').split("-")[2];
                            if (this.checked) {
                                $('#tr-case-'+caseIndex).addClass('case-considered');
                            } else {
                                $('#tr-case-'+caseIndex).removeClass('case-considered');
                            }
                        }
                    );



                }
            }
        );


    }

}