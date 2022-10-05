package dev.tigrao.autocomplete

class DogService {

    fun fetchDogs(): List<CustomDogs> {
        val listOfDogs = buildList {
            repeat(100) {
                val dog = CustomDogs(
                    id = it,
                    name = if (it % 2 == 0) {
                        "Pastor $it"
                    } else {
                        "Bernardo $it"
                    }
                )

                add(dog)
            }
        }

        return listOfDogs
    }
}