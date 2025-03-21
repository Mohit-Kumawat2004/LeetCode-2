class Solution {
    fun findAllRecipes(
        recipes: Array<String>,
        ingredients: List<List<String>>,
        supplies: Array<String>
    ): 
    
    
    List<String> = HashSet<String>().apply {
        val supplySet = supplies.toHashSet()
        val recipeMap = HashMap<String, List<String>>()
            .apply { recipes.indices.forEach { put(recipes[it], ingredients[it]) } }
        val making = HashSet<String>()



        fun isRecipePossible(recipe: String): Boolean {
            if (recipe in supplySet) return true 
            if (recipe in this) return true  
            if (recipe in making) return false  
            val ingredients: List<String> = recipeMap.remove(recipe) ?: return false

            making.add(recipe)
            ingredients.forEach { if (!isRecipePossible(it)) return false } // check all ings

            add(recipe)   // add possible recipe
            return true
        }

        recipes.forEach {
            making.clear()
            isRecipePossible(it)
        }
    }.toList()
}