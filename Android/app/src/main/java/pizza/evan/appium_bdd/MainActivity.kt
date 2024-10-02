@file:OptIn(ExperimentalComposeUiApi::class)

package pizza.evan.appium_bdd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pizza.evan.appium_bdd.ui.theme.AppiumBDDTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppiumBDDTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .semantics { testTagsAsResourceId = true },
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box (
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Greeting(
                            modifier = Modifier.align(Alignment.Center),
                            name = "world"
                        )
                        Button(
                            onClick = { /* Do something! */ },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(16.dp)
                                .testTag("next_button")
                        ) {
                            Text("Next")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_language_24),
            contentDescription = "Globe",
            modifier = Modifier
                .testTag("icon")
                .padding(8.dp)
        )
        Text(
            text = "Hello, $name!",
            modifier = Modifier.testTag("greeting")
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppiumBDDTheme {
        Greeting("Android")
    }
}