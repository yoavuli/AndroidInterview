package via.rider.interview.ridercodinginterview

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import via.rider.interview.ridercodinginterview.ui.adapters.PrimeComparator
import via.rider.interview.ridercodinginterview.ui.adapters.PrimeListAdapter

class MainActivity : ComponentActivity() {

    val viewModel by viewModels < MainActivityViewModel>()
    val pagingAdapter = PrimeListAdapter(PrimeComparator)
    val recyclerView : RecyclerView by lazy { findViewById<RecyclerView>(R.id.primeList) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_prime_numbers)
        enableEdgeToEdge()
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = pagingAdapter
        }
        lifecycleScope.launch {
            viewModel.primeFlow.collectLatest{  value -> pagingAdapter.submitData(value) }
        }

        // Pick and choose the solution which makes sense to you

        // Complete the implementation of an infinite list showing prime numbers
        // Compose
        // setContent {
        //      PrimeNumbersScreen()
        // }


        // XML-Based

    }
}