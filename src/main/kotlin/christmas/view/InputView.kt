package christmas.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    companion object {
        fun enterVisitDate(): Int {
            println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
            println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
            val userInput = Console.readLine()
            val userVisitDate = userInput.toInt()
            return userVisitDate
        }

        fun enterMenu(): Map<String, Int> {
            println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
            val userInput = Console.readLine()
            val orderMenu = parseOrderString(userInput)
            return orderMenu
        }

        private fun parseOrderString(orderString: String): Map<String, Int> {
            val orderMap = mutableMapOf<String, Int>()
            val items = orderString.split(",")
            for (item in items) {
                val (menu, quantityStr) = item.split("-")
                orderMap[menu] = quantityStr.toInt()
            }
            return orderMap
        }
    }
}