chai = require 'chai'
chai.should()

describe "Pojo", ->
    Pojo = null
    myPojo = null

    before ->
        Pojo = require './resources/pojo-result'
        myPojo = new Pojo

    describe "Instance methods", ->
        it "has a method called setNumber", ->
            myPojo.should.respondTo 'setNumber'

        it "has a method called setString", ->
            myPojo.should.respondTo 'setString'

        it "has a method called getNumber", ->
            myPojo.should.respondTo 'getNumber'

        it "has a method called getString", ->
            myPojo.should.respondTo 'getString'

    describe "Functionality", ->
        it "sets the number to two", ->
            myPojo.setNumber 2
            myPojo.getNumber().should.equal 2

        it "sets the string to 'gal hagever'", ->
            myPojo.setString 'gal hagever'
            myPojo.getString().should.equal 'gal hagever'