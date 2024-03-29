var bill_count = 0;
var index = 0;

function addBill(orderId, intIndex) {
    index = intIndex + bill_count;
    var tbody = document.getElementById("myBill");
    var tr = document.createElement("tr");
    tr.className = "tb-row";
    tr.id = index;
    var td1 = document.createElement("td");
    var td2 = document.createElement("td");
    var td3 = document.createElement("td");
    var td4 = document.createElement("td");

    // Initialize variable Id
    var inputid = document.createElement("input");
    inputid.id = "billList" + index + ".id";
    inputid.type = "text";
    inputid.name = "billList[" + index + "].id";
    inputid.readOnly = "true";
    inputid.hidden = "true";
    inputid.setAttribute('value', "0");

    // Initialize variable orderId
    var inputorderid = document.createElement("input");
    inputorderid.id = "billList" + index + ".orderId";
    inputorderid.type = "text";
    inputorderid.name = "billList[" + index + "].orderId";
    inputorderid.readOnly = "true";
    inputorderid.hidden = "true";
    inputorderid.setAttribute('value', orderId.toString());

    // Initialize variable price
    var inputPrice = document.createElement("input");
    inputPrice.id = "billList" + index + ".price";
    inputPrice.type = "text";
    inputPrice.name = "billList[" + index + "].price";

    // Initialize variable Quantity
    var inputQuantity = document.createElement("input");
    inputQuantity.id = "billList" + index + ".quantity";
    inputQuantity.type = "text";
    inputQuantity.name = "billList[" + index + "].quantity";

    // Initialize variable index
    var labelIndex = document.createElement("a");
    labelIndex.innerText = index;

    // Add variable to div
    td1.appendChild(inputid);
    td1.appendChild(inputorderid);
    td1.appendChild(labelIndex);
    td2.appendChild(inputQuantity);
    td3.appendChild(inputPrice);
    var a = document.createElement("a");
    a.className = "btn-danger btn-xs";
    a.innerText = "-";
    a.onclick = function (ev) {
        a.parentNode.parentNode.parentNode.removeChild(a.parentNode.parentNode);
    };
    td4.appendChild(a);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tbody.appendChild(tr);
    bill_count++;
}

var billScript = {
    editOrderValidateForm: function () {
        var nameTests = document.getElementById('nameOrder').value;
        var priceBill = $("#myBill > tr.tb-row > td > input[id*=price]");
        var quantityBill = $("#myBill > tr.tb-row > td > input[id*=quantity]");

        /*Case: Name Order is Incorrectly*/
        if(nameTests == "") {
            document.getElementById('nameOrder').style.borderColor = "red";
            return false;
        } else
            document.getElementById('nameOrder').style.borderColor = "";

        /*Case: Click button Hoàn Thành without input data in index 1*/
        if (isNaN(quantityBill.get(0).value) || quantityBill.get(0).value <= 0 || quantityBill.get(0).value == "") {
            quantityBill.get(0).style.borderColor = "red";
            return false;
        } else
            quantityBill.get(0).style.borderColor = "";

        if (isNaN(priceBill.get(0).value) || priceBill.get(0).value <= 0 || priceBill.get(0).value == "") {
            priceBill.get(0).style.borderColor = "red";
            return false;
        } else
            priceBill.get(0).style.borderColor = "";

        /*Case: Check default when not input data*/
        for (var i = 0; i < priceBill.length; i++) {
            if (isNaN(quantityBill.get(i).value) || quantityBill.get(i).value < 0 || quantityBill.get(i).value == "") {
                quantityBill.get(i).style.borderColor = "red";
                return false;
            } else
                quantityBill.get(i).style.borderColor = "";

            if (isNaN(priceBill.get(i).value) || priceBill.get(i).value < 0 || priceBill.get(i).value == "") {
                priceBill.get(i).style.borderColor = "red";
                return false;
            } else
                priceBill.get(i).style.borderColor = "";
        }

    }

};









