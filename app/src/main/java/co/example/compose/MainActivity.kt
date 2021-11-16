package co.example.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme() {
                MessageCard(
                    Message(
                        "John",
                        "the girl by the river"
                    )
                )
            }
        }
    }



    @Composable
    fun MessageCard(msg: Message) {
        Row (modifier = Modifier.padding(all = 8.dp)){
            Image(painter = painterResource(id = R.drawable.profile_picture),
                contentDescription = "Some nonsense pic",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = msg.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = msg.body,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.background
                )
            }
           
        }

    }
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark mode"
    )
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_NO,
        showBackground = true,
        name = "Light mode"
    )
    @Composable
    fun WatchCard(){
        ComposeTheme {
            MessageCard(Message(
                "Header",
                "This is our body"
            )
        )
        }
    }
    data class Message(val author:String, val body:String)
}

