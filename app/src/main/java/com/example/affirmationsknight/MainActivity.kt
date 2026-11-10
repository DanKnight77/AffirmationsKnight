package com.example.affirmationsknight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmationsknight.data.Datasource
import com.example.affirmationsknight.model.Affirmation
import com.example.affirmationsknight.ui.theme.AffirmationsKnightTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Sets up the app's theme.
            AffirmationsKnightTheme {
                // Provides the background for the app.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

// Displays the list of affirmations.
@Composable
fun AffirmationsApp() {
    AffirmationList(
        affirmationList = Datasource().loadAffirmations()
    )
}

// Creates a vertically scrollable list.
@Composable
fun AffirmationList(
    affirmationList: List<Affirmation>,
    modifier: Modifier = Modifier
) {
    //Displays each card vertically on top of one another
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(affirmationList) { affirmation ->
            // Adds each affirmation to the list.
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

// Creates a card with an image and affirmation message.
@Composable
fun AffirmationCard(
    affirmation: Affirmation,
    modifier: Modifier = Modifier
) {
    //Creates our card
    Card(modifier = modifier) {
        //Stacks image on top of text
        Column {
            // Displays the affirmation image.
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                //Crops image to fit screen
                contentScale = ContentScale.Crop
            )

            // Displays the affirmation text.
            Text(
                text = stringResource(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

// Shows a preview of one affirmation card.
@Preview(showBackground = true)
@Composable
private fun AffirmationCardPreview() {
    AffirmationsKnightTheme {
        AffirmationCard(
            affirmation = Affirmation(
                R.string.affirmation1,
                R.drawable.affirmation1
            )
        )
    }
}