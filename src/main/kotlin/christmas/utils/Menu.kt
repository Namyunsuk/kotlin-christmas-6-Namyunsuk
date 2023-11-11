package christmas.utils

enum class Menu(val menuName: String, val price: Int, val category: String) {
    // 애피타이저
    MUSHROOM_SOUP("양송이수프", 6_000, "애피타이저"),
    TAPAS("타파스", 5_500, "애피타이저"),
    CAESAR_SALAD("시저샐러드", 8_000, "애피타이저"),

    // 메인
    T_BONE_STEAK("티본스테이크", 55_000, "메인"),
    BBQ_RIBS("바비큐립", 54_000, "메인"),
    SEAFOOD_PASTA("해산물파스타", 35_000, "메인"),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, "메인"),

    // 디저트
    CHOCO_CAKE("초코케이크", 15_000, "디저트"),
    ICE_CREAM("아이스크림", 5_000, "디저트"),

    // 음료
    ZERO_COLA("제로콜라", 3_000, "음료"),
    RED_WINE("레드와인", 60_000, "음료"),
    CHAMPAGNE("샴페인", 25_000, "음료");

    companion object {
        fun matchMenu(menuName: String): Menu? {
            return entries.firstOrNull { it.menuName == menuName }
        }
    }
}