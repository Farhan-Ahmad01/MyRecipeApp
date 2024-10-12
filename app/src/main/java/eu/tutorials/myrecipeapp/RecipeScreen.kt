package eu.tutorials.myrecipeapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewState: MainViewModel.RecipeState,
                 navigateToDetail: (Category) -> Unit
                 ){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black)
        ){
        when{
            viewState.loading ->{
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null ->{
                Text("ERROR OCCURRED")
            }
            else ->{
                CategoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>,
                   navigateToDetail: (Category) -> Unit
                   ){
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
        items(categories){
            category ->
            CategoryItem(category = category, navigateToDetail)
        }
    }
}
// How each Items looks like
@Composable
fun CategoryItem(category: Category,
                 navigateToDetail: (Category) -> Unit
                 ){
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxSize(),
        border = BorderStroke(5.dp, Color.Black),
        ) {
        Column(modifier = Modifier
            .padding(6.dp)
            .fillMaxSize()
            .clickable { navigateToDetail(category) },
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .clip(CircleShape)
            )


            Text(
                text = category.strCategory,
                fontSize = 16.sp,
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontFamily = FontFamily.Serif
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UIPreview() {

}


