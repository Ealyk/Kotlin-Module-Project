import java.util.Scanner
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val menuController = MenuController(scanner)
    val archiveScreen = ArchiveScreen()
    while (true) {
        val listMenu = mutableListOf("Архивы")
        println("Главное меню: ")
        val choice = menuController.menu(listMenu)
        when (choice) {
            1 -> archiveScreen.archiveMenu(menuController)
            2 -> {
                println("Завершение работы.")
                break
            }
            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}
class MenuController(val scanner: Scanner) {
    fun menu(listMenu: MutableList<String>): Int {
        listMenu.add("Выход")
        listMenu.forEach { content -> println("${listMenu.indexOf(content) + 1}. $content") }
        val choice = scanner.nextLine().toIntOrNull()
        if (choice != null && choice in 1..listMenu.size) return choice
        else return -1
    }

}