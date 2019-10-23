var selectedRow = null;

function onFormSubmit(){
    var formData = readFormData();
    if (selectedRow == null)
        insertNewRecord(formData);
        else
        updateRecord(formData);

    resetForm()
}

function readFormData(){
    var formData = {};
    formData["className"] = document.getElementById("className").value;
    formData["classTime"] = document.getElementById("classTime").value;
    formData["professor"] = document.getElementById("professor").value;
    formData["information"] = document.getElementById("information").value;
    return formData;
}

function insertNewRecord(data){
    var table = document.getElementById("classList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.legnth);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.className;
    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.classTime;
    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.professor;
    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.information;
    cell4 = newRow.insertCell(4);
    cell4.innerHTML = `<a onClick="onEdit(this)">Edit</a>
                       <a onClick="onDelete(this)">Delete</a>`;
}

function resetForm(){
    document.getElementById("className").value = "";
    document.getElementById("classTime").value = "";
    document.getElementById("professor").value = "";
    document.getElementById("information").value = "";
    selectedRow = null;
}

function onEdit(td){
    selectedRow = td.parentElement.parentElement;
    document.getElementById("className").value = selectedRow.cells[0].innerHTML;
    document.getElementById("classTime").value = selectedRow.cells[1].innerHTML;
    document.getElementById("professor").value = selectedRow.cells[2].innerHTML;
    document.getElementById("information").value = selectedRow.cells[3].innerHTML;
}

function updateRecord(formData){
    selectedRow.cells[0].innerHTML = formData.className;
    selectedRow.cells[1].innerHTML = formData.classTime;
    selectedRow.cells[2].innerHTML = formData.professor;
    selectedRow.cells[3].innerHTML = formData.information;
}

function onDelete(td){
    if(confirm('Are you sure to delete this class?'))
        row = td.parentElement.parentElement;
        document.getElementById("classList").deleteRow(row.rowIndex);
        resetForm();
}