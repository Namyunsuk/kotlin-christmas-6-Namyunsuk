package christmas.utils

enum class Calendar(val date: Int, val dayOfWeek: String,val weekend: Boolean,val star: Boolean) {
    FIRST(1, "금요일", true, false),
    SECOND(2, "토요일", true, false),
    THIRD(3, "일요일", false, true),
    FOURTH(4, "월요일", false, false),
    FIFTH(5, "화요일", false, false),
    SIXTH(6, "수요일", false, false),
    SEVENTH(7, "목요일", false, false),
    EIGHTH(8, "금요일", true, false),
    NINTH(9, "토요일", true, false),
    TENTH(10, "일요일", false, true),
    ELEVENTH(11, "월요일", false, false),
    TWELFTH(12, "화요일", false, false),
    THIRTEENTH(13, "수요일", false, false),
    FOURTEENTH(14, "목요일", false, false),
    FIFTEENTH(15, "금요일", true, false),
    SIXTEENTH(16, "토요일", true, false),
    SEVENTEENTH(17, "일요일", false, true),
    EIGHTEENTH(18, "월요일", false, false),
    NINETEENTH(19, "화요일", false, false),
    TWENTIETH(20, "수요일", false, false),
    TWENTY_FIRST(21, "목요일", false, false),
    TWENTY_SECOND(22, "금요일", true, false),
    TWENTY_THIRD(23, "토요일", true, false),
    TWENTY_FOURTH(24, "일요일", false, true),
    TWENTY_FIFTH(25, "월요일", false, true),
    TWENTY_SIXTH(26, "화요일", false, false),
    TWENTY_SEVENTH(27, "수요일", false, false),
    TWENTY_EIGHTH(28, "목요일", false, false),
    TWENTY_NINTH(29, "금요일", true, false),
    THIRTIETH(30, "토요일", true, false),
    THIRTY_FIRST(31, "일요일", false, true);

    companion object {
        fun matchDate(date: Int): Calendar? {
            return entries.firstOrNull { it.date == date }
        }
    }
}