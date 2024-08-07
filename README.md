# ChatwiseAssignment App

This is a demo Android application showcasing a three-screen interface for viewing and interacting with a list of products. The application fetches data from an API and displays it using RecyclerView. The project emphasizes proper code quality and architecture.

## Download

[Download the APK](https://www.dropbox.com/scl/fi/f2e6077zk3r4hdkyjuy0j/ChatwiseAssignment.apk?rlkey=2ck9snhlcdghvto6shvfxrxbi&st=odozgzn8&dl=0
)


## Features

1. **Main Screen (MainActivity)**: Contains a button to view products. Clicking the button navigates to the second screen.
2. **Products List Screen (ProductsActivity)**: Displays a list of products fetched from the API. The RecyclerView contains two types of items:
   - A title item with the text "Products List".
   - Product items fetched from the API.
3. **Product Detail Screen (ProductDetailActivity)**: Displays detailed information about a selected product. Users can navigate to this screen by clicking on any item in the second screen.

## ScreenShots
![screenshotlight](https://github.com/user-attachments/assets/87cec496-e90f-4938-9a85-c9ad9c55b96d)
![screenshotdark](https://github.com/user-attachments/assets/8a64cbb0-9eb1-4a11-a288-2e85ce1eabef)

## API

- **Endpoint**: [https://dummyjson.com/products](https://dummyjson.com/products)
- **Type**: GET

## Technologies Used

- **Retrofit**: For calling the API.
- **RecyclerView**: For displaying the list of products.
- **ViewModel and StateFlow**: For managing UI-related data in a lifecycle-conscious way.
- **Glide**: For loading images.
- **Data Binding**: For binding UI components in layouts to data sources in your app using a declarative format rather than programmatically.

## Setup and Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/bhavesh100/ChatwiseAssignment.git
    ```
2. **Open the project in Android Studio**.

3. **Build the project**:
    - The project should sync and build automatically when opened in Android Studio.

4. **Run the app**:
    - Connect your device or start an emulator.
    - Click on the 'Run' button in Android Studio.

