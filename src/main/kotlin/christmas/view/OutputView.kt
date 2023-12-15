package christmas.view

class OutputView {
    companion object {
        fun printStartComment() {
            println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
        }

        fun printPromotionPreviewComment() {
            println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n")
        }

        fun printOrderedMenu(orderedMenu: Map<String, Int>) {
            for ((menu, number) in orderedMenu) {
                println("${menu} ${number}개")
            }
            println()
        }

        fun printAmountBeforePromotion(amount: Int) {
            println("<할인 전 총주문 금액>")
            println("${String.format("%,d", amount)}원")
            println()
        }

        fun printPresentMenu(present: Boolean) {
            println("<증정 메뉴>")
            if (present) {
                println("샴페인 1개")
                return
            }
            println("없음")
        }

        fun printPromotionList(promotionList: Map<String, Int>) {
            println("<혜택 내역>")
            if (promotionList.isEmpty()) {
                println("없음")
                return
            }
            for ((promotionName, promotionAmount) in promotionList) {
                println("${promotionName}: ${String.format("%,d", -promotionAmount)}")
            }
            println()
        }

        fun printTotalPromotionAmount(totalPromotionAmount: Int) {
            println("<총혜택 금액>")
            println("${String.format("%,d", -totalPromotionAmount)}원")
            println()
        }

        fun printEventBadge(badgeName: String) {
            println(badgeName)
        }
    }
}