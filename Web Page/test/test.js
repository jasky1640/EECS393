var expert = require('chai').expect;
var script = require('../add');


describe('First function', function(){
    context('with string arguments', function(){
        it('should return the string array', function(){
            expect(add("Tom","1230","tom","123")).to.deep.equal("Tom","1230","tom","123");
        })
    })
    
})
