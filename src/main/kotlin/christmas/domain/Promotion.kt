package christmas.domain

import christmas.utils.Calendar
import christmas.utils.Constants

class Promotion(private val promotionCalculation: PromotionCalculation, private val visitDate: Calendar?) {
    fun applyPromotion(): MutableMap<String, Int> {
        val appliedPromotion = mutableMapOf<String, Int>()
        if (promotionCalculation.sumTotalPrice() >= Constants.MINIMUM_TOTAL_PRICE_FOR_PROMOTION) {
            applyChristmasDiscount(appliedPromotion)
            applyDayDiscount(appliedPromotion)
            applySpecialPromotion(appliedPromotion)
            applyPresentationEvent(appliedPromotion)
        }
        return appliedPromotion
    }

    private fun applyChristmasDiscount(appliedPromotion: MutableMap<String, Int>) {
        if (visitDate!!.date <= 25) {
            appliedPromotion[Constants.CHRISTMAS_DISCOUNT] = promotionCalculation.christmasDiscount(visitDate.date)
        }
    }

    private fun applyDayDiscount(appliedPromotion: MutableMap<String, Int>) {
        if (isWeekend(visitDate!!.week)) {
            appliedPromotion[Constants.WEEKEND_DISCOUNT] = promotionCalculation.weekendDiscount()
            return
        }
        appliedPromotion[Constants.WEEKDAY_DISCOUNT] = promotionCalculation.weekdayDiscount()
    }

    private fun isWeekend(weekend: String): Boolean {
        return weekend == Constants.WEEKEND_DAY1 || weekend == Constants.WEEKEND_DAY2
    }

    private fun applySpecialPromotion(appliedPromotion: MutableMap<String, Int>) {
        if (visitDate!!.star) {
            appliedPromotion[Constants.SPECIAL_DISCOUNT] = promotionCalculation.specialDiscount()
        }
    }

    private fun applyPresentationEvent(appliedPromotion: MutableMap<String, Int>) {
        if (promotionCalculation.presentationEvent()) {
            appliedPromotion[Constants.PRESENTATION_EVENT] = Constants.PRESENTATION_EVENT_DISCOUNT
        }
    }
}