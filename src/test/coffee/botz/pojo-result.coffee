class Pojo
    setNumber: (number)->
      @number = number
    setString: (string) ->
      @string = string
    getString: ->
      @string
    getNumber: ->
      @number


module.exports = Pojo