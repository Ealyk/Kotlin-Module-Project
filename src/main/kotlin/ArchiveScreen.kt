class ArchiveScreen {

    val archives = mutableListOf<Archive>()

    fun choiseArchives(menuController: MenuController) {
        if (archives.isEmpty()) println("Архивов пока нет. Попробуйте создать новый")
        else {
            while (true){
                println("Выберите архив: ")
                val archivesName = archives.map{ archive -> archive.nameArchive}.toMutableList()
                val choise = menuController.menu(archivesName)
                when (choise){
                    in 1..archives.size -> {
                        println("Открыт архив ${archives[choise - 1].nameArchive}")
                        archives[choise - 1].noteMenu(menuController, archives[choise - 1])
                    }
                    archives.size + 1 -> break
                    else -> println("Такого архива нет")
                }
            }

        }
    }

    fun addArchive(menuController: MenuController) {
        while (true) {
            println("Введите название нового архива или 0, чтобы выйти ")
            val archiveName = menuController.scanner.nextLine().trim()
            if (archiveName.isEmpty()) println("Название архива не может быть пустым. Попробуйте снова.")
            else if (archiveName.equals("0")) break
            else {
                archives.add(Archive(archiveName))
                println("Архив $archiveName создан.")
            }
        }

    }
        fun archiveMenu(menuController: MenuController) {
            while (true){
                println("Меню Архивов: ")
                val listMenu = mutableListOf("Создать архив", "Открыть архив")
                val choice = menuController.menu(listMenu)
                when (choice) {
                    1 -> addArchive(menuController)
                    2 -> choiseArchives(menuController)
                    3 -> break
                    else -> println("Неверный выбор, попробуйте снова.")
                }
            }
        }




}


