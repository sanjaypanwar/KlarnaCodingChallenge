# KlarnaCodingChallenge
## Task description : Create a simple app which displays the weather for the users' location.

# Planning:
My main focus was to implement the business logic and the UI of the funtionality.
I decided to plan for the methods we are going to required in repository class in data layer where we write the bussiness logic.
First worked on the domain layer containing the model classes for the WeatherAPI data also added models to represent on the UI.
## Domain models I added:
### For api response:
- WeatherInfoApiResponse : Model to contains the parsed data from API.
- WeatherPresenterData : Data model to contains the data to show on UI. This model is mapped from WeatherInfoApiResponse.
Failure of above criterias or any other conditions we need to notify user the failure of action. For that , I have added DataHolder sealed class(containing SUCCESS , FAILURE) which is a wrapper class for data model as well as the error message.
WeatherServiceApi class provides the API data.

## Data layer:
Contains the repository and data source classes.
- WeatherRepository: contains logic to fetch and transform api data to ui presentable data.
- WeatherRemoteDataSource: fetching data from API

## UI layer:
- WeatherActivity : its the single activity showing the weather data to user on launch.
Location permission model is implemented to check if user has granted permission to user and request for permission if not.

https://user-images.githubusercontent.com/10473282/154896046-82ef38f5-3ef1-416b-b1bb-4cb0a3047c8e.mp4



https://user-images.githubusercontent.com/10473282/154896165-03ec19ca-d9dd-4a26-9301-175aa7ec1b0d.mp4



## for Dependecy injection :
- NetworkModule : for providing dependencies related to the retrofit.
- DataModule : for providing dependencies related to the repositories and usecases .

# Architecture: 
## CLean Architecture with MVVM
For architecture, I have decided to implement the feature with clean architecture with MVVM:
![clean](https://user-images.githubusercontent.com/10473282/152679625-d15e6b5c-a2ff-4b00-9737-655d20e3fcae.png)

# Libraries added

## Coroutines
> For Flow API implementation and async call.

# Libraries added
## HILT
> Used for Dependency Injection

## DataBinding
>To ease the management of UI xml views in activity code

## Retrofit 
> For making service calls
