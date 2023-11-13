package christmas

import christmas.utils.UserInputException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserInputExceptionTest {
    @Test
    fun `날짜 입력값이 숫자가 아닐 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("2a1")
        }
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("2ㅇ")
        }
    }

    @Test
    fun `날짜 범위가 잘못된 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("0")
        }
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("32")
        }
    }

    @Test
    fun `메뉴 형식이 잘못된 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-1,티본스테이크: 1")
        }
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-1,티본스테이크-1,")
        }
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-1 티본스테이크-1")
        }
    }

    @Test
    fun `메뉴 입력값이 숫자가 아닐 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-a")
        }
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-1a")
        }
    }

    @Test
    fun `메뉴 주문 숫자가 1개 미만일 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-0")
        }
    }

    @Test
    fun `총주문 숫자가 20개 초과일 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-2,해산물파스타-2,시저샐러드-1,샴페인-1,제로콜라-5,아이스크림-5,초코케이크-5")
        }
    }

    @Test
    fun `중복된 메뉴를 주문한 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-1,해산물파스타-1,크리스마스파스타-1")
        }
    }

    @Test
    fun `음료만 주문한 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("레드와인-1")
        }
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("제로콜라-3,레드와인-1,샴페인-1")
        }
    }

    @Test
    fun `존재하지 않는 메뉴를 주문한 경우 예외 테스트`() {
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("화이트와인-1")
        }
        assertThrows<IllegalArgumentException>("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.") {
            UserInputException.visitDateException("크리스마스파스타-3,화이트와인-1,샴페인-1")
        }
    }
}