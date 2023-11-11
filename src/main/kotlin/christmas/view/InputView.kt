package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.utils.Menu
import christmas.utils.UserInputException

class InputView {
    companion object {
        fun readDate(): Int {
            println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
            while (true) {
                val input = Console.readLine()
                try {
                    return UserInputException.visitDateException(input)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        fun readMenu(): Map<Menu?, Int> {
            println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
            while (true) {
                val input = Console.readLine()
                try {
                    return UserInputException.menuException(input)
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }
    }
}