package christmas

import christmas.utils.Calendar
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CalendarTest {
    @Test
    fun `해당 날짜를 정확히 가져오는 지 없을 경우 Null을 반환하는지 테스트`() {
        val validResult = Calendar.matchDate(23)
        val invalidResult = Calendar.matchDate(32)

        assertThat(validResult).isEqualTo(Calendar.TwentyThree)
        assertThat(invalidResult).isEqualTo(null)
    }
}