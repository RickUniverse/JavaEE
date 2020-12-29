

function sum(num1, num2) {
    var result = 0;
    for (var i = 0; i < arguments.length; i++) {
        if (typeof (arguments[i]) == "number") {
            result = arguments[i] + result;
        }
    }
    return result;
}

alert(sum(1,2,3,4,5,6,"234"));