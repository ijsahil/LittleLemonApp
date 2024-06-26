import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.data.DishRepository
import com.example.littlelemon.data.MenuDish


@Composable
fun DishDetail(id: Int) {
    val context = LocalContext.current
    val dish = requireNotNull(DishRepository.getDish(id))
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        androidx.compose.material.Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(),
            elevation = 4.dp
        ) {
            Column {
                Image(
                    painter = painterResource(id = dish.image),
                    contentDescription = dish.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = dish.name,
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 8.dp, start = 9.dp)
                    )

                    Text(
                        text = " ₹${dish.price}/-",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 8.dp, start = 9.dp)
                    )
                    Counter(dish)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {
                                Toast.makeText(
                                    context, "${dish.name} added to cart",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            colors = ButtonDefaults.buttonColors(
                                Color.Green,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Add to cart")
                        }

                        Button(
                            onClick = {
                                Toast.makeText(
                                    context, "${dish.name} order Confirmed",
                                    Toast.LENGTH_LONG
                                ).show()
                            },
                            colors = ButtonDefaults.buttonColors(
                                Color.Green,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "Order now")
                        }

                    }


                }
            }

        }
    }
}

@Composable
fun Counter(dish: MenuDish) {
    var counter by remember { mutableIntStateOf(1) }
    var dishPrice by remember {
        mutableIntStateOf(dish.price)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { counter-- },
            enabled = counter > 1,
            colors = ButtonDefaults.buttonColors(
                MaterialTheme.colors.secondary,
                contentColor = Color.White
            )
        ) {
            Text(text = "-")
        }
        Text(
            text = counter.toString(),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Button(
            onClick = { counter++ },
            colors = ButtonDefaults.buttonColors(
                MaterialTheme.colors.secondary,
                contentColor = Color.White
            )
        ) {
            Text(text = "+")
        }
        Text(
            text = "Total: ",
            fontWeight = FontWeight.Medium,
            color = Color.Red,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = "₹${dishPrice * counter}/-",
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 22.sp
        )
    }

}


@Preview(showBackground = true)
@Composable
fun DishDetailPreview() {
    DishDetail(id = 9)
}
