package eu.tutorials.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun CategoryDetailScreen(category: Category) {
    Card(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Black),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = "${category.strCategoryDescription} thumbail",
                modifier = Modifier
                    .wrapContentSize()
                    .aspectRatio(1f)
                    .clip(CircleShape)
            )

            Text(text = category.strCategory, fontSize = 24.sp, textAlign  = TextAlign.Center, modifier = Modifier.fillMaxWidth() )



            Box(modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color.Black))

            Text(text = category.strCategoryDescription,
                textAlign = TextAlign.Justify,
                modifier = Modifier.verticalScroll(rememberScrollState())
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun itsPreview() {
    CategoryDetailScreen(Category("", "", "", ""))
}

























