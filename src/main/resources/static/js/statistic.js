var statisticScript = {
    formValidate: function () {
        var fromDate = document.getElementById('fromDate').value;
        var toDate = document.getElementById('toDate').value;

        if(fromDate == "" || toDate == "" ){
            document.getElementById('fromDate').style.borderColor = "red";
            document.getElementById('toDate').style.borderColor = "red";
            return false;
        }else {
            document.getElementById('fromDate').style.borderColor = "";
            document.getElementById('toDate').style.borderColor = "";
        }

    }
};

$(document).ready(function () {
    $("#alphabetTeamId").change(function () {
        var team_id = $("#alphabetTeamId").val();
        window.location.replace('/statisticproduct?teamId=' + team_id +'&teamName=');
    });
})