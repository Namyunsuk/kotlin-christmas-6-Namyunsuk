package christmas.domain

import christmas.utils.Constants
import christmas.utils.Menu

class PromotionCalculation(private val orderedMenu: Map<Menu?, Int>) {
    fun christmasDiscount(date: Int): Int {
        return Constants.INITIAL_AMOUNT + (date -Constants. START_DAY) * Constants.DISCOUNT_PER_DAY;
    }

    // 평일 할인
    fun weekdayDiscount(): Int {
        val dessertCount = orderedMenu.filter { it.key!!.category == Constants.DESSERT_CATEGORY }.values.sum()
        return dessertCount * Constants.DISCOUNT_PER_MENU
    }

    //주말 할인
    fun weekendDiscount(): Int {
        val mainCount = orderedMenu.filter { it.key!!.category == Constants.MAIN_CATEGORY }.values.sum()
        return mainCount * Constants.DISCOUNT_PER_MENU
    }

    fun specialDiscount(): Int {
        return Constants.SPECIAL_DISCOUNT_AMOUNT
    }

    fun presentationEvent(): Boolean {
        if (sumTotalPrice() > Constants.PRESENTATION_PRICE) {
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

    }
}