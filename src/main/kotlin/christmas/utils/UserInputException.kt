package christmas.utils

class UserInputException {
    companion object {
        fun visitDateException(userInput: String): Int {
            require(isNumberException(userInput)) { Constants.INVALID_DATE_ERROR }
            val visitDate = userInput.toInt()
            require(visitDateRangeException(visitDate)) { Constants.INVALID_DATE_ERROR }
            return visitDate
        }

        fun menuException(userInput: String): Map<Menu?, Int> {
            require(menuFormatException(userInput)) { Constants.INVALID_ORDER_ERROR }
            val splitMenu = makeSplitMenu(userInput)
            require(splitMenuException(splitMenu)) { Constants.INVALID_ORDER_ERROR }
            val orderedMenu = makeOrderedMenu(splitMenu)
            require(onlyBeverageMenuException(orderedMenu)) { Constants.INVALID_ORDER_ERROR }

            return orderedMenu
        }

        private fun menuFormatException(userInput: String): Boolean {
            return menuSeparatorFormatException(userInput) && menuCountIsNumberException(userInput)
        }

        private fun splitMenuException(splitMenu: Map<String, Int>): Boolean {
            return menuSizeException(splitMenu) &&
                    totalMenuSizeException(splitMenu) &&
                    duplicateMenuException(splitMenu) &&
                    notExistMenuException(splitMenu)
        }

        private fun isNumberException(userInput: String): Boolean {
            for (numberIndex in userInput.indices) {
                if (userInput[numberIndex].code < '0'.code || userInput[numberIndex].code > '9'.code) {
                    return false
                }
            }
            return true
        }

        private fun visitDateRangeException(visitDate: Int): Boolean {
            return Calendar.matchDate(visitDate) != null
        }

        private fun menuSeparatorFormatException(userInput: String): Boolean {
            val menuCountSeparatorNum = userInput.count { it == Constants.MENU_COUNT_SEPARATOR }
            val menuSeparatorNum = userInput.count { it == Constants.MENU_SEPARATOR }
            return (menuCountSeparatorNum - 1) == menuSeparatorNum
        }

        private fun menuCountIsNumberException(userInput: String): Boolean {
            val splitMenu = userInput.split(Constants.MENU_SEPARATOR )
                .map { it.split(Constants.MENU_COUNT_SEPARATOR) }
            return splitMenu.all { isNumberException(it[1]) }
        }

        private fun menuSizeException(splitMenu: Map<String, Int>): Boolean {
            return splitMenu.all { it.value >= Constants.MINIMUM_ORDER_VALUE }
        }

        private fun totalMenuSizeException(splitMenu: Map<String, Int>): Boolean {
            return splitMenu.values.sum() <= Constants.MAXIMUM_TOTAL_ORDER_VALUE
        }

        private fun duplicateMenuException(splitMenu: Map<String, Int>): Boolean {
            val menuList = splitMenu.keys.toList()
            val distinctMenuList = menuList.distinct()
            return menuList.size == distinctMenuList.size
        }

        private fun onlyBeverageMenuException(orderedMenu: Map<Menu?, Int>): Boolean {
            return !orderedMenu.all { it.key?.category == Constants.BEVERAGE_CATEGORY }
        }

        private fun notExistMenuException(splitMenu: Map<String, Int>): Boolean {
            return splitMenu.all { Menu.matchMenu(it.key) != null }
        }

        private fun makeSplitMenu(userInput: String): Map<String, Int> {
            return userInput.split(Constants.MENU_SEPARATOR)
                .map { it.split(Constants.MENU_COUNT_SEPARATOR) }
                .associate { (menu, count) -> menu to count.toInt() }
        }

        private fun makeOrderedMenu(splitMenu: Map<String, Int>): Map<Menu?, Int> {
            val orderedMenu = mutableMapOf<Menu?, Int>()
            splitMenu.forEach { (name, count) -> orderedMenu[Menu.matchMenu(name)] = count }
            return orderedMenu
        }
    }
}