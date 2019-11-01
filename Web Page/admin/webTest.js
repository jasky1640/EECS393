// app.test.js

var app = require('../script.js');
var assert = require('assert');   // use Node.js itself assert module

describe('test functions in script.js', function() {
  it('The output data should the same as the input data', function() {
	assert.equal(readFormData(),{"className":"testClassName","classTime":"testClassTime","professor":"testProfessor","information":"testInformation"});
  });
  it('After the insertion of new record there should be a new row', () => {
	assert.equal(insertNewRecord(), {"before_insert":0,"after_insert":1});
  });
   it('The data should be clear after reset', () => {
	assert.equal(insertNewRecord(), {"className":"","classTime":"","professor":"","information":""}));
  });
   it('The data should be changed', () => {
	assert.equal(onEdit(1), {"className":"onEditClassName","classTime":"onEditClassTime","professor":"onEditProfessor","information":"onEditInformation"}));
  });
  it('It will update the new information of the data', () => {
	assert.equal(updateRecord(), {"className":"afterUpdateClassName","classTime":"afterUpdateClassTime","professor":"afterUpdateProfessor","information":"afterUpdateInformation"}));
  });
  


});