class Archive(val nameArchive: String) {
    val notes = mutableListOf<Note>()

    fun addNote(menuController: MenuController) {
        while (true) {
            println("Введите название новой заметки или 0, чтобы выйти ")
            val noteName = menuController.scanner.nextLine().trim()
            if (noteName.isEmpty()) println("Название заметки не может быть пустым. Попробуйте снова.")
            else if (noteName.equals("0")) break
            else {
                notes.add(Note(noteName))

                println("Заметка $noteName создана.")
            }
        }
    }

    fun choiseNote(menuController: MenuController) {
        if (notes.isEmpty()) println("Заметок пока нет. Попробуйте создать новый")
        else {
            while (true){
                println("Выберите заметку: ")
                val notesName = notes.map{ archive -> archive.nameNote}.toMutableList()
                val choise = menuController.menu(notesName)
                when (choise){
                    in 1..notes.size -> {
                        println("Открыта заметка ${notes[choise -1].nameNote}")
                        notes[choise -1].menuContent(menuController, notes[choise -1])
                    }
                    notes.size + 1 -> break
                    else -> println("Такой заметки нет")
                }
            }

        }
    }
        fun noteMenu(menuController: MenuController, archive: Archive) {
            while (true) {
                println("Меню Заметок: ")
                val listMenu = mutableListOf("Создать заметку", "Открыть заметку")
                val choice = menuController.menu(listMenu)
                when (choice) {
                    1 -> addNote(menuController)
                    2 -> choiseNote(menuController)
                    3 -> break
                    else -> println("Неверный выбор, попробуйте снова.")
                }
            }
        }

}