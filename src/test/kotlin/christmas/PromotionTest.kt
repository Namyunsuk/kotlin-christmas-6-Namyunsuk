package christmas

import christmas.domain.Promotion
import christmas.domain.PromotionCalculation
import christmas.utils.Calendar
import christmas.utils.Menu
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PromotionTest {
    private val orderedMenu = mapOf<Menu?, Int>(Menu.BBQ_RIBS to 1, Menu.CHOCO_CAKE to 1)

    @Test
    fun `총 주문 금액이 이벤트가 적용되는 금액 이상인지 판단하는 기능 테스트`() {
        var promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.Twenty)
        var result = promotion.confirmMinimumTotalPriceForPromotion()
        assertThat(result).isEqualTo(true)

        val orderedMenu = mapOf<Menu?, Int>(Menu.ZERO_COLA to 1)
        promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.Twenty)
        result = promotion.confirmMinimumTotalPriceForPromotion()
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `크리스마스 디데이 할인 기간 내인지 판단 후 적용하는 기능 테스트`() {
        val promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.Twenty)
        val appliedPromotion = mutableMapOf<String, Int>()
        promotion.applyChristmasDiscount(appliedPromotion)
        assertThat(appliedPromotion).isEqualTo(mutableMapOf("크리스마스 디데이 할인" to 2900))
    }

    @Test
    fun `평일할인 적용되는지 테스트`() {
        val promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.Twenty)
        val appliedPromotion = mutableMapOf<String, Int>()
        promotion.applyDayDiscount(appliedPromotion)
        assertThat(appliedPromotion).isEqualTo(mutableMapOf("평일 할인" to 2023))
    }

    @Test
    fun `주말할인 적용되는지 테스트`() {
        val promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.TwentyNine)
        val appliedPromotion = mutableMapOf<String, Int>()
        promotion.applyDayDiscount(appliedPromotion)
        assertThat(appliedPromotion).isEqualTo(mutableMapOf("주말 할인" to 2023))
    }

    @Test
    fun `특별 할인 적용되는지 테스트`() {
        val promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.TwentyFour)
        val appliedPromotion = mutableMapOf<String, Int>()
        promotion.applySpecialPromotion(appliedPromotion)
        assertThat(appliedPromotion).isEqualTo(mutableMapOf("특별 할인" to 1000))
    }

    @Test
    fun `할인 전 총주문 금액에 따라 증정이벤트 해당 여부 반환 테스트`(){
        var promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.TwentyFour)
        val appliedPromotion = mutableMapOf<String, Int>()
        promotion.applyPresentationEvent(appliedPromotion)
        assertThat(appliedPromotion).isNotEqualTo(mutableMapOf("증정 이벤트" to 25000))

        val orderedMenu = mapOf<Menu?, Int>(Menu.BBQ_RIBS to 3)
        promotion = Promotion(PromotionCalculation(orderedMenu), Calendar.TwentyFour)
        promotion.applyPresentationEvent(appliedPromotion)
        assertThat(appliedPromotion).isEqualTo(mutableMapOf("증정 이벤트" to 25000))
    }
}