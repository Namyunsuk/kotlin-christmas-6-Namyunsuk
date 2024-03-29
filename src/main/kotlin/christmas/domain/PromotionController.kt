package christmas.domain

import christmas.utils.Calendar
import christmas.utils.Constants
import christmas.utils.Menu
import christmas.view.InputView
import christmas.view.OutputView

class PromotionController {
    fun start() {
        OutputView.printGreetingComment()
        val (orderedMenu, visitDate) = controlMenuAndDateInput()
        controlPreviewPromotion(orderedMenu, visitDate)
    }

    private fun controlMenuAndDateInput(): Pair<Map<Menu?, Int>, Calendar?> {
        val visitDate = Calendar.matchDate(InputView.readDate())
        val orderedMenu = InputView.readMenu()
        return Pair(orderedMenu, visitDate)
    }

    private fun applyPromotion(promotion: Promotion): MutableMap<String, Int> {
        val appliedPromotion = mutableMapOf<String, Int>()
        if (promotion.confirmMinimumTotalPriceForPromotion()) {
            promotion.applyChristmasDiscount(appliedPromotion)
            promotion.applyDayDiscount(appliedPromotion)
            promotion.applySpecialPromotion(appliedPromotion)
            promotion.applyPresentationEvent(appliedPromotion)
        }
        return appliedPromotion
    }

    private fun controlPreviewPromotion(orderedMenu: Map<Menu?, Int>, visitDate: Calendar?) {
        val promotionCalculation = PromotionCalculation(orderedMenu)
        val promotion = Promotion(promotionCalculation, visitDate)
        val appliedPromotion = applyPromotion(promotion)
        val moneyCalculation = MoneyCalculation(appliedPromotion, orderedMenu)
        controlOrderedMenu(orderedMenu)
        controlPromotionCalculation(appliedPromotion, moneyCalculation)
    }

    private fun controlPromotionCalculation(
        appliedPromotion: MutableMap<String, Int>,
        moneyCalculation: MoneyCalculation
    ) {
        controlTotalOrderPrice(moneyCalculation)
        controlPresentationMenu(appliedPromotion)
        OutputView.printPromotionDetails(appliedPromotion)
        controlPromotionDetails(moneyCalculation)
    }

    private fun controlOrderedMenu(orderedMenu: Map<Menu?, Int>) {
        OutputView.printEventPreviewComment()
        OutputView.printOrderMenu(orderedMenu)
    }

    private fun controlTotalOrderPrice(moneyCalculation: MoneyCalculation) {
        val totalOrderPrice = moneyCalculation.calculateTotalPrice()
        OutputView.printTotalOrderPrice(totalOrderPrice)
    }

    private fun controlPresentationMenu(appliedPromotion: MutableMap<String, Int>) {
        if (appliedPromotion.any { it.key == Constants.PRESENTATION_EVENT }) {
            OutputView.printPresentationMenu(true)
            return
        }
        OutputView.printPresentationMenu(false)
    }

    private fun controlPromotionDetails(moneyCalculation: MoneyCalculation) {
        val totalPromotionPrice = moneyCalculation.calculateTotalPromotionPrice()
        OutputView.printTotalDisCount(totalPromotionPrice)
        controlExpectedAmount(moneyCalculation)
        controlEventBadge(totalPromotionPrice)
    }

    private fun controlExpectedAmount(moneyCalculation: MoneyCalculation) {
        val expectedPayAmount = moneyCalculation.calculateExpectedPayAmount()
        OutputView.printExpectedPayAmount(expectedPayAmount)
    }

    private fun controlEventBadge(totalPromotionPrice: Int) {
        val badge = determineEventBadge(totalPromotionPrice)
        OutputView.printEventBadge(badge)
    }

    private fun determineEventBadge(totalPromotionPrice: Int): String {
        return when {
            totalPromotionPrice >= Constants.THRESHOLD_SANTA -> Constants.SANTA_BADGE
            totalPromotionPrice >= Constants.THRESHOLD_TREE -> Constants.TREE_BADGE
            totalPromotionPrice >= Constants.THRESHOLD_STAR -> Constants.STAR_BADGE
            else -> Constants.NONE
        }
    }
}