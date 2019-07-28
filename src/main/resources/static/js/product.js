var productScript = {
    productValidateForm: function () {
        var priceProd = $("#myProduct  > tr.tb-row > td > input[id*=price]");
        var quantityProd = $("#myProduct  > tr.tb-row > td > input[id*=quantity]");

        /*Case: Check default when not input data*/
        for (var i = 0; i < priceProd.length; i++) {
            if (isNaN(quantityProd.get(i).value) || quantityProd.get(i).value <= 0 || quantityProd.get(i).value == "") {
                quantityProd.get(i).style.borderColor = "red";
                return false;
            } else
                quantityProd.get(i).style.borderColor = "";

            if (isNaN(priceProd.get(i).value) || priceProd.get(i).value <= 0 || priceProd.get(i).value == "") {
                priceProd.get(i).style.borderColor = "red";
                return false;
            } else
                priceProd.get(i).style.borderColor = "";
        }
    },

    productConfirmDelete: function (id) {
        if(confirm("BẠN thật sự muốn XÓA Nhập Hàng này ??? ") == true)
            window.location.replace("/deleteproduct/"+id);
    },
};

$(document).ready(function () {
    $("#alphabetTeamId").change(function () {
        var team_id = $("#alphabetTeamId").val();
        window.location.replace('/product?teamId=' + team_id);
    });
})