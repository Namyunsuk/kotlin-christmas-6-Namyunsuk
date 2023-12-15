package christmas.model

import christmas.utils.Calendar
import christmas.utils.Menu

class PromotionCalculation {
    fun calculateChristmasPromotion(date: Int): Int {
        return DEFAULT_CHRISTMAS_PROMOTION_AMOUNT + (date - 1) * CHRISTMAS_PROMOTION_INCREASE_AMOUNT
    }

    fun calculateWeekdayPromotion(menu: Map<String, Int>): Int { //평일할인
        val dessertCount = menu.filter { (menu, amount) -> Menu.matchMenu(menu)!!.category == "디저트" }.values.sum()
        return dessertCount * 2023
    }

    fun calculateWeekendPromotion(menu: Map<String, Int>): Int { //평일할인
        val mainMenuCount = menu.filter { (menu, amount) -> Menu.matchMenu(menu)!!.category == "메인" }.values.sum()
        return mainMenuCount * 2023
    }

    fun calculateSpecialPromotion(): Int {
        return 1000
    }

    fun calculatePresentPromotion(): Int {
        return Menu.CHAMPAGNE.amount
    }

    companion object {
        const val DEFAULT_CHRISTMAS_PROMOTION_AMOUNT = 1000
        const val CHRISTMAS_PROMOTION_INCREASE_AMOUNT = 100
    }
}