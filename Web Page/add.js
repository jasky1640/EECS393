module.exports = function() {
    var formData = {};
    formData["className"] = document.getElementById("className").value;
    formData["classTime"] = document.getElementById("classTime").value;
    formData["professor"] = document.getElementById("professor").value;
    formData["information"] = document.getElementById("information").value;
    return formData;
}