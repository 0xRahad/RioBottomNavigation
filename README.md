# Rio Bottom Navigation

A simple & Fab Centred Bottom navigation for Android written in **Kotlin Jetpack Compose** with ♥ .

![](https://github.com/0xRahad/RioBottomNavigation/blob/main/my.gif)


## Download

Update your `settings.gradle.kts` like below :

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven( url = "https://jitpack.io" )
    }
}
```

Update your `build.gradle` (module path) like below :

```groovy
dependencies{
    implementation ("com.github.0xRahad:RioBottomNavigation:1.0.2")
}
```


## Usage

```kotlin
@Composable
fun MainScreen() {
    // Constants for icon resources and labels
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

    // Use rememberSaveable to retain state across configuration changes
    var selectedIndex = rememberSaveable { mutableIntStateOf(0) }

    // Create RioBottomNavItemData for the bottom navigation buttons
    val buttons = items.mapIndexed { index, iconData ->
        RioBottomNavItemData(
            imageVector = ImageVector.vectorResource(iconData),
            selected = index == selectedIndex.intValue,
            onClick = { selectedIndex.intValue = index },
            label = labels[index]
        )
    }

    // Main Scaffold setup
    Scaffold(
        bottomBar = {
            BottomNavigationBar(buttons = buttons)
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        // Handle the screen content based on the selected index
        ScreenContent(selectedIndex.intValue, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun ScreenContent(selectedIndex: Int, modifier: Modifier = Modifier) {
    when (selectedIndex) {
        0 -> ShowText("Account")
        1 -> ShowText("Transfer")
        2 -> ShowText("Payment")
        3 -> ShowText("Explore")
    }
}
@Composable
fun BottomNavigationBar(buttons: List<RioBottomNavItemData>) {
    RioBottomNavigation(
        fabIcon = ImageVector.vectorResource(id = R.drawable.ic_qr),
        buttons = buttons,
        fabSize = 70.dp,
        barHeight = 70.dp,
        selectedItemColor = fabColor,
        fabBackgroundColor = fabColor,
    )
}
```

<b>Note: </b>
You can use drawable Resource also

```kotlin
        RioBottomNavItemData(
            drawableResId = R.drawable.ic_settings, // Drawable resource example
            selected = false,
            onClick = { /* Navigate to Account */ },
            label = "Account"
        )

```



# Thanks and Support

## Thank You for Your Interest!

Thank you for taking the time to explore this project! Your interest and support mean a lot to us. We appreciate every contributor, user, and follower. Your engagement drives us to improve and innovate further.

## Support and Contributions

If you find this project helpful or if you would like to contribute, there are several ways you can support us:

1. **Star the Repository**: If you like this project, give it a star on GitHub. It helps us reach a wider audience and shows that you value our work.

2. **Report Issues**: If you encounter any bugs or issues, please report them using the [Issues](https://github.com/yourusername/yourproject/issues) page. Your feedback is essential for us to improve.

3. **Contribute**: We welcome contributions! Whether it's code, documentation, or suggestions, feel free to fork the repository and submit a pull request. Check out our [Contributing Guide](CONTRIBUTING.md) for more information.

4. **Spread the Word**: Share this project with your friends and colleagues. The more people know about it, the more we can grow and enhance the community around it.

5. **Follow Us**: Stay updated by following our GitHub profile and subscribing to notifications for this repository. 

## Contact

If you have any questions, feel free to reach out via [email](mailto:haxorrahad@gmail.com) or open an issue in the repository.

Thank you for your support! We look forward to hearing from you and seeing how you use this project.
