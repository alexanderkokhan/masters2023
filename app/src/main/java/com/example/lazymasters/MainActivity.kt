package com.example.lazymasters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazymasters.ui.theme.LazyMastersTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyMastersTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyMastersApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


data class MastersPlayer(
    val name: String,
    val nickname: String,
    val description: String,
    val painterResource: Painter
)


@Composable
fun MastersPlayerCard(
    player: MastersPlayer,
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){

        Image(painter = player.painterResource, null)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = player.name + " (" + player.nickname + ")",
            fontSize = 30.sp,

            )
        Text(
            text = player.description,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }

}


@Composable
fun LazyMastersApp(modifier: Modifier = Modifier) {

// Model

    val mastersPlayers: List<MastersPlayer> = listOf(
        MastersPlayer(
            name = stringResource(R.string.bonya_name),
            nickname = stringResource(R.string.bonya_nickname),
            description = stringResource(R.string.bonya_description),
            painterResource = painterResource(R.drawable.bonya)
        ),
        MastersPlayer(
            name = stringResource(R.string.samarityanka_name),
            nickname = stringResource(R.string.samarityanka_nickname),
            description = stringResource(R.string.samarityanka_description),
            painterResource = painterResource(R.drawable.samarityanka)
        ),
        MastersPlayer(
            name = stringResource(R.string.interactive_name),
            nickname = stringResource(R.string.interactive_nickname),
            description = stringResource(R.string.interactive_description),
            painterResource = painterResource(R.drawable.interactive)
        ),
        MastersPlayer(
            name = stringResource(R.string.napoleon_name),
            nickname = stringResource(R.string.napoleon_nickname),
            description = stringResource(R.string.napoleon_description),
            painterResource = painterResource(R.drawable.napoleon)
        ),
        MastersPlayer(
            name = stringResource(R.string.artik_name),
            nickname = stringResource(R.string.artik_nickname),
            description = stringResource(R.string.artik_description),
            painterResource = painterResource(R.drawable.artik)
        ),

        MastersPlayer(
            name = stringResource(R.string.cristo_name),
            nickname = stringResource(R.string.cristo_nickname),
            description = stringResource(R.string.cristo_description),
            painterResource = painterResource(R.drawable.cristo)
        ),
        MastersPlayer(
            name = stringResource(R.string.zveryuga_name),
            nickname = stringResource(R.string.zveryuga_nickname),
            description = stringResource(R.string.zveryuga_description),
            painterResource = painterResource(R.drawable.zveryuga)
        ),
        MastersPlayer(
            name = stringResource(R.string.bumblebee_name),
            nickname = stringResource(R.string.bumblebee_nickname),
            description = stringResource(R.string.bumblebee_description),
            painterResource = painterResource(R.drawable.bumblebee)
        ),
        MastersPlayer(
            name = stringResource(R.string.castortroy_name),
            nickname = stringResource(R.string.castortroy_nickname),
            description = stringResource(R.string.castortroy_description),
            painterResource = painterResource(R.drawable.castortroy)
        ),
        MastersPlayer(
            name = stringResource(R.string.esaul_name),
            nickname = stringResource(R.string.esaul_nickname),
            description = stringResource(R.string.esaul_description),
            painterResource = painterResource(R.drawable.esaul)
        )
    )

// View

    val listState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = listState
    ){

        items(mastersPlayers) { player ->
            MastersPlayerCard(player = player)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyMastersPreview() {
    LazyMastersTheme {
        LazyMastersApp()
    }
}