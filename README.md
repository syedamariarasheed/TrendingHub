# TrendingHub
TrendingHub is an Android application that was implemented using MAD skills. It displays a list of the currently trending GitHub repositories. This app was developed using 100% Kotlin and the Android SDK.

### Feature:
- App shows Github repositories trending list. (Note: expandable list view is not implemented because content of list item is minimal so It doesn’t seem appropriate with ui experience).
- Dark mode support that means when user change the display setting as dark mode, within application it provides dark theme. (You can also view in composable previews).
- Failure handling, right now failure segregated with 3 types Network connectivity , API failure and unknown failure (default) with proper message.
- Swipe-to-refresh to show updated data when requested.

### Architecture description & development approach:

- Jetpack Compose: UI developed 100% on composable + Dark mode handling. 
- TrendingHub implemented on clean architecture that itself has various reasons one of the top most having separation of concerns, each layer has well defined responsibility and much more. 
- For Asynchronous operations i.e network call TrendingHub use Flow because In modern app development Flow provides a simple and efficient way to handle asynchronous data streams which can help to simplify code, reactive programming and in a non-blocking manner.
- TDD by outside in approach as being client facing outside in approach is more beneficial tests are written for the highest level of functionality first such as user-facing features instead inside out that focuses on writing tests for lower-level code first.
- For network call using retrofit and for json parsing using Moshi for faster parsing and type safety. 
- Hilt as dependency injection.

This is brief, would be great to discuss more in detail :) 


<img width="340" alt="Screenshot 2023-05-02 at 12 02 42 AM" src="https://user-images.githubusercontent.com/45803103/235529897-7e2d24c5-ad75-4e9e-8cec-d2d1cc519741.png">  <img width="340" alt="Screenshot 2023-05-02 at 12 02 36 AM" src="https://user-images.githubusercontent.com/45803103/235529822-caa663af-320d-407b-9bdb-0b6ec4e40e88.png">


