package christmas.domain

import christmas.utils.Calendar

class Promotion(private val promotionCalculation: PromotionCalculation, private val visitDate: Calendar) {
    fun applyPromotion(): MutableMap<String, Int> {
        val appliedPromotion = mutableMapOf<String, Int>()
        if (promotionCalculation.sumTotalPrice() >= MINIMUM_TOTAL_PRICE_FOR_PROMOTION) {
            applyChristmasDicount(appliedPromotion)
            applyDayDicount(appliedPromotion)
            applySpecialPromotion(appliedPromotion)
            applyPresentationEvent(appliedPromotion)
        }
        return appliedPromotion
    }

    private fun applyChristmasDicount(appliedPromotion: MutableMap<String, Int>) {
        if (visitDate.date <= 25) {
            appliedPromotion["크리스마스 디데이 할인"] = promotionCalculation.christmasDiscount(visitDate.date)
        }
    }

    private fun applyDayDicount(appliedPromotion: MutableMap<String, Int>) {
        if (isWeekend(visitDate.week)) {
            appliedPromotion["주말 할인"] = promotionCalculation.weekendDiscount()
            return
        }
        appliedPromotion["평일 할인"] = promotionCalculation.weekdayDiscount()
    }

    private fun isWeekend(weekend: String): Boolean {
        return weekend == "FRIDAY" || weekend == "SATURDAY"
    }

    private fun applySpecialPromotion(appliedPromotion: MutableMap<String, Int>) {
        if (visitDate.star) {
            appliedPromotion["특별 할인"] = promotionCalculation.specialDiscount()
        }
    }

    fun applyPresentationEvent(appliedPromotion: MutableMap<String, Int>) {
        if (promotionCalculation.presentationEvent()) {
            appliedPromotion["증정 이벤트"] = PRESENTATION_EVENT
        }
    }

    companion object {
        const val PRESENTATION_EVENT = 25_000
        const val MINIMUM_TOTAL_PRICE_FOR_PROMOTION = 10_000
    }
}