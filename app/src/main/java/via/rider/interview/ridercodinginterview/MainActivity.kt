package via.rider.interview.ridercodinginterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Complete the implementation of an infinite list showing prime numbers
        // Pick and choose the solution which makes sense to you

        // Compose
        // setContent {
        //      PrimeNumbersScreen()
        // }

        // XML-Based
        // setContentView(R.layout.layout_prime_numbers)
    }
}