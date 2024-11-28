val list = listOf("Pomme", "Banane", "Cerise")  ;
val mutableList = mutableListOf(1, 2, 3)  ;
val set = setOf(1, 2, 3, 3);

fun main(){
    println(set)
}
// Filter and transform data:
val nombres = listOf(1, 2, 3, 4, 5)
val pairs = nombres.filter { it % 2 == 0 }
val carrés = nombres.map { it * it }
fun main(){
    println(pairs)
    println(carrés)
    nombres.forEach{println(it)}
}
// Create a generic function:
fun <T> afficherElement(element: T) {
    println(element)
}

fun main(){
    afficherElement(42)         // Fonctionne avec un Int
    afficherElement("Bonjour")  // Fonctionne avec un String


}

// Create a generic function:
class Boîte<T>(val contenu: T) {
    fun afficherContenu() {
        println("Contenu : $contenu")
    }
}

val boîteInt = Boîte(123)
val boîteString = Boîte("Hello")


fun main(){
    boîteInt.afficherContenu()     // Contenu : 123
    boîteString.afficherContenu()  // Contenu : Hello

}

//Extensions :

fun String.inverser(): String {
    return this.reversed()
}

fun main(){
    println("Kotlin".inverser())  // Résultat : "niltok"


}

// Fonctions d’ordre supérieur :

fun appliquerOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Utilisation
val somme = appliquerOperation(5, 3) { x, y -> x + y }   // 8
val produit = appliquerOperation(5, 3) { x, y -> x * y } // 15

fun main(){
    println(somme)
    println(produit)


}









