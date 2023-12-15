package christmas.model

import christmas.utils.Calendar
import christmas.utils.Menu

class Promotion(
    private val promotionCalculation: PromotionCalculation,
    private val visitDate: Calendar?,
    private val orderedMenu: Map<String, Int>
) {
    fun isPromotionTarget(orderAmount: Int): Boolean {
        return orderAmount > PROMOTION_MINIMUM_AMOUNT
    }

    fun christmasPromotion(promotionList: MutableMap<String, Int>) {
        if (visitDate!!.date in 1..25) {
            promotionList["크리스마스 디데이 할인"] = promotionCalculation.calculateChristmasPromotion(visitDate.date)
        }
    }

    fun weekdayPromotion(promotionList: MutableMap<String, Int>) {
        if (!visitDate!!.weekend) {
            promotionList["평일 할인"] = promotionCalculation.calculateWeekdayPromotion(orderedMenu)
        }
    }

    fun weekendPromotion(promotionList: MutableMap<String, Int>) {
        if (visitDate!!.weekend) {
            promotionList["주말 할인"] = promotionCalculation.calculateWeekendPromotion(orderedMenu)
        }
    }

    fun specialPromotion(promotionList: MutableMap<String, Int>) {
        if (visitDate!!.star) {
            promotionList["특별 할인"] = promotionCalculation.calculateSpecialPromotion()
        }
    }

    fun presentPromotion(promotionList: MutableMap<String, Int>) {
        val totalAmount = calculateTotalOrderAmount()
        if (totalAmount > 120000) {
            promotionList["증정 이벤트"] = promotionCalculation.calculatePresentPromotion()
        }
    }

    fun eventBadge(totalPromotionAmount:Int):String{
        if(totalPromotionAmount>=20000) return "산타"
        if(totalPromotionAmount>=10000) return "트리"
        if(totalPromotionAmount>=5000) return "별"
        return "없음"
    }

    fun calculateTotalOrderAmount(): Int {
        var totalAmount = 0
        for ((menu, count) in orderedMenu) {
            val menuInfo = Menu.matchMenu(menu)
            totalAmount += menuInfo!!.amount * count
        }
        return totalAmount
    }

    companion object {
        const val PROMOTION_MINIMUM_AMOUNT = 10000
    }
}