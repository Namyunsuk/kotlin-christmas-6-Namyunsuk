package christmas.utils

enum class Menu(val category: String, val menuName: String, val amount: Int) {
    // 애피타이저
    MUSHROOM_SOUP("애피타이저", "양송이수프", 6000),
    TAPAS("애피타이저", "타파스", 5500),
    CAESAR_SALAD("애피타이저", "시저샐러드", 8000),

    // 메인
    T_BONE_STEAK("메인", "티본스테이크", 55000),
    BBQ_RIB("메인", "바비큐립", 54000),
    SEAFOOD_PASTA("메인", "해산물파스타", 35000),
    CHRISTMAS_PASTA("메인", "크리스마스파스타", 25000),

    // 디저트
    CHOCOLATE_CAKE("디저트", "초코케이크", 15000),
    ICE_CREAM("디저트", "아이스크림", 5000),

    // 음료
    ZERO_COLA("음료", "제로콜라", 3000),
    RED_WINE("음료", "레드와인", 60000),
    CHAMPAGNE("음료", "샴페인", 25000);

    companion object {
        fun matchMEnu(menuName: String): Menu? {
            return entries.firstOrNull { it.menuName == menuName }
        }
    }
}