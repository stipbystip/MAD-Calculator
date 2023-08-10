package com.example.calculator_v2

object Display {
    var res: String = ""
    var dot = 1
    fun getOne(): String {
        res = res + "1"
        return res
    }

    fun getTwo(): String {
        res = res + "2"
        return res
    }

    fun getThree(): String {
        res = res + "3"
        return res
    }

    fun getFour(): String {
        res = res + "4"
        return res
    }

    fun getFive(): String {
        res = res + "5"
        return res
    }

    fun getSix(): String {
        res = res + "6"
        return res
    }

    fun getSeven(): String {
        res = res + "7"
        return res
    }

    fun getEight(): String {
        res = res + "8"
        return res
    }

    fun getNine(): String {
        res = res + "9"
        return res
    }

    fun getZero(): String {
        res = res + "0"
        return res
    }

    fun getDel(): String {
        if (res.length != 0) {
            if (res[res.length - 1] == '.') {
                dot = 1
            }
            if (res[res.length - 1] in "+-÷×") {
                dot = 0
            }
            var copy_res = ""
            for (i in 0 until res.length - 1) {
                copy_res += res[i]
            }
            res = copy_res
            return res
        }
        return res
    }

    fun getAC(): String {
        dot = 1
        res = ""
        return res
    }

    fun getPlus(): String {
        dot = 1
        if (res.length == 0) {
            return res
        } else if (res[res.length - 1] in "-÷×+") {
            var copy_res = ""
            for (i in 0 until res.length - 1) {
                copy_res += res[i]
            }
            res = copy_res + "+"
            return res
        } else if (res[res.length - 1] in "(.") {
            return res
        }
        res = res + "+"
        return res
    }

    fun getMinus(): String {
        dot = 1
        if (res.length != 0) {
            if (res[res.length - 1] == '-') {
                var copy_res = ""
                for (i in 0 until res.length - 1) {
                    copy_res += res[i]
                }
                res = copy_res + "+"
                return res
            } else if (res[res.length - 1] == '+') {
                var copy_res = ""
                for (i in 0 until res.length - 1) {
                    copy_res += res[i]
                }
                res = copy_res + "-"
                return res
            } else if (res[res.length - 1] == '.') {
                return res
            }
        }
        res = res + "-"
        return res
    }

    fun getMult(): String {
        dot = 1
        if (res.length == 0) {
            return res
        } else if (res[res.length - 1] in "-÷×+") {
            var copy_res = ""
            for (i in 0 until res.length - 1) {
                copy_res += res[i]
            }
            res = copy_res + "×"
            return res
        } else if (res[res.length - 1] in "(.") {
            return res
        }
        res = res + "×"
        return res
    }

    fun getDiv(): String {
        dot = 1
        if (res.length == 0) {
            return res
        } else if (res[res.length - 1] in "-÷×+") {
            var copy_res = ""
            for (i in 0 until res.length - 1) {
                copy_res += res[i]
            }
            res = copy_res + "÷"
            return res
        } else if (res[res.length - 1] in "(.") {
            return res
        }
        res = res + "÷"
        return res
    }

    fun getBracketL(): String {
        dot = 1
        res = res + "("
        return res
    }

    fun getBracketR(): String {
        dot = 1
        res = res + ")"
        return res
    }

    fun getDot(): String {
        if (dot != 0) {
            if (res.length == 0) {
                return res
            } else if (res[res.length - 1] in "-÷()×+") {
                return res
            } else if (res[res.length - 1] == '.') {
                return res
            } else {
                res = res + "."
                dot = 0
                return res
            }
        }
        return res
    }

    fun getEqual(): String {
        return res
    }

    fun change_res(str: String) {
        if ('.' in str) {
            dot = 0
        }
        res = str
    }
}
