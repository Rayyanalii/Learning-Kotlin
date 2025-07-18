import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.learning_kotlin.CardModel
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf

class SearchViewModel : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _emptyMessage = mutableStateOf<String?>(null)
    val emptyMessage: State<String?> = _emptyMessage

    private val _classList = listOf(
        CardModel(1, "Math", "Learn about numbers.", showDescription = true),
        CardModel(2, "Science", "Explore the universe.", showDescription = true),
        CardModel(3, "History", "Understand the past.", showDescription = true),
        CardModel(4, "Art", "Be creative.", showDescription = true)
    )

    val filteredList: State<List<CardModel>> = derivedStateOf {
        val result = if (_searchQuery.value.isBlank()) {
            _classList
        } else {
            _classList.filter {
                it.title.contains(_searchQuery.value, ignoreCase = true) ||
                        it.description.contains(_searchQuery.value, ignoreCase = true)
            }
        }

        _emptyMessage.value = if (result.isEmpty()) "No results found." else null

        result
    }

    fun onQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
    }
}
