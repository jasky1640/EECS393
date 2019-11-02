var assert = require('chai').assert;
var script = require('../admin/script');

describe('First function', function(){
    it('should use the function resetForm in the end', function(){
        assert.equal(script(), resetForm());
    })
})
