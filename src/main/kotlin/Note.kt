import java.lang.StringBuilder

class Note(val nameNote: String) {

    val content = StringBuilder()
     fun editNote(menuController: MenuController) {
        content.append(menuController.scanner.nextLine())
     }
    fun menuContent(menuControlle: MenuController, note: Note) {
        while (true) {
            println("Выберите действие")
            val listContent = mutableListOf("Посмотреть содержимое", "Добавить текст")
            val choise = menuControlle.menu(listContent)
            when (choise) {
                1 -> println("$content")
                2 -> editNote(menuControlle)
                3 -> break
                else -> println("Неверный выбор, попробуйте снова.")
            }
        }
    }
}