var productScript = {
    productValidateForm: function () {
        var nameProd = $("#myProduct > tr.tb-row > td > input[id*=name]");
        var priceProd = $("#myProduct  > tr.tb-row > td > input[id*=price]");
        var quantityProd = $("#myProduct  > tr.tb-row > td > input[id*=quantity]");

        /*Case: Check default when not input data*/
        for (var i = 0; i < priceProd.length; i++) {
            if ( nameProd.get(i).value == "") {
                nameProd.get(i).style.borderColor = "red";
                return false;
            } else
                nameProd.get(i).style.borderColor = "";

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
    }
};