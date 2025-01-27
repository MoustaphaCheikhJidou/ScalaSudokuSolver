import scala.io.Source // Importer la bibliothèque pour lire des fichiers texte

// Définir l'objet Sudoku
object Sudoku {
  // Point d'entrée principal du programme
  def main(args: Array[String]): Unit = {
    // Charger le fichier Sudoku
    val filename = "sudoku-v1.txt" // Nom du fichier contenant le Sudoku
    // Lire les lignes du fichier, les transformer en tableau d'entiers
    val board = Source
      .fromFile(filename) // Ouvre le fichier
      .getLines()         // Lit toutes les lignes du fichier comme un itérateur
      .toArray            // Convertit les lignes en tableau
      .map(_.split(" ").map(_.toInt)) // Sépare chaque ligne en valeurs entières (basées sur les espaces)

    // Afficher le tableau de Sudoku
    println("Sudoku Board:") // Indique que le tableau sera affiché
    printSudokuBoard(board)  // Appelle une fonction pour afficher le tableau formaté
  }

  // Fonction pour afficher le tableau de Sudoku
  def printSudokuBoard(board: Array[Array[Int]]): Unit = {
    for (i <- board.indices) { // Parcourt les indices des lignes du tableau
      // Ajouter des séparateurs horizontaux toutes les 3 lignes (sauf pour la première)
      if (i % 3 == 0 && i != 0) {
        println("------+-------+------") // Ligne de séparation entre blocs 3x3
      }
      for (j <- board(i).indices) { // Parcourt les indices des colonnes de la ligne actuelle
        // Ajouter des barres verticales toutes les 3 colonnes (sauf pour la première)
        if (j % 3 == 0 && j != 0) {
          print("| ") // Barre verticale pour séparer les blocs 3x3
        }
        // Afficher la valeur de la cellule suivie d'un espace
        print(board(i)(j) + " ")
      }
      println() // Passe à la ligne suivante après avoir affiché une ligne entière du tableau
    }
  }
}
