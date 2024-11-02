fun main() {
    // Start the program and prompt for user input
    val maxRent = getMaxRentFromUser()
    val location = getLocationFromUser()
    
    // Fetch and filter apartments based on criteria
    val apartments = ApartmentService.fetchApartments(location, maxRent)
    
    // Display the results
    apartments.forEach { println(it) }
}

object ApartmentService {
    fun fetchApartments(location: String, maxRent: Double): List<Apartment> {
        val apartments = listOf<Apartment>() // Replace with API or data fetching logic
        return apartments.filter { it.rent <= maxRent && it.location.contains(location) }
    }
}

data class Apartment(val name: String, val location: String, val rent: Double, val amenities: List<String>)

// Function to get the maximum rent from the user
fun getMaxRentFromUser(): Double {
    print("Enter your maximum rent: ")
    return readLine()?.toDoubleOrNull() ?: 0.0
}

// Function to get location preference from the user
fun getLocationFromUser(): String {
    print("Enter the desired location: ")
    return readLine() ?: ""
}
