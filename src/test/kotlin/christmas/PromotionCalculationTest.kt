package christmas

import christmas.domain.PromotionCalculation
import christmas.utils.Menu
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class PromotionCalculationTest {
    private var orderedMenu =
        mapOf<Menu?, Int>(
            Menu.BBQ_RIBS to 1,
            Menu.CAESAR_SALAD to 1,
            Menu.CHAMPAGNE to 1,
            Menu.T_BONE_STEAK to 1,
            Menu.ICE_CREAM to 3
        )
    private var promotionCalculation = PromotionCalculation(orderedMenu)

    @Test
    fun `크리스마스 할인 금액 계산 기능 테스트`() {
        val result = promotionCalculation.christmasDiscount(25)
        assertThat(result).isEqualTo(3_400)
    }

    @Test
    fun `평일 할인 금액 계산 기능 테스트`() {
        val result = promotionCalculation.weekdayDiscount()
        assertThat(result).isEqualTo(6_069)
    }

    @Test
    fun `주말 할인 금액 계산 기능 테스트`() {
        val result = promotionCalculation.weekendDiscount()
        assertThat(result).isEqualTo(4_046)
    }

    @Test
    fun `증정 할인 금액 계산 기능 테스트`() {
        var result = promotionCalculation.presentationEvent()
        assertThat(result).isEqualTo(true)

        orderedMenu = mapOf<Menu?, Int>(Menu.ICE_CREAM to 3)
        promotionCalculation = PromotionCalculation(orderedMenu)
        result = promotionCalculation.presentationEvent()
        assertThat(result).isNotEqualTo(true)
    }
}