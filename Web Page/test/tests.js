var should = chai.should();

describe("The test of admin page", function () {
    it("Testing the submition of the new data", function () {
        // submit
        document.getElementById("className").value = "1";
        document.getElementById("classTime").value = "2";
        document.getElementById("professor").value = "3";
        document.getElementById("information").value = "4";
        onFormSubmit();
        let row = document.getElementById("tableBody").children[0];
        should.equal(row.children[0].innerHTML, "1");
        should.equal(row.children[1].innerHTML, "2");
        should.equal(row.children[2].innerHTML, "3");
        should.equal(row.children[3].innerHTML, "4");
        should.equal(document.getElementById("className").value, "");
        should.equal(document.getElementById("classTime").value, "");
        should.equal(document.getElementById("professor").value, "");
        should.equal(document.getElementById("information").value, "");
        // edit
        onEdit(row.children[4].children[0]);
        document.getElementById("className").value = "4";
        document.getElementById("classTime").value = "3";
        document.getElementById("professor").value = "2";
        document.getElementById("information").value = "1";
        onFormSubmit();
        row = document.getElementById("tableBody").children[0];
        should.equal(row.children[0].innerHTML, "4");
        should.equal(row.children[1].innerHTML, "3");
        should.equal(row.children[2].innerHTML, "2");
        should.equal(row.children[3].innerHTML, "1");
        should.equal(document.getElementById("className").value, "");
        should.equal(document.getElementById("classTime").value, "");
        should.equal(document.getElementById("professor").value, "");
        should.equal(document.getElementById("information").value, "");
    });

    it("Testing the reading of the data", function () {
        document.getElementById("className").value = "1";
        document.getElementById("classTime").value = "2";
        document.getElementById("professor").value = "3";
        document.getElementById("information").value = "4";
        let temp = readFormData();
        console.log(temp);
        should.equal(temp["className"], "1");
        should.equal(temp["classTime"], "2");
        should.equal(temp["professor"], "3");
        should.equal(temp["information"], "4");
    });

    it("Testing the adding of the data", function () {
        let formData = {};
        formData["className"] = "NewRecord1";
        formData["classTime"] = "NewRecord2";
        formData["professor"] = "NewRecord3";
        formData["information"] = "NewRecord4";
        insertNewRecord(formData);
        let row = document.getElementById("tableBody").children[1];
        should.equal(row.children[0].innerHTML, "NewRecord1");
        should.equal(row.children[1].innerHTML, "NewRecord2");
        should.equal(row.children[2].innerHTML, "NewRecord3");
        should.equal(row.children[3].innerHTML, "NewRecord4");
    });

    it("Testing the reset of the data", function () {
        resetForm();
        should.equal(document.getElementById("className").value, "");
        should.equal(document.getElementById("classTime").value, "");
        should.equal(document.getElementById("professor").value, "");
        should.equal(document.getElementById("information").value, "");
    });

    it("Testing the editing of the data", function () {
        let row = document.getElementById("tableBody").children[1];
        onEdit(row.children[4].children[0]);
        should.equal(document.getElementById("className").value, "NewRecord1");
        should.equal(document.getElementById("classTime").value, "NewRecord2");
        should.equal(document.getElementById("professor").value, "NewRecord3");
        should.equal(document.getElementById("information").value, "NewRecord4");
    });

    it("Testing the updating of the data", function () {
        let formData = {};
        formData["className"] = "NewRecord4";
        formData["classTime"] = "NewRecord3";
        formData["professor"] = "NewRecord2";
        formData["information"] = "NewRecord1";
        updateRecord(formData);
        let row = document.getElementById("tableBody").children[1];
        should.equal(row.children[0].innerHTML, "NewRecord4");
        should.equal(row.children[1].innerHTML, "NewRecord3");
        should.equal(row.children[2].innerHTML, "NewRecord2");
        should.equal(row.children[3].innerHTML, "NewRecord1");
    });

    it("Teseting the deleting of the data", function () {
        let row = document.getElementById("tableBody").children[1];
        let temp = window.confirm
        window.confirm=function(){return true}
        onDelete(row.children[4].children[1]);
        should.equal(document.getElementById("tableBody").children[1], undefined);
        row = document.getElementById("tableBody").children[0];
        window.confirm=function(){return false}
        onDelete(row.children[4].children[1]);
        should.not.equal(document.getElementById("tableBody").children[0], undefined);
        window.confirm=temp
    });
})