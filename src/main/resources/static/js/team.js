var checkNameTeam = false;
var teamScript = {
    teamFormValidate: function () {
        var nameTeam = $("#nameTeam");
        var teamId = $("#teamId");

        if(nameTeam.get(0).value == ""){
            nameTeam.get(0).style.borderColor = "red";
            return false;
        }else
            nameTeam.get(0).style.borderColor = "";

        if(checkNameTeam == false){
            nameTeam.get(0).style.borderColor = "red";
            teamId.get(0).style.borderColor = "red";
            return false;
        }else{
            nameTeam.get(0).style.borderColor = "";
            teamId.get(0).style.borderColor = "";
        }
    },
    
    editTeamConfirmOut: function () {
        if (confirm("Bạn muốn thoát ??? ") == true)
            window.location.replace('/teams');
    },
    
    teamFormConfirmDelete: function (id) {
        if(confirm("BẠN thật sự muốn XÓA đội này ??? ") == true)
            window.location.replace("deleteteam/"+id);
    },
    
    teamFormConfirmEdit: function (id) {
        if(confirm("BẠN muốn CẬP NHẬT thông tin đội này ??? ") == true)
            window.location.replace("editteam/"+id);
    }
};

$(document).ready(function () {
    $("#nameTeam").focusout(function () {
        var txtName = $("#nameTeam").val();
        var txtTeamId = $("#teamId").val();
        $.post("/checkteam", {nameCheck: txtName, teamIdCheck: txtTeamId}, function(result){
            checkNameTeam = result;
        });
    });

    $("#teamId").change(function () {
        var txtName = $("#nameTeam").val();
        var txtTeamId = $("#teamId").val();
        $.post("/checkteam", {nameCheck: txtName, teamIdCheck: txtTeamId}, function(result){
            checkNameTeam = result;
        });
    });
})


