package com.rahad.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahad.myapplication.ui.theme.MyApplicationTheme
import com.rahad.myapplication.ui.theme.fabColor
import com.rahad.riobottomnavigation.composables.RioBottomNavItemData
import com.rahad.riobottomnavigation.composables.RioBottomNavigation


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val items = listOf(
                    R.drawable.ic_account,
                    R.drawable.ic_transfer,
                    R.drawable.ic_payment,
                    R.drawable.ic_explore
                )

                val labels = listOf(
                    "Account",
                    "Transfer",
                    "Payment",
                    "Explore"
                )
                val selectedIndex = remember { mutableIntStateOf(0) }

                val buttons = items.mapIndexed { index, iconData ->
                    RioBottomNavItemData(
                        imageVector = ImageVector.vectorResource(iconData),
                        selected = index == selectedIndex.intValue,
                        onClick = { selectedIndex.intValue = index },
                        label = labels[index] // Assign the label for each button
                    )
                }

                Scaffold(
                    bottomBar = {
                        RioBottomNavigation(
                            fabIcon = ImageVector.vectorResource(id = R.drawable.ic_qr),
                            buttons = buttons,
                            fabSize = 70.dp, // Customizable FAB size
                            barHeight = 70.dp,
                            selectedItemColor = fabColor,// Customizable bar height
                            fabBackgroundColor = fabColor,// Custom FAB color
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    when (selectedIndex.intValue) {
                        0 -> Greeting("Account", modifier = Modifier.padding(innerPadding))
                        1 -> Greeting("Transfer", modifier = Modifier.padding(innerPadding))
                        2 -> Greeting("Payment", modifier = Modifier.padding(innerPadding))
                        3 -> Greeting("Explore", modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}
