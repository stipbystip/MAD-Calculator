package com.example.calculator_v2

class Calculate() {
    val EMPTY_STRING = ""
    val WRONG_FORMAT = "Ошибка Формата"
    val DIV_ZERO = "Деление на 0"


    fun calculate(res: String): String {
        val check_fromat = checkInput(res)
        val check_bracket = checkBracket(res)
        if(check_fromat == EMPTY_STRING && check_bracket){
            val x = splitter(res)
            val arr = infixInPost(x)
            val stack = ArrayDeque<String>()
            for(i in arr){
                if(i !in "+-÷×"){
                    stack.add(i)
                }else{
                    var x1 = stack.removeLast().toDouble()
                    var x2 = stack.removeLast().toDouble()
                    if(i == "+") stack.add((x1+x2).toString())
                    else if(i == "-") stack.add((x2 - x1).toString())
                    else if(i == "×") stack.add((x2 * x1).toString())
                    else if(i == "÷") stack.add((x2 / x1).toString())
                }
            }
            if(stack.size == 1){
                return stack.last()
            }
        }











        return check_fromat
    }

    fun checkBracket(str: String): Boolean {
        val stack = ArrayDeque<Char>()

        for(symbol in str){
            if(symbol == '('){
                stack.addLast(symbol)
            }else if(symbol == ')' && !stack.isEmpty()){
                stack.removeLast()
            }else if(symbol == ')' && stack.isEmpty()){
                return false
            }
        }
        return stack.isEmpty()
    }

    fun splitter(str: String): MutableList<String> {
        val arr: MutableList<String> = mutableListOf()
        var st = ""
        var i = 0
        while(i != str.length-1){
            if(str[i] in "÷×(" && str[i+1] == '-'){
                if(st.length != 0){
                    arr.add(st)
                    st = ""
                }
                st += str[i+1]
                arr.add(str[i].toString())
                i += 2
            }else if(str[i] == '-' && str[i+1] in "0123456789" && i == 0){
                st += str[i]
                st += str[i+1]
                i+=2
            }else if(str[i] in "0123456789."){
                st += str[i]
                i+=1
            }else if(str[i] in "-+÷×()"){
                if(st != ""){arr.add(st)}
                st = ""
                arr.add(str[i].toString())
                i+=1
            }
        }
        if(st != ""){
            if(str[str.length-1] == ')'){
                arr.add(st)
                arr.add(")")
            }else{
                st += str[str.length-1]
                arr.add(st)
            }
        }else{
            arr.add(str[str.length-1].toString())
        }
        return arr
    }

    fun infixInPost(arr: MutableList<String>): MutableList<String> {
        val stack = ArrayDeque<String>()
        val res: MutableList<String> = mutableListOf()
        var i = 0
        while(i < arr.size){
            if(arr[i] !in "+-()÷×"){
                res.add(arr[i])
            }
            if(arr[i] in "+-()÷×" && stack.isEmpty()){
                stack.addFirst(arr.get(i))
            }else if(arr[i] in "+-()÷×" && !stack.isEmpty()){
                if(arr[i] in "÷×"){
                    while(!stack.isEmpty()){
                        if(stack.last() == "×" || stack.last() == "÷"){
                            val t = stack.removeLast()
                            res.add(t)
                        }else break
                    }
                    stack.addLast(arr[i])
                } else if(arr[i] in "+-"){
                    while(!stack.isEmpty()){
                        if(stack.last() != "("){
                            val t = stack.removeLast()
                            res.add(t)
                        }else break
                    }
                    stack.addLast(arr[i])
                }else if(arr[i] == "("){
                    stack.addLast(arr[i])
                } else if(arr[i] == ")"){
                    var r = ""
                    while(r != "("){
                        r = stack.removeLast()
                        if(r !in "()"){
                            res.add(r)
                        }
                    }
                }
            }
            i += 1
        }
        while(!stack.isEmpty()){
            val p = stack.removeLast()
            res.add(p)
        }
        return res
    }

    fun checkInput(str: String): String {
        if(str.length == 0){
            return WRONG_FORMAT
        }
        if(str[0] in "÷×+"){
            return WRONG_FORMAT
        }
        for (i in 0 until str.length - 1) {
            if (str[i] in "(" && str[i + 1] in "÷×+") {
                return WRONG_FORMAT
            }
            if(str[i] in "-÷×+" && str[i+1] in "÷×+"){
                return WRONG_FORMAT
            }
            if (str[i] == '÷' && str[i + 1] == '0') {
                return DIV_ZERO
            }
        }
        return EMPTY_STRING
    }
}