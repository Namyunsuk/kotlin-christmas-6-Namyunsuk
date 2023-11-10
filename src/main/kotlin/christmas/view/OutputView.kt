package christmas.view

import christmas.utils.Menu

class OutputView {
    companion object {
        fun printGreetingComment() {
            println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
        }

        fun printEventPreviewComment() {
            println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n")
        }

        fun printOrderMenu(orderedMenu: Map<Menu, Int>) {
            println("<주문 메뉴>")
            orderedMenu.forEach { (menu, count) -> println("${menu.menuName} ${count}개\n") }
        }

        fun printTotalOrderPrice(totalOrderPrice: Int) {
            println("<할인 전 총주문 금액>")
            println("${String.format("%,d", totalOrderPrice)}원\n")
        }

        fun printPresentationMenu(presentationStatus: Boolean) {
            println("<증정 메뉴>")
            if (presentationStatus) {
                println("샴페인 1개\n")
                return
            }
            println("없음\n")
        }

        fun printPromotionDetails(appliedPromotion: MutableMap<String, Int>) {
            println("<혜택 내역>")
            if (appliedPromotion.size == 0) {
                println("없음\n")
                return
            }
            appliedPromotion.forEach { (kind, amount) -> println("${kind}: -${String.format("%,d", amount)}원") }
            println()
        }

        fun printTotalDisCount(totalDiscount: Int) {
            println("<총혜택 금액>")
            println("-${String.format(",%d", totalDiscount)}원\n")
        }

        fun printExpectedPayAmount(expectedPayAmount: Int) {
            println("<할인 후 예상 결제 금액>")
            println("${String.format(",%d", expectedPayAmount)}원\n")
        }

        fun printEventBadge(eventBadge: String) {
            println("<12월 이벤트 배지>")
            println(eventBadge)
        }
    }
}