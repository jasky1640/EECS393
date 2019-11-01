
var script = require('../script.js');
var assert = require('assert');   // use Node.js itself assert module

describe('test onFormSubmit function in script.js', function() {
  it('Should call resetForm function', function() {
    assert.equal(script(), resetForm());
  });
});