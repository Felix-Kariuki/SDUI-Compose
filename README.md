## SDUI - Compose

[Server-Driven UI](SDUI) is an architectural pattern designed to minimize client-side logic and ensure consistency across multiple platforms (web, iOS, Android, etc.). 
Instead of returning raw domain data, the API delivers layout information, allowing the UI to be dynamically consumed and reducing the need for platform-specific code.

This is a sample project created to show case the SDUI approach on android apps using jetpack compose.


## Resources
1. [Design Server-Driven UI with Jetpack Compose and Firebase](https://getstream.io/blog/server-driven-compose-firebase/)

2. [How to Build Server Driven UI w/ Firebase + Jetpack Compose](https://www.youtube.com/watch?v=tca-6yhWXNo)


## **Tech stack & Libraries 🛠️👨‍💻**
 - [Kotlin](https://kotlinlang.org/docs/reference/) - Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of Kotlin's standard library depends on the Java Class Library, but type inference allows its syntax to be more concise
 * [Jetpack Components:](https://developer.android.com/topic/architecture?gclid=Cj0KCQjw8O-VBhCpARIsACMvVLOH1satX45o9f4PMQ4Sxr7bG9myl6-KZL9nYda8PJsHV7m2uJL8bzgaAmqiEALw_wcB&gclsrc=aw.ds)
    * [Jetpack Compose](https://developer.android.com/jetpack/compose?gclid=Cj0KCQjwhqaVBhCxARIsAHK1tiMMwHsxQ8Z25jyEdtLha9erq11wROoEfL6RqpGMprgbDTNuMO3_Ri8aAu5EEALw_wcB&gclsrc=aw.ds) -  Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android
    * [View Model](https://developer.android.com/topic/libraries/architecture/viewmodel)-  store and manage UI-related data in a lifecycle conscious way.
    * [Lifecycle]( https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    * [Android KTX](https://developer.android.com/kotlin/ktx.html) - Android KTX is a set of Kotlin extensions that are included with Android Jetpack and other Android libraries. KTX extensions provide concise, idiomatic Kotlin to Jetpack, Android platform, and other APIs.
    * [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.


* [Dagger-Hilt](https://dagger.dev/hilt/)- a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project

* [Coroutines](https://developer.android.com/kotlin/coroutines) - a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
* [Flow](https://developer.android.com/kotlin/flow)- In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value.

* [CI/CD](https://codemagic.io/android-continuous-integration/) - Continuous integration systems let you automatically build and test your app every time you check in updates to your source control system.

* [Firebase Android KTX](): Kotlin & Compose-friendly Firebase extensions designed to help you focus on your business logic.

* [ksp]() Kotlin Symbol Processing API for code generation and analysis.

* [Coil](https://coil-kt.github.io/coil/compose/) - Image Loader library.

 * [Compose Navigation]()
 * [Lottie Animation](https://lottiefiles.com/what-is-lottie) - A Lottie is a JSON-based animation file format that allows you to ship animations on any platform as easily as shipping static assets.


## Project Set Up
To set up this project... 

1. Set up firebase and add the `google-services.json` to the app directory of the project.
2. Copy this json to your machine and save it with `.json` extension e.g (games.json)
   ``` json
   {
   "gamesCompose": {
    "games": {
      "list": {
        "itemSize": {
          "height": 200,
          "width": 0
        },
        "items": [
          {
            "developer": "Level Infinite",
            "freetogame_profile_url": "https://www.freetogame.com/tarisland",
            "game_url": "https://www.freetogame.com/open/tarisland",
            "genre": "MMORPG",
            "platform": "PC (Windows)",
            "publisher": "Tencent",
            "release_date": "2024-06-22",
            "scaleType": "crop",
            "short_description": "A cross-platform MMORPG developed by Level Infinite and Published by Tencent.",
            "title": "Tarisland",
            "url": "https://www.freetogame.com/g/582/thumbnail.jpg"
          },
          {
            "developer": "Blizzard Entertainment",
            "freetogame_profile_url": "https://www.freetogame.com/overwatch-2",
            "game_url": "https://www.freetogame.com/open/overwatch-2",
            "genre": "Shooter",
            "platform": "PC (Windows)",
            "publisher": "Activision Blizzard",
            "release_date": "2022-10-04",
            "scaleType": "crop",
            "short_description": "A hero-focused first-person team shooter from Blizzard Entertainment.",
            "title": "Overwatch 2",
            "url": "https://www.freetogame.com/g/540/thumbnail.jpg"
          },
          {
            "developer": "KRAFTON, Inc.",
            "freetogame_profile_url": "https://www.freetogame.com/pubg",
            "game_url": "https://www.freetogame.com/open/pubg",
            "genre": "Shooter",
            "platform": "PC (Windows)",
            "publisher": "KRAFTON, Inc.",
            "release_date": "2022-01-12",
            "scaleType": "crop",
            "short_description": "Get into the action in one of the longest running battle royale games PUBG Battlegrounds.",
            "title": "PUBG: BATTLEGROUNDS",
            "url": "https://www.freetogame.com/g/516/thumbnail.jpg"
          },
          {
            "developer": "InnoGames",
            "freetogame_profile_url": "https://www.freetogame.com/forge-of-empires",
            "game_url": "https://www.freetogame.com/open/forge-of-empires",
            "genre": "Strategy",
            "platform": "Web Browser",
            "publisher": "InnoGames",
            "release_date": "2012-04-17",
            "scaleType": "crop",
            "short_description": "A free to play 2D browser-based online strategy game, become the leader and raise your city.",
            "title": "Forge of Empires",
            "url": "https://www.freetogame.com/g/345/thumbnail.jpg"
          },
          {
            "developer": "Mediatonic",
            "freetogame_profile_url": "https://www.freetogame.com/fall-guys",
            "game_url": "https://www.freetogame.com/open/fall-guys",
            "genre": "Battle Royale",
            "platform": "PC (Windows)",
            "publisher": "Mediatonic",
            "release_date": "2020-08-04",
            "scaleType": "crop",
            "short_description": "Play the most competitive massively multiplayer party royale game featuring beans ever for free on a variety of platforms. ",
            "title": "Genshin Impact",
            "url": "https://www.freetogame.com/g/523/thumbnail.jpg"
          }
        ],
        "layout": "column",
        "testStyles": {
          "heightImage": 200,
          "subTitleFontWeight": "medium",
          "subTitleSize": 15,
          "titleFontWeight": "bold",
          "titleSize": 17,
          "widthImage": 0
        }
      },
      "order": 2,
      "title": {
        "fontWeight": "bold",
        "size": 28,
        "text": "Free To Game"
      }
    },
    "version": 1
   }
   }
 ```
```
4. Set up [Firebase realtime Databsee]() and once done import the json as demonstrated:![Screenshot 2024-09-24 at 01 50 39](https://github.com/user-attachments/assets/8fc8c896-0ea2-4712-87bc-dc623b74c209)
5. Copy the realtime Database Url to and add it to your local.properties as:

```
REALTIME_DATABASE_URL=URL_HERE
```
![Screenshot 2024-09-24 at 01 51 06](https://github.com/user-attachments/assets/71f275a6-1505-4757-be32-ac478cd6cc9b)




 ## Author
Felix Kariuki

<a href="https://www.buymeacoffee.com/felix.kariuki" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: 41px !important;width: 174px !important;box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;-webkit-box-shadow: 0px 3px 2px 0px rgba(190, 190, 190, 0.5) !important;" ></a>

Do Reach Out :

  * [Twitter](https://twitter.com/felixkariuki_)

  * [LinkedIn](https://www.linkedin.com/in/felix-kariuki/)
  
   ## License and Copyright





   
