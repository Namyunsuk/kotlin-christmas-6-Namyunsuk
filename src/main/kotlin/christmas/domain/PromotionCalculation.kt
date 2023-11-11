package christmas.domain

import christmas.utils.Menu

class PromotionCalculation(private val orderedMenu: Map<Menu?, Int>) {
    fun christmasDiscount(date: Int): Int {
        return INITIAL_AMOUNT + (date - START_DAY) * DISCOUNT_PER_DAY;
    }

    // 평일 할인
    fun weekdayDiscount(): Int {
        val dessertCount = orderedMenu.filter { it.key!!.category == "디저트" }.values.sum()
        return dessertCount * DISCOUNT_PER_MENU
    }

    //주말 할인
    fun weekendDiscount(): Int {
        val mainCount = orderedMenu.filter { it.key!!.category == "메인" }.values.sum()
        return mainCount * DISCOUNT_PER_MENU
    }

    fun specialDiscount(): Int {
        return SPECIAL_DISCOUNT
    }

    fun presentationEvent(): Boolean {
        if (sumTotalPrice() > PRESENTATION_PRICE) {
            return true
        }
        return false
    }

    fun sumTotalPrice():Int{
        var totalPrice = 0
        orderedMenu.forEach { (menu, count) -> totalPrice += menu!!.price * count }
        return totalPrice
    }

    companion object {
        const val START_DAY = 1
        const val INITIAL_AMOUNT = 1000
        const val DISCOUNT_PER_DAY = 100
        const val DISCOUNT_PER_MENU = 2023
        const val SPECIAL_DISCOUNT = 1000
        const val PRESENTATION_PRICE = 120_000
    }
}