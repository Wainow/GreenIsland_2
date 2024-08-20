# GreenIsland_2

Description:
GreenIsland_2 is an application designed to display stock quotes and manage a list of favorite stocks.

Key Features:

1) Add Stocks to Favorites: Users can mark stocks as favorites, which allows them to quickly access their preferred stocks.
2) Save Favorite Stocks to Database: The application saves the list of favorite stocks in a local database using Room, ensuring that user preferences persist across sessions.
3) Sort Stocks: Stocks can be sorted by name or value, allowing users to view them in their preferred order.
4) View Prices in Multiple Currencies: Users can view stock prices in various currencies including USD, EUR, RUB, and CZK.

Technology Stack:

1) Retrofit: For network operations and API calls to fetch stock data.
2) Room: For local database management and storing favorite stocks.
3) Flow & StateFlow: For reactive programming and managing UI state in a more declarative manner.
4) Coroutines: For asynchronous programming and handling concurrent tasks.
5) Hilt: For dependency injection to manage application dependencies.
6) MVVM (Model-View-ViewModel): Architectural pattern to separate concerns and manage UI-related data.
7) Clean Architecture: To ensure the application is scalable, maintainable, and testable by separating different concerns into distinct layers.
