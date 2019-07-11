var orderScript = {

    orderFormValidate: function () {
        var nameTable = document.getElementById('nameOrder').value;

        if(nameTable == ""){
            document.getElementById('nameOrder').style.borderColor = "red";
            return false;
        }else
            document.getElementById('nameOrder').style.borderColor = "";

    }
};

