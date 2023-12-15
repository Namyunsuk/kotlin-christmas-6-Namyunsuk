package christmas.model

import christmas.utils.Menu

class MoneyCalculation {
    fun calculateTotalOrderAmount(orderedMenu: Map<String, Int>): Int {
        var totalAmount = 0
        for ((menu, count) in orderedMenu) {
            val menuInfo = Menu.matchMenu(menu)
            totalAmount += menuInfo!!.amount * count
        }
        return totalAmount
    }

    fun calculateTotalPromotionAmount(adaptedPromotion: Map<String, Int>): Int {
        var totalAmount = 0
        for ((promotion, amount) in adaptedPromotion) {
            totalAmount += amount
        }
        return totalAmount
    }

    fun calculatePromotionAmount(adaptedPromotion: Map<String, Int>): Int {
        var totalAmount = 0
        for ((promotion, amount) in adaptedPromotion) {
            if (promotion == NOT_DISCOUNT_PROMOTION) continue
            totalAmount += amount
        }
        return totalAmount
    }

    fun calculateExpectedPayment(totalOrderAmount: Int, promotionAmount: Int): Int {
        return totalOrderAmount - promotionAmount
    }

    companion object {
        const val NOT_DISCOUNT_PROMOTION = "증정 이벤트"
    }
}