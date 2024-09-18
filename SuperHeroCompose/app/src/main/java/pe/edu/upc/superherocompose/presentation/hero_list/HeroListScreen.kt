package pe.edu.upc.superherocompose.presentation.hero_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HeroListScreen(viewModel: HeroListViewModel) {
    val name = viewModel.name.value
    val state = viewModel.state.value
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                value = name, onValueChange = {
                    viewModel.onNameChanged(it)
                })
            OutlinedButton(onClick = {
                viewModel.searchHero()
            }) {
                Text("Search")
            }
            state.data?.let { heroes ->
                LazyColumn {
                    items(heroes) { hero ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                GlideImage(
                                    modifier = Modifier.size(96.dp),
                                    imageModel = { hero.url }, // loading a network image using an URL.
                                    imageOptions = ImageOptions(
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.Center
                                    )
                                )
                                Column(modifier = Modifier
                                    .padding(4.dp)
                                    .weight(1f)) {

                                    Text(hero.name)
                                    Text(hero.fullName)
                                }
                                IconButton(onClick = {}) {
                                    Icon(Icons.Filled.Favorite, "Favorite")
                                }
                            }


                        }
                    }
                }
            }
            if (state.isLoading) {
                CircularProgressIndicator()
            }
            if (state.message.isNotEmpty()) {
                Text(state.message)
            }
        }
    }

}
