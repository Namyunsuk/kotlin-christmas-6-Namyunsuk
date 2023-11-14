package christmas.domain

import christmas.utils.Calendar
import christmas.utils.Constants

class Promotion(private val promotionCalculation: PromotionCalculation, private val visitDate: Calendar?) {
    fun confirmMinimumTotalPriceForPromotion(): Boolean {
        return promotionCalculation.sumTotalPrice() >= Constants.MINIMUM_TOTAL_PRICE_FOR_PROMOTION
    }

    fun applyChristmasDiscount(appliedPromotion: MutableMap<String, Int>) {
        if (visitDate!!.date <= Constants.CHRISTMAS_DISCOUNT_LAST_DAY) {
            appliedPromotion[Constants.CHRISTMAS_DISCOUNT] = promotionCalculation.christmasDiscount(visitDate.date)
        }
    }

    fun applyDayDiscount(appliedPromotion: MutableMap<String, Int>) {
        if (isWeekend(visitDate!!.week)) {
            appliedPromotion[Constants.WEEKEND_DISCOUNT] = promotionCalculation.weekendDiscount()
            return
        }
        appliedPromotion[Constants.WEEKDAY_DISCOUNT] = promotionCalculation.weekdayDiscount()
    }

    fun applySpecialPromotion(appliedPromotion: MutableMap<String, Int>) {
        if (visitDate!!.star) {
            appliedPromotion[Constants.SPECIAL_DISCOUNT] = promotionCalculation.specialDiscount()
        }
    }

    fun applyPresentationEvent(appliedPromotion: MutableMap<String, Int>) {
        if (promotionCalculation.presentationEvent()) {
            appliedPromotion[Constants.PRESENTATION_EVENT] = Constants.PRESENTATION_EVENT_DISCOUNT
        }
    }

    private fun isWeekend(weekend: String): Boolean {
        return weekend == Constants.WEEKEND_DAY1 || weekend == Constants.WEEKEND_DAY2
    }
}