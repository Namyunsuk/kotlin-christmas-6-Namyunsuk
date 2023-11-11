package christmas.domain

import christmas.utils.Menu

class MoneyCalculation(private val appliedPromotion: MutableMap<String, Int>, private val orderedMenu: Map<Menu?, Int>) {
    fun calculateTotalPrice(): Int {
        var totalPrice = 0
        orderedMenu.forEach { (menu, count) -> totalPrice += menu!!.price * count }
        return totalPrice
    }

    fun calculateTotalDiscount(): Int {
        return appliedPromotion.filter { it.key != "증정 이벤트" }.values.sum()
    }

    fun calculateTotalPromotionPrice(): Int {
        return appliedPromotion.values.sum()
    }

    fun calculateExpectedPayAmount(): Int {
        return calculateTotalPrice() - calculateTotalDiscount()
    }
}