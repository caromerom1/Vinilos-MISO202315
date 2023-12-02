package com.miso2023equipo2.vinilos.pages.album

import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.miso2023equipo2.vinilos.App
import com.miso2023equipo2.vinilos.R
import com.miso2023equipo2.vinilos.Strings
import com.miso2023equipo2.vinilos.data.model.CommentCreate
import com.miso2023equipo2.vinilos.data.repository.AlbumsRepository
import com.miso2023equipo2.vinilos.navigation.state.DataUiState
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

data class AlbumCommentState(
    val description: MutableState<String>,
    val rating: MutableState<String>,
)

class CommentViewModel(
    private val albumsRepository: AlbumsRepository,
) : ViewModel() {
    var commentUiState: DataUiState<CommentCreate> by mutableStateOf(DataUiState.Loading)
    var formState: AlbumCommentState by mutableStateOf(
        AlbumCommentState(
            description = mutableStateOf(""),
            rating = mutableStateOf("")
        )
    )


    fun commentAlbum(
        albumId: String,
        comment: CommentCreate,
        navController: NavController,
    ) {
        viewModelScope.launch {
            commentUiState = try {
                val response = albumsRepository.commentAlbum(albumId, comment)
                Toast.makeText(
                    navController.context,
                    Strings.get(R.string.comment_created_toast),
                    Toast.LENGTH_SHORT
                ).show()

                DataUiState.Success(
                    response
                )
            } catch (e: IOException) {
                Toast.makeText(
                    navController.context,
                    Strings.get(R.string.comment_create_failed_toast),
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Error
            } catch (e: HttpException) {
                Toast.makeText(
                    navController.context,
                    Strings.get(R.string.comment_create_failed_toast),
                    Toast.LENGTH_SHORT
                ).show()
                DataUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as App)
                val albumRepository = application.container.albumsRepository
                CommentViewModel(albumsRepository = albumRepository)
            }
        }
    }

}