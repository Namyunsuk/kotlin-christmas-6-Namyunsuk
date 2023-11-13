package christmas

import christmas.utils.Menu
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MenuTest {
    @Test
    fun `해당 메뉴를 정확히 가져오는 지 없을 경우 Null을 반환하는지 테스트`() {
        val validResult = Menu.matchMenu("크리스마스파스타")
        val invalidResult = Menu.matchMenu("닭볶음탕")

        assertThat(validResult).isEqualTo(Menu.CHRISTMAS_PASTA)
        assertThat(invalidResult).isEqualTo(null)
    }
}