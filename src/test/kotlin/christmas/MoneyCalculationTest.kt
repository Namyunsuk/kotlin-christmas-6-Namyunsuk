package christmas

import christmas.domain.MoneyCalculation
import christmas.utils.Menu
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class MoneyCalculationTest {
    private val appliedPromotion =
        mapOf("크리스마스 디데이 할인" to 3300, "평일 할인" to 0, "특별 할인" to 1000, "증정 이벤트" to 25000)
    private val orderedMenu =
        mapOf<Menu?, Int>(Menu.BBQ_RIBS to 1, Menu.CAESAR_SALAD to 1, Menu.CHAMPAGNE to 1, Menu.T_BONE_STEAK to 1)
    private val moneyCalculation = MoneyCalculation(appliedPromotion, orderedMenu)

    @Test
    fun `총주문 금액 계산 기능 테스트`() {
        val result = moneyCalculation.calculateTotalPrice()
        assertThat(result).isEqualTo(142_000)
    }

    @Test
    fun `총혜택 금액 계산 기능 테스트`() {
        val result = moneyCalculation.calculateTotalPromotionPrice()
        assertThat(result).isEqualTo(29_300)
    }

    @Test
    fun `할인 후 예상 결제 금액 계산 기능 테스트`() {
        val result = moneyCalculation.calculateExpectedPayAmount()
        assertThat(result).isEqualTo(137_700)
    }
}