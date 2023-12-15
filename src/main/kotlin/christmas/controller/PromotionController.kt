package christmas.controller

import christmas.model.MoneyCalculation
import christmas.model.Promotion
import christmas.model.PromotionCalculation
import christmas.utils.Calendar
import christmas.view.InputView
import christmas.view.OutputView

class PromotionController {
    private val promotionList = mutableMapOf<String, Int>()
    fun start() {
        OutputView.printStartComment()
        val visitDate = Calendar.matchDate(InputView.enterVisitDate())
        val orderedMenu = InputView.enterMenu()
        OutputView.printPromotionPreviewComment()

        OutputView.printOrderedMenu(orderedMenu)

        val moneyCalculation = MoneyCalculation()
        val totalOrderAmount = moneyCalculation.calculateTotalOrderAmount(orderedMenu)
        OutputView.printAmountBeforePromotion(totalOrderAmount)

        val promotion = Promotion(PromotionCalculation(), visitDate, orderedMenu)
        adaptPromotion(promotion)
        
        OutputView.printPresentMenu(promotionList.contains("증정이벤트"))

        OutputView.printPromotionList(promotionList)

        val totalPromotionAmount = moneyCalculation.calculateTotalPromotionAmount(promotionList)
        OutputView.printTotalPromotionAmount(totalPromotionAmount)

        val promotionAmount = moneyCalculation.calculatePromotionAmount(promotionList)
        val expectedPayment = moneyCalculation.calculateExpectedPayment(totalOrderAmount,promotionAmount)
        OutputView.printExpectedPayment(expectedPayment)

        val badge = promotion.eventBadge(totalPromotionAmount)
        OutputView.printEventBadge(badge)

    }

    fun adaptPromotion(promotion: Promotion) {
        promotion.christmasPromotion(promotionList)
        promotion.weekdayPromotion(promotionList)
        promotion.weekendPromotion(promotionList)
        promotion.specialPromotion(promotionList)
        promotion.presentPromotion(promotionList)
    }
}