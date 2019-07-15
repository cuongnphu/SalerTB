var orderScript = {
    orderFormValidate: function () {
        var nameTable = document.getElementById('nameOrder').value;

        if(nameTable == ""){
            document.getElementById('nameOrder').style.borderColor = "red";
            return false;
        }else
            document.getElementById('nameOrder').style.borderColor = "";

    },
    printDiv:function () {
        var printContents = document.getElementById('printDiv').innerHTML;
        var originalContents = document.body.innerHTML;

        document.body.innerHTML = printContents;
        window.print();

        document.body.innerHTML = originalContents;
    }
};

