package christmas.utils

class UserInputException {
    companion object {
        fun visitDateException(userInput: String): Int {
            require(isNumberException(userInput)) { "[ERROR] 입력값은 숫자여야 합니다. 다시 입력해 주세요." }
            val visitDate = userInput.toInt()
            require(visitDateRangeException(visitDate)) { "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요." }
            return visitDate
        }

        private fun isNumberException(userInput: String): Boolean {
            for (numberIndex in 0 until userInput.length) {
                if (userInput[numberIndex].code < '0'.code || userInput[numberIndex].code > '9'.code) {
                    return false
                }
            }
            return true
        }

        private fun visitDateRangeException(visitDate: Int): Boolean {
            return Calendar.matchDate(visitDate) != null
        }
    }
}