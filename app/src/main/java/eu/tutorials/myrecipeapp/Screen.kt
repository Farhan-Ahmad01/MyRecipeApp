package eu.tutorials.myrecipeapp

sealed class Screen(val rout: String) {
    object RecipeScreen: Screen("recipescreen")

    object DetailScreen: Screen("Detailscreen")

}