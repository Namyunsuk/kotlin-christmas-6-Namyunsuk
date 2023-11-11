package christmas.utils

enum class Calendar(val date: Int, val week: String, val star: Boolean) {
    One(1, "Friday", false),
    Two(2, "Saturday", false),
    Three(3, "Sunday", true),
    Four(4, "Monday", false),
    Five(5, "Tuesday", false),
    Six(6, "Wednesday", false),
    Seven(7, "Thursday", false),
    Eight(8, "Friday", false),
    Nine(9, "Saturday", false),
    Ten(10, "Sunday", true),
    Eleven(11, "Monday", false),
    Twelve(12, "Tuesday", false),
    Thirteen(13, "Wednesday", false),
    Fourteen(14, "Thursday", false),
    Fifteen(15, "Friday", false),
    Sixteen(16, "Saturday", false),
    Seventeen(17, "Sunday", true),
    Eighteen(18, "Monday", false),
    Nineteen(19, "Tuesday", false),
    Twenty(20, "Wednesday", false),
    TwentyOne(21, "Thursday", false),
    TwentyTwo(22, "Friday", false),
    TwentyThree(23, "Saturday", false),
    TwentyFour(24, "Sunday", true),
    TwentyFive(25, "Monday", true),
    TwentySix(26, "Tuesday", false),
    TwentySeven(27, "Wednesday", false),
    TwentyEight(28, "Thursday", false),
    TwentyNine(29, "Friday", false),
    Thirty(30, "Saturday", false),
    ThirtyONE(31, "Sunday", true);

    companion object {
        fun matchDate(date: Int): Calendar? {
            return entries.firstOrNull { it.date == date }
        }
    }
}